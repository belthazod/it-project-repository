/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import BEANS.Product;
import UTIL.DatabaseConnector;
import UTIL.TableManager;
import VIEW.ProductsUI;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Belthazod
 */
public class DeliveryController {
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    private TableManager deliveryProductsTableManager;
    private TableManager deliveryTableManager;
    private JComboBox<ComboItem> deliveryProductFilterSupplierComboBox;
    private JLabel deliverySupplierLabel;
    private static ProductController productController;
    private static ArrayList<Product> productList;
    /**
     * Creates and instance of <code>DeliveryController</code> based on the given UI components to be manipulated
     * @param deliveryProductsTable - the <code>JTable</code> containing the list of all products in the inventory system
     * @param deliveryTable - the <code>JTable</code> containing the list of all products received from delivery
     * @param deliveryProductFilterSupplierComboBox - the <code>JComboBox</code> containing the list of suppliers to filter the Products in the Inventory System
     * @param deliverySupplierComboBox - the <code>JComboBox</code> containing the list of suppliers to identify from whom the delivery came from.
     */
    public DeliveryController(JTable deliveryProductsTable, JTable deliveryTable, JComboBox<ComboItem> deliveryProductFilterSupplierComboBox, JLabel deliverySupplierLabel){
        try{
        this.deliveryProductsTableManager = new TableManager(deliveryProductsTable);
        this.deliveryTableManager = new TableManager(deliveryTable);
        this.deliveryProductFilterSupplierComboBox = deliveryProductFilterSupplierComboBox;
        this.deliverySupplierLabel= deliverySupplierLabel;
        this.productController = new ProductController();
        productList = ProductController.getProductList();
        deliveryProductsTableManager.alignCellRight(4);
        }catch(NullPointerException npe){
            
        }
    }
    
    /**
     * Copies the selected product details from the Delivery Products Table
     * to the DeliverySummary Table.
     */
    public void addSelectedToDeliverySummary(){
        
        boolean itemExists = false;
        try{
            String productID = deliveryProductsTableManager.getIDFromTable(deliveryProductsTableManager.getSelectedRow());

            for(int row = 0; row < deliveryTableManager.getRowCount(); row++){
                String truckProductID = deliveryTableManager.getIDFromTable(row);
                itemExists = productID.equals(truckProductID);
            }
            if(itemExists){
                JOptionPane.showMessageDialog(null,
                    "Item already in truck.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }else{
                String name = (String) deliveryProductsTableManager.getValueAt(deliveryProductsTableManager.getSelectedRow(), 1);
                String unit = (String) deliveryProductsTableManager.getValueAt(deliveryProductsTableManager.getSelectedRow(), 3);

                deliveryTableManager.addRowContent(new String[]{productID, name, unit, ""});

            }
        }catch(IndexOutOfBoundsException ioobe){
            ioobe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Please select a Product to add to the Delivery Summary Table", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Removes the selected row in the Delivery Summary<code>JTable</code>
     */
    public void removeSelectedRow(){
        deliveryTableManager.deleteRow();
    }
    
    /**
     * Filters the Products in the Products <code>JTable</code> to show only products 
     * coming from a particular supplier.
     */
    public void filterProducts(){
        
        if(deliveryProductFilterSupplierComboBox.getSelectedItem()!=null && productList != null){
            deliveryProductsTableManager.clearTableContents();
            String supplier = deliveryProductFilterSupplierComboBox.getSelectedItem().toString();
            System.out.print(supplier);
            if(supplier.equals("All")){
                for(Product product : productList){

                String[] deliveryValues = {product.getProductID(), product.getName(),  product.getTypeName(), 
                    product.getUnit(), product.getPhysicalCount(), 
                    product.getReorderQuantityLevel()};

                deliveryProductsTableManager.addRowContent(deliveryValues);
                }
            }else{
                productList = ProductController.getProductList();
                for(Product product : productList){
                    if(product.getSupplierName().equals(supplier)){
                        String[] deliveryValues = {product.getProductID(), product.getName(),  product.getTypeName(), 
                            product.getUnit(), product.getPhysicalCount(), 
                            product.getReorderQuantityLevel()};

                        deliveryProductsTableManager.addRowContent(deliveryValues);
                        
                    }
                }
            }
            deliverySupplierLabel.setText(deliveryProductFilterSupplierComboBox.getSelectedItem().toString());
        }
    }
    
    /**
     * Gets all the products enlisted in the "Delivery" <code>JTable</code> and 
     * creates a delivery and delivery_details topple(s) based on the values 
     * in the table.
     */
    public void acknowledgeDelivery(){
        try{
            ComboItem supplier = (ComboItem)deliveryProductFilterSupplierComboBox.getSelectedItem();
            String supplierID = supplier.getValue();
            
            long timeNow = System.currentTimeMillis();
            Date today = new Date(timeNow);
            
            boolean invalidQuantityFlag = false;
            for(int row = 0; row < deliveryTableManager.getRowCount();row++){
                int quantity = Integer.parseInt(deliveryTableManager.getValueAt(
                        deliveryTableManager.getSelectedRow(), 3));
                if(quantity <= 0){
                    invalidQuantityFlag = true;
                    break;
                }
            }

            
            if(!invalidQuantityFlag){
                dbConnector.insert("INSERT INTO delivery (supplier_id, date_order_received) VALUES(?,?)", 
                        new String[]{supplierID, today.toString() });
                ResultSet rs = dbConnector.query("SELECT delivery_id FROM delivery ORDER BY 1 DESC LIMIT 1");
                rs.next();
                String deliveryID = rs.getString(1);
                for(int row = 0; row < deliveryTableManager.getRowCount(); row++){
                    Integer quantityToTransfer = Integer.parseInt(deliveryTableManager.getValueAt(row, 3));
                        
                    String productID = deliveryTableManager.getIDFromTable(row);
                    if(quantityToTransfer > 0){
                        dbConnector.insert("INSERT INTO deliverydetails "
                                + "(delivery_id, product_id, quantity_delivered)"
                                + " VALUES(?,?,?)", 
                                new String[]{deliveryID, productID, quantityToTransfer.toString()});
                        
                        
                    }
                }
                deliveryTableManager.clearTableContents();
                ProductsUI.updateAdminProductsTable();
                filterProducts();
                dbConnector.closeConnection();
                JOptionPane.showMessageDialog(null, "The delivery acknowledged successfully", "Delivery Acknowledgement Success", JOptionPane.INFORMATION_MESSAGE);        
            }else{
                JOptionPane.showMessageDialog(null, "Please check the delivered quantity of each product. The quantity should not be empty, equal to 0, or less than 0", "Quantity Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to transfer products", "Database error.", JOptionPane.ERROR_MESSAGE);
        }catch(IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "Please input the quantity of the item/s delivered.");
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please input a valid quantity.");
        }
    }
}
