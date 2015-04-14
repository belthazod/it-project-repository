/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import UTIL.DatabaseConnector;
import UTIL.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class WarrantyController {
    DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    TableManager warrantyTableManager;
    JTextField serialNumberInput;
    JLabel productNameLabel;
    JLabel durationLabel;
    JLabel salesDateLabel;
    JLabel salesIDLabel;
    JLabel productIDLabel;
    public WarrantyController(JTable warrantyTable, JTextField serialNumberInput, JLabel productNameLabel, JLabel durationLabel, JLabel salesDateLabel, JLabel salesIDLabel, JLabel productIDLabel){
        this.productNameLabel = productNameLabel;
        this.durationLabel = durationLabel;
        this.salesDateLabel = salesDateLabel;
        this.serialNumberInput = serialNumberInput;
        this.salesIDLabel = salesIDLabel;
        this.productIDLabel = productIDLabel;
        warrantyTableManager = new TableManager(warrantyTable);
    }
    
    public void searchSerialNumber(){
        try{
            String serialNumber = serialNumberInput.getText();
            
            ResultSet rs = dbConnector.query("SELECT name, sales_date, sales_details.warranty_duration, sales_details.sales_id, sales_details.product_ID FROM sales_details JOIN product USING(product_id) JOIN sales USING(sales_id) WHERE sales_details.serial_number = ?", serialNumber);
            if(rs.next()){
                String productName = rs.getString(1);
                String salesDate = rs.getString(2);
                String duration = rs.getString(3);
                String salesID = rs.getString(4);
                String productID = rs.getString(5);
                
                System.out.print(productName);
                productNameLabel.setText(productName);
                salesDateLabel.setText(salesDate);
                durationLabel.setText(duration + "month(s)");
                salesIDLabel.setText(salesID);
                productIDLabel.setText(productID);
            }else{
            JOptionPane op = new JOptionPane("The serial number you entered doesn't match to any product.",JOptionPane.ERROR_MESSAGE);
            JDialog dialog = op.createDialog("Input Error");
            dialog.setAlwaysOnTop(true); //<-- this line
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
                //JOptionPane.showMessageDialog(null, "No product with that serial number was found.", "Not found", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    
    public void updateWarrantyTable(){
        try{
        ResultSet rs = dbConnector.query("SELECT name, serial_number, warranty_ret_date FROM warranty JOIN Product USING(product_id) JOIN sales_details USING(sales_id)");
        warrantyTableManager.clearTableContents();
        while(rs.next()){
            String name = rs.getString(1);
            String serialNumber = rs.getString(2);
            String returnDate = rs.getString(3);
            
            warrantyTableManager.addRowContent(new String[]{name, serialNumber, returnDate});
        }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            
        }
    }
    
    public void acceptItemAsCovered(){
        try{
            String salesID = salesIDLabel.getText();
            String productID = productIDLabel.getText();
            Date date = new Date();
            String warrantyReturnDate = date.toString();
            dbConnector.insert("INSERT INTO warranty (sales_id, product_id, warranty_ret_date) VALUES(?,?,?)", 
                        new String[]{salesID, productID, warrantyReturnDate });
            updateWarrantyTable();
        }catch(NullPointerException npe){
            npe.printStackTrace();
            JOptionPane.showMessageDialog(null, "No item is being accepted.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
}
