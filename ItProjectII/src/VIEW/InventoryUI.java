/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.ComboItem;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author Belthazod
 */
public class InventoryUI extends javax.swing.JPanel {

    /**
     * Creates new form InventoryUI
     */
    public InventoryUI() {
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

        productFilterComboBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 36, 63));

        productFilterComboBox.setBackground(new java.awt.Color(230, 76, 102));
        productFilterComboBox.setForeground(new java.awt.Color(255, 255, 255));
        productFilterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accessories", "Batteries", "Oils", "Rims", "Tires" }));
        productFilterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productFilterComboBoxActionPerformed(evt);
            }
        });

        inventoryTable.setAutoCreateRowSorter(true);
        inventoryTable.setBackground(new java.awt.Color(57, 66, 99));
        inventoryTable.setForeground(new java.awt.Color(255, 255, 255));
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product_id", "Name", "Description", "Category", "Unit", "Supplier", "Quantity", "Reorder Quantity Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inventoryTable.setGridColor(new java.awt.Color(204, 204, 204));
        inventoryTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(inventoryTable);
        inventoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        inventoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        jButton14.setBackground(new java.awt.Color(230, 76, 102));
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Mark as bought");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category:");

        jButton20.setBackground(new java.awt.Color(230, 76, 102));
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Critical Product");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product Inventory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(productFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 765, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14)
                    .addComponent(jButton20))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(430, 430, 430)
                            .addComponent(jLabel2))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 37, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(productFilterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(47, 47, 47)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 67, Short.MAX_VALUE)))
        );

        //updateCategoryComboBox();
    }// </editor-fold>//GEN-END:initComponents

    private void productFilterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productFilterComboBoxActionPerformed
//        System.out.print("ComboBox");
//
//        if(productFilterComboBox.getSelectedItem()!=null){
//            String category = productFilterComboBox.getSelectedItem().toString();
//            System.out.print(category);
//            if(category.equals("All")){
//                updateInventoryTable();
//            }else{
//                updateInventoryTable(category);
//            }
//        }
    }//GEN-LAST:event_productFilterComboBoxActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Cart c = new Cart();
        c.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        CriticalProducts cp = new CriticalProducts();
        cp.setVisible(true);
    }//GEN-LAST:event_jButton20ActionPerformed
    public static JTable getInventoryTable(){
        return inventoryTable;
    }
    public static JComboBox<ComboItem> getProductFilterCategoryComboBox(){
        return productFilterComboBox;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable inventoryTable;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton20;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JComboBox productFilterComboBox;
    // End of variables declaration//GEN-END:variables
}
