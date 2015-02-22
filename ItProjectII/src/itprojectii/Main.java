/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itprojectii;

import BEANS.Product;
import BEANS.SecondHandProduct;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        cardWindow = new javax.swing.JPanel();
        inventoryPanel = new javax.swing.JPanel();
        productFilterComboBox = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        reports1 = new itprojectii.Reports();
        secondhandTradeIn1 = new itprojectii.SecondhandTradeIn();
        createOrder1 = new itprojectii.CreateOrder();
        delivery1 = new itprojectii.Delivery();
        transfer1 = new itprojectii.Transfer();
        warranty2 = new itprojectii.Warranty();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("main"));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 114, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/delivery-1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 114, 105, 92));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/report.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/report-1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 212, 112, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/tradein-1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 301, 112, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/NEW ICONS/warranty-o.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/NEW ICONS/warranty.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 390, 112, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/transfer-1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 479, 112, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/admin.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/admin-1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 568, 112, -1));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/NEW ICONS/home-o.png"))); // NOI18N
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setPreferredSize(new java.awt.Dimension(100, 83));
        jButton16.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/UI ICONS/NEW ICONS/home.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 105, 92));

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

        cardWindow.setBackground(new java.awt.Color(102, 102, 102));
        cardWindow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cardWindow.setLayout(new java.awt.CardLayout());

        inventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productFilterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accessories", "Batteries", "Oils", "Rims", "Tires" }));
        productFilterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productFilterComboBoxActionPerformed(evt);
            }
        });
        inventoryPanel.add(productFilterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));
        updateCategoryComboBox();

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product_id", "Name", "Description", "Category", "Unit", "Supplier", "Quantity", "Reorder Quantity Level", "SecondHand"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(inventoryTable);
        inventoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        inventoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        inventoryPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1021, 390));

        jButton14.setText("Add To Cart");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        inventoryPanel.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, -1, 56));

        jButton15.setText("Buy");
        inventoryPanel.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 500, 65, 56));

        jLabel3.setText("Category:");
        inventoryPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jButton20.setText("Critical Product");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        inventoryPanel.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        jLabel2.setText("Product Inventory");
        inventoryPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        cardWindow.add(inventoryPanel, "inventoryCard");
        cardWindow.add(reports1, "reportsCard");
        cardWindow.add(secondhandTradeIn1, "secondHandTradeInCard");
        cardWindow.add(createOrder1, "createOrderCard");
        cardWindow.add(delivery1, "deliveryCard");
        cardWindow.add(transfer1, "transferCard");
        cardWindow.add(warranty2, "warrantyCard");

        jPanel4.add(cardWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 60, 1100, 590));
        card = (CardLayout)cardWindow.getLayout();

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, 1134, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );

        updateProductsList();
        updateSecondHandList();
        AddProduct.updateCategoryTable();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed


        card.show(cardWindow, "inventoryCard");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        card.show(cardWindow, "adminCard");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        card.show(cardWindow, "transferCard");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        card.show(cardWindow, "warrantyCard");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        card.show(cardWindow, "secondHandTradeInCard");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        card.show(cardWindow, "reportsCard");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        card.show(cardWindow, "deliveryCard");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void productFilterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productFilterComboBoxActionPerformed
        System.out.print("ComboBox");
        
        if(productFilterComboBox.getSelectedItem()!=null){
            String category = productFilterComboBox.getSelectedItem().toString();
            System.out.print(category);
            if(category.equals("All")){
                updateInventoryTable();
            }else{
                updateInventoryTable(category);
            }
        }
    }//GEN-LAST:event_productFilterComboBoxActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed
        static String host = "jdbc:mysql://localhost:3306/inventory";
        static String uName = "root";
        static String uPass = "";
        static ArrayList<Product> productList = new ArrayList<Product>();
        static ArrayList<SecondHandProduct> secondHandList = new ArrayList<SecondHandProduct>();                                    

        public static void deleteAllRows() {
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        for(int row =0; row < model.getRowCount(); ) {
            model.removeRow(0);
        }
    }
    static private void updateInventoryTable(){
        deleteAllRows();
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();

        for(Product product: Main.productList){
            model.addRow(new Object[]{product.getProductID(), product.getName(),
                product.getDescription(), product.getTypeName(), product.getUnit(),
                product.getSupplierName(), product.getPhysicalCount(), 
                product.getReorderQuantityLevel()});
        }
        
    }
    static private void updateInventoryTable(String category){
        deleteAllRows();
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        
        for(Product product: Main.productList){
            if(category.equals(product.getTypeName())){
                model.addRow(new Object[]{product.getProductID(), product.getName(),
                    product.getDescription(), product.getTypeName(), product.getUnit(),
                    product.getSupplierName(), product.getPhysicalCount(), 
                    product.getReorderQuantityLevel()});
            }
        }
    }
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
        Delivery.updateProductsListDeliveryTable();
        Transfer.updateTransferTable();
        AddProduct.updateAdminProductsTable();
        Warranty.updateProductsListWarrantyTable();
        updateInventoryTable();
        
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
    public static void updateCategoryComboBox(){
            productFilterComboBox.removeAllItems();
            PreparedStatement selectStatement = null;
            try{
            Connection con = DriverManager.getConnection(host,uName, uPass);
            String selectString = "SELECT type_name FROM type ORDER By 1 ASC";
            selectStatement = con.prepareStatement(selectString);
            ResultSet rs = selectStatement.executeQuery();
            productFilterComboBox.addItem("All");
                while(rs.next()){
                    String categoryName = rs.getString(1);

                    productFilterComboBox.addItem(categoryName);
                }

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
    private javax.swing.JPanel cardWindow;
    private itprojectii.CreateOrder createOrder1;
    private itprojectii.Delivery delivery1;
    private static javax.swing.JPanel inventoryPanel;
    private static javax.swing.JTable inventoryTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JComboBox productFilterComboBox;
    private itprojectii.Reports reports1;
    private itprojectii.SecondhandTradeIn secondhandTradeIn1;
    private itprojectii.Transfer transfer1;
    private itprojectii.Warranty warranty2;
    // End of variables declaration//GEN-END:variables
}
