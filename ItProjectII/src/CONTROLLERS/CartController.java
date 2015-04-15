/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.Product;
import UTIL.TableManager;
import UTIL.DatabaseConnector;
import VIEW.Cart;
import VIEW.ProductsUI;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author Belthazod
 */
public class CartController {
    private TableManager cartTableManager;
    private TableManager inventoryTableManager;
    private JDialog salesTypeDialog;
    private static JLabel receiptInfoLabel1;
    private static JLabel receiptInfoLabel2;
    private static JTextField receiptNumberInput;
    private static Cart cart;
    private JTextField inventorySearchInput;
    private ProductController productController;
    private JLabel clearMark;
    
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    
    public CartController(JTable cartTable, JTable inventoryTable, JTextField inventoryTableSearchInput, JLabel clearMark){
        cartTableManager = new TableManager(cartTable);
        cartTableManager.setAutoClear(true);
        inventoryTableManager = new TableManager(inventoryTable);
        inventorySearchInput = inventoryTableSearchInput;
        productController = new ProductController();
        inventoryTableManager.alignCellRight(4);
        this.clearMark = clearMark;
    }
    public CartController (JTable cartTable, JDialog salesTypeDialog, JLabel receiptInfoLabel1, JLabel receiptInfoLabel2, JTextField receiptNumberInput){
        cartTableManager = new TableManager(cartTable);
        cartTableManager.setAutoClear(true);
        this.salesTypeDialog = salesTypeDialog;
        this.receiptInfoLabel1 = receiptInfoLabel1;
        this.receiptInfoLabel2 = receiptInfoLabel2;
        this.receiptNumberInput = receiptNumberInput;
    }
    
    public void addToCart(){
        try{
            int currentQuantity = Integer.parseInt(inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 4));
            String productName = inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
            if(currentQuantity != 0){
                boolean itemExists = false;
                String productID = inventoryTableManager.getIDFromTable(inventoryTableManager.getSelectedRow());
                String existingProductName = "";

                for(int row = 0; row < cartTableManager.getRowCount() && Integer.parseInt(inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1)) == 0; row++){

                    String truckProductID = cartTableManager.getIDFromTable(row);
                    
                   
                    if(productID.equals(truckProductID)){

                        itemExists = true;
                        existingProductName = inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
                        break;
                    }
                    
                }
                if(itemExists){
                JOptionPane op = new JOptionPane(existingProductName + " is already in the list.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
//                    JOptionPane.showMessageDialog(null,
//                        "Item already in cart.",
//                        "Error",
//                        JOptionPane.ERROR_MESSAGE);
                }else{
                    String name = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
                    String supplier = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 3);
                    String quantity = (String)  inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 4);
                    String warranty = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1);
                    
                    cartTableManager.addRowContent(new String[]{productID, warranty, name, supplier, quantity, "", ""});
                }
            }else{
                JOptionPane op = new JOptionPane("There are no available stocks for " + productName + ". Add to list failed.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "There is no available stock for " + productName + ". Cannot add to cart.", "Product Selection Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NullPointerException | IndexOutOfBoundsException npe){
            //JOptionPane.showMessageDialog(null, "Please select an item from the table to mark as bought.", "Product Selection Error", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearCart(){
        cartTableManager.clearTableContents();
    }
    
    public void markItemsAsSold(String salesType){
        
        long timeNow = System.currentTimeMillis();
        Date today = new Date(timeNow);
        String receiptNumber = "";
        boolean orIsEmpty = false;
        try{
            if(receiptNumberInput.isVisible()){
                receiptNumber = receiptNumberInput.getText();
                if(receiptNumber.equals("")){
                    orIsEmpty = true;
                }
                dbConnector.insert("INSERT INTO sales(sales_date, sales_type, receipt_number) VALUES(?,?,?)", new String[]{today.toString(), salesType, receiptNumber});
            }else{
                dbConnector.insert("INSERT INTO sales(sales_date, sales_type) VALUES(?,?)", new String[]{today.toString(), salesType});
            }
            
            if(!orIsEmpty){
                ResultSet rs = dbConnector.query("SELECT sales_id FROM sales ORDER BY 1 DESC LIMIT 1");

                rs.next();

                for(int i = 0; i< cartTableManager.getRowCount(); i++){
                    String productID = cartTableManager.getIDFromTable(i);
                    String quantity = cartTableManager.getValueAt(i, 6);
                    String serialNumber = cartTableManager.getValueAt(i,5);
                    String warranty = cartTableManager.getValueAt(i, 1);
                    if(Integer.parseInt(warranty) > 0){
                    dbConnector.insert("INSERT INTO sales_details(sales_id, product_id, serial_number, warranty_duration) VALUES(?,?,?,?)", new String[]{rs.getString(1), productID, serialNumber, warranty});
                    
                    }else{
                    dbConnector.insert("INSERT INTO sales_details(sales_id, product_id, quantity_sold, warranty_duration) VALUES(?,?,?,?)", new String[]{rs.getString(1), productID, quantity, warranty});
                    }
                }

                salesTypeDialog.dispose();
                cartTableManager.clearTableContents();
                cart.setVisible(false);
                ProductsUI.updateAdminProductsTable();
                JOptionPane op = new JOptionPane("This item is already in the list.",JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Items successfully marked as bought.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane op = new JOptionPane("Please enter serial number.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Serial Number Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Please enter serial number.", "Serial number error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    
    public void openSalesTypeDialog(){
        try{
            boolean greaterThanQuantity = false;
            boolean lessThanOrEqualToZero = false;
            boolean noSerialNumber = false;
            int quantity = 0;
            int currentQuantity = 0;
            int warranty = 0;
            String serialNumber = "";
            for(int i = 0; i< cartTableManager.getRowCount(); i++){
                
                if(Integer.parseInt(cartTableManager.getValueAt(i, 1)) == 0){
                    quantity = Integer.parseInt(cartTableManager.getValueAt(i, 6));
                    currentQuantity = Integer.parseInt(cartTableManager.getValueAt(i, 4));
                }else if(Integer.parseInt(cartTableManager.getValueAt(i, 1)) > 0){
                    warranty = Integer.parseInt(cartTableManager.getValueAt(i, 1));
                    serialNumber = cartTableManager.getValueAt(i,5);
                }
                
                
                String productName = cartTableManager.getValueAt(i, 2);
                if(warranty == 0 && quantity>currentQuantity ){
                    greaterThanQuantity = true;
                JOptionPane op = new JOptionPane("The entered quantity sold for " + productName + " exceeds the physical count in stock. \n Please check the quantity before proceeding.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " exceeds the physical count in stock. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                if(warranty == 0 && quantity <= 0){
                    lessThanOrEqualToZero = true;
                JOptionPane op = new JOptionPane("The entered quantity sold for " + productName + " cannot be negative or zero. \n Please check the quantity before proceeding.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);   
                    //JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " cannot be negative or zero. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                     break;
                }
                if(warranty > 0 && serialNumber.equals("")){
                    noSerialNumber = true;
                JOptionPane op = new JOptionPane("Please input the serial number for " + productName + ".",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);   
                    //JOptionPane.showMessageDialog(null, "Please input the serial number for " + productName + ".", "Input Error", JOptionPane.ERROR_MESSAGE);
                     break;
                }
                
            }
            if(cartTableManager.getRowCount() == 0){
                JOptionPane op = new JOptionPane("There is/are no item/s to checkout.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Checkout Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true); 
               // JOptionPane.showMessageDialog(null, "There are no items placed in the cart. Cannot checkout", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!greaterThanQuantity && !lessThanOrEqualToZero && !noSerialNumber && cartTableManager.getRowCount() != 0){
                salesTypeDialog.setVisible(true);
            }
       }catch(NumberFormatException | NullPointerException nfe){
           //JOptionPane.showMessageDialog(null, "Please set the quantity of all items before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    public void searchProduct(){
        String productName = inventorySearchInput.getText();
        
        ArrayList<Product> productList = productController.getProducts();
        inventoryTableManager.clearTableContents();
        for(Product product: productList){
            if(product.getName().contains(productName)){
                String[] adminCompleteValues = {product.getProductID(), product.getWarranty(), product.getName(), 
                     product.getSupplierName(),
                     product.getPhysicalCount(), 
                    product.getReorderQuantityLevel()};
                inventoryTableManager.addRowContent(adminCompleteValues);
            }
        }
        if(productName.equals("")){
            clearMark.setVisible(false);
        }else{
            clearMark.setVisible(true);
        }
    }
    
    public void clearSearch(){
        inventorySearchInput.setText("");
        searchProduct();
        clearMark.setVisible(false);
    }
    
    public void closeSalesTypeDialog(){
        salesTypeDialog.dispose();
    }
    
    public void selectTypeService (){
        markItemsAsSold("service");
    }
    
    public void selectTypePurchase (){
        markItemsAsSold("purchase");
    }
    
   
}
