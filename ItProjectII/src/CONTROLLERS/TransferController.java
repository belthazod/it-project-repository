/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import UTIL.DatabaseConnector;
import UTIL.TableManager;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Belthazod
 */
public class TransferController {
    private final DatabaseConnector dbConnector; 
    private TableManager transferTableManager;
    private TableManager truckTableManager;
    private JComboBox<ComboItem> transferFromComboBox;
    private JComboBox<ComboItem> transferToComboBox;
    
    /**
     * Creates an instance of Transfer Controller mapped to the Truck/Transfer Table
     * @param transferTable - the <code>JTable</code> containing the products available for transfered
     * to the other branches.
     * @param truckTable - the <code>JTable</code> containing the products to be transfered
     * to the other branches.
     * @param transferFromComboBox - the <code>JComboBox</code> containing the branches from which
     * the products are coming from
     * @param transferToComboBox - the <code>JComboBox</code> containing the branches to which the which
     * the products are to be transfered
     * 
     */
    public TransferController(JTable transferTable, JTable truckTable, JComboBox<ComboItem> transferFromComboBox, JComboBox<ComboItem> transferToComboBox) {
        transferTableManager = new TableManager(transferTable);
        truckTableManager = new TableManager(truckTable);
        dbConnector= DatabaseConnector.getInstance();
        this.transferFromComboBox = transferFromComboBox;
        this.transferToComboBox = transferToComboBox;
    }
    /**
     * Copies the selected product details from the Transfer Products Table
     * to the Truck Table.
     */
    public void addSelectedToTruck(){
        
        boolean itemExists = false;
        String productID = transferTableManager.getIDFromTable(transferTableManager.getSelectedRow());
        
        for(int row = 0; row < truckTableManager.getRowCount(); row++){
            String truckProductID = truckTableManager.getIDFromTable(row);
            itemExists = productID.equals(truckProductID);
        }
        if(itemExists){
            JOptionPane.showMessageDialog(null,
                "Item already in truck.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }else{
            String name = (String) transferTableManager.getValueAt(transferTableManager.getSelectedRow(), 1);
            String unit = (String) transferTableManager.getValueAt(transferTableManager.getSelectedRow(), 3);
            String quantity = (String) transferTableManager.getValueAt(transferTableManager.getSelectedRow(), 4);
        
            truckTableManager.addRowContent(new String[]{productID, quantity, name, unit, ""});
            
        }
    }
    
    /**
     * Gets all the products enlisted in the "Truck" <code>JTable</code> and 
     * creates a transfer and transfer_details topple(s) based on the values 
     * in the table.
     */
    public void transferProducts(){
        try{
            String transferFrom = transferFromComboBox.getSelectedItem().toString();
            String transferTo = transferToComboBox.getSelectedItem().toString();
            long timeNow = System.currentTimeMillis();
            Date today = new Date(timeNow);
            boolean mainIsSelected = false;
            int mainCount = 0;
            boolean invalidQuantityFlag = false;
            boolean greaterThanCurrent = false;
            for(int row = 0; row < truckTableManager.getRowCount();row++){
                int currentQuantity = Integer.parseInt(truckTableManager.getValueAt(
                        truckTableManager.getSelectedRow(), 1));
                int newQuantity = Integer.parseInt(truckTableManager.getValueAt(
                        truckTableManager.getSelectedRow(), 4));
                if(newQuantity <= 0){
                    invalidQuantityFlag = true;
                    break;
                }
                if(currentQuantity < newQuantity){
                    greaterThanCurrent = true;
                }
                
            }
            //checks if the "Main" branch is selected in either comboBox
            if(transferFrom.equals("Main")){
                mainIsSelected = true;
                mainCount++;
            }
            if(transferTo.equals("Main")){
                mainIsSelected = true;
                mainCount++;
            }
            if(!invalidQuantityFlag && !greaterThanCurrent){
                if(mainIsSelected && mainCount != 2){
                    dbConnector.insert("INSERT INTO transfers (transfer_date, "
                            + "transfer_from, destination) VALUES(?,?,?)", 
                            new String[]{today.toString(),transferFrom, transferTo  });
                    ResultSet rs = dbConnector.query("SELECT transfer_id FROM transfers ORDER BY 1 DESC LIMIT 1");
                    rs.next();
                    String transferID = rs.getString(1);
                    for(int row = 0; row < truckTableManager.getRowCount(); row++){
                        Integer quantityToTransfer = Integer.parseInt(truckTableManager.getValueAt(row, 4));
                        Integer currentQuantity = Integer.parseInt(truckTableManager.getValueAt(row, 1));    
                        String productID = truckTableManager.getIDFromTable(row);
                        if(quantityToTransfer < currentQuantity && quantityToTransfer > 0){
                            dbConnector.insert("INSERT INTO transferdetails "
                                    + "(transfer_id, product_id, qty_transfered) "
                                    + "VALUES(?,?,?)", new String[]{transferID, productID, quantityToTransfer.toString()});
                        }
                    }
                    truckTableManager.clearTableContents();
                    dbConnector.closeConnection();
                    JOptionPane.showMessageDialog(null, "Products transfered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);        
                }else{
                    JOptionPane.showMessageDialog(null, "Please check the sender and recipient of the transfer. The Main branch should be in either of the two not both.", "Branch allocation error.", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(invalidQuantityFlag){
                JOptionPane.showMessageDialog(null, "Please check the delivered quantity of each product. The quantity should not be empty, equal to 0, or less that 0", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if(greaterThanCurrent){
                JOptionPane.showMessageDialog(null, "Please check the delivered quantity of each product. The quantity to be delivered cannot exceed the current product count in stock.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
            
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to transfer products", "Database error.", JOptionPane.ERROR_MESSAGE);
        }catch(IndexOutOfBoundsException ioobe){
            JOptionPane.showMessageDialog(null, "Please input the quantity of the item/s.");
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please input a valid quantity.");
        }
    }
    
    /**
     * Removes the selected row in the Truck<code>JTable</code>
     */
    public void removeSelectedRow(){
        truckTableManager.deleteRow();
    }
    
    
    
}
