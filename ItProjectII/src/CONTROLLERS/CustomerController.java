/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import UTIL.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class CustomerController {
    private final DatabaseConnector dbConnector; 
    private TableManager customerTableManager;
    

    public CustomerController(JTable table) {
        customerTableManager = new TableManager(table);
        dbConnector= DatabaseConnector.getInstance();
       
    }
    
    public void addCustomer(JTextField name, JTextField number){

        if(InputValidator.checkInput(name.getText(), "Customer Name cannot be empty.") 
                && InputValidator.checkInput(number.getText(), "Contact Number cannot be empty")){
                       
            if(InputValidator.match(number.getText()) == true || InputValidator.match2(number.getText()) == true 
                || InputValidator.match3(number.getText()) == true || InputValidator.match4(number.getText()) == true){
            String[] values = {name.getText(), number.getText()};
 
            try{
            dbConnector.insert("INSERT INTO Customer(customer_name, customer_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name,number};
            JOptionPane op = new JOptionPane(name.getText() + " saved to Customers list.",JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = op.createDialog("Add Customer");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, name.getText() + " saved to Customers list.");
            InputValidator.clearInput(inputs);
            dbConnector.closeConnection();
            }catch(SQLException sqlE){
                JOptionPane op = new JOptionPane("Failed to add Contact.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Add to contacts failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
            }else{
                JOptionPane op = new JOptionPane("Invalid contact number. Please enter a valid contact number.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Invalid contact number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
    }else{
                JOptionPane op = new JOptionPane("Please fill out all fields.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateTableContents(){
        try{
        ResultSet rs = dbConnector.query("SELECT customer_id, customer_name, customer_contact FROM customer ORDER BY 2 ASC");
        customerTableManager.importDBContents(rs);
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane op = new JOptionPane("Failed to update Customer Table.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true); //<-- this line
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Customer Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editCustomer(JTextField name, JTextField contactNumber, String customerID){

        if(InputValidator.checkInput(name.getText(), "Customer Name cannot be empty.") 
                & InputValidator.checkInput(contactNumber.getText(), "Contact Number cannot be empty.")){
            
            try{
                if(InputValidator.match(contactNumber.getText()) == true || InputValidator.match2(contactNumber.getText()) == true 
                || InputValidator.match3(contactNumber.getText()) == true || InputValidator.match4(contactNumber.getText()) == true){
                String[] values = {name.getText(), contactNumber.getText()};
                dbConnector.update("UPDATE customer SET customer_name = ?, customer_contact = ? WHERE customer_id = ?", values, customerID);
                JOptionPane.showMessageDialog(null, "Customer details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                JTextField[] inputs = {contactNumber, name};
                InputValidator.clearInput(inputs);
                dbConnector.closeConnection();
                }else{
                JOptionPane op = new JOptionPane("Invalid contact number. Please enter a valid contact number.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); 
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "Invalid contact number.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            }catch(SQLException sqlE){
                JOptionPane op = new JOptionPane("Failed to edti customer.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true); 
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Edit customer failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
                JOptionPane op = new JOptionPane("Please fill out all fields.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Input Error");
                dialog.setAlwaysOnTop(true); 
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean openEditDialog(String customerID, JTextField[] inputs, JLabel custID){
        try{
            ResultSet rs = dbConnector.query("SELECT customer_name, customer_contact FROM customer WHERE customer_id = ?", customerID);
            while(rs.next()){
                for(int i = 0; i < inputs.length; i++){
                    inputs[i].setText(rs.getString(i+1));
                }
            }
            custID.setText(customerID);
            return true;
           
        }catch(SQLException sqlE){
            JOptionPane op = new JOptionPane("Editing failed.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Editing failed", "Database error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void deleteSelectedCustomer(){
        try{
            String customerID = customerTableManager.getIDFromTable(customerTableManager.getSelectedRow());
            dbConnector.delete("DELETE FROM customer WHERE customer_id = ?", customerID);
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane op = new JOptionPane("Failed to delete customer.",JOptionPane.ERROR_MESSAGE);
                JDialog dialog = op.createDialog("Database Error");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            //JOptionPane.showMessageDialog(null, "Failed to delete selected customer.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}