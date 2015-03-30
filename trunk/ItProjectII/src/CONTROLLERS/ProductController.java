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
 * The Logic Controller for the Product Bean and AdminProducts User Interface
 * including the components involving products.
 * 
 * @author Belthazod
 */



public class ProductController {
    private DatabaseConnector dbConnector;
    private TableManager adminProductTableManager;
    private TableManager inventoryTableManager;
    private TableManager transferTableManager;
    private TableManager deliveryTableManager;
    private TableManager criticalProductsTableManager;
    private JTabbedPane productsTab;
    private static ArrayList<Product> productList;
    private TableManager secondhandSwapProductsTableManager;
    
    public ProductController(){
    dbConnector = DatabaseConnector.getInstance();
    productList = getProducts();
    }
    /**
     * Creates an instance of ProductController capturing all the UI components
     * affected by the BEAN <code>Product</code>
     * @param adminTable - the JTable located at the Administrator module.
     * @param inventoryTable - the JTable located at the Sales or Home User Interface
     * @param transferTable - the JTable located at the Transfer module
     * @param deliveryTable - the JTable located at the Delivery module
     * @param productsTab - the products Tab that opens after adding a product
     * @param criticalProductsTable - the table of products with quantities below their reorder quantity level or zero 
     * @param secondhandSwapProductsTable - table of products for swapping
     * 
     */
    public ProductController(JTable adminTable, JTable inventoryTable, JTable transferTable, JTable deliveryTable, JTabbedPane productsTab, JTable criticalProductsTable, JTable secondhandSwapProductsTable){
        try{
        dbConnector = DatabaseConnector.getInstance();
        adminProductTableManager = new TableManager(adminTable);
        inventoryTableManager = new TableManager(inventoryTable);
        transferTableManager = new TableManager(transferTable);
        deliveryTableManager = new TableManager(deliveryTable);
        criticalProductsTableManager = new TableManager(criticalProductsTable);
        secondhandSwapProductsTableManager = new TableManager(secondhandSwapProductsTable);
        
        adminProductTableManager.alignCellRight(5);
        adminProductTableManager.alignCellRight(6);
        adminProductTableManager.alignCellRight(7);
        
        inventoryTableManager.alignCellRight(6);
        
        deliveryTableManager.alignCellRight(4);
        
        transferTableManager.alignCellRight(4);
        
        criticalProductsTableManager.alignCellRight(5);
        
        this.productsTab = productsTab;
        }catch(NullPointerException npe){
            npe.printStackTrace();
        }
    }
    
    /**
     * Adds a new tuple to the Products table in the database based on the user inputs on the components.
     * <p>The components enlisted should not be empty, otherwise a <code>JOptionPane</code>
     * containing the error message appears.
     * @param productName - the <code>JTextField</code> containing the new product
     * @param description - the <code>JTextField</code> containing the new product's description
     * @param quantity - the <code>JTextField</code> containing the new product's quantity
     * @param unit - the <code>JComboBox</code> containing the unit of measurement of the new product
     * @param supplier - the <code>JComboBox</code> containing the selected supplier of the new product
     * @param category - the <code>JComboBox</code> containing the selected category of the new product
     * @param reorderQuantity - the <code>JSpinner</code> containing the reorder quantity level of the new product
     * @param warranty - <code>JSpinner</code> containing the number of months the warranty of the product has.
     */
    public void addProduct(JTextField productName, JTextField quantity, JComboBox<String> unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity, JSpinner warranty){
        try{
        Object supplierComboBoxitem = supplier.getSelectedItem();
        String supplierID = ((ComboItem)supplierComboBoxitem).getValue();
       
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getValue(); 
        
        
        JTextField[] inputs = {productName, quantity};
        String[] values = {typeID, productName.getText(), supplierID, unit.getSelectedItem().toString(), quantity.getText(), reorderQuantity.getValue().toString(), warranty.getValue().toString() };
       
        if(InputValidator.checkInput(productName.getText(), "Product Name cannot be empty.")
            & InputValidator.checkInput(quantity.getText(), "Quantity cannot be empty.")    
            & InputValidator.checkIfNumber(quantity.getText(), "Quantity should be a number.") 
            & InputValidator.checkInput(reorderQuantity.getValue().toString(), "Reorder quantity should be a number.")){
            
            dbConnector.insert("INSERT INTO product ( type_id, name, "
                    + "supplier_id, unit, physical_count, reorder_quantity, warranty_duration) "
                    + "VALUES(?,?,?,?,?,?,?)", values);
            
            reorderQuantity.setValue(0);
            int result = JOptionPane.showConfirmDialog(null, productName.getText() + " added to list of products. Would you like to add another product?", "Success", JOptionPane.YES_NO_OPTION);
            InputValidator.clearInput(inputs);
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
    
    /**
     * Updates the values of the selected <code>Product</code> in the database based on the values in the EditDialog.
     * The following components should not be empty, otherwise a <code>JDialog</code> is shown prompting the user to
     *      modify these before proceeding.
     * @param editDialog - the <code>JDialog</code> used to edit the details of the <code>Product</code>
     * @param productIDEditInput - the hidden <code>JLabel</code> containing the product ID of the Product being updated 
     * @param productName - the <code>JTextField</code> containing the <code>Product</code> name
     * @param description - the <code>JTextField</code> containing the <code>Product</code> description
     * @param quantity - the <code>JLabel</code> containing the <code>Product</code> quantity
     * @param unit - the <code>JComboBox</code> containing the <code>Product</code> unit of measurement
     * @param supplier - the <code>JComboBox</code> containing the <code>Product</code> supplier
     * @param category - the <code>JComboBox</code> containing the <code>Product</code> category
     * @param reorderQuantity - the <code>JSpinner</code> containing the <code>Product</code> reorder Quantity level
     * @param warranty - the <code>JSpinner</code> containing the number of months the warranty of the <code>Product</code> has
     */
    public void editProduct(JDialog editDialog,JLabel productIDEditInput, JTextField productName, JLabel quantity, JComboBox<String> unit, JComboBox supplier, JComboBox category, JSpinner reorderQuantity, JSpinner warranty){
        try{
        Object supplierComboBoxitem = supplier.getSelectedItem();
        String supplierID = ((ComboItem)supplierComboBoxitem).getValue();
        
        Object typeComboBoxitem = category.getSelectedItem();
        String typeID = ((ComboItem)typeComboBoxitem).getValue(); 
        
        JTextField[] inputs = {productName};
        
        String[] values = {typeID, productName.getText(), supplierID, unit.getSelectedItem().toString(), quantity.getText(), reorderQuantity.getValue().toString(), warranty.getValue().toString() };
        if(InputValidator.checkInput(productName.getText(), "Product Name cannot be empty.")
            & InputValidator.checkInput(quantity.getText(), "Quantity should be a number.")    
            & InputValidator.checkIfNumber(quantity.getText(), "Quantity should be a number.") 
            & InputValidator.checkInput(reorderQuantity.getValue().toString(), "Reorder quantity should be a number.")){
            
            dbConnector.update("UPDATE product SET type_id = ?, name = ?, "
                    + "supplier_id = ?, unit = ?, physical_count = ?, reorder_quantity = ?, warranty_duration = ?"
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
    
    /**
     * Opens the EditProduct Dialog box. Components are updated based on the 
     * selected product in the table.
     * 
     * @param prodID - the selected product ID
     * @param productIDTextField - the hidden <code>JTextField</code> that would contain the
     *      productID of the product.
     * @param productNameTextField - <code>JTextField</code> containing the product Name in the EditDialog
     * @param descriptionTextField - <code>JTextField</code> containing the description/brand of the product in the EditDialog 
     * @param categoryComboBox - <code>JComboBox</code> containing the list of product types/categories in the Edit Dialog
     * @param supplierComboBox - <code>JComboBox</code> containing the list of suppliers in the EditDialog
     * @param unitComboBox -  <code>JComboBox</code> containing the unit of measurement in the EditDialog
     * @param quantityLabel -   <code>JLabel</code> containing the quantity of the selected product in the EditDialog
     * @param reorderQuantityLevelSpinner - <code>JSpinner</code> containing the reorder quantity level in the EditDialog
     */
    public void openProductEditDialog(String prodID, JLabel productIDTextField, JTextField productNameTextField,
            JComboBox<ComboItem> categoryComboBox, JComboBox<ComboItem> supplierComboBox, 
            JComboBox<String> unitComboBox, JLabel quantityLabel, JSpinner reorderQuantityLevelSpinner, JSpinner warrantySpinner){
        
        String selectString = "SELECT product_id, name, "
                + "type_id, supplier_id, Unit, physical_count AS Quantity, "
                + "reorder_quantity, type_id, warranty_duration FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id) WHERE product_ID = ? LIMIT 1;";
        
        try{
            ResultSet rs = dbConnector.query(selectString, prodID);
            while(rs.next()){
                String productID = rs.getString(1);
                String productName = rs.getString(2);
                String typeID = rs.getString(3);
                String supplierID = rs.getString(4);
                String unit = rs.getString(5);
                String physicalCount = rs.getString(6);
                Integer reorderQuantity = rs.getInt(7);
                Integer warranty = rs.getInt(9);
                
                
                productIDTextField.setText(productID);
                productNameTextField.setText(productName);
                
                quantityLabel.setText(physicalCount);
                reorderQuantityLevelSpinner.setValue(reorderQuantity);
                System.out.print("Warranty:" + warranty);
                warrantySpinner.setValue(warranty);
                
                for(int i = 0; i < unitComboBox.getItemCount(); i++){
                    if( unitComboBox.getItemAt(i).equals(unit) ){
                        unitComboBox.setSelectedItem(unitComboBox.getItemAt(i));
                    }
                }
                
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
    
    /**
     * Queries from the database all the list of products stored including all their
     * attributes.
     * @return an <code>ArrayList</code> of the <code>Product</code> Bean 
     */
    public ArrayList<Product> getProducts(){
        productList = new ArrayList<Product>();
        try{
            String selectString = "SELECT product_id, type_id, type_name, name, "
                + "supplier_ID, supplier_name, Unit, physical_count, "
                + "reorder_quantity, warranty_duration FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id) ORDER BY 4 ASC;";
            ResultSet rs = dbConnector.query(selectString);

            while(rs.next()){
                Product product = new Product(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), 
                    rs.getString(9), rs.getString(10)  );

                productList.add(product);
            }
            dbConnector.closeConnection();
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Incorrect Product SQL query", "Database error", JOptionPane.ERROR_MESSAGE);
        }
        return productList;
    }

    /**
     * Gets the list of <code>Product</code>s
     * @return an <code>ArrayList</code> of <code>Product</code>s taken from the 
     *  database
     */
    public static ArrayList<Product> getProductList() {
        return productList;
    }
    
    /**
     * Updates all the <code>JTable</code>s containing product information.
     */
    public void updateTableContents() {
        adminProductTableManager.clearTableContents();
        inventoryTableManager.clearTableContents();
        transferTableManager.clearTableContents();
        deliveryTableManager.clearTableContents();
        criticalProductsTableManager.clearTableContents();
        secondhandSwapProductsTableManager.clearTableContents();
        getProducts();
        for(Product product : productList){
            String[] completeValues = {product.getProductID(), product.getWarranty(), product.getName(), 
                 product.getTypeName(), product.getUnit(),
                product.getSupplierName(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()};
            
            String[] adminCompleteValues = {product.getProductID(), product.getName(), 
                 product.getTypeName(), product.getUnit(),
                product.getSupplierName(), product.getWarranty(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()};
            
            String[] deliveryValues = {product.getProductID(), product.getName(), 
                 product.getTypeName(), 
                product.getUnit(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()};
            secondhandSwapProductsTableManager.addRowContent(completeValues);
            adminProductTableManager.addRowContent(adminCompleteValues);
            inventoryTableManager.addRowContent(completeValues);
            deliveryTableManager.addRowContent(deliveryValues);
            if((product.getPhysicalCount()!=null) && Integer.parseInt(product.getPhysicalCount()) != 0){
                String[] transferValues = {product.getProductID(), product.getName(), 
                    product.getTypeName(), 
                    product.getUnit(), product.getPhysicalCount(), 
                    product.getReorderQuantityLevel()};
                transferTableManager.addRowContent(transferValues);
            }
            try{
            if(Integer.parseInt(product.getPhysicalCount()) <= Integer.parseInt(product.getReorderQuantityLevel())){
                String[] completeCriticalValues = {product.getProductID(), product.getName(), 
                 product.getTypeName(), product.getUnit(),
                product.getSupplierName(), product.getPhysicalCount()};
                
                criticalProductsTableManager.addRowContent(completeCriticalValues);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        dbConnector.closeConnection();
    }
    
    /**
     * deletes the selected <code>Product</code> in the adminProductsList
     */
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
