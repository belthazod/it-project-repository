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
                if(itemExists && Integer.parseInt(inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1)) == 0){
                    JOptionPane.showMessageDialog(null,
                        "Item already in cart.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }else{
                    String name = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
                    String description = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 3);
                    String unit = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 5);
                    String quantity = (String)  inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 7);
                    String warranty = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1);
                    
                    cartTableManager.addRowContent(new String[]{productID, quantity, warranty, name, description, unit, "", ""});
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
                    String quantity = cartTableManager.getValueAt(i, 7);
                    String serialNumber = cartTableManager.getValueAt(i,6);
                    String warranty = cartTableManager.getValueAt(i, 2);
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
            boolean noSerialNumber = false;
            int quantity = 0;
            int currentQuantity = 0;
            int warranty = 0;
            String serialNumber = "";
            for(int i = 0; i< cartTableManager.getRowCount(); i++){
                
                if(Integer.parseInt(cartTableManager.getValueAt(i, 2)) == 0){
                    quantity = Integer.parseInt(cartTableManager.getValueAt(i, 7));
                    currentQuantity = Integer.parseInt(cartTableManager.getValueAt(i, 1));
                }else if(Integer.parseInt(cartTableManager.getValueAt(i, 2)) > 0){
                    warranty = Integer.parseInt(cartTableManager.getValueAt(i, 2));
                    serialNumber = cartTableManager.getValueAt(i,6);
                }
                
                
                String productName = cartTableManager.getValueAt(i, 3);
                if(warranty == 0 && quantity>currentQuantity ){
                    greaterThanQuantity = true;
                    JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " exceeds the physical count in stock. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                if(warranty == 0 && quantity <= 0){
                    lessThanOrEqualToZero = true;
                    JOptionPane.showMessageDialog(null, "The set quantity sold for " + productName + " cannot be negative or zero. \n Please check the quantity before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
                     break;
                }
                if(warranty > 0 && serialNumber.equals("")){
                    noSerialNumber = true;
                    JOptionPane.showMessageDialog(null, "Please input the serial number for " + productName + ".", "Input Error", JOptionPane.ERROR_MESSAGE);
                     break;
                }
                
            }
            if(cartTableManager.getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "There are no items placed in the cart. Cannot checkout", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!greaterThanQuantity && !lessThanOrEqualToZero && !noSerialNumber && cartTableManager.getRowCount() != 0){
                salesTypeDialog.setVisible(true);
            }
       }catch(NumberFormatException | NullPointerException nfe){
           JOptionPane.showMessageDialog(null, "Please set the quantity of all items before proceeding.", "Input Error", JOptionPane.ERROR_MESSAGE);
       }catch(Exception e){
           e.printStackTrace();
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
    
   
}
