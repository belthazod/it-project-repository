/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import BEANS.Product;
import BEANS.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class ProductController {
    private final DatabaseConnector dbConnector;
    private TableManager adminProductTableManager;
    private TableManager inventoryTableManager;
    private TableManager transferTableManager;
    private TableManager deliveryTableManager;
    ArrayList<Product> productList;
    
    public ProductController(JTable adminTable){
        dbConnector = DatabaseConnector.getInstance();
        adminProductTableManager = new TableManager(adminTable);
    }
    
    public ProductController(JTable adminTable, JTable inventoryTable, JTable transferTable, JTable deliveryTable){
        dbConnector = DatabaseConnector.getInstance();
        adminProductTableManager = new TableManager(adminTable);
        inventoryTableManager = new TableManager(inventoryTable);
        transferTableManager = new TableManager(transferTable);
        deliveryTableManager = new TableManager(deliveryTable);
        
    }
    
    public void addProduct(JTextField productName, JTextField description, JTextField quantity, JTextField unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity){
        try{
        Object supplierComboBoxitem = supplier.getSelectedItem();
        String supplierID = ((ComboItem)supplierComboBoxitem).getLabel();
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getLabel(); 
        
        ResultSet supplierResult = dbConnector.query("SELECT supplier_id FROM supplier WHERE supplier_name = ? LIMIT 1", supplier.getSelectedItem().toString());
        JTextField[] inputs = {productName, description, quantity, unit};
        String[] values = {typeID, productName.getText(), description.getText(), supplierID, unit.getText(), quantity.getText(), reorderQuantity.getValue().toString() };
        if(InputValidator.checkInput(productName.getText(), "Product Name cannot be empty.")
            & InputValidator.checkInput(quantity.getText(), "Quantity should be a number.")    
            & InputValidator.checkIfNumber(quantity.getText(), "Quantity should be a number.") 
            & InputValidator.checkInput(unit.getText(), "Unit of measurement cannot be empty.")
            & InputValidator.checkInput(reorderQuantity.getValue().toString(), "Reorder quantity should be a number.")){
            
            dbConnector.insert("INSERT INTO product ( type_id, name, description, "
                    + "supplier_id, unit, physical_count, reorder_quantity) "
                    + "VALUES(?,?,?,?,?,?,?)", values);
        }
        JOptionPane.showMessageDialog(null, productName.getText() + " added to lis of products.", "Success", JOptionPane.INFORMATION_MESSAGE);
        InputValidator.clearInput(inputs);
        reorderQuantity.setValue(0);
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            
            JOptionPane.showMessageDialog(null,"Failed to add Product.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editProduct(JLabel productIDEditInput, JTextField productName, JTextField description, JTextField quantity, JTextField unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity){
        try{
        ResultSet categoryResult = dbConnector.query("SELECT type_id FROM type WHERE type_name = ? LIMIT 1", category.getSelectedItem().toString());
        ResultSet supplierResult = dbConnector.query("SELECT supplier_id FROM supplier WHERE supplier_name = ? LIMIT 1", supplier.getSelectedItem().toString());
        supplierResult.next();
        categoryResult.next();
        JTextField[] inputs = {productName, description, quantity, unit};
        String[] values = {categoryResult.getString(1), productName.getText(), description.getText(), supplierResult.getString(1), unit.getText(), quantity.getText(), reorderQuantity.getValue().toString() };
        if(InputValidator.checkInput(productName.getText(), "Product Name cannot be empty.")
            & InputValidator.checkInput(quantity.getText(), "Quantity should be a number.")    
            & InputValidator.checkIfNumber(quantity.getText(), "Quantity should be a number.") 
            & InputValidator.checkInput(unit.getText(), "Unit of measurement cannot be empty.")
            & InputValidator.checkInput(reorderQuantity.getValue().toString(), "Reorder quantity should be a number.")){
            
            dbConnector.update("UPDATE product SET( type_id, name, description, "
                    + "supplier_id, unit, physical_count, reorder_quantity) "
                    + "VALUES(?,?,?,?,?,?,?) WHERE product_ID = ?", values, productIDEditInput.getText());
        }
        
        InputValidator.clearInput(inputs);
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null,"Failed to add Product.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void openProductEditDialog(){
        
    }
    public ArrayList<Product> getProducts(){
        productList = new ArrayList<Product>();
        try{
            String selectString = "SELECT product_id, type_id, type_name, name, description, "
                + "supplier_ID, supplier_name, Unit, physical_count, "
                + "reorder_quantity FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id);";
            ResultSet rs = dbConnector.query(selectString);

            while(rs.next()){
                Product product = new Product(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), 
                    rs.getString(9), rs.getString(10) );

                productList.add(product);
            }
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Incorrect Product SQL query", "Database error", JOptionPane.ERROR_MESSAGE);
        }
        return productList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public void updateTableContents() {
        adminProductTableManager.clearTableContents();
        inventoryTableManager.clearTableContents();
        transferTableManager.clearTableContents();
        deliveryTableManager.clearTableContents();
        
        getProducts();
        for(Product product : productList){
            String[] completeValues = {product.getProductID(), product.getName(), 
                product.getDescription(), product.getTypeName(), product.getUnit(),
                product.getSupplierName(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()};
            
            String[] shortValues = {product.getProductID(), product.getName(), 
                product.getDescription(), product.getTypeName(), 
                product.getUnit(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()};
            adminProductTableManager.addRowContent(completeValues);
            try{
            inventoryTableManager.addRowContent(completeValues);
            }catch(Exception E){
                E.printStackTrace();
            }
            transferTableManager.addRowContent(shortValues);
            deliveryTableManager.addRowContent(shortValues);
        }
        dbConnector.closeConnection();
    }
    
}
