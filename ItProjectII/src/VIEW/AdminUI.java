/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import java.awt.CardLayout;

/**
 *
 * @Belthazod
 */
public class AdminUI extends javax.swing.JPanel {

    /**
     * Creates new form Admin
     */
    public AdminUI() {
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

        addCustomer1 = new VIEW.CustomerUI();
        addProduct1 = new VIEW.ProductsUI();
        jPanel1 = new javax.swing.JPanel();
        customerAdminButton = new javax.swing.JButton();
        supplierAdminButton = new javax.swing.JButton();
        productAdminButton = new javax.swing.JButton();
        adminCards = new javax.swing.JPanel();
        customerPanel = new VIEW.CustomerUI();
        supplierPanel = new VIEW.SupplierUI();
        productPanel = new VIEW.ProductsUI();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerAdminButton.setText("Customer");
        customerAdminButton.setEnabled(false);
        customerAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerAdminButtonActionPerformed(evt);
            }
        });

        supplierAdminButton.setText("Supplier");
        supplierAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierAdminButtonActionPerformed(evt);
            }
        });

        productAdminButton.setText("Product");
        productAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productAdminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productAdminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(customerAdminButton)
                .addGap(30, 30, 30)
                .addComponent(supplierAdminButton)
                .addGap(30, 30, 30)
                .addComponent(productAdminButton)
                .addContainerGap(463, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 87, -1, -1));

        adminCards.setLayout(new java.awt.CardLayout());
        adminCards.add(customerPanel, "customerCard");
        adminCards.add(supplierPanel, "supplierCard");
        adminCards.add(productPanel, "productCard");

        add(adminCards, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 87, 821, 500));

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel1.setText("Admin Panel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 19, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void customerAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerAdminButtonActionPerformed
        CardLayout card = (CardLayout)adminCards.getLayout();
        card.show(adminCards, "customerCard");
        supplierAdminButton.setEnabled(true); 
        customerAdminButton.setEnabled(false);
        productAdminButton.setEnabled(true);
    }//GEN-LAST:event_customerAdminButtonActionPerformed

    private void productAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productAdminButtonActionPerformed
        CardLayout card = (CardLayout)adminCards.getLayout();
        card.show(adminCards, "productCard");
        
        productAdminButton.setEnabled(false);
        customerAdminButton.setEnabled(true);
        supplierAdminButton.setEnabled(true);
    }//GEN-LAST:event_productAdminButtonActionPerformed

    private void supplierAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierAdminButtonActionPerformed
        CardLayout card = (CardLayout)adminCards.getLayout();
        card.show(adminCards, "supplierCard");
        
        productAdminButton.setEnabled(true);
        customerAdminButton.setEnabled(true);
        supplierAdminButton.setEnabled(false);
    }//GEN-LAST:event_supplierAdminButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private VIEW.CustomerUI addCustomer1;
    private VIEW.ProductsUI addProduct1;
    private javax.swing.JPanel adminCards;
    private javax.swing.JButton customerAdminButton;
    private VIEW.CustomerUI customerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton productAdminButton;
    private VIEW.ProductsUI productPanel;
    private javax.swing.JButton supplierAdminButton;
    private VIEW.SupplierUI supplierPanel;
    // End of variables declaration//GEN-END:variables
}
