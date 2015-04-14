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
    public WarrantyController(JTable warrantyTable, JTextField serialNumberInput, JLabel productNameLabel, JLabel durationLabel, JLabel salesDateLabel, JLabel salesIDLabel){
        this.productNameLabel = productNameLabel;
        this.durationLabel = durationLabel;
        this.salesDateLabel = salesDateLabel;
        this.serialNumberInput = serialNumberInput;
        this.salesIDLabel = salesIDLabel;
    }
    
    public void searchSerialNumber(){
        try{
            String serialNumber = serialNumberInput.getText();
            
            ResultSet rs = dbConnector.query("SELECT name, sales_date, sales_details.warranty_duration, sales_details.sales_id FROM sales_details JOIN product USING(product_id) JOIN sales USING(sales_id) WHERE sales_details.serial_number = ?", serialNumber);
            if(rs.next()){
                String productName = rs.getString(1);
                String salesDate = rs.getString(2);
                String duration = rs.getString(3);
                String salesID = rs.getString(4);
                
                System.out.print(productName);
                productNameLabel.setText(productName);
                salesDateLabel.setText(salesDate);
                durationLabel.setText(duration + "month(s)");
                salesIDLabel.setText(salesID);
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
    
//    public void acceptItemAsCovered(){
//        try{
//            
//        }catch(NullPointerException npe){
//            JOptionPane.showMessageDialog(null, "No item is being accepted.", "Input Error", JOptionPane.ERROR_MESSAGE);
//        }catch(SQLException sqlE){
//            sqlE.printStackTrace();
//        }
//    }
}
