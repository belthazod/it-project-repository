/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import UTIL.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Belthazod
 */
public class SupplierController {
    private final DatabaseConnector dbConnector; 
    private TableManager supplierTableManager;
    private JComboBox<ComboItem> addProductSupplierComboBox;
    private JComboBox<ComboItem> editProductSupplierComboBox;
    private JComboBox<ComboItem> deliveryProductFilterSupplierComboBox;
    private JComboBox<ComboItem> deliverySupplierComboBox;

    public SupplierController(JTable table, JComboBox<ComboItem> addProductSupplierComboBox, JComboBox<ComboItem> editProductSupplierComboBox, JComboBox<ComboItem> deliveryProductFilterSupplierComboBox, JComboBox<ComboItem> deliverySupplierComboBox) {
        supplierTableManager = new TableManager(table);
        dbConnector= DatabaseConnector.getInstance();
        this.addProductSupplierComboBox = addProductSupplierComboBox;
        this.editProductSupplierComboBox = editProductSupplierComboBox;
        this.deliveryProductFilterSupplierComboBox = deliveryProductFilterSupplierComboBox;
        this.deliverySupplierComboBox = deliverySupplierComboBox;
    }
    
    public void addSupplier(JTextField name, JTextField number, JComboBox Contactcmb){
        
        Pattern pat = Pattern.compile("[0-9]{9}");
        Matcher mat = pat.matcher(number.getText());
        boolean match = mat.matches();
        
        Pattern pat2 = Pattern.compile("[0-9]{7}");
        Matcher mat2 = pat2.matcher(number.getText());
        boolean match2 = mat2.matches();
        
        if(InputValidator.checkInput(name.getText(), "Supplier Name cannot be empty.") 
                && InputValidator.checkInput(number.getText(), "Contact Number cannot be empty")){
            Object selected = Contactcmb.getSelectedItem();
            
            if(selected.toString().equals("09") && match == true){
            String[] values = {name.getText(), selected + number.getText()};
            try{
            dbConnector.insert("INSERT INTO Supplier(supplier_name, supplier_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name, number};
            
            JOptionPane.showMessageDialog(null, name.getText() + " saved to Supplier list.");
            InputValidator.clearInput(inputs);
            dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null, "Add to suppliers list failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
            
            }else if(selected.toString().equals("+639") && match == true){
            String[] values = {name.getText(), selected + number.getText()};
            try{
            dbConnector.insert("INSERT INTO Supplier(supplier_name, supplier_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name, number};
            
            JOptionPane.showMessageDialog(null, name.getText() + " saved to Supplier list.");
            InputValidator.clearInput(inputs);
            dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null, "Add to suppliers list failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
            }else if(selected.toString().equals("074") && match2 == true){
             String[] values = {name.getText(), selected + number.getText()};
            try{
            dbConnector.insert("INSERT INTO Supplier(supplier_name, supplier_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name, number};
            
            JOptionPane.showMessageDialog(null, name.getText() + " saved to Supplier list.");
            InputValidator.clearInput(inputs);
            dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null, "Add to suppliers list failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a valid phone number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateTableContents(){
        try{
        ResultSet rs = dbConnector.query("SELECT supplier_id, supplier_name, supplier_contact FROM supplier ORDER BY 2 ASC");
        supplierTableManager.importDBContents(rs);
        updateSupplierComponents();
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editSupplier(JTextField name, JTextField contactNumber, String supplierID){
        if(InputValidator.checkInput(name.getText(), "Supplier Name cannot be empty.") 
                & InputValidator.checkInput(contactNumber.getText(), "Contact Number cannot be empty.")){
            try{
                String[] values = {name.getText(), contactNumber.getText()};
                dbConnector.update("UPDATE supplier SET supplier_name = ?, supplier_contact = ? WHERE supplier_id = ?", values, supplierID);
                JTextField[] inputs = {contactNumber, name};
                JOptionPane.showMessageDialog(null, "Supplier details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                InputValidator.clearInput(inputs);
                dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null, "Edit supplier failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean openEditDialog(String supplierID, JTextField[] inputs, JLabel supplierIDTextField){
        try{
            ResultSet rs = dbConnector.query("SELECT supplier_name, supplier_contact FROM supplier WHERE supplier_id = ?", supplierID);
            while(rs.next()){
                for(int i = 0; i < inputs.length; i++){
                    inputs[i].setText(rs.getString(i+1));
                }
            }
            supplierIDTextField.setText(supplierID);
            return true;
           
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to edit supplier details.", "Database error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void deleteSelectedSupplier(){
        try{
            String supplierID = supplierTableManager.getIDFromTable(supplierTableManager.getSelectedRow());
            dbConnector.delete("DELETE FROM supplier WHERE supplier_id = ?", supplierID);
            JOptionPane.showMessageDialog(null, "Selected supplier was deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException sqlE){
            if(sqlE.getSQLState().startsWith("23")){
                JOptionPane.showMessageDialog(null, "Failed to delete selected supplier. Supplier is currently linked to a product. \n\nTo remove this supplier. Please clear all products associated with it.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }else{
            sqlE.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Failed to delete selected supplier.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void updateSupplierComponents(){
        try{
            ResultSet rs = dbConnector.query("SELECT supplier_id, supplier_name FROM supplier");
            addProductSupplierComboBox.removeAllItems();
            editProductSupplierComboBox.removeAllItems();
            deliveryProductFilterSupplierComboBox.removeAllItems();
            deliverySupplierComboBox.removeAllItems();
            deliveryProductFilterSupplierComboBox.addItem(new ComboItem( null, "All"));
            while(rs.next()){
                String supplierID = rs.getString(1);
                String supplierName = rs.getString(2);
                
                addProductSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
                editProductSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
                deliveryProductFilterSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
                deliverySupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
            }
        } catch(SQLException sqlE){
             sqlE.printStackTrace();
             JOptionPane.showMessageDialog(null,"Failed to update Supplier Components.", "Database Error", JOptionPane.ERROR_MESSAGE);
         }
    }
}
