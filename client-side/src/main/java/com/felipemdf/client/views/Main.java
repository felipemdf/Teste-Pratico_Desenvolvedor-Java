/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.felipemdf.client.views;

import com.felipemdf.client.controllers.BrandController;
import com.felipemdf.client.controllers.CarController;
import com.felipemdf.client.controllers.CategoryController;
import com.felipemdf.client.controllers.CustomerController;
import com.felipemdf.client.controllers.SpecificationController;
import java.awt.TextArea;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author fmari_v4rpu9g
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Category
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

        MainDesktopPane = new javax.swing.JDesktopPane();
        CategoryMenuNavigation = new javax.swing.JMenuBar();
        MainMenuCustomers = new javax.swing.JMenu();
        MainMenuCars = new javax.swing.JMenu();
        MainItemCategories = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MainItemSpecifications = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MainItemBrands = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        MainItemCars = new javax.swing.JMenuItem();
        MainMenuRentals = new javax.swing.JMenu();
        MainItemSchedules = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        MainItemRentals = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rental Cars");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(null);
        setName("PrincipalFrame"); // NOI18N
        setResizable(false);

        MainDesktopPane.setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout MainDesktopPaneLayout = new javax.swing.GroupLayout(MainDesktopPane);
        MainDesktopPane.setLayout(MainDesktopPaneLayout);
        MainDesktopPaneLayout.setHorizontalGroup(
            MainDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        MainDesktopPaneLayout.setVerticalGroup(
            MainDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        MainMenuCustomers.setText("Customers");
        MainMenuCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuCustomersMouseClicked(evt);
            }
        });
        MainMenuCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuCustomersActionPerformed(evt);
            }
        });
        CategoryMenuNavigation.add(MainMenuCustomers);

        MainMenuCars.setText("Cars");
        MainMenuCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuCarsActionPerformed(evt);
            }
        });

        MainItemCategories.setText("Categories");
        MainItemCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainItemCategoriesActionPerformed(evt);
            }
        });
        MainMenuCars.add(MainItemCategories);
        MainMenuCars.add(jSeparator2);

        MainItemSpecifications.setText("Specifications");
        MainItemSpecifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainItemSpecificationsActionPerformed(evt);
            }
        });
        MainMenuCars.add(MainItemSpecifications);
        MainMenuCars.add(jSeparator4);

        MainItemBrands.setText("Brands");
        MainItemBrands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainItemBrandsActionPerformed(evt);
            }
        });
        MainMenuCars.add(MainItemBrands);
        MainMenuCars.add(jSeparator5);

        MainItemCars.setText("Cars");
        MainItemCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainItemCarsActionPerformed(evt);
            }
        });
        MainMenuCars.add(MainItemCars);

        CategoryMenuNavigation.add(MainMenuCars);

        MainMenuRentals.setText("Rentals");

        MainItemSchedules.setText("Schedules");
        MainMenuRentals.add(MainItemSchedules);
        MainMenuRentals.add(jSeparator3);

        MainItemRentals.setText("Rentals");
        MainMenuRentals.add(MainItemRentals);

        CategoryMenuNavigation.add(MainMenuRentals);

        setJMenuBar(CategoryMenuNavigation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1214, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainItemCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainItemCategoriesActionPerformed
        Category categoryScreen = new Category(new CategoryController());
        MainDesktopPane.add(categoryScreen);
        
        categoryScreen.setSize(MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        categoryScreen.setVisible(true);

    }//GEN-LAST:event_MainItemCategoriesActionPerformed

    private void MainItemCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainItemCarsActionPerformed
        Car car = new Car(new CarController());
        MainDesktopPane.add(car);
        
        car.setSize(MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        car.setVisible(true);
    }//GEN-LAST:event_MainItemCarsActionPerformed

    private void MainMenuCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuCustomersActionPerformed

    }//GEN-LAST:event_MainMenuCustomersActionPerformed

    private void MainMenuCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuCustomersMouseClicked
        Customer customer = new Customer(new CustomerController());
        MainDesktopPane.add(customer);
        
        customer.setSize(MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        customer.setVisible(true);
    }//GEN-LAST:event_MainMenuCustomersMouseClicked

    private void MainItemSpecificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainItemSpecificationsActionPerformed
        Specification specification = new Specification(new SpecificationController());
        MainDesktopPane.add(specification);
        
        specification.setSize(MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        specification.setVisible(true);
    }//GEN-LAST:event_MainItemSpecificationsActionPerformed

    private void MainMenuCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuCarsActionPerformed

    }//GEN-LAST:event_MainMenuCarsActionPerformed

    private void MainItemBrandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainItemBrandsActionPerformed
        Brand brand = new Brand(new BrandController());
        MainDesktopPane.add(brand);
        
        brand.setSize(MainDesktopPane.getWidth(), MainDesktopPane.getHeight());
        brand.setVisible(true);
    }//GEN-LAST:event_MainItemBrandsActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar CategoryMenuNavigation;
    private javax.swing.JDesktopPane MainDesktopPane;
    private javax.swing.JMenuItem MainItemBrands;
    private javax.swing.JMenuItem MainItemCars;
    private javax.swing.JMenuItem MainItemCategories;
    private javax.swing.JMenuItem MainItemRentals;
    private javax.swing.JMenuItem MainItemSchedules;
    private javax.swing.JMenuItem MainItemSpecifications;
    private javax.swing.JMenu MainMenuCars;
    private javax.swing.JMenu MainMenuCustomers;
    private javax.swing.JMenu MainMenuRentals;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
