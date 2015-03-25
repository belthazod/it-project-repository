/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.ComboItem;
import CONTROLLERS.DeliveryController;
import UTIL.InputValidator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Belthazod
 */
public class DeliveryUI extends javax.swing.JPanel {
    private DeliveryController deliveryController;
    /**
     * Creates new form Delivery
     */
    public DeliveryUI() {
        initComponents();
        deliveryController = new DeliveryController(deliveryProductsTable, deliveryTable, deliveryProductFilterSupplierComboBox, deliverySupplierLabel);
        InputValidator.enabler(deliveryProductsTable, addToListButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deliveryProductsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        removeFromListButton = new javax.swing.JButton();
        saveDeliveryButton = new javax.swing.JButton();
        addToListButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deliveryProductFilterSupplierComboBox = new javax.swing.JComboBox<ComboItem>();
        jLabel5 = new javax.swing.JLabel();
        deliverySupplierLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 177, 78));

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setText("Delivery Acknowledgement");

        deliveryProductsTable.setAutoCreateRowSorter(true);
        deliveryProductsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deliveryProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Name", "Description", "Category", "Unit", "Current Quantity", "ReorderQuantity Level"
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
        jScrollPane1.setViewportView(deliveryProductsTable);
        deliveryProductsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        deliveryProductsTable.getColumnModel().getColumn(0).setMinWidth(0);
        deliveryProductsTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        if (deliveryProductsTable.getColumnModel().getColumnCount() > 0) {
            deliveryProductsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        deliveryTable.setAutoCreateRowSorter(true);
        deliveryTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Description", "Unit of measurement", "Quantity delivered"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(deliveryTable);
        deliveryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        deliveryTable.getColumnModel().getColumn(0).setMinWidth(0);
        deliveryTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        deliveryTable.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Delivery Summary (Items Received)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Products List");

        removeFromListButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removeFromListButton.setText("Remove From List");
        removeFromListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromListButtonActionPerformed(evt);
            }
        });

        saveDeliveryButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveDeliveryButton.setText("Save Delivery");
        saveDeliveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDeliveryButtonActionPerformed(evt);
            }
        });

        addToListButton.setText("Add To List");
        addToListButton.setEnabled(false);
        addToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Supplier:");

        deliveryProductFilterSupplierComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deliveryProductFilterSupplierComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deliveryProductFilterSupplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryProductFilterSupplierComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Supplier:");

        deliverySupplierLabel.setText("SupplierName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deliveryProductFilterSupplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deliverySupplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeFromListButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(880, 880, 880)
                            .addComponent(saveDeliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(deliveryProductFilterSupplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(deliverySupplierLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(removeFromListButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveDeliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeFromListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromListButtonActionPerformed
        deliveryController.removeSelectedRow();
    }//GEN-LAST:event_removeFromListButtonActionPerformed

    private void saveDeliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDeliveryButtonActionPerformed
        deliveryController.acknowledgeDelivery();
    }//GEN-LAST:event_saveDeliveryButtonActionPerformed

    private void addToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListButtonActionPerformed
        deliveryController.addSelectedToDeliverySummary();
    }//GEN-LAST:event_addToListButtonActionPerformed

    private void deliveryProductFilterSupplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryProductFilterSupplierComboBoxActionPerformed
        deliveryController.filterProducts();
    }//GEN-LAST:event_deliveryProductFilterSupplierComboBoxActionPerformed

    public static JTable getDeliveryProductsTable(){
        return deliveryProductsTable;
    }
    
    public static JComboBox getDeliveryProductFilterSupplierComboBox(){
        return deliveryProductFilterSupplierComboBox;
    }
    
    public static JLabel getDeliverySupplierLabel(){
        return deliverySupplierLabel;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToListButton;
    private static javax.swing.JComboBox<ComboItem> deliveryProductFilterSupplierComboBox;
    public static javax.swing.JTable deliveryProductsTable;
    private static javax.swing.JLabel deliverySupplierLabel;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeFromListButton;
    private javax.swing.JButton saveDeliveryButton;
    // End of variables declaration//GEN-END:variables
}