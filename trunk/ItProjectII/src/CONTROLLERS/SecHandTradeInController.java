/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import BEANS.SecondHandProduct;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import UTIL.TableManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.ArrayList;
/**
 *
 * @author AMD
 */
public class SecHandTradeInController {
    private final DatabaseConnector dbConnector;
    private TableManager secondHandTableManager;
    private static ArrayList<SecondHandProduct> secHandItems;
    static JComboBox category;
    
    public SecHandTradeInController(JTable table){
        secondHandTableManager = new TableManager(table);
        dbConnector = DatabaseConnector.getInstance();
        secHandItems = new ArrayList<SecondHandProduct>();
    }
    

    public void addSecondHand(JTextField itemName, JTextField description, JComboBox category){
        try{
        //Object supplierComboBoxitem = supplier.getSelectedItem();
        //String supplierID = ((ComboItem)supplierComboBoxitem).getValue();
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getValue();
        
        System.out.println(typeID);
        //ResultSet supplierResult = dbConnector.query("SELECT supplier_id FROM supplier WHERE supplier_name = ? LIMIT 1", supplier.getSelectedItem().toString());
        JTextField[] inputs = {itemName, description};
        String[] values = {typeID, itemName.getText(), description.getText()};
       
        if(InputValidator.checkInput(itemName.getText(), "Product Name cannot be empty.")){
            
            dbConnector.insert("INSERT INTO secondhand ( used_item_type, used_item_name, description) "
                    + "VALUES(?,?,?)", values);
            
            JOptionPane.showMessageDialog(null, itemName.getText() + " added to list of secondhand items.", "Success", JOptionPane.INFORMATION_MESSAGE);
            InputValidator.clearInput(inputs);
        }
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add Product.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
     public ArrayList<SecondHandProduct> getSecItems(){
        secHandItems = new ArrayList<SecondHandProduct>();
        try{
            String selectString = "SELECT used_item_id, used_item_name, "
                + "used_item_type, type_name, description "
                + "FROM secondhand JOIN type ON type.type_id = used_item_type;";
            ResultSet rs = dbConnector.query(selectString);

            while(rs.next()){
                SecondHandProduct shp = new SecondHandProduct(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5));

                secHandItems.add(shp);
            }
            dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Incorrect Product SQL query", "Database error", JOptionPane.ERROR_MESSAGE);
        }
        return secHandItems;
    }
     public static ArrayList<SecondHandProduct> getSecItemList() {
        return secHandItems;
    }
     public void updateSecondHandTable(){
         secondHandTableManager.clearTableContents();
         
         getSecItems();
         for(SecondHandProduct shp : secHandItems){
                String[] transferValues = {shp.getProductID(), shp.getName(), 
                    shp.getDescription(), shp.getTypeName()};
                secondHandTableManager.addRowContent(transferValues);
    }        
     }
     public void deleteSelectedItem(){
      
        try{
            String itemID = secondHandTableManager.getIDFromTable(secondHandTableManager.getSelectedRow());
            dbConnector.delete("DELETE FROM secondhand WHERE used_item_id = ?", itemID);
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete item from the Users list.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  /*  
     public void tradeItem(){
        Integer selectedRow = secondHandProductsListTable.getSelectedRow();
        String item = (String) secondHandProductsListTable.getModel().getValueAt(selectedRow, 1);
        int result = JOptionPane.showConfirmDialog(null, "Swap " + item,"Warning!" ,JOptionPane.YES_NO_OPTION);
        if(result == 0){
        secHandTradeInController.addSecondHand(itemNameInput, descriptionInput, secondHandCategoryComboBox);
        secHandTradeInController.deleteSelectedItem();   
        secHandTradeInController.updateSecondHandTable();
        }
     }
     */
}
