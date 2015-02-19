/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Belthazod
 */
public class TableManager {
    private  DefaultTableModel model;
    
    public TableManager(JTable table) {
        model = (DefaultTableModel) table.getModel();
    }
    
    public void clearTableContents(){
        for(int row = 0; row < model.getRowCount();row++){
            model.removeRow(0);
        }   
    }
    
    public void importDBContents(ResultSet rs) throws SQLException{
        for(int row = 0; rs.next(); row++){
            for(int col = 0; col<3; col++){
                model.setValueAt(rs.getString(col+1), row, col);
            }
        }
    }
    
    public void deleteRow(int row){
        model.removeRow(row);
    }
    
    
}
