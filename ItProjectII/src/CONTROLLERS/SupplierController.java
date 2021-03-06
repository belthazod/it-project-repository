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
import javax.swing.JDialog;
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


    public SupplierController(JTable table, JComboBox<ComboItem> addProductSupplierComboBox, JComboBox<ComboItem> editProductSupplierComboBox, JComboBox<ComboItem> deliveryProductFilterSupplierComboBox) {
        supplierTableManager = new TableManager(table);
        dbConnector= DatabaseConnector.getInstance();

        this.addProductSupplierComboBox = addProductSupplierComboBox;
        this.editProductSupplierComboBox = editProductSupplierComboBox;
        this.deliveryProductFilterSupplierComboBox = deliveryProductFilterSupplierComboBox;
        this.deliverySupplierComboBox = deliverySupplierComboBox;
    }
    
    public void addSupplier(JTextField name, JTextField number){

        if(InputValidator.checkInput(name.getText(), "Supplier Name cannot be empty.") 
                && InputValidator.checkInput(number.getText(), "Contact Number cannot be empty")){
            
           if(InputValidator.match(number.getText()) == true || InputValidator.match2(number.getText()) == true 
           || InputValidator.match3(number.getText()) == true || InputValidator.match4(number.getText()) == true){
            String[] values = {name.getText(), number.getText()};
            try{
            dbConnector.insert("INSERT INTO Supplier(supplier_name, supplier_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name, number};
            
            JOptionPane.showMessageDialog(null, name.getText() + " saved to Supplier list.");
            InputValidator.clearInput(inputs);
            dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane op = new JOptionPane("Failed to add supplier.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Add to suppliers list failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
            
            }else{
                JOptionPane op = new JOptionPane("Invalid contact number. Please input a valid contact number.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
               // JOptionPane.showMessageDialog(null, "Invalid contact number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
                JOptionPane op = new JOptionPane("Please fill out all the fields.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
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
                if(InputValidator.match(contactNumber.getText()) == true || InputValidator.match2(contactNumber.getText()) == true 
                || InputValidator.match3(contactNumber.getText()) == true || InputValidator.match4(contactNumber.getText()) == true){
                String[] values = {name.getText(), contactNumber.getText()};
                dbConnector.update("UPDATE supplier SET supplier_name = ?, supplier_contact = ? WHERE supplier_id = ?", values, supplierID);
                JTextField[] inputs = {contactNumber, name};
                JOptionPane op = new JOptionPane("Supplier details successfully updated.",JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = op.createDialog("Edit Supplier");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Supplier details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                InputValidator.clearInput(inputs);
                dbConnector.closeConnection();
                }else{
                JOptionPane op = new JOptionPane("Invalid contact number. Please enter a valid contact.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //    JOptionPane.showMessageDialog(null, "Invalid contact number.", "Error", JOptionPane.ERROR_MESSAGE);                   
                }
            }catch(SQLException sqlE){
                JOptionPane op = new JOptionPane("Failed to edit supplier.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
               // JOptionPane.showMessageDialog(null, "Edit supplier failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }        
           }else{
                JOptionPane op = new JOptionPane("Please fill out all fields",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
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
                JOptionPane op = new JOptionPane("Failed to delete selected supplier. Supplier is currently linked to a product. \n\nTo remove this supplier. Please clear all products associated with it.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Failed to delete selected supplier. Supplier is currently linked to a product. \n\nTo remove this supplier. Please clear all products associated with it.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }else{
            sqlE.printStackTrace();
            JOptionPane op = new JOptionPane("Failed to delete selected supplier.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Failed to delete selected supplier.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void updateSupplierComponents(){
        try{
            ResultSet rs = dbConnector.query("SELECT supplier_id, supplier_name FROM supplier");
            addProductSupplierComboBox.removeAllItems();
            editProductSupplierComboBox.removeAllItems();
            deliveryProductFilterSupplierComboBox.removeAllItems();
            while(rs.next()){
                String supplierID = rs.getString(1);
                String supplierName = rs.getString(2);
                
                addProductSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
                editProductSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
                deliveryProductFilterSupplierComboBox.addItem(new ComboItem(supplierID, supplierName));
            }
        } catch(SQLException sqlE){
             sqlE.printStackTrace();
             JOptionPane op = new JOptionPane("Failed to update supplier components.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
             //JOptionPane.showMessageDialog(null,"Failed to update Supplier Components.", "Database Error", JOptionPane.ERROR_MESSAGE);
         }
    }
}
