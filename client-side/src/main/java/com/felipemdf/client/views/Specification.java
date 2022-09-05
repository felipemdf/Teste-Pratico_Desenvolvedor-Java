package com.felipemdf.client.views;


import com.felipemdf.client.controllers.SpecificationController;
import com.felipemdf.client.dtos.SpecificationDto;
import com.felipemdf.client.utils.Dialogs;
import com.felipemdf.client.utils.Utils;
import java.awt.Font;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JLabel;


import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Specification extends DefaultFormAndTable{
    
    SpecificationController specificationController;
    
    JLabel specificationFormLabelName;
    JTextField specificationFormFieldName;
    
    JLabel specificationFormLabelId;
    JTextField specificationFormFieldId;
    
    JLabel specificationFormLabelDescription;
    JTextField specificationFormFieldDescription;
    
    JLabel specificationFilterLabelId;
    JTextField specificationFilterFieldId;

    JLabel specificationFilterLabelName;
    JTextField specificationFilterFieldName;
    
    public Specification (SpecificationController specificationController) {
         setTitle("Rental Cats - Specification");
         this.specificationController = specificationController;
         
         updateTable();
    }
    
    @Override
    public void initializeComponents () {
        
        specificationFormLabelId = new JLabel("Id");
        specificationFormLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        specificationFormLabelId.setBounds(defaultTitleRegister.getX(), defaultTitleRegister.getY() + 40, 50, 35);
        
        specificationFormFieldId = new JTextField("");
        specificationFormFieldId.setBounds(specificationFormLabelId.getX() - 1, specificationFormLabelId.getY() + 40, 100, 35);
        specificationFormFieldId.setEnabled(false);
        
        defaultPaneForm.add(specificationFormLabelId);
        defaultPaneForm.add(specificationFormFieldId);
        
        
        
        specificationFormLabelName = new JLabel("Name");
        specificationFormLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        specificationFormLabelName.setBounds(specificationFormFieldId.getX() + specificationFormFieldId.getWidth() + 30, specificationFormLabelId.getY(), 150, 35);  
        
        specificationFormFieldName = new JTextField("");
        specificationFormFieldName.setBounds(specificationFormLabelName.getX() - 1, specificationFormLabelName.getY() + 40, 400, 35);
        
        defaultPaneForm.add(specificationFormLabelName);
        defaultPaneForm.add(specificationFormFieldName);
        
        
        specificationFormLabelDescription = new JLabel("Description");
        specificationFormLabelDescription.setFont(new Font("Segoe UI", Font.BOLD, 14));
        specificationFormLabelDescription.setBounds(specificationFormFieldId.getX(), specificationFormFieldId.getY() + 40, 100, 35);
        
        specificationFormFieldDescription = new JTextField("");
        specificationFormFieldDescription.setBounds(specificationFormLabelDescription.getX() - 1, specificationFormLabelDescription.getY() + 40, 1100, 35);
        
        defaultPaneForm.add(specificationFormLabelDescription);
        defaultPaneForm.add(specificationFormFieldDescription);
        
        
        specificationFilterLabelId = new JLabel("Id");
        specificationFilterLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        specificationFilterLabelId.setBounds(defaultTitleFilter.getX(), defaultTitleFilter.getY() + 40, 50, 35);
        
        specificationFilterFieldId = new JTextField("");
        specificationFilterFieldId.setBounds(specificationFilterLabelId.getX() - 2, specificationFilterLabelId.getY() + 40, 100, 35);
        
        defaultPaneFilter.add(specificationFilterLabelId);
        defaultPaneFilter.add(specificationFilterFieldId);
        
        
        specificationFilterLabelName = new JLabel("Name");
        specificationFilterLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        specificationFilterLabelName.setBounds(specificationFilterFieldId.getX()  + specificationFilterFieldId.getWidth() + 30, specificationFilterLabelId.getY(), 100, 35);
        
        specificationFilterFieldName = new JTextField("");
        specificationFilterFieldName.setBounds(specificationFilterLabelName.getX(), specificationFilterFieldId.getY(), 400, 35);
        
        defaultPaneFilter.add(specificationFilterLabelName);
        defaultPaneFilter.add(specificationFilterFieldName);
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        specificationFormFieldName.setEnabled(isEditing);
        specificationFormFieldDescription.setEnabled(isEditing);

    }
    
    @Override
    public void cleanForm() {
       specificationFormFieldName.setText("");  
       specificationFormFieldId.setText("");
       specificationFormFieldDescription.setText("");
    }

    @Override
    public void cleanFilter() {
       specificationFilterFieldId.setText("");  
       specificationFilterFieldName.setText("");
    }
    @Override
    protected void formSave() {
        Integer id = Utils.isEmpty(specificationFormFieldId.getText()) ? null: Integer.valueOf(specificationFormFieldId.getText());
        String name = specificationFormFieldName.getText();
        String description = specificationFormFieldDescription.getText();
        
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
        
        SpecificationDto specificationDto = new SpecificationDto(id, name, description);
        this.specificationController.save(specificationDto);
        
        cleanForm();
        
        updateTable();
        
    }

    @Override
    protected void formRemove() {
        Integer id = Utils.toInteger(specificationFormFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.DialogError("Specification not selected!");
           return;
            
        }
        this.specificationController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {100, 245, 735}, SpecificationDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        Integer id = Utils.toInteger(specificationFilterFieldId.getText());
        String name = specificationFilterFieldName.getText();
        specificationFilterFieldName.setText("");
        specificationFilterFieldId.setText("");
        
        ArrayList<SpecificationDto> specification = specificationController.get(new SpecificationDto(id, name));
        updateTable(specification);
    }

    @Override
    protected void updateTable() {
         ArrayList<SpecificationDto> specifications =  specificationController.getAll();
         updateTable(specifications);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, specificationController.toObjectArray((ArrayList<SpecificationDto>) list));
    }

    @Override
    protected void updateForm() {
        specificationFormFieldId.setText(Utils.getTableColumnValue(table, 0));
        specificationFormFieldName.setText(Utils.getTableColumnValue(table, 1));
        specificationFormFieldDescription.setText(Utils.getTableColumnValue(table, 2));
    }

    @Override
    protected void formConfigListener() {
        specificationFormFieldName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      specificationFormFieldDescription.requestFocus();
                 }
            }
        });
        
        specificationFormFieldDescription.addKeyListener(new KeyAdapter() {
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
        specificationFilterFieldId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      specificationFilterFieldName.requestFocus();
                 }
            }
        });
        
       specificationFilterFieldName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_ENTER){
                      search();
                 }
            }
        });
    }
}
