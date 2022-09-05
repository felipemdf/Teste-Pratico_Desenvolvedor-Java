package com.felipemdf.client.views;

import com.felipemdf.client.controllers.CategoryController;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.utils.Dialogs;
import com.felipemdf.client.utils.Utils;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fmari_v4rpu9g
 */
public class Category extends DefaultFormAndTable{
    
    CategoryController categoryController;
    
    JLabel categoryFormLabelName;
    JTextField categoryFormFieldName;
    
    JLabel categoryFormLabelId;
    JTextField categoryFormFieldId;
    
    JLabel categoryFormLabelDescription;
    JTextField categoryFormFieldDescription;
    
    JLabel categoryFilterLabelId;
    JTextField categoryFilterFieldId;

    JLabel categoryFilterLabelName;
    JTextField categoryFilterFieldName;
    
    public Category (CategoryController categoryController) {
         setTitle("Rental Cats - Category");
         this.categoryController = categoryController;
         
         updateTable();
    }
    
    @Override
    public void initializeComponents () {
        
        categoryFormLabelId = new JLabel("Id");
        categoryFormLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFormLabelId.setBounds(defaultTitleRegister.getX(), defaultTitleRegister.getY() + 40, 50, 35);
        
        categoryFormFieldId = new JTextField("");
        categoryFormFieldId.setBounds(categoryFormLabelId.getX() - 1, categoryFormLabelId.getY() + 40, 100, 35);
        categoryFormFieldId.setEnabled(false);
        
        defaultPaneForm.add(categoryFormLabelId);
        defaultPaneForm.add(categoryFormFieldId);
        
        
        
        categoryFormLabelName = new JLabel("Name");
        categoryFormLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFormLabelName.setBounds(categoryFormFieldId.getX() + categoryFormFieldId.getWidth() + 30, categoryFormLabelId.getY(), 150, 35);  
        
        categoryFormFieldName = new JTextField("");
        categoryFormFieldName.setBounds(categoryFormLabelName.getX() - 1, categoryFormLabelName.getY() + 40, 400, 35);
        
        defaultPaneForm.add(categoryFormLabelName);
        defaultPaneForm.add(categoryFormFieldName);
        
        
        categoryFormLabelDescription = new JLabel("Description");
        categoryFormLabelDescription.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFormLabelDescription.setBounds(categoryFormFieldId.getX(), categoryFormFieldId.getY() + 40, 100, 35);
        
        categoryFormFieldDescription = new JTextField("");
        categoryFormFieldDescription.setBounds(categoryFormLabelDescription.getX() - 1, categoryFormLabelDescription.getY() + 40, 1100, 35);
        
        defaultPaneForm.add(categoryFormLabelDescription);
        defaultPaneForm.add(categoryFormFieldDescription);
        
        
        categoryFilterLabelId = new JLabel("Id");
        categoryFilterLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFilterLabelId.setBounds(defaultTitleFilter.getX(), defaultTitleFilter.getY() + 40, 50, 35);
        
        categoryFilterFieldId = new JTextField("");
        categoryFilterFieldId.setBounds(categoryFilterLabelId.getX() - 2, categoryFilterLabelId.getY() + 40, 100, 35);
        
        defaultPaneFilter.add(categoryFilterLabelId);
        defaultPaneFilter.add(categoryFilterFieldId);
        
        
        categoryFilterLabelName = new JLabel("Name");
        categoryFilterLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFilterLabelName.setBounds(categoryFilterFieldId.getX()  + categoryFilterFieldId.getWidth() + 30, categoryFilterLabelId.getY(), 100, 35);
        
        categoryFilterFieldName = new JTextField("");
        categoryFilterFieldName.setBounds(categoryFilterLabelName.getX(), categoryFilterFieldId.getY(), 400, 35);
        
        defaultPaneFilter.add(categoryFilterLabelName);
        defaultPaneFilter.add(categoryFilterFieldName);
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        categoryFormFieldName.setEnabled(isEditing);
        categoryFormFieldDescription.setEnabled(isEditing);

    }
    
    @Override
    public void cleanForm() {
       categoryFormFieldName.setText("");  
       categoryFormFieldId.setText("");
       categoryFormFieldDescription.setText("");
    }
    
    @Override
    public void cleanFilter() {
       categoryFilterFieldId.setText("");  
       categoryFilterFieldName.setText("");
    }

       @Override
    protected void formSave() {
        Integer id = Utils.isEmpty(categoryFormFieldId.getText()) ? null: Integer.valueOf(categoryFormFieldId.getText());
        String name = categoryFormFieldName.getText();
        String description = categoryFormFieldDescription.getText();
        
        if(Utils.isEmpty(name)) {
           Dialogs.DialogError("Name field is empty!");
           cleanForm();
           return;
        }
        
        if(Utils.isEmpty(description)) {
           Dialogs.DialogError("Description field is empty!");
           cleanForm();
           return;
        }
        
        CategoryDto categoryDto = new CategoryDto(id, name, description);
        this.categoryController.save(categoryDto);
        
        cleanForm();
        
        updateTable();
        
    }

    @Override
    protected void formRemove() {
        Integer id = Utils.toInteger(categoryFormFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.DialogError("Category not selected!");
           return;
            
        }
        this.categoryController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {100, 245, 735}, CategoryDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        Integer id = Utils.toInteger(categoryFilterFieldId.getText());
        String name = categoryFilterFieldName.getText();
        
        cleanFilter();
        
        ArrayList<CategoryDto> categories = categoryController.get(new CategoryDto(id, name));
        updateTable(categories);
    }

    @Override
    protected void updateTable() {
         ArrayList<CategoryDto> categories =  categoryController.getAll();
         updateTable(categories);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, categoryController.toObjectArray((ArrayList<CategoryDto>) list));
    }

    @Override
    protected void updateForm() {
        categoryFormFieldId.setText(Utils.getTableColumnValue(table, 0));
        categoryFormFieldName.setText(Utils.getTableColumnValue(table, 1));
        categoryFormFieldDescription.setText(Utils.getTableColumnValue(table, 2));
    }

    @Override
    protected void formConfigListener() { 
        categoryFormFieldName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    categoryFormFieldDescription.requestFocus();
                 }
            }
        });
        
        categoryFormFieldDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      alterButtonsStatesWhenEditing(false);
                        alterFormComponentsStatesWhenEditing(false);
                        formSave();
                 }
            }
        });
    }

    @Override
    protected void filterConfigListener() {
        categoryFilterFieldId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    categoryFilterFieldName.requestFocus();
                 }
            }
        });
        
       categoryFilterFieldName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      search();
                 }
            }
        });
    }
}
