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
import UTIL.TableManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
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
    private JTabbedPane productsTab;
    private ArrayList<Product> productList;
    
    public ProductController(JTable adminTable){
        dbConnector = DatabaseConnector.getInstance();
        adminProductTableManager = new TableManager(adminTable);
    }
    
    public ProductController(JTable adminTable, JTable inventoryTable, JTable transferTable, JTable deliveryTable, JTabbedPane productsTab){
        dbConnector = DatabaseConnector.getInstance();
        adminProductTableManager = new TableManager(adminTable);
        inventoryTableManager = new TableManager(inventoryTable);
        transferTableManager = new TableManager(transferTable);
        deliveryTableManager = new TableManager(deliveryTable);
        this.productsTab = productsTab;
    }
    
    public void addProduct(JTextField productName, JTextField description, JTextField quantity, JTextField unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity){
        try{
        Object supplierComboBoxitem = supplier.getSelectedItem();
        String supplierID = ((ComboItem)supplierComboBoxitem).getValue();
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getValue(); 
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
            InputValidator.clearInput(inputs);
            reorderQuantity.setValue(0);
            int result = JOptionPane.showConfirmDialog(null, productName.getText() + " added to list of products. Would you like to add another product?", "Success", JOptionPane.YES_NO_OPTION);
            if(result == 1){
                productsTab.setSelectedIndex(result);
            }
        }
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add Product.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editProduct(JDialog editDialog,JLabel productIDEditInput, JTextField productName, JTextField description, JLabel quantity, JTextField unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity){
        try{
        Object supplierComboBoxitem = supplier.getSelectedItem();
        String supplierID = ((ComboItem)supplierComboBoxitem).getValue();
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getValue(); 
        
        JTextField[] inputs = {productName, description, unit};
        
        String[] values = {typeID, productName.getText(), description.getText(), supplierID, unit.getText(), quantity.getText(), reorderQuantity.getValue().toString() };
        if(InputValidator.checkInput(productName.getText(), "Product Name cannot be empty.")
            & InputValidator.checkInput(quantity.getText(), "Quantity should be a number.")    
            & InputValidator.checkIfNumber(quantity.getText(), "Quantity should be a number.") 
            & InputValidator.checkInput(unit.getText(), "Unit of measurement cannot be empty.")
            & InputValidator.checkInput(reorderQuantity.getValue().toString(), "Reorder quantity should be a number.")){
            
            dbConnector.update("UPDATE product SET type_id = ?, name = ?, description = ?, "
                    + "supplier_id = ?, unit = ?, physical_count = ?, reorder_quantity = ?"
                    + " WHERE product_ID = ?", values, productIDEditInput.getText());
            
            editDialog.dispose();
            InputValidator.clearInput(inputs);
            quantity.setText("");
            JOptionPane.showMessageDialog(null, "Product details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed to add Product.","Database error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void openProductEditDialog(String prodID, JLabel productIDTextField, JTextField productNameTextField, JTextField descriptionTextField,
            JComboBox<ComboItem> categoryComboBox, JComboBox<ComboItem> supplierComboBox, 
            JTextField unitTextField, JLabel quantityLabel, JSpinner reorderQuantityLevelSpinner){
        
        String selectString = "SELECT product_id, name, description, "
                + "type_id, supplier_id, Unit, physical_count AS Quantity, "
                + "reorder_quantity, type_id FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id) WHERE product_ID = ? LIMIT 1;";
        
        try{
            ResultSet rs = dbConnector.query(selectString, prodID);
            while(rs.next()){
                String productID = rs.getString(1);
                String productName = rs.getString(2);
                String description = rs.getString(3);
                String typeID = rs.getString(4);
                String supplierID = rs.getString(5);
                String unit = rs.getString(6);
                String physicalCount = rs.getString(7);
                Integer reorderQuantity = rs.getInt(8);
                
                
                productIDTextField.setText(productID);
                productNameTextField.setText(productName);
                descriptionTextField.setText(description);
                unitTextField.setText(unit);
                quantityLabel.setText(physicalCount);
                reorderQuantityLevelSpinner.setValue(reorderQuantity);
                for(int i = 0; i < categoryComboBox.getItemCount(); i++){
                    if( categoryComboBox.getItemAt(i).getValue().equals(typeID) ){
                        categoryComboBox.setSelectedItem(categoryComboBox.getItemAt(i));
                    }
                }
                
                for(int i = 0; i < supplierComboBox.getItemCount(); i++){
                    if( supplierComboBox.getItemAt(i).getValue().equals(supplierID) ){
                        supplierComboBox.setSelectedItem(supplierComboBox.getItemAt(i));
                    }
                }
                
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load Edit Dialog.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public ArrayList<Product> getProducts(){
        productList = new ArrayList<Product>();
        try{
            String selectString = "SELECT product_id, type_id, type_name, name, description, "
                + "supplier_ID, supplier_name, Unit, physical_count, "
                + "reorder_quantity FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id) ORDER BY 4 ASC;";
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
            inventoryTableManager.addRowContent(completeValues);
            transferTableManager.addRowContent(shortValues);
            deliveryTableManager.addRowContent(shortValues);
        }
        dbConnector.closeConnection();
    }
    public void deleteSelectedProduct(){
        try{
            String productID = adminProductTableManager.getIDFromTable(adminProductTableManager.getSelectedRow());
            dbConnector.delete("DELETE FROM product WHERE product_id = ?", productID);
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete selected product.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
