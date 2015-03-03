/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.Product;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

        transferDialog = new javax.swing.JDialog();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        transferFromComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        truckTable = new javax.swing.JTable();
        AddToTruckButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        transferProductsTable = new javax.swing.JTable();
        transferToComboBox = new javax.swing.JComboBox();
        removeItemButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setMaximumSize(new java.awt.Dimension(814, 592));
        setPreferredSize(new java.awt.Dimension(814, 592));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accessories", "Batteries" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel1.setText("Transfer From:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jLabel2.setText("Transfer To:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, -1, -1));

        transferFromComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Main", "Marcos", "Trinidad", "Pacdal" }));
        transferFromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferFromComboBoxActionPerformed(evt);
            }
        });
        add(transferFromComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jButton1.setText("Transfer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, 190, 50));

        jLabel4.setText("Category:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        truckTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product_id", "quantity limit", "Name", "Brand", "Category", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(truckTable);
        if (truckTable.getColumnModel().getColumnCount() > 0) {
            truckTable.getColumnModel().getColumn(0).setResizable(false);
            truckTable.getColumnModel().getColumn(1).setResizable(false);
        }
        truckTable.getColumnModel().getColumn(0).setMaxWidth(0);
        truckTable.getColumnModel().getColumn(0).setMinWidth(0);
        truckTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        truckTable.getColumnModel().getColumn(1).setMaxWidth(0);
        truckTable.getColumnModel().getColumn(1).setMinWidth(0);
        truckTable.getColumnModel().getColumn(1).setPreferredWidth(0);
        truckTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 400, 280));

        AddToTruckButton.setText("Add to truck");
        AddToTruckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToTruckButtonActionPerformed(evt);
            }
        });
        add(AddToTruckButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, 50));

        transferProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "Brand", "Category", "Unit", "Quantity", "Re-order Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(transferProductsTable);
        transferProductsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        transferProductsTable.getColumnModel().getColumn(0).setMinWidth(0);
        transferProductsTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        if (transferProductsTable.getColumnModel().getColumnCount() > 0) {
            transferProductsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 370));

        transferToComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Marcos", "Trinidad", "Pacdal", "Main" }));
        add(transferToComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 490, -1, -1));

        removeItemButton.setText("Remove Item");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
            }
        });
        add(removeItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 490, -1, -1));

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel3.setText("Product Transfer");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
    private void AddToTruckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToTruckButtonActionPerformed

        Integer transferTableSelectedRow = transferProductsTable.getSelectedRow();
        String transferProductID = (String) transferProductsTable.getModel().getValueAt(transferTableSelectedRow, 0);
        
        boolean flag = false;
        
        for(int row = 0; row < truckTable.getRowCount(); row++){
            String truckProductID = (String) truckTable.getModel().getValueAt(row, 0);
            if(transferProductID.equals(truckProductID)){
                flag = true;
            }else{
                flag = false;
            }
        }
        if(flag){
            JOptionPane.showMessageDialog(null,
                "Item already in truck.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }else{
        String name = (String) transferProductsTable.getModel().getValueAt(transferTableSelectedRow, 1);
        String description = (String) transferProductsTable.getModel().getValueAt(transferTableSelectedRow, 2);
        String category = (String) transferProductsTable.getModel().getValueAt(transferTableSelectedRow, 3);
        String quantity = (String) transferProductsTable.getModel().getValueAt(transferTableSelectedRow, 4);
        
        DefaultTableModel model = (DefaultTableModel) truckTable.getModel();
        model.addRow(new Object[]{transferProductID, quantity, name, description, category, ""});
        }
    }//GEN-LAST:event_AddToTruckButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) truckTable.getModel();
        boolean flag = false;
        
        try{
            for(int row = 0; row < model.getRowCount(); row++ ){
                String quantity = (String) truckTable.getModel().getValueAt(row, 5);
                System.out.print("Quantity" + quantity);
                if(quantity == null){
                    JOptionPane.showMessageDialog(null,
                        "Please set all the truck item's quantity.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                    PreparedStatement insertStatement = null;
                    PreparedStatement selectStatement = null;
                    Connection con = DriverManager.getConnection(host,uName, uPass);
                    
                    String branchTo = transferToComboBox.getSelectedItem().toString();
                    System.out.print(branchTo);
                    
                    String branchFrom = transferFromComboBox.getSelectedItem().toString();
                    System.out.print(branchFrom);
                    

                    long timeNow = System.currentTimeMillis();
                   
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(timeNow);
                    
                                       
                    String insertString = "INSERT INTO transfers (transfer_date, transfer_from, destination) VALUES(?,?,?)";
                    insertStatement = con.prepareStatement(insertString);

                    insertStatement.setDate(1, date);
                    insertStatement.setString(2, branchFrom);
                    insertStatement.setString(3, branchTo);
                    insertStatement.executeUpdate();
                    
                    
                    String selectString = "SELECT transfer_id FROM transfers ORDER BY 1 DESC LIMIT 1";
                    selectStatement = con.prepareStatement(selectString);
                    
                    ResultSet result = selectStatement.executeQuery();

                    result.next();
                    String transferID = result.getString(1);
                    
                    
                for(int row = 0; row<model.getRowCount();row++){

                    String deliveryInsertString = "INSERT INTO transferdetails (transfer_id, product_id, qty_transfered) VALUES(?,?,?)";
                    insertStatement = con.prepareStatement(deliveryInsertString);
                    
                    String transferProductID = (String) truckTable.getModel().getValueAt(row, 0);
                    String quantity = (String) truckTable.getModel().getValueAt(row, 5);
                    
                    insertStatement.setString(1, transferID);
                    insertStatement.setString(2, transferProductID);
                    insertStatement.setString(3, quantity);
                    insertStatement.executeUpdate();

                }
                JOptionPane.showMessageDialog(null, "Transfer aknowledged");
                deleteAllRows(truckTable);
                
            }
        }catch ( SQLException err ){
                System.out.println( err.getMessage ());
                System.out.print("FAIL");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void transferFromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferFromComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferFromComboBoxActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        Integer truckTableSelectedRow = truckTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) truckTable.getModel();
        
        model.removeRow(truckTableSelectedRow);
        
    }//GEN-LAST:event_removeItemButtonActionPerformed
    
    private static void deleteAllRows(final JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int row =0; row < model.getRowCount(); ) {
            model.removeRow(0);
        
        }
    }
    public static void updateTransferTable(){
        
        deleteAllRows(transferProductsTable);
        DefaultTableModel model = (DefaultTableModel) transferProductsTable.getModel();

        for(Product product: Main.productList){
            model.addRow(new Object[]{product.getProductID(), product.getName(), product.getDescription(), product.getTypeName(), product.getPhysicalCount(), product.getReorderQuantityLevel()});
        }
        //customerListTable.removeColumn(customerListTable.getColumnModel().getColumn(2));
        
        //JTable inventoryTable = new JTable(buildTableModel(rs));
       
        

    }
    
    public static JTable getTransferProductsTable(){
        return transferProductsTable;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToTruckButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JDialog transferDialog;
    private javax.swing.JComboBox transferFromComboBox;
    private static javax.swing.JTable transferProductsTable;
    private javax.swing.JComboBox transferToComboBox;
    private javax.swing.JTable truckTable;
    // End of variables declaration//GEN-END:variables
}
