/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import BEANS.TableManager;
import UTIL.DatabaseConnector;
import UTIL.InputValidator;
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
public class CategoryController {
    TableManager categoryTableManager;
    DatabaseConnector dbConnector = DatabaseConnector.getInstance();
    public CategoryController(JTable categoryTable){
        categoryTableManager = new TableManager(categoryTable);
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
            sqlE.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete category", "Database error.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateCategoryTable(){
        try{
        ResultSet rs = dbConnector.query("SELECT type_id, type_name FROM type ORDER BY 2 ASC");
        categoryTableManager.importDBContents(rs);
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
    
   
}
