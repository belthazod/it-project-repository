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
    public TableManager(JTable table) {
        this.table = table;
        model = (DefaultTableModel) table.getModel();
    }
    
    public void clearTableContents(){
        for(int row = 0; row < model.getRowCount();){
            model.removeRow(0);
        }   
    }
    
    public void importDBContents(ResultSet rs) throws SQLException{
        clearTableContents();
        for(int row = 0; rs.next(); row++){
            model.addRow(new Vector());
            for(int col = 0; col<model.getColumnCount(); col++){
                model.setValueAt(rs.getString(col+1), row, col);
            }
        }
    }
    
    public void deleteRow(){
        model.removeRow(table.getSelectedRow());
    }
    
}
