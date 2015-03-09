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
import java.util.ArrayList;
import javax.swing.JComboBox;
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
    private JComboBox<ComboItem> deliverySupplierComboBox;
    private ProductController productController;
    private ArrayList<Product> productList;
    /**
     * Creates and instance of <code>DeliveryController</code> based on the given UI components to be manipulated
     * @param deliveryProductsTable - the <code>JTable</code> containing the list of all products in the inventory system
     * @param deliveryTable - the <code>JTable</code> containing the list of all products received from delivery
     * @param deliveryProductFilterSupplierComboBox - the <code>JComboBox</code> containing the list of suppliers to filter the Products in the Inventory System
     * @param deliverySupplierComboBox - the <code>JComboBox</code> containing the list of suppliers to identify from whom the delivery came from.
     */
    public DeliveryController(JTable deliveryProductsTable, JTable deliveryTable, JComboBox<ComboItem> deliveryProductFilterSupplierComboBox, JComboBox<ComboItem> deliverySupplierComboBox){
        this.deliveryProductsTableManager = new TableManager(deliveryProductsTable);
        this.deliveryTableManager = new TableManager(deliveryTable);
        this.deliveryProductFilterSupplierComboBox = deliveryProductFilterSupplierComboBox;
        this.deliverySupplierComboBox = deliverySupplierComboBox;
        this.productController = new ProductController();
        productList = ProductController.getProductList();
    }
    
    /**
     * Copies the selected product details from the Delivery Products Table
     * to the DeliverySummary Table.
     */
    public void addSelectedToDeliverySummary(){
        
        boolean itemExists = false;
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
            String description = (String) deliveryProductsTableManager.getValueAt(deliveryProductsTableManager.getSelectedRow(), 2);
            String unit = (String) deliveryProductsTableManager.getValueAt(deliveryProductsTableManager.getSelectedRow(), 4);
        
            deliveryTableManager.addRowContent(new String[]{productID, name, description, unit, ""});
            
        }
    }
    
    /**
     * Removes the selected row in the Delivery Summary<code>JTable</code>
     */
    public void removeSelectedRow(){
        deliveryTableManager.deleteRow();
    }
    
    public void filterProducts(){
        
        if(deliveryProductFilterSupplierComboBox.getSelectedItem()!=null && productList != null){
            deliveryProductsTableManager.clearTableContents();
            String supplier = deliveryProductFilterSupplierComboBox.getSelectedItem().toString();
            System.out.print(supplier);
            if(supplier.equals("All")){
                for(Product product : productList){

                String[] deliveryValues = {product.getProductID(), product.getName(), 
                    product.getDescription(), product.getTypeName(), 
                    product.getUnit(), product.getPhysicalCount(), 
                    product.getReorderQuantityLevel()};

                deliveryProductsTableManager.addRowContent(deliveryValues);
                }
            }else{
                for(Product product : productList){

                    if(product.getSupplierName().equals(supplier)){
                        String[] deliveryValues = {product.getProductID(), product.getName(), 
                            product.getDescription(), product.getTypeName(), 
                            product.getUnit(), product.getPhysicalCount(), 
                            product.getReorderQuantityLevel()};

                        deliveryProductsTableManager.addRowContent(deliveryValues);
                    }
                }
            }
        }
    }
}
