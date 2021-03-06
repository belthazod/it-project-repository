/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLLERS.CartController;
import javax.swing.JTable;

/**
 *
 * @author Bea
 */
public class Cart extends javax.swing.JFrame {
    CartController cartController;
    /**
     * Creates new form Cart
     */
    public Cart() {
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

        salesTypeDialog = new javax.swing.JDialog();
        selectPurchaseButton = new javax.swing.JButton();
        selectServiceButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        receiptInfoLabel1 = new javax.swing.JLabel();
        receiptInfoLabel2 = new javax.swing.JLabel();
        receiptNumberInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        salesTypeDialog.setTitle("Choose Transaction Type");
        salesTypeDialog.setBounds(new java.awt.Rectangle(0, 0, 500, 200));
        salesTypeDialog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salesTypeDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        salesTypeDialog.setLocationRelativeTo(null);

        selectPurchaseButton.setText("Purchase");
        selectPurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPurchaseButtonActionPerformed(evt);
            }
        });

        selectServiceButton.setText("Service");
        selectServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectServiceButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        receiptInfoLabel1.setText("The system has detected an item with warranty among the products in the cart.");
        receiptInfoLabel1.setVisible(false);

        receiptInfoLabel2.setText("Please enter the Receipt Number:");
        receiptInfoLabel2.setVisible(false);

        receiptNumberInput.setVisible(false);

        javax.swing.GroupLayout salesTypeDialogLayout = new javax.swing.GroupLayout(salesTypeDialog.getContentPane());
        salesTypeDialog.getContentPane().setLayout(salesTypeDialogLayout);
        salesTypeDialogLayout.setHorizontalGroup(
            salesTypeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesTypeDialogLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(selectPurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selectServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesTypeDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addContainerGap())
            .addGroup(salesTypeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salesTypeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salesTypeDialogLayout.createSequentialGroup()
                        .addComponent(receiptInfoLabel1)
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(salesTypeDialogLayout.createSequentialGroup()
                        .addComponent(receiptInfoLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(receiptNumberInput)))
                .addContainerGap())
        );
        salesTypeDialogLayout.setVerticalGroup(
            salesTypeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salesTypeDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(receiptInfoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(salesTypeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiptInfoLabel2)
                    .addComponent(receiptNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(salesTypeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(250, 238, 161));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Product List");

        jButton2.setText("Clear List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(573, 573, 573))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cartController.clearCart();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectPurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPurchaseButtonActionPerformed
        cartController.selectTypePurchase();
    }//GEN-LAST:event_selectPurchaseButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cartController.closeSalesTypeDialog();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectServiceButtonActionPerformed
        cartController.selectTypeService();
    }//GEN-LAST:event_selectServiceButtonActionPerformed
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel receiptInfoLabel1;
    private javax.swing.JLabel receiptInfoLabel2;
    private javax.swing.JTextField receiptNumberInput;
    private javax.swing.JDialog salesTypeDialog;
    private javax.swing.JButton selectPurchaseButton;
    private javax.swing.JButton selectServiceButton;
    // End of variables declaration//GEN-END:variables
}
