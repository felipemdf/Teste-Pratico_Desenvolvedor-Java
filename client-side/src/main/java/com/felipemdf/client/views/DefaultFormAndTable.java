/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.felipemdf.client.views;

import com.felipemdf.client.utils.Table;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fmari_v4rpu9g
 */
public abstract class DefaultFormAndTable extends javax.swing.JInternalFrame {

    protected abstract void initializeComponents ();
    protected abstract void alterFormComponentsStatesWhenEditing (boolean isEditing);
    protected abstract void formSave();
    protected abstract void formRemove();
    protected abstract void cleanForm();
    protected abstract void updateForm();
    
    protected abstract void search();
    protected abstract void createTable();
    protected abstract void updateTable(ArrayList<?> list);
    protected abstract void updateTable();
    
    protected abstract void formConfigListener();
    protected abstract void filterConfigListener();
    
    protected JTable table;
    protected DefaultTableModel tableModel;
    protected Table tableManager = new Table(); //1090 width
   
    public DefaultFormAndTable() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        
        alterButtonsStatesWhenEditing(false);
        initializeComponents();
        alterFormComponentsStatesWhenEditing(false);
        createTable();
        tableConfigListener();
        formConfigListener();
        filterConfigListener();
    }
    
    protected void alterButtonsStatesWhenEditing(boolean isEditing) {
       alterButtonsStatesWhenEditing(isEditing, false);
        
    }
    
    protected void alterButtonsStatesWhenEditing(boolean isEditing, boolean hasTableItemSelected) {
        defaultButtonNew1.setEnabled(!isEditing);
        defaultButtonEdit.setEnabled(!isEditing && hasTableItemSelected);
        defaultButtonRemove.setEnabled(!isEditing);
        
        defaultButtonSave.setEnabled(isEditing);
        dategoryButtonCancel.setEnabled(isEditing);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultPaneButtons = new javax.swing.JPanel();
        dategoryButtonCancel = new javax.swing.JButton();
        defaultButtonEdit = new javax.swing.JButton();
        defaultButtonRemove = new javax.swing.JButton();
        defaultButtonSave = new javax.swing.JButton();
        defaultButtonClose = new javax.swing.JButton();
        defaultButtonNew1 = new javax.swing.JButton();
        defaultPaneForm = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        defaultTitleRegister = new javax.swing.JLabel();
        defaultPaneFilter = new javax.swing.JPanel();
        defaultTitleFilter = new javax.swing.JLabel();
        defaultButtonSearch = new javax.swing.JButton();
        defaultPaneTable = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(102, 102, 102));
        setMaximumSize(null);
        setName(""); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        defaultPaneButtons.setMaximumSize(getSize());

        dategoryButtonCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dategoryButtonCancel.setForeground(new java.awt.Color(51, 51, 51));
        dategoryButtonCancel.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\cancel.png")); // NOI18N
        dategoryButtonCancel.setText(" Cancel");
        dategoryButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dategoryButtonCancelActionPerformed(evt);
            }
        });

        defaultButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonEdit.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonEdit.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\edit.png")); // NOI18N
        defaultButtonEdit.setText(" Edit");
        defaultButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonEditActionPerformed(evt);
            }
        });

        defaultButtonRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonRemove.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonRemove.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\remove.png")); // NOI18N
        defaultButtonRemove.setText(" Remove");
        defaultButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonRemoveActionPerformed(evt);
            }
        });

        defaultButtonSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonSave.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonSave.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\save.png")); // NOI18N
        defaultButtonSave.setText("  Save");
        defaultButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonSaveActionPerformed(evt);
            }
        });

        defaultButtonClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonClose.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonClose.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\close.png")); // NOI18N
        defaultButtonClose.setText(" Close");
        defaultButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonCloseActionPerformed(evt);
            }
        });

        defaultButtonNew1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonNew1.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonNew1.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\add.png")); // NOI18N
        defaultButtonNew1.setText(" New");
        defaultButtonNew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonNew1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout defaultPaneButtonsLayout = new javax.swing.GroupLayout(defaultPaneButtons);
        defaultPaneButtons.setLayout(defaultPaneButtonsLayout);
        defaultPaneButtonsLayout.setHorizontalGroup(
            defaultPaneButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneButtonsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(defaultButtonNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(defaultButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(88, 88, 88)
                .addComponent(defaultButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(defaultButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78)
                .addComponent(dategoryButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addComponent(defaultButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        defaultPaneButtonsLayout.setVerticalGroup(
            defaultPaneButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneButtonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(defaultPaneButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defaultButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defaultButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dategoryButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defaultButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defaultButtonNew1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        defaultPaneForm.setMaximumSize(null);
        defaultPaneForm.setPreferredSize(new java.awt.Dimension(1200, 152));

        defaultTitleRegister.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        defaultTitleRegister.setText("Register");

        javax.swing.GroupLayout defaultPaneFormLayout = new javax.swing.GroupLayout(defaultPaneForm);
        defaultPaneForm.setLayout(defaultPaneFormLayout);
        defaultPaneFormLayout.setHorizontalGroup(
            defaultPaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneFormLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(defaultPaneFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultTitleRegister)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        defaultPaneFormLayout.setVerticalGroup(
            defaultPaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneFormLayout.createSequentialGroup()
                .addComponent(defaultTitleRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        defaultTitleFilter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        defaultTitleFilter.setText("Filter");

        defaultButtonSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        defaultButtonSearch.setForeground(new java.awt.Color(51, 51, 51));
        defaultButtonSearch.setIcon(new javax.swing.ImageIcon("D:\\repositorio github\\Teste-Pratico_Desenvolvedor-Java\\client-side\\assets\\search.png")); // NOI18N
        defaultButtonSearch.setText("Search");
        defaultButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout defaultPaneFilterLayout = new javax.swing.GroupLayout(defaultPaneFilter);
        defaultPaneFilter.setLayout(defaultPaneFilterLayout);
        defaultPaneFilterLayout.setHorizontalGroup(
            defaultPaneFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defaultPaneFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(defaultPaneFilterLayout.createSequentialGroup()
                        .addComponent(defaultTitleFilter)
                        .addGap(1029, 1029, 1029))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defaultPaneFilterLayout.createSequentialGroup()
                        .addComponent(defaultButtonSearch)
                        .addGap(15, 15, 15))))
        );
        defaultPaneFilterLayout.setVerticalGroup(
            defaultPaneFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPaneFilterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultTitleFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(defaultButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        defaultPaneTable.setMaximumSize(getSize());

        javax.swing.GroupLayout defaultPaneTableLayout = new javax.swing.GroupLayout(defaultPaneTable);
        defaultPaneTable.setLayout(defaultPaneTableLayout);
        defaultPaneTableLayout.setHorizontalGroup(
            defaultPaneTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
        );
        defaultPaneTableLayout.setVerticalGroup(
            defaultPaneTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(defaultPaneButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(defaultPaneFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(defaultPaneForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE))
                        .addComponent(defaultPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(defaultPaneButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultPaneForm, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultPaneFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(defaultPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        defaultPaneForm.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void tableConfigListener() {
        table.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 if(e.getClickCount() == 2) {
                    updateForm();
                    alterButtonsStatesWhenEditing(false, true);
                 }
             } 
        });    
    }
    
    private void dategoryButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dategoryButtonCancelActionPerformed
        alterButtonsStatesWhenEditing(false);
        alterFormComponentsStatesWhenEditing(false);
        cleanForm();
    }//GEN-LAST:event_dategoryButtonCancelActionPerformed

    private void defaultButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonEditActionPerformed
        alterButtonsStatesWhenEditing(true);
        alterFormComponentsStatesWhenEditing(true);

    }//GEN-LAST:event_defaultButtonEditActionPerformed

    private void defaultButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonRemoveActionPerformed
        formRemove();
    }//GEN-LAST:event_defaultButtonRemoveActionPerformed

    private void defaultButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonSaveActionPerformed
        alterButtonsStatesWhenEditing(false);
        alterFormComponentsStatesWhenEditing(false);
        
        formSave();
    }//GEN-LAST:event_defaultButtonSaveActionPerformed

    private void defaultButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonCloseActionPerformed
        alterFormComponentsStatesWhenEditing(false);
        dispose();
    }//GEN-LAST:event_defaultButtonCloseActionPerformed

    private void defaultButtonNew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonNew1ActionPerformed
        alterButtonsStatesWhenEditing(true);
        alterFormComponentsStatesWhenEditing(true);
        cleanForm();
    }//GEN-LAST:event_defaultButtonNew1ActionPerformed

    private void defaultButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultButtonSearchActionPerformed
        search();
    }//GEN-LAST:event_defaultButtonSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dategoryButtonCancel;
    private javax.swing.JButton defaultButtonClose;
    private javax.swing.JButton defaultButtonEdit;
    private javax.swing.JButton defaultButtonNew1;
    private javax.swing.JButton defaultButtonRemove;
    private javax.swing.JButton defaultButtonSave;
    public javax.swing.JButton defaultButtonSearch;
    private javax.swing.JPanel defaultPaneButtons;
    public javax.swing.JPanel defaultPaneFilter;
    public javax.swing.JPanel defaultPaneForm;
    public javax.swing.JPanel defaultPaneTable;
    public javax.swing.JLabel defaultTitleFilter;
    public javax.swing.JLabel defaultTitleRegister;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}