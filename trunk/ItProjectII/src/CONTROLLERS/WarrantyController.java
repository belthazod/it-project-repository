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
    
    public WarrantyController(JTable warrantyTable, JTextField serialNumberInput, JLabel productNameLabel, JLabel durationLabel, JLabel salesDateLabel){
        this.productNameLabel = productNameLabel;
        this.durationLabel = durationLabel;
        this.salesDateLabel = salesDateLabel;
        this.serialNumberInput = serialNumberInput;
    }
    
    public void searchSerialNumber(){
        try{
            String serialNumber = serialNumberInput.getText();
            
            ResultSet rs = dbConnector.query("SELECT name, sales_date, sales_details.warranty_duration FROM sales_details JOIN product USING(product_id) JOIN sales USING(sales_id) WHERE sales_details.product_id = ?", serialNumber);
            if(rs.next()){
                String productName = rs.getString(1);
                String salesDate = rs.getString(2);
                String duration = rs.getString(3);
                
                productNameLabel.setText(productName);
                salesDateLabel.setText(salesDate);
                durationLabel.setText(duration);
            }else{
                JOptionPane.showMessageDialog(null, "No product with that serial number was found.", "Not found", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
}
