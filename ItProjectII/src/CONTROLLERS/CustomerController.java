/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.DatabaseConnector;
import BEANS.InputValidator;
import BEANS.TableManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class CustomerController{
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    private TableManager customerTableManager;
    
    public CustomerController() {
    }

    public CustomerController(JTable table) {
        customerTableManager = new TableManager(table);
    }
    
    public void addCustomer(JTextField name, JTextField number){
        if(InputValidator.checkInput(name) && InputValidator.checkInput(number)){
            String[] values = {name.getText(), number.getText()};
            try{
            dbConnector.insert("INSERT INTO Customer(customer_name, customer_contact) VALUES(?,?)", values);
            JTextField[] inputs = {name, number};
            
            JOptionPane.showMessageDialog(null, name.getText() + " saved to Customers list.");
            InputValidator.clearInput(inputs);
            }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null, "Add to contacts failed", "Database error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please fill out all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
