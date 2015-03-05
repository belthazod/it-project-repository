/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Belthazod
 */
public class TableManager {
    private  DefaultTableModel model;
    private JTable table;
    
 /**
 *  Creates and instance of TableManager linking it to a particular table which
 *  will later on be modified through the TableManager methods.
 *  @param table - the selected table to be modified and controlled.
 *
 */
    public TableManager(JTable table) {
        try{
            this.table = table;
            model = (DefaultTableModel) table.getModel();
        }catch(NullPointerException npe){
            npe.printStackTrace();
            return;
        }
    }
    
 /**
 *  Clears the table of all rows leaving it empty. Column headers are retained.
 *
 */
    public void clearTableContents(){
        for(int row = 0; row < model.getRowCount();){
            model.removeRow(0);
        }   
    }
    
 /**
 *  Clears the JTable of any current rows and values and afterwards adds 
 *  rows and values to the JTable based on the result of a query.
 *  The number of columns in the JTable should match the number of attributes
 *  in the Result Set.
 *  
 *  @param rs - the database Result Set produced from a query
 *  @exception SQLException - The database Result Set cannot be found or the
 *      header count of the ResultSet does not match the column count of
 *      the JTable. 
 */ 
    public void importDBContents(ResultSet rs) throws SQLException{
        clearTableContents();
        for(int row = 0; rs.next(); row++){
            model.addRow(new Vector());
            for(int col = 0; col<model.getColumnCount(); col++){
                model.setValueAt(rs.getString(col+1), row, col);
            }
        }
    }

 /**
 *  Deletes the row currently shown as selected in the JTable.
 *
 */
    public void deleteRow(){
        model.removeRow(table.getSelectedRow());
    }

 /**
 *  Adds a set of values in the form of a row to the JTable
 *
 *  @param values - a String array containing all the values to be added as a 
 *      row to the JTable.
 */
    public void addRowContent(String[] values){
        model.addRow(new Vector());
        for(int col = 0; col<values.length; col++){
                model.setValueAt(values[col], model.getRowCount()-1, col);
            }
    }
    
 /**
 *  Returns the row index of the highlighted or selected row in the JTable. If 
 *  multiple rows are selected, the returned value is always the result of the 
 *  first selected row.
 * 
 *  @return selectedRow - the index of the single selected row in the JTable
 * 
 */
    public int getSelectedRow(){
        return table.getSelectedRow();
    }
    
  /**
 *  Returns the ID of a particular row in the JTable containing values from the 
 *  database. This is based on the row number
 * 
 *  @param row - the row index of the JTable containing the desired element ID.
 *  @return id - the id mapped to the database.
 *  @exception NullPointerException - throws this when the specified row cannot 
 *      be found from the JTable.
 */
    public String getIDFromTable(int row) throws NullPointerException{
        return table.getValueAt(row, 0).toString();
    }
}
