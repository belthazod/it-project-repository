/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import BEANS.ComboItem;
import CONTROLLERS.CategoryController;
import CONTROLLERS.ProductController;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Belthazod
 */
public class ProductsUI extends javax.swing.JPanel {
    static ProductController productController;
    static CategoryController categoryController;
    /**
     * Creates new form AddProduct
     */
    public ProductsUI() {
        initComponents();
        productController = new ProductController(adminProductsTable, InventoryUI.getInventoryTable(), Transfer.getTransferProductsTable(), Delivery.getDeliveryProductsTable(), productsTab );
        categoryController = new CategoryController(categoryTable, addProductCategoryComboBox, editProductCategoryComboBox);
        adminProductsTable.getColumnModel().getColumn(0).setMaxWidth(0);
        adminProductsTable.getColumnModel().getColumn(0).setMinWidth(0);
        adminProductsTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        categoryTable.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editProductDialog = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        productNameEditInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        editProductCategoryComboBox = new javax.swing.JComboBox<ComboItem>();
        jLabel10 = new javax.swing.JLabel();
        descriptionEditInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editProductSupplierComboBox = new javax.swing.JComboBox<ComboItem>();
        jLabel12 = new javax.swing.JLabel();
        unitEditInput = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        quantityEditInput = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        reorderQuantityEditSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        productIDEditInput = new javax.swing.JLabel();
        productIDEditInput.setVisible(false);
        editCategoryDialog = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        categoryEditInput = new javax.swing.JTextField();
        saveEditCategoryButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        categoryIDEditInput = new javax.swing.JLabel();
        productsTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productNameInput = new javax.swing.JTextField();
        productDescriptionInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        quantityInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        unitInput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addProductCategoryComboBox = new javax.swing.JComboBox<ComboItem>();
        jLabel7 = new javax.swing.JLabel();
        AddProductButton = new javax.swing.JButton();
        addProductSupplierComboBox = new javax.swing.JComboBox<ComboItem>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        reorderQuantityLevelSpinner = new javax.swing.JSpinner();
        reorderLevelEnableRadioButton = new javax.swing.JRadioButton();
        reorderLevelDisableRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminProductsTable = new javax.swing.JTable();
        editProductButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        categoryNameInput = new javax.swing.JTextField();
        editCategoryButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        addNewCategoryButton = new javax.swing.JButton();

        editProductDialog.setBounds(new java.awt.Rectangle(0, 0, 600, 500));
        editProductDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        editProductDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Product Name: ");
        editProductDialog.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 20));

        productNameEditInput.setText("jTextField1");
        productNameEditInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameEditInputActionPerformed(evt);
            }
        });
        editProductDialog.getContentPane().add(productNameEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 250, -1));

        jLabel9.setText("Category:");
        editProductDialog.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        editProductCategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        editProductDialog.getContentPane().add(editProductCategoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 250, -1));

        jLabel10.setText("Description:");
        editProductDialog.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        descriptionEditInput.setText("jTextField1");
        editProductDialog.getContentPane().add(descriptionEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 290, -1));

        jLabel11.setText("Supplier:");
        editProductDialog.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        editProductSupplierComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        editProductDialog.getContentPane().add(editProductSupplierComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, -1));

        jLabel12.setText("Unit:");
        editProductDialog.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        unitEditInput.setText("jTextField1");
        editProductDialog.getContentPane().add(unitEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 250, -1));

        jLabel13.setText("Physical Count:");
        editProductDialog.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        quantityEditInput.setText("jLabel14");
        editProductDialog.getContentPane().add(quantityEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel15.setText("Reorder Quantity Level");
        editProductDialog.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));
        editProductDialog.getContentPane().add(reorderQuantityEditSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 90, -1));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        editProductDialog.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, -1));

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        editProductDialog.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        productIDEditInput.setText("jLabel17");
        editProductDialog.getContentPane().add(productIDEditInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        editCategoryDialog.setBounds(new java.awt.Rectangle(0, 0, 500, 300));

        jLabel17.setText("Category Name:");

        saveEditCategoryButton.setText("Save");

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        categoryIDEditInput.setText("jLabel18");
        categoryIDEditInput.setEnabled(false);

        javax.swing.GroupLayout editCategoryDialogLayout = new javax.swing.GroupLayout(editCategoryDialog.getContentPane());
        editCategoryDialog.getContentPane().setLayout(editCategoryDialogLayout);
        editCategoryDialogLayout.setHorizontalGroup(
            editCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCategoryDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editCategoryDialogLayout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveEditCategoryButton))
                    .addGroup(editCategoryDialogLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryEditInput, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editCategoryDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(categoryIDEditInput)
                .addContainerGap())
        );
        editCategoryDialogLayout.setVerticalGroup(
            editCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editCategoryDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryIDEditInput)
                .addGap(28, 28, 28)
                .addGroup(editCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(categoryEditInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(editCategoryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveEditCategoryButton)
                    .addComponent(jButton6))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        setMaximumSize(new java.awt.Dimension(814, 592));
        setPreferredSize(new java.awt.Dimension(814, 592));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Product Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 55, -1, -1));

        jLabel2.setText("Description:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, -1, -1));

        productNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameInputActionPerformed(evt);
            }
        });
        jPanel1.add(productNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 614, -1));

        productDescriptionInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDescriptionInputActionPerformed(evt);
            }
        });
        jPanel1.add(productDescriptionInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 614, -1));

        jLabel3.setText("Quantity:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, -1, -1));
        jPanel1.add(quantityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 161, -1));

        jLabel4.setText("Re- order Level:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel5.setText("Unit:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel1.add(unitInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 161, -1));

        jLabel6.setText("Category:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        addProductCategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accessories" }));
        addProductCategoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductCategoryComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(addProductCategoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 150, -1));

        jLabel7.setText("Supplier:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 198, -1, -1));

        AddProductButton.setText("Add New Product");
        AddProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        addProductSupplierComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addProductSupplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductSupplierComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(addProductSupplierComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 150, -1));
        jPanel1.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        reorderQuantityLevelSpinner.setEnabled(false);
        jPanel1.add(reorderQuantityLevelSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 60, 30));
        reorderQuantityLevelSpinner.setVisible(false);

        reorderLevelEnableRadioButton.setText("Enabled");
        reorderLevelEnableRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderLevelEnableRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(reorderLevelEnableRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));
        reorderQuantityLevelGroup.add(reorderLevelEnableRadioButton);
        reorderLevelDisableRadioButton.setSelected(true);

        reorderLevelDisableRadioButton.setText("Disabled");
        reorderLevelDisableRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderLevelDisableRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(reorderLevelDisableRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        reorderQuantityLevelGroup.add(reorderLevelDisableRadioButton);

        productsTab.addTab("Add Product", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "Product Name", "Description", "Category", "Unit", "Supplier", "Physical Count", "Reorder Quantity Level"
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
        adminProductsTable.setName(""); // NOI18N
        jScrollPane1.setViewportView(adminProductsTable);
        if (adminProductsTable.getColumnModel().getColumnCount() > 0) {
            adminProductsTable.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 795, 410));

        editProductButton.setText("Edit Product");
        editProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProductButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, -1));

        deleteProductButton.setText("Delete Product");
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, -1));

        productsTab.addTab("Edit Product", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "type_id", "Category Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(categoryTable);
        categoryTable.getColumnModel().getColumn(0).setMaxWidth(0);
        categoryTable.getColumnModel().getColumn(0).setMinWidth(0);
        categoryTable.getColumnModel().getColumn(0).setPreferredWidth(0);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 600, 230));

        jLabel14.setText("Category List");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel16.setText("Category Name:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));
        jPanel3.add(categoryNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 500, -1));

        editCategoryButton.setText("Edit Category");
        editCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCategoryButtonActionPerformed(evt);
            }
        });
        jPanel3.add(editCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jButton4.setText("Delete Category");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        addNewCategoryButton.setText("Add to Category List");
        addNewCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCategoryButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addNewCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        productsTab.addTab("Add/Edit Category", jPanel3);

        add(productsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 590));
    }// </editor-fold>//GEN-END:initComponents

    ButtonGroup reorderQuantityLevelGroup = new ButtonGroup();
    private void productNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameInputActionPerformed

    private void addProductSupplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductSupplierComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductSupplierComboBoxActionPerformed

    private void addProductCategoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductCategoryComboBoxActionPerformed
        // TODO add your handling code here:
        System.out.println("Selected value = " +  evt.getActionCommand());
    }//GEN-LAST:event_addProductCategoryComboBoxActionPerformed

    private void AddProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductButtonActionPerformed
        productController.addProduct(productNameInput, productDescriptionInput, quantityInput, unitInput, addProductSupplierComboBox, addProductCategoryComboBox, reorderQuantityLevelSpinner);    
        productController.updateTableContents();

    }//GEN-LAST:event_AddProductButtonActionPerformed

    private void reorderLevelEnableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderLevelEnableRadioButtonActionPerformed
        if(reorderLevelEnableRadioButton.isSelected()){
            reorderQuantityLevelSpinner.setEnabled(true);
            reorderQuantityLevelSpinner.setVisible(true);
        }
    }//GEN-LAST:event_reorderLevelEnableRadioButtonActionPerformed

    private void reorderLevelDisableRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderLevelDisableRadioButtonActionPerformed
        if(reorderLevelDisableRadioButton.isSelected()){
            reorderQuantityLevelSpinner.setEnabled(false);
            reorderQuantityLevelSpinner.setVisible(false);
            reorderQuantityLevelSpinner.setValue(0);
        }
    }//GEN-LAST:event_reorderLevelDisableRadioButtonActionPerformed

    private void editProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProductButtonActionPerformed
        Integer selectedRow = adminProductsTable.getSelectedRow();
        String result = (String) adminProductsTable.getModel().getValueAt(selectedRow, 0);
        productController.openProductEditDialog(result, productIDEditInput, productNameEditInput, descriptionEditInput, editProductCategoryComboBox, editProductSupplierComboBox, unitEditInput, quantityEditInput, reorderQuantityEditSpinner);
        editProductDialog.setVisible(true);
    }//GEN-LAST:event_editProductButtonActionPerformed

    private void productNameEditInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameEditInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameEditInputActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        productController.editProduct(editProductDialog, productIDEditInput, productNameEditInput, descriptionEditInput, quantityEditInput, unitEditInput, editProductSupplierComboBox, editProductCategoryComboBox, reorderQuantityEditSpinner);
        productController.updateTableContents();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addNewCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCategoryButtonActionPerformed
        categoryController.addCategory(categoryNameInput);
        categoryController.updateCategoryTable();
    }//GEN-LAST:event_addNewCategoryButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Integer selectedRow = categoryTable.getSelectedRow();
        String categoryName = (String) categoryTable.getModel().getValueAt(selectedRow, 1);
        int result = JOptionPane.showConfirmDialog(null, "Are you sure in deleting " + categoryName + " from the Category List","Warning!" ,JOptionPane.YES_NO_OPTION);
        
        if(result == 0){
            categoryController.deleteCategory();
            categoryController.updateCategoryTable();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void productDescriptionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDescriptionInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productDescriptionInputActionPerformed

    private void editCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCategoryButtonActionPerformed
        Integer selectedRow = categoryTable.getSelectedRow();
        String result = (String) categoryTable.getModel().getValueAt(selectedRow, 0);
        
        if(categoryController.openEditDialog(result, categoryEditInput, categoryIDEditInput)){
            editCategoryDialog.setVisible(true);
        }
        editCategoryDialog.setVisible(true);
    }//GEN-LAST:event_editCategoryButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        editCategoryDialog.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editProductDialog.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        Integer selectedRow = adminProductsTable.getSelectedRow();
        String name = (String) adminProductsTable.getModel().getValueAt(selectedRow, 1);
        int result = JOptionPane.showConfirmDialog(null, "Are you sure in deleting " + name + " from the Products List","Warning!" ,JOptionPane.YES_NO_OPTION);
        
        if(result == 0){
            productController.deleteSelectedProduct();
            productController.updateTableContents();
        }
    }//GEN-LAST:event_deleteProductButtonActionPerformed
    private static void deleteAllRows(final JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int row =0; row < model.getRowCount(); ) {
            model.removeRow(0);
        
        }
    }
    
    public static void updateAdminProductsTable(){
        productController.updateTableContents();
    }

    public static void updateCategoryTable(){
        categoryController.updateCategoryTable();
    }
    
    public static JComboBox getAddProductSupplierComboBox(){
        return addProductSupplierComboBox;
    }
    
    public static JComboBox getEditProductSupplierComboBox(){
        return editProductSupplierComboBox;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductButton;
    private javax.swing.JButton addNewCategoryButton;
    private static javax.swing.JComboBox<ComboItem> addProductCategoryComboBox;
    private static javax.swing.JComboBox<ComboItem> addProductSupplierComboBox;
    private static javax.swing.JTable adminProductsTable;
    private javax.swing.JTextField categoryEditInput;
    private javax.swing.JLabel categoryIDEditInput;
    private javax.swing.JTextField categoryNameInput;
    private static javax.swing.JTable categoryTable;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JTextField descriptionEditInput;
    private javax.swing.JButton editCategoryButton;
    private javax.swing.JDialog editCategoryDialog;
    private javax.swing.JButton editProductButton;
    private javax.swing.JComboBox<ComboItem> editProductCategoryComboBox;
    private javax.swing.JDialog editProductDialog;
    private static javax.swing.JComboBox<ComboItem> editProductSupplierComboBox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField productDescriptionInput;
    private javax.swing.JLabel productIDEditInput;
    private javax.swing.JTextField productNameEditInput;
    private javax.swing.JTextField productNameInput;
    private javax.swing.JTabbedPane productsTab;
    private javax.swing.JLabel quantityEditInput;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JRadioButton reorderLevelDisableRadioButton;
    private javax.swing.JRadioButton reorderLevelEnableRadioButton;
    private javax.swing.JSpinner reorderQuantityEditSpinner;
    private javax.swing.JSpinner reorderQuantityLevelSpinner;
    private javax.swing.JButton saveEditCategoryButton;
    private javax.swing.JTextField unitEditInput;
    private javax.swing.JTextField unitInput;
    // End of variables declaration//GEN-END:variables
}
