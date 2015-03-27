/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.Product;
import BEANS.SecondHandProduct;
import CONTROLLERS.UserController;
import java.awt.CardLayout;
import java.util.ArrayList;
/**
 *
 * @author Belthazod
 */
public class Main extends javax.swing.JFrame {
   
    CardLayout card;
    UserController userController;
    /**
     * Creates new form main
     */
    public Main() {
        initComponents();
        try{
        ProductsUI.updateAdminProductsTable();
        CustomerUI.updateCustomerTable();
        SupplierUI.updateSupplierTable();
        ProductsUI.updateCategoryTable();
        UserUI.updateUsersTable();
        SecondhandTradeIn.updateSecondHandTable();
        userController = new UserController(oldUserPasswordInput, newUserPasswordInput, newUserConfirmPasswordInput,editPasswordDialog, userLabel);
        }catch(Exception e){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPasswordDialog = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        oldUserPasswordInput = new javax.swing.JPasswordField();
        newUserPasswordInput = new javax.swing.JPasswordField();
        newUserConfirmPasswordInput = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        deliveryMenuButton = new javax.swing.JButton();
        reportsMenuButton = new javax.swing.JButton();
        tradeInMenuButton = new javax.swing.JButton();
        warrantyMenuButton = new javax.swing.JButton();
        transferMenuButton = new javax.swing.JButton();
        salesMenuButton = new javax.swing.JButton();
        returnsMenuButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        cardWindow = new javax.swing.JPanel();
        inventoryUI1 = new VIEW.InventoryUI();
        deliveryUI1 = new VIEW.DeliveryUI();
        reports1 = new VIEW.Reports();
        secondhandTradeIn1 = new VIEW.SecondhandTradeIn();
        warranty1 = new VIEW.Warranty();
        transferUI1 = new VIEW.TransferUI();
        returns1 = new VIEW.Returns();
        newCustomerUI1 = new VIEW.NewCustomerUI();
        adminUI1 = new VIEW.AdminUI();
        adminMenuButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userView = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        editPasswordDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editPasswordDialog.setTitle("Change User Password");
        editPasswordDialog.setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        editPasswordDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        editPasswordDialog.setLocationRelativeTo(null);

        jLabel3.setText("Username:");

        jLabel4.setText("Old Password:");

        userLabel.setText("user");

        jLabel5.setText("New Password:");

        jLabel6.setText("Confirm New Password:");

        oldUserPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldUserPasswordInputActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPasswordDialogLayout = new javax.swing.GroupLayout(editPasswordDialog.getContentPane());
        editPasswordDialog.getContentPane().setLayout(editPasswordDialogLayout);
        editPasswordDialogLayout.setHorizontalGroup(
            editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPasswordDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editPasswordDialogLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(editPasswordDialogLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(newUserConfirmPasswordInput))
                        .addGroup(editPasswordDialogLayout.createSequentialGroup()
                            .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(49, 49, 49)
                            .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userLabel)
                                .addComponent(newUserPasswordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(oldUserPasswordInput)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        editPasswordDialogLayout.setVerticalGroup(
            editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPasswordDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userLabel))
                .addGap(29, 29, 29)
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(oldUserPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(newUserPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(newUserConfirmPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(editPasswordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 238, 161));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/customer_yellow.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/customer_hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        deliveryMenuButton.setBackground(new java.awt.Color(31, 37, 61));
        deliveryMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery_yellow.png"))); // NOI18N
        deliveryMenuButton.setToolTipText("");
        deliveryMenuButton.setBorderPainted(false);
        deliveryMenuButton.setContentAreaFilled(false);
        deliveryMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery_hover.png"))); // NOI18N
        deliveryMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryMenuButtonActionPerformed(evt);
            }
        });

        reportsMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/reports_yellow.png"))); // NOI18N
        reportsMenuButton.setBorderPainted(false);
        reportsMenuButton.setContentAreaFilled(false);
        reportsMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/reports_hover.png"))); // NOI18N
        reportsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsMenuButtonActionPerformed(evt);
            }
        });

        tradeInMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein.png"))); // NOI18N
        tradeInMenuButton.setBorderPainted(false);
        tradeInMenuButton.setContentAreaFilled(false);
        tradeInMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein_hover.png"))); // NOI18N
        tradeInMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradeInMenuButtonActionPerformed(evt);
            }
        });

        warrantyMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/warranty-o_1.png"))); // NOI18N
        warrantyMenuButton.setBorderPainted(false);
        warrantyMenuButton.setContentAreaFilled(false);
        warrantyMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/warranty.png"))); // NOI18N
        warrantyMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warrantyMenuButtonActionPerformed(evt);
            }
        });

        transferMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer_yellow.png"))); // NOI18N
        transferMenuButton.setBorderPainted(false);
        transferMenuButton.setContentAreaFilled(false);
        transferMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer_hover.png"))); // NOI18N
        transferMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferMenuButtonActionPerformed(evt);
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

        returnsMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/returns.png"))); // NOI18N
        returnsMenuButton.setBorder(null);
        returnsMenuButton.setBorderPainted(false);
        returnsMenuButton.setContentAreaFilled(false);
        returnsMenuButton.setOpaque(false);
        returnsMenuButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/returns-hover.png"))); // NOI18N
        returnsMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnsMenuButtonActionPerformed(evt);
            }
        });

        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);

        jButton13.setBackground(new java.awt.Color(31, 37, 61));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/logout.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        cardWindow.setBackground(new java.awt.Color(102, 102, 102));
        cardWindow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cardWindow.setLayout(new java.awt.CardLayout());
        cardWindow.add(inventoryUI1, "inventoryCard");
        cardWindow.add(deliveryUI1, "deliveryCard");
        cardWindow.add(reports1, "reportsCard");
        cardWindow.add(secondhandTradeIn1, "tradeInCard");
        cardWindow.add(warranty1, "warrantyCard");
        cardWindow.add(transferUI1, "transferCard");
        cardWindow.add(returns1, "returnsCard");
        cardWindow.add(newCustomerUI1, "customerCard");
        cardWindow.add(adminUI1, "adminCard");

        adminMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/adminkey.png"))); // NOI18N
        adminMenuButton.setBorderPainted(false);
        adminMenuButton.setContentAreaFilled(false);
        adminMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminMenuButtonMouseClicked(evt);
            }
        });
        adminMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMenuButtonActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/settings-grey.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        userView.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        userView.setForeground(new java.awt.Color(51, 51, 51));
        userView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userView.setText("123");
        userView.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cardWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(800, 800, 800)
                        .addComponent(userView, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(userView)
                                .addGap(1, 1, 1))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(adminMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cardWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        card = (CardLayout)cardWindow.getLayout();

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphics/bg.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reportsMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(warrantyMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deliveryMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(transferMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tradeInMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(returnsMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(reportsMenuButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(warrantyMenuButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(deliveryMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(transferMenuButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(tradeInMenuButton))
                    .addComponent(salesMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returnsMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1286, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void returnsMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnsMenuButtonActionPerformed
         card.show(cardWindow, "returnsCard");
    }//GEN-LAST:event_returnsMenuButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        card.show(cardWindow, "customerCard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        editPasswordDialog.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void oldUserPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldUserPasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldUserPasswordInputActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        userController.changeUserPassword();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        editPasswordDialog.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void adminMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminMenuButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_adminMenuButtonMouseClicked
        static String host = "jdbc:mysql://localhost:3306/inventory";
        static String uName = "root";
        static String uPass = "";
        static ArrayList<Product> productList = new ArrayList<Product>();
        static ArrayList<SecondHandProduct> secondHandList = new ArrayList<SecondHandProduct>();                                    

    
    public static void setUser(String name){
        userView.setText(name);
    }
    
    public static void setUserName (String username){
        userLabel.setText(username);
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
    private javax.swing.JButton deliveryMenuButton;
    private VIEW.DeliveryUI deliveryUI1;
    private javax.swing.JDialog editPasswordDialog;
    private VIEW.InventoryUI inventoryUI1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private VIEW.NewCustomerUI newCustomerUI1;
    private javax.swing.JPasswordField newUserConfirmPasswordInput;
    private javax.swing.JPasswordField newUserPasswordInput;
    private javax.swing.JPasswordField oldUserPasswordInput;
    private VIEW.Reports reports1;
    private javax.swing.JButton reportsMenuButton;
    private VIEW.Returns returns1;
    private javax.swing.JButton returnsMenuButton;
    private javax.swing.JButton salesMenuButton;
    private VIEW.SecondhandTradeIn secondhandTradeIn1;
    private javax.swing.JButton tradeInMenuButton;
    private javax.swing.JButton transferMenuButton;
    private VIEW.TransferUI transferUI1;
    private static javax.swing.JLabel userLabel;
    private static javax.swing.JLabel userView;
    private VIEW.Warranty warranty1;
    private javax.swing.JButton warrantyMenuButton;
    // End of variables declaration//GEN-END:variables
}
