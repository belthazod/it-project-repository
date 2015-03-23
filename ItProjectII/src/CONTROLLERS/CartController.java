/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import UTIL.TableManager;
import UTIL.DatabaseConnector;
import VIEW.Cart;
import VIEW.ProductsUI;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    
    public CartController(JTable cartTable, JTable inventoryTable, Cart cart){
        cartTableManager = new TableManager(cartTable);
        cartTableManager.setAutoClear(true);
        inventoryTableManager = new TableManager(inventoryTable);
        this.cart = cart;
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
            int currentQuantity = Integer.parseInt(inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 7));
            String productName = inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
            if(currentQuantity != 0){

                boolean itemExists = false;
                String productID = inventoryTableManager.getIDFromTable(inventoryTableManager.getSelectedRow());

                for(int row = 0; row < cartTableManager.getRowCount(); row++){
                    String truckProductID = cartTableManager.getIDFromTable(row);
                    itemExists = productID.equals(truckProductID);
                }
                if(itemExists){
                    JOptionPane.showMessageDialog(null,
                        "Item already in cart.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }else{
                    String name = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
                    String description = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 3);
                    String unit = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 5);
                    String category = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 4);
                    String quantity = (String)  inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 7);
                    String supplier = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 6);
                    String warranty = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1);
                    
                    cartTableManager.addRowContent(new String[]{productID, quantity, warranty, name, description, category, unit, supplier, ""});
                    cart.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "There is no available stock for " + productName + ". Cannot add to cart.", "Product Selection Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(NullPointerException | IndexOutOfBoundsException npe){
            JOptionPane.showMessageDialog(null, "Please select an item from the table to mark as bought.", "Product Selection Error", JOptionPane.ERROR_MESSAGE);
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
                    String quantity = cartTableManager.getValueAt(i, 8);
                    dbConnector.insert("INSERT INTO sales_details(sales_id, product_id, quantity_sold) VALUES(?,?,?)", new String[]{rs.getString(1), productID, quantity});
                }

                salesTypeDialog.dispose();
                cartTableManager.clearTableContents();
                cart.setVisible(false);
                ProductsUI.updateAdminProductsTable();
                JOptionPane.showMessageDialog(null, "Items successfully marked as bought.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Please enter serial number.", "Serial number error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    
    public void openSalesTypeDialog(){
        try{
            boolean greaterThanQuantity = false;
            boolean lessThanOrEqualToZero = false;
            for(int i = 0; i< cartTableManager.getRowCount(); i++){
                int quantity = Integer.parseInt(cartTableManager.getValueAt(i, 8));
                int currentQuantity = Integer.parseInt(cartTableManager.getValueAt(i, 1));
                
                
                String productName = cartTableManager.getValueAt(i, 3);
                if(quantity>currentQuantity){
                    greaterThanQuantity = true;
                    JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " exceeds the physical count in stock. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                if(quantity <= 0 ){
                    lessThanOrEqualToZero = true;
                    JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " cannot be negative or zero. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                     break;
                }
            }
            if(cartTableManager.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "There are no items placed in the cart. Cannot checkout", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!greaterThanQuantity && !lessThanOrEqualToZero){
                boolean hasWarranty = false;
                for(int i = 0; i< cartTableManager.getRowCount(); i++){
                    int warranty =  Integer.parseInt(cartTableManager.getValueAt(i, 2));
                    
                    if(warranty > 0){
                        hasWarranty = true;
                    }
                }
                
                if(hasWarranty){
                    receiptInfoLabel1.setVisible(true);
                    receiptInfoLabel2.setVisible(true);
                    receiptNumberInput.setVisible(true);
                }else{
                    receiptInfoLabel1.setVisible(false);
                    receiptInfoLabel2.setVisible(false);
                    receiptNumberInput.setVisible(false);
                }
                salesTypeDialog.setVisible(true);
            }
       }catch(NumberFormatException | NullPointerException nfe){
           nfe.printStackTrace();
           JOptionPane.showMessageDialog(null, "Please set the quantity of all items before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
       }
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
    
//    public void deleteCategory(){
//        try{
//            String categoryID = categoryTableManager.getIDFromTable(categoryTableManager.getSelectedRow());
//            dbConnector.delete("DELETE FROM type WHERE type_id = ?", categoryID);
//        }catch(SQLException sqlE){
//            if(sqlE.getSQLState().startsWith("23")){
//                JOptionPane.showMessageDialog(null, "Failed to delete selected category. Category is currently linked to a product. \n\nTo remove this category. Please clear all products associated with it.", "Constraint Error", JOptionPane.ERROR_MESSAGE);
//            }else{
//            sqlE.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Failed to delete category", "Database error.", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//    
//    public void updateCategoryTable(){
//        try{
//        ResultSet rs = dbConnector.query("SELECT type_id, type_name FROM type ORDER BY 2 ASC");
//        categoryTableManager.importDBContents(rs);
//        updateCategoryComponents();
//        dbConnector.closeConnection();
//        }catch(SQLException sqlE){
//            JOptionPane.showMessageDialog(null, "Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    
//    public boolean openEditDialog(String selectedTypeID, JTextField input, JLabel typeID){
//        try{
//            ResultSet rs = dbConnector.query("SELECT type_name FROM type WHERE type_id = ?", selectedTypeID);
//            rs.next();
//                input.setText(rs.getString(1));
//            typeID.setText(selectedTypeID);
//            return true;
//           
//        }catch(SQLException sqlE){
//            sqlE.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Editing failed", "Database error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    }
//    public void updateCategoryComponents(){
//        addProductCategoryComboBox.removeAllItems();
//        editProductCategoryComboBox.removeAllItems();
//        secondHandCategoryComboBox.removeAllItems();
//        try{
//        ResultSet rs = dbConnector.query("SELECT type_id, type_name FROM type ORDER BY 2 ASC");
//        while(rs.next()){
//            String categoryID = rs.getString(1);
//            String categoryName = rs.getString(2);
//            addProductCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
//            editProductCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
//            secondHandCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
//        }
//        dbConnector.closeConnection();
//        }catch(SQLException sqlE){
//            JOptionPane.showMessageDialog(null, "Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
   
}
