/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.ComboItem;
import UTIL.TableManager;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class CategoryController {
    private TableManager categoryTableManager;
    private JComboBox<ComboItem> addProductCategoryComboBox;
    private JComboBox<ComboItem> editProductCategoryComboBox;
    private JComboBox<ComboItem> secondHandCategoryComboBox;
    private JDialog categoryEditDialog;
    private JLabel categoryIDLabel;
    private JTextField categoryNameEditInput;
    private DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    
    public CategoryController(JTable categoryTable, 
            JComboBox<ComboItem> addProductCategoryComboBox, 
            JComboBox<ComboItem> editProductCategoryComboBox, 
            JComboBox<ComboItem> secondHandCategoryComboBox,
            JLabel categoryIDLabel, JTextField categoryNameEditInput,
            JDialog categoryEditDialog){
        categoryTableManager = new TableManager(categoryTable);
        this.addProductCategoryComboBox = addProductCategoryComboBox;
        this.editProductCategoryComboBox = editProductCategoryComboBox;
        this.secondHandCategoryComboBox = secondHandCategoryComboBox;
        this.categoryIDLabel = categoryIDLabel;
        this.categoryNameEditInput = categoryNameEditInput;
        this.categoryEditDialog = categoryEditDialog;
    }
    
    public void addCategory(JTextField categoryName){
        try{
            dbConnector.insert("INSERT INTO type ( type_name) VALUES(?)", categoryName.getText());
            JOptionPane.showMessageDialog(null, categoryName.getText()+ " added to the category list", "Success",  JOptionPane.INFORMATION_MESSAGE);
            InputValidator.clearInput(categoryName);
        } catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to add " + categoryName.getText() + " to category list", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteCategory(){
        try{
            String categoryID = categoryTableManager.getIDFromTable(categoryTableManager.getSelectedRow());
            dbConnector.delete("DELETE FROM type WHERE type_id = ?", categoryID);
        }catch(SQLException sqlE){
            if(sqlE.getSQLState().startsWith("23")){
                JOptionPane.showMessageDialog(null, "Failed to delete selected category. Category is currently linked to a product. \n\nTo remove this category. Please clear all products associated with it.", "Constraint Error", JOptionPane.ERROR_MESSAGE);
            }else{
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete category", "Database error.", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void updateCategoryTable(){
        try{
        ResultSet rs = dbConnector.query("SELECT type_id, type_name FROM type ORDER BY 2 ASC");
        categoryTableManager.importDBContents(rs);
        updateCategoryComponents();
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean openEditDialog(String selectedTypeID, JTextField input, JLabel typeID){
        try{
            ResultSet rs = dbConnector.query("SELECT type_name FROM type WHERE type_id = ?", selectedTypeID);
            rs.next();
                input.setText(rs.getString(1));
            typeID.setText(selectedTypeID);
            return true;
           
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Editing failed", "Database error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public void editCategory(){
        try{
            String categoryID = categoryIDLabel.getText();
            String categoryName = categoryNameEditInput.getText();
            if(!categoryName.equals("")){
                dbConnector.update("UPDATE type SET type_name = ? WHERE type_ID = ?", new String[]{categoryName}, categoryID);
                JOptionPane.showMessageDialog(null, "Category details updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
                InputValidator.clearInput(categoryNameEditInput);
                updateCategoryTable();
                categoryEditDialog.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Category Name cannot be empty.", "Input error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    public void updateCategoryComponents(){
        addProductCategoryComboBox.removeAllItems();
        editProductCategoryComboBox.removeAllItems();
        secondHandCategoryComboBox.removeAllItems();
        try{
        ResultSet rs = dbConnector.query("SELECT type_id, type_name FROM type ORDER BY 2 ASC");
        while(rs.next()){
            String categoryID = rs.getString(1);
            String categoryName = rs.getString(2);
            addProductCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
            editProductCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
            secondHandCategoryComboBox.addItem(new ComboItem(categoryID, categoryName));
        }
        dbConnector.closeConnection();
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Table update failed", "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
}
