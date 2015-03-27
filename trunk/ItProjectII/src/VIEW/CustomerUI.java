/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;


import CONTROLLERS.CustomerController;
import UTIL.InputValidator;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Belthazod
 */
public class CustomerUI extends javax.swing.JPanel {
    private static CustomerController customerController; 
    

    /**
     * Creates new form AddCustomer
     */
    public CustomerUI() {
        initComponents();
        customerController = new CustomerController(customerListTable);
        customerListTable.getColumnModel().getColumn(0).setMaxWidth(0);
        customerListTable.getColumnModel().getColumn(0).setMinWidth(0);
        customerListTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        InputValidator.enabler(customerListTable, editCustomerButton);
        InputValidator.enabler(customerListTable, deleteCustomerButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editCustomerDialog = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contactNumberEditInput = new javax.swing.JTextField();
        customerNameEditInput = new javax.swing.JTextField();
        saveEditedCustomerButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        customerIDEditInput = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerNameInput = new javax.swing.JTextField();
        contactNumberInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerListTable = new javax.swing.JTable();
        addCustomerButton = new javax.swing.JButton();
        deleteCustomerButton = new javax.swing.JButton();
        editCustomerButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        editCustomerDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editCustomerDialog.setTitle("Edit Customer Information");
        editCustomerDialog.setBounds(new java.awt.Rectangle(0, 0, 400, 200));
        editCustomerDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel6.setText("Customer Name:");

        jLabel7.setText("Contact Number:");

        contactNumberEditInput.setEditable(true);
        contactNumberEditInput.setText("jTextField1");
        contactNumberEditInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberEditInputActionPerformed(evt);
            }
        });

        customerNameEditInput.setText("jTextField1");
        customerNameEditInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameEditInputActionPerformed(evt);
            }
        });

        saveEditedCustomerButton.setText("Save");
        saveEditedCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEditedCustomerButtonActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        customerIDEditInput.setText("jLabel6");

        javax.swing.GroupLayout editCustomerDialogLayout = new javax.swing.GroupLayout(editCustomerDialog.getContentPane());
        editCustomerDialog.getContentPane().setLayout(editCustomerDialogLayout);
        editCustomerDialogLayout.setHorizontalGroup(
            editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCustomerDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveEditedCustomerButton)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(39, 39, 39))
            .addGroup(editCustomerDialogLayout.createSequentialGroup()
                .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editCustomerDialogLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(customerIDEditInput))
                        .addGroup(editCustomerDialogLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerNameEditInput, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(contactNumberEditInput))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        editCustomerDialogLayout.setVerticalGroup(
            editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editCustomerDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerIDEditInput)
                .addGap(18, 18, 18)
                .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(customerNameEditInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(contactNumberEditInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addGroup(editCustomerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(saveEditedCustomerButton))
                .addGap(21, 21, 21))
        );

        customerIDEditInput.setVisible(false);

        editCustomerDialog.setLocationRelativeTo(this);

        setBackground(new java.awt.Color(250, 238, 161));
        setMaximumSize(new java.awt.Dimension(814, 592));
        setPreferredSize(new java.awt.Dimension(814, 592));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Customer Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Contact Number:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        customerNameInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameInputActionPerformed(evt);
            }
        });
        add(customerNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 32, 670, -1));

        contactNumberInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contactNumberInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberInputActionPerformed(evt);
            }
        });
        contactNumberInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactNumberInputKeyPressed(evt);
            }
        });
        add(contactNumberInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 70, 670, -1));

        customerListTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                "customer_id", "Customer Name", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerListTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 794, 182));

        addCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addCustomerButton.setText("Add Customer");
        addCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButtonActionPerformed(evt);
            }
        });
        add(addCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

        deleteCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteCustomerButton.setText("Delete Customer");
        deleteCustomerButton.setEnabled(false);
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });
        add(deleteCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, -1, -1));

        editCustomerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editCustomerButton.setText("Edit Customer");
        editCustomerButton.setEnabled(false);
        editCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerButtonActionPerformed(evt);
            }
        });
        add(editCustomerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        jButton7.setText("Edit Customer");
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("e.g. 074-555-444, 09091234567, +639091234567");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void contactNumberInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberInputActionPerformed

    private void customerNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameInputActionPerformed

    private void addCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerButtonActionPerformed
        customerController.addCustomer(customerNameInput, contactNumberInput);
        customerController.updateTableContents();
        
    }//GEN-LAST:event_addCustomerButtonActionPerformed

    private void editCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerButtonActionPerformed
        Integer selectedRow = customerListTable.getSelectedRow();
        String result = (String) customerListTable.getModel().getValueAt(selectedRow, 0);
        JTextField[] inputs = {customerNameEditInput, contactNumberEditInput};
        if(customerController.openEditDialog(result, inputs, customerIDEditInput)){
            editCustomerDialog.setVisible(true);
        }
    }//GEN-LAST:event_editCustomerButtonActionPerformed

    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCustomerButtonActionPerformed
        Integer selectedRow = customerListTable.getSelectedRow();
        String name = (String) customerListTable.getModel().getValueAt(selectedRow, 1);
        int result = JOptionPane.showConfirmDialog(null, "Are you sure in deleting " + name + " from the Customer List","Warning!" ,JOptionPane.YES_NO_OPTION);
        
        if(result == 0){
            customerController.deleteSelectedCustomer();
            customerController.updateTableContents();
        }
    }//GEN-LAST:event_deleteCustomerButtonActionPerformed

    private void contactNumberInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumberInputKeyPressed
        
        if (evt.getKeyCode()== KeyEvent.VK_ENTER)
	{
            addCustomerButton.doClick();
	}

    }//GEN-LAST:event_contactNumberInputKeyPressed

    private void contactNumberEditInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberEditInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberEditInputActionPerformed

    private void customerNameEditInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameEditInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameEditInputActionPerformed

    private void saveEditedCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEditedCustomerButtonActionPerformed
        customerController.editCustomer(customerNameEditInput, contactNumberEditInput, customerIDEditInput.getText());
        customerController.updateTableContents();
        editCustomerDialog.dispose();
    }//GEN-LAST:event_saveEditedCustomerButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        editCustomerDialog.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void updateCustomerTable(){
        customerController.updateTableContents();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomerButton;
    protected static javax.swing.JTextField contactNumberEditInput;
    private javax.swing.JTextField contactNumberInput;
    private javax.swing.JLabel customerIDEditInput;
    private static javax.swing.JTable customerListTable;
    protected javax.swing.JTextField customerNameEditInput;
    private javax.swing.JTextField customerNameInput;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JButton editCustomerButton;
    private javax.swing.JDialog editCustomerDialog;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveEditedCustomerButton;
    // End of variables declaration//GEN-END:variables

    
}
