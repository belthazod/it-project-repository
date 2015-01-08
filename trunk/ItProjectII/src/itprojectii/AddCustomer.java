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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author weak_2030
 */
public class AddCustomer extends javax.swing.JPanel {

    /**
     * Creates new form AddCustomer
     */
    public AddCustomer() {
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

        editPanel = new javax.swing.JFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerNameEditInput = new javax.swing.JTextField();
        contactNumberEditInput = new javax.swing.JTextField();
        saveEditedCustomerButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        customerIDEditInput = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerNameInput = new javax.swing.JTextField();
        contactNumberInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerListTable = new javax.swing.JTable();
        AddCustomerButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        editPanel.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editPanel.setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        editPanel.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        editPanel.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Customer Name:");
        editPanel.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 39, -1, -1));

        jLabel4.setText("Contact Number:");
        editPanel.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 90, -1, -1));

        customerNameEditInput.setEditable(true);
        customerNameEditInput.setText("jTextField1");
        customerNameEditInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameEditInputActionPerformed(evt);
            }
        });
        editPanel.getContentPane().add(customerNameEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 36, 194, -1));

        contactNumberEditInput.setText("jTextField1");
        contactNumberEditInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberEditInputActionPerformed(evt);
            }
        });
        editPanel.getContentPane().add(contactNumberEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 87, 194, -1));

        saveEditedCustomerButton.setText("Save");
        saveEditedCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditedCustomerButtonActionPerformed(evt);
            }
        });
        editPanel.getContentPane().add(saveEditedCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 159, -1, -1));

        jLabel5.setText("Edit Customer");
        editPanel.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 11, -1, -1));

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        editPanel.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 159, -1, -1));

        customerIDEditInput.setText("jLabel6");
        editPanel.getContentPane().add(customerIDEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, -1, -1));
        customerIDEditInput.setVisible(false);

        editPanel.setLocationRelativeTo(this);

        setMaximumSize(new java.awt.Dimension(814, 592));
        setPreferredSize(new java.awt.Dimension(814, 592));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, -1, -1));

        jLabel2.setText("Contact Number:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        customerNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameInputActionPerformed(evt);
            }
        });
        add(customerNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 32, 670, -1));

        contactNumberInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberInputActionPerformed(evt);
            }
        });
        add(contactNumberInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 70, 670, -1));

        customerListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "customer_id", "Name", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        updateCustomerList();
        jScrollPane1.setViewportView(customerListTable);
        customerListTable.getColumnModel().getColumn(0).setMaxWidth(0);
        customerListTable.getColumnModel().getColumn(0).setMinWidth(0);
        customerListTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 794, 182));

        AddCustomerButton.setText("Add Customer");
        AddCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerButtonActionPerformed(evt);
            }
        });
        add(AddCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 101, -1, -1));

        deleteCustomerButton.setText("Delete Customer");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });
        add(deleteCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, -1, -1));

        editCustomerButton.setText("Edit Customer");
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });
        add(editCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, -1, -1));

        jButton7.setText("Edit Customer");
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));
    }// </editor-fold>//GEN-END:initComponents

    private void contactNumberInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberInputActionPerformed

    private void customerNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameInputActionPerformed

    private void AddCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerButtonActionPerformed
        
        PreparedStatement insertStatement = null;
        try{
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        
        
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        Statement stmt = con.createStatement( );
        
        String insertString = "INSERT INTO customer (customer_name, customer_contact) VALUES(?,?)";
        insertStatement = con.prepareStatement(insertString);
        
        insertStatement.setString(1,customerNameInput.getText());
        insertStatement.setString(2, contactNumberInput.getText());
        insertStatement.executeUpdate();
        
        updateCustomerList();
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
        
    }//GEN-LAST:event_AddCustomerButtonActionPerformed

    private void contactNumberEditInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberEditInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberEditInputActionPerformed

    private void saveEditedCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditedCustomerButtonActionPerformed
        PreparedStatement insertStatement = null;
        try{
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        
        
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        Statement stmt = con.createStatement( );
        
        String insertString = "UPDATE customer SET customer_name = ?, customer_contact = ? WHERE customer_id = ?";
        insertStatement = con.prepareStatement(insertString);
        
        insertStatement.setString(1,customerNameEditInput.getText());
        insertStatement.setString(2, contactNumberEditInput.getText());
        insertStatement.setString(3, customerIDEditInput.getText());
        insertStatement.executeUpdate();
        
        updateCustomerList();
        editPanel.dispose();
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }//GEN-LAST:event_saveEditedCustomerButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        editPanel.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
    
        editPanel.setVisible(true);
        
        PreparedStatement selectStatement = null;
        try{
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        
        
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        String selectString = "SELECT customer_name, customer_contact FROM customer WHERE customer_id = ?";
        selectStatement = con.prepareStatement(selectString);
        Integer selectedRow = customerListTable.getSelectedRow();
        System.out.println("selected Row:"+ selectedRow);
        String result = (String) customerListTable.getModel().getValueAt(selectedRow, 0);
        System.out.print(result);
        selectStatement.setString(1,result);
        ResultSet rs = selectStatement.executeQuery();
        
            while(rs.next()){
                String customerName = rs.getString(1);
                String customerContact = rs.getString(2);
                
                customerNameEditInput.setText(customerName);
                contactNumberEditInput.setText(customerContact);
            }
            customerIDEditInput.setText(result);
        
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void customerNameEditInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameEditInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameEditInputActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
        PreparedStatement selectStatement = null;
        try{
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        
        
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        String selectString = "SELECT customer_name, customer_contact FROM customer WHERE customer_id = ? LIMIT 1";
        selectStatement = con.prepareStatement(selectString);
        String selectedRow = (String) customerListTable.getValueAt(customerListTable.getSelectedRow(),0);
        selectStatement.setString(1,selectedRow);
        ResultSet rs = selectStatement.executeQuery();
        
            while(rs.next()){
                String customerName = rs.getString(1);
                String customerContact = rs.getString(2);
                
                PreparedStatement deleteStatement = null;
                try{



                String deleteString = "DELETE FROM customer WHERE customer_id = ?";
                deleteStatement = con.prepareStatement(deleteString);

                deleteStatement.setString(1, selectedRow);
                deleteStatement.executeUpdate();
                System.out.print("test");
                updateCustomerList();
                }
                catch ( SQLException err ){
                    System.out.println( err.getMessage ());
                    System.out.print("FAIL");
                }

            }
        
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed
    private static void deleteAllRows(final JTable model) {
        for(int row =0; row < model.getRowCount();  row++ ) {
            for(int col = 0; col<3; col++){
                
                model.setValueAt(null, row, col );
            }
        }
    }
    private static void editCustomerList(){
        String customerID = customerListTable.getValueAt(customerListTable.getSelectedRow(),0).toString();
        
    }
    protected void updateCustomerList(){
        try{
        
        String host = "jdbc:mysql://localhost:3306/inventory";
        String uName = "root";
        String uPass = "";
        Connection con = DriverManager.getConnection(host,uName, uPass);
        //customerListTable.addColumn(new TableColumn());
        Statement stmt = con.createStatement( );
        String SQL = "SELECT  customer_id, customer_name, customer_contact FROM customer;";
        
       
        deleteAllRows(customerListTable);
        ResultSet rs = stmt.executeQuery( SQL );
        for(int row = 0; rs.next(); row++){
            for(int col = 0; col<3; col++){
            customerListTable.setValueAt(rs.getString(col+1), row, col );
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
    private javax.swing.JButton AddCustomerButton;
    protected javax.swing.JTextField contactNumberEditInput;
    private javax.swing.JTextField contactNumberInput;
    private javax.swing.JLabel customerIDEditInput;
    private static javax.swing.JTable customerListTable;
    protected static javax.swing.JTextField customerNameEditInput;
    private javax.swing.JTextField customerNameInput;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JFrame editPanel;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveEditedCustomerButton;
    // End of variables declaration//GEN-END:variables
}
