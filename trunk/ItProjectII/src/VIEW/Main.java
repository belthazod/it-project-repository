/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.Product;
import BEANS.SecondHandProduct;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Belthazod
 */
public class Main extends javax.swing.JFrame {
   
    CardLayout card;

    /**
     * Creates new form main
     */
    public Main() {
        initComponents();
        ProductsUI.updateAdminProductsTable();
        CustomerUI.updateCustomerTable();
        SupplierUI.updateSupplierTable();
        ProductsUI.updateCategoryTable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        deliveryMenuButton = new javax.swing.JButton();
        reportsMenuButton = new javax.swing.JButton();
        tradeInMenuButton = new javax.swing.JButton();
        warrantyMenuButton = new javax.swing.JButton();
        transferMenuButton = new javax.swing.JButton();
        adminMenuButton = new javax.swing.JButton();
        salesMenuButton = new javax.swing.JButton();
        returnsMenuButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cardWindow = new javax.swing.JPanel();
        inventoryUI1 = new VIEW.InventoryUI();
        delivery1 = new VIEW.DeliveryUI();
        warranty1 = new VIEW.Warranty();
        transfer1 = new VIEW.TransferUI();
        adminUI1 = new VIEW.AdminUI();
        tradeInUI1 = new VIEW.TradeInUI();
        reports1 = new VIEW.Reports();
        returns1 = new VIEW.Returns();

        jButton6.setText("returns");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("main"));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));

        deliveryMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery.png"))); // NOI18N
        deliveryMenuButton.setBorderPainted(false);
        deliveryMenuButton.setContentAreaFilled(false);
        deliveryMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery-1.png"))); // NOI18N
        deliveryMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryMenuButtonActionPerformed(evt);
            }
        });

        reportsMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/report.png"))); // NOI18N
        reportsMenuButton.setBorderPainted(false);
        reportsMenuButton.setContentAreaFilled(false);
        reportsMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/report-1.png"))); // NOI18N
        reportsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsMenuButtonActionPerformed(evt);
            }
        });

        tradeInMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein.png"))); // NOI18N
        tradeInMenuButton.setBorderPainted(false);
        tradeInMenuButton.setContentAreaFilled(false);
        tradeInMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein-1.png"))); // NOI18N
        tradeInMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradeInMenuButtonActionPerformed(evt);
            }
        });

        warrantyMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/warranty-o.png"))); // NOI18N
        warrantyMenuButton.setBorderPainted(false);
        warrantyMenuButton.setContentAreaFilled(false);
        warrantyMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/warranty.png"))); // NOI18N
        warrantyMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warrantyMenuButtonActionPerformed(evt);
            }
        });

        transferMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer.png"))); // NOI18N
        transferMenuButton.setBorderPainted(false);
        transferMenuButton.setContentAreaFilled(false);
        transferMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer-1.png"))); // NOI18N
        transferMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferMenuButtonActionPerformed(evt);
            }
        });

        adminMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/admin.png"))); // NOI18N
        adminMenuButton.setBorderPainted(false);
        adminMenuButton.setContentAreaFilled(false);
        adminMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/admin-1.png"))); // NOI18N
        adminMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMenuButtonActionPerformed(evt);
            }
        });

        salesMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/home-o.png"))); // NOI18N
        salesMenuButton.setBorderPainted(false);
        salesMenuButton.setContentAreaFilled(false);
        salesMenuButton.setPreferredSize(new java.awt.Dimension(100, 83));
        salesMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/home_1.png"))); // NOI18N
        salesMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesMenuButtonActionPerformed(evt);
            }
        });

        returnsMenuButton.setText("Returns");
        returnsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnsMenuButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 11, 420, 29));

        jLabel1.setText("Search:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, -1, -1));

        jButton17.setBorderPainted(false);
        jButton17.setContentAreaFilled(false);
        jPanel4.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 73, -1, 29));

        jButton18.setBorderPainted(false);
        jButton18.setContentAreaFilled(false);
        jPanel4.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1005, 58, -1, -1));

        jButton19.setBorderPainted(false);
        jButton19.setContentAreaFilled(false);
        jPanel4.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1064, 58, -1, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/search2.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 11, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/settings2.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(985, 0, 53, 29));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/logout2.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1044, 0, -1, -1));

        jButton1.setText("Customers");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        cardWindow.setBackground(new java.awt.Color(102, 102, 102));
        cardWindow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cardWindow.setLayout(new java.awt.CardLayout());
        cardWindow.add(inventoryUI1, "inventoryCard");
        cardWindow.add(delivery1, "deliveryCard");
        cardWindow.add(warranty1, "warrantyCard");
        cardWindow.add(transfer1, "transferCard");
        cardWindow.add(adminUI1, "adminCard");
        cardWindow.add(tradeInUI1, "tradeInCard");
        cardWindow.add(reports1, "reportsCard");
        reports1.getAccessibleContext().setAccessibleName("");

        cardWindow.add(returns1, "returnsCard");

        jPanel4.add(cardWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 60, 1100, 590));
        card = (CardLayout)cardWindow.getLayout();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportsMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tradeInMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warrantyMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(returnsMenuButton))
                    .addComponent(adminMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1134, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(deliveryMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(reportsMenuButton)
                        .addGap(6, 6, 6)
                        .addComponent(tradeInMenuButton)
                        .addGap(6, 6, 6)
                        .addComponent(warrantyMenuButton)
                        .addGap(6, 6, 6)
                        .addComponent(transferMenuButton)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(returnsMenuButton))
                            .addComponent(adminMenuButton)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void salesMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesMenuButtonActionPerformed
        card.show(cardWindow, "inventoryCard");
    }//GEN-LAST:event_salesMenuButtonActionPerformed

    private void adminMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminMenuButtonActionPerformed
        card.show(cardWindow, "adminCard");
    }//GEN-LAST:event_adminMenuButtonActionPerformed

    private void transferMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferMenuButtonActionPerformed
        card.show(cardWindow, "transferCard");
    }//GEN-LAST:event_transferMenuButtonActionPerformed

    private void warrantyMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warrantyMenuButtonActionPerformed
        card.show(cardWindow, "warrantyCard");
    }//GEN-LAST:event_warrantyMenuButtonActionPerformed

    private void tradeInMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradeInMenuButtonActionPerformed
        card.show(cardWindow, "tradeInCard");
    }//GEN-LAST:event_tradeInMenuButtonActionPerformed

    private void reportsMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsMenuButtonActionPerformed
        card.show(cardWindow, "reportsCard");
    }//GEN-LAST:event_reportsMenuButtonActionPerformed

    private void deliveryMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryMenuButtonActionPerformed
        card.show(cardWindow, "deliveryCard");
    }//GEN-LAST:event_deliveryMenuButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void returnsMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnsMenuButtonActionPerformed
         card.show(cardWindow, "returnsCard");
    }//GEN-LAST:event_returnsMenuButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        card.show(cardWindow, "customerCard");
    }//GEN-LAST:event_jButton1ActionPerformed
        static String host = "jdbc:mysql://localhost:3306/inventory";
        static String uName = "root";
        static String uPass = "";
        static ArrayList<Product> productList = new ArrayList<Product>();
        static ArrayList<SecondHandProduct> secondHandList = new ArrayList<SecondHandProduct>();                                    

    


    
    public static void updateProductsList(){
        PreparedStatement selectStatement = null;
        productList.clear();
        try{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        String selectString = "SELECT product_id, type_id, type_name, name, description, "
                + "supplier_ID, supplier_name, Unit, physical_count, "
                + "reorder_quantity FROM product JOIN type USING(type_id) JOIN "
                + "supplier using(supplier_id);";
        selectStatement = con.prepareStatement(selectString);
        ResultSet rs = selectStatement.executeQuery();
        
            while(rs.next()){
                Product product = new Product(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7), rs.getString(8), 
                        rs.getString(9), rs.getString(10) );
                
                productList.add(product);

            }
        Warranty.updateProductsListWarrantyTable();

  //          customerIDEditInput.setText(result);
       // editCustomerDialog.setVisible(true);
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }
    
    public static void updateSecondHandList(){
        PreparedStatement selectStatement = null;
        secondHandList.clear();
        try{
        Connection con = DriverManager.getConnection(host,uName, uPass);
        
        String selectString = "SELECT used_item_id, used_item_name, used_item_brand, used_item_quality, "
                + "used_item_quantity, used_item_type, type_name "
                + "FROM secondhand JOIN type ON type.type_id = used_item_type;";
        selectStatement = con.prepareStatement(selectString);
        ResultSet rs = selectStatement.executeQuery();
        
            while(rs.next()){
                SecondHandProduct product = new SecondHandProduct(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getString(7));
                
                secondHandList.add(product);

            }
        SecondhandTradeIn.updateSecondHandProductsListTable();
        }
        catch ( SQLException err ){
            System.out.println( err.getMessage ());
            System.out.print("FAIL");
        }
    }
    

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminMenuButton;
    private VIEW.AdminUI adminUI1;
    private javax.swing.JPanel cardWindow;
    private VIEW.DeliveryUI delivery1;
    private javax.swing.JButton deliveryMenuButton;
    private VIEW.InventoryUI inventoryUI1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private VIEW.Reports reports1;
    private javax.swing.JButton reportsMenuButton;
    private VIEW.Returns returns1;
    private javax.swing.JButton returnsMenuButton;
    private javax.swing.JButton salesMenuButton;
    private javax.swing.JButton tradeInMenuButton;
    private VIEW.TradeInUI tradeInUI1;
    private VIEW.TransferUI transfer1;
    private javax.swing.JButton transferMenuButton;
    private VIEW.Warranty warranty1;
    private javax.swing.JButton warrantyMenuButton;
    // End of variables declaration//GEN-END:variables
}
