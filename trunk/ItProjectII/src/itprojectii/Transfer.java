/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itprojectii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author weak_2030
 */
public class Transfer extends javax.swing.JPanel {

    /**
     * Creates new form Transfer
     */
    public Transfer() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        transferTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(814, 592));
        setPreferredSize(new java.awt.Dimension(814, 592));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accessories", "Batteries" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 21, -1, -1));

        jLabel1.setText("Transfer From:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, -1, -1));

        jLabel2.setText("Transfer To:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 425, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "branch 2" }));
        add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 422, -1, -1));

        jLabel3.setText("Transfer Date:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 456, -1, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 453, 222, -1));

        jButton1.setText("Transfer");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 530, -1, -1));

        jButton2.setText("Back To Main");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, -1, -1));

        jLabel4.setText("Category:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 24, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "product_id", "Name", "Brand", "Category", "Quantity", "Re-order Level"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 400, 360));

        jLabel5.setText("Quantity:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 425, -1, -1));

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("main");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 425, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 422, 37, -1));

        jButton3.setText("Add to truck");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        transferTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Name", "Brand", "Category", "Quantity", "Re-order Level"
            }
        ));
        jScrollPane2.setViewportView(transferTable);
        updateTransferTable();
        transferTable.getColumnModel().getColumn(0).setMaxWidth(0);
        transferTable.getColumnModel().getColumn(0).setMinWidth(0);
        transferTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 370));
    }// </editor-fold>//GEN-END:initComponents

        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private static void deleteAllRows(final JTable model) {
        for(int row =0; row < model.getRowCount();  row++ ) {
            for(int col = 0; col<6; col++){
                
                model.setValueAt(null, row, col );
            }
        }
    }
    public void updateTransferTable(){
        try{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        //customerListTable.addColumn(new TableColumn());
        Statement stmt = con.createStatement( );
        String SQL = "SELECT product_id, name, description, type_name, physical_count, reorder_quantity FROM product JOIN type USING(type_id)";
        
       
        deleteAllRows(transferTable);
        ResultSet rs = stmt.executeQuery( SQL );
        for(int row = 0; rs.next(); row++){
            for(int col = 0; col<6; col++){
            transferTable.setValueAt(rs.getString(col+1), row, col );
        }
        }
        //customerListTable.removeColumn(customerListTable.getColumnModel().getColumn(2));
        
        //JTable inventoryTable = new JTable(buildTableModel(rs));
        
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable transferTable;
    // End of variables declaration//GEN-END:variables
}
