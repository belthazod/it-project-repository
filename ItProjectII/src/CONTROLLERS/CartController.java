/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import UTIL.TableManager;
import UTIL.DatabaseConnector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Belthazod
 */
public class CartController {
    private TableManager cartTableManager;
    private TableManager inventoryTableManager;
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    
    public CartController(JTable cartTable, JTable inventoryTable){
        cartTableManager = new TableManager(cartTable);
        inventoryTableManager = new TableManager(inventoryTable);
    }
    
    public void addToCart(){
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
            String name = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 1);
            String description = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 2);
            String unit = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 4);
            String category = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 3);
            String quantity = (String)  inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 6);
            String supplier = (String) inventoryTableManager.getValueAt(inventoryTableManager.getSelectedRow(), 5);
            
            cartTableManager.addRowContent(new String[]{productID, quantity, name, description, category, unit, supplier, ""});
        }
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
