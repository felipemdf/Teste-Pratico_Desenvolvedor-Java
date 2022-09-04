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

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fmari_v4rpu9g
 */
public class Category extends DefaultFormAndTable{
    
    CategoryController categoryController;
    
    JLabel categoryFormLabelCategory;
    JTextField categoryFormFieldCategory;
    
    JLabel categoryFormLabelId;
    JTextField categoryFormFieldId;
    
    JLabel categoryFilterLabelCategory;
    JTextField categoryFilterFieldCategory;
    
    public Category (CategoryController categoryController) {
         setTitle("Rental Cats - Category");
         this.categoryController = categoryController;
         
         updateTable();
    }
    
    @Override
    public void initializeComponents () {
        
        categoryFormLabelId = new JLabel("Id");
        categoryFormLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFormLabelId.setBounds(defaultTitleRegister.getX(), defaultTitleRegister.getY() + 40, 50, 50);
        
        categoryFormFieldId = new JTextField("");
        categoryFormFieldId.setBounds(categoryFormLabelId.getX() - 2, categoryFormLabelId.getY() + 40, 100, 40);
        categoryFormFieldId.setEnabled(false);
        
        defaultPaneForm.add(categoryFormLabelId);
        defaultPaneForm.add(categoryFormFieldId);
        
        
        
        categoryFormLabelCategory = new JLabel("Category");
        categoryFormLabelCategory.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFormLabelCategory.setBounds(categoryFormFieldId.getX() + categoryFormFieldId.getWidth() + 50, defaultTitleRegister.getY() + 40, 150, 50);  
        
        categoryFormFieldCategory = new JTextField("");
        categoryFormFieldCategory.setBounds(categoryFormLabelCategory.getX() - 2, categoryFormLabelCategory.getY() + 40, 500, 40);
        
        defaultPaneForm.add(categoryFormLabelCategory);
        defaultPaneForm.add(categoryFormFieldCategory);
        
        
        categoryFilterLabelCategory = new JLabel("Category");
        categoryFilterLabelCategory.setFont(new Font("Segoe UI", Font.BOLD, 14));
        categoryFilterLabelCategory.setBounds(defaultTitleFilter.getX(), defaultTitleFilter.getY() + 40, 100, 50);
        
        categoryFilterFieldCategory = new JTextField("");
        categoryFilterFieldCategory.setBounds(categoryFilterLabelCategory.getX() - 2, categoryFilterLabelCategory.getY() + 40, 400, 40);
        
        defaultPaneFilter.add(categoryFilterLabelCategory);
        defaultPaneFilter.add(categoryFilterFieldCategory);
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        categoryFormFieldCategory.setEnabled(isEditing);

    }
    
    @Override
    public void cleanForm() {
       categoryFormFieldCategory.setText("");  
       categoryFormFieldId.setText("");
    }

       @Override
    protected void formSave() {
        Integer id = Utils.isEmpty(categoryFormFieldId.getText()) ? 0: Integer.valueOf(categoryFormFieldId.getText());
        String category = categoryFormFieldCategory.getText();
        if(Utils.isEmpty(category)) {
           Dialogs.DialogError("Category field is empty!");
           return;
        }
        
        CategoryDto categoryDto = new CategoryDto(id,category);
        this.categoryController.save(categoryDto);
        categoryFormFieldCategory.setText("");
        
        updateTable();
        
    }

    @Override
    protected void formRemove() {
        Integer id = Integer.valueOf(categoryFormFieldId.getText());
        this.categoryController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {100, 980}, CategoryDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        String categoryFilter = categoryFilterFieldCategory.getText();
        categoryFilterFieldCategory.setText("");
        
        ArrayList<CategoryDto> categories = categoryController.get(new CategoryDto(categoryFilter));
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
        categoryFormFieldCategory.setText(Utils.getTableColumnValue(table, 1));
    }

    @Override
    protected void formConfigListener() {
        categoryFormFieldCategory.addKeyListener(new KeyAdapter() {
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
       categoryFilterFieldCategory.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      search();
                 }
            }
        });
    }
}
