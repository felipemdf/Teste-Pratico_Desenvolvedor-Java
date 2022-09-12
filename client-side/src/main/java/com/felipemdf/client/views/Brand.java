package com.felipemdf.client.views;

import com.felipemdf.client.services.BrandService;

import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.felipemdf.client.views.components.Dialogs;
import com.felipemdf.client.utils.Utils;
import java.awt.Font;


import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;


import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fmari_v4rpu9g
 */
public class Brand extends DefaultFormAndTable{
    
    BrandService brandService;
    // FORM ------------------------------------------
    JLabel formLabelName;
    JTextField formFieldName;
    
    JLabel formLabelId;
    JTextField formFieldId;
    // ---------------------------------------------------------------
    
    // FILTER -------------------------------------------------------
    JLabel filterLabelId;
    JTextField filterFieldId;

    JLabel filterLabelName;
    JTextField filterFieldName;
    
    JLabel filterLabelDriverLicense;
    JTextField filterFieldDriverLicense;
    // ---------------------------------------------------------------
    
    public Brand (BrandService brandService) {
         setTitle("Rental Cars - Brand");
         this.brandService = brandService;
         
         updateTable();
    }
    
    @Override
    public void initializeComponents () {
        // ID ------------------------------------------------------------------------------------------------------
        formLabelId = new JLabel("Id");
        formLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelId.setBounds(defaultTitleRegister.getX(), defaultTitleRegister.getY() + 40, 50, 35);
        
        formFieldId = new JTextField("");
        formFieldId.setBounds(formLabelId.getX() - 1, formLabelId.getY() + 40, 100, 35);
        formFieldId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        formFieldId.setEnabled(false);
        
        defaultPaneForm.add(formLabelId);
        defaultPaneForm.add(formFieldId);
        //------------------------------------------------------------------------------------------------------
 
        // NAME ------------------------------------------------------------------------------------------------
        formLabelName = new JLabel("Name");
        formLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelName.setBounds(formFieldId.getX() + formFieldId.getWidth() + 30, formLabelId.getY(), 150, 35);  
        
        
        formFieldName = new JTextField("");
        formFieldName.setBounds(formLabelName.getX() - 1, formFieldId.getY(), 470, 35);
        formFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelName);
        defaultPaneForm.add(formFieldName);
       
        // FILTER ID --------------------------------------------------------------------------------------------
        filterLabelId = new JLabel("Id");
        filterLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filterLabelId.setBounds(defaultTitleFilter.getX(), defaultTitleFilter.getY() + 40, 50, 35);
        
        filterFieldId = new JTextField("");
        filterFieldId.setBounds(filterLabelId.getX() - 2, filterLabelId.getY() + 40, 100, 35);
        
        defaultPaneFilter.add(filterLabelId);
        defaultPaneFilter.add(filterFieldId);
        
        // ------------------------------------------------------------------------------------------------------
        
         // FILTER NAME --------------------------------------------------------------------------------------------
        filterLabelName = new JLabel("Name");
        filterLabelName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filterLabelName.setBounds(filterFieldId.getX()  + filterFieldId.getWidth() + 30, filterLabelId.getY(), 150, 35);
        
        filterFieldName = new JTextField("");
        filterFieldName.setBounds(filterLabelName.getX(), filterFieldId.getY(), 400, 35);
        
        defaultPaneFilter.add(filterLabelName);
        defaultPaneFilter.add(filterFieldName);
        
        // ------------------------------------------------------------------------------------------------------
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        formFieldName.setEnabled(isEditing);
    }
    
    @Override
    public void cleanForm() {
       formFieldId.setText("");
       formFieldName.setText("");  
    }
    
    @Override
    public void cleanFilter() {
       filterFieldId.setText("");  
       filterFieldName.setText("");
    }

       @Override
    protected void formSave() {
        
        if(!validateForm()) {
           Dialogs.dialogMessage(true, "Please fill out all required fields!");
           cleanForm();
           return;
        }
        
        Long id = Utils.toLong(formFieldId.getText());
        String name = formFieldName.getText();
      


        BrandDto brandDto = new BrandDto(name);
        ResponseDto response;
        
        if(id == null)
            response = this.brandService.save(brandDto);
        else
            response = this.brandService.update(id, brandDto);
        
        Dialogs.dialogMessage(response);
        cleanForm();
        
        updateTable();
        
    }
    
    private boolean validateForm() {
        String name = formFieldName.getText();
        
        
        if(Utils.isEmpty(name)) 
            return false;
     
        return true;
            
    }
        

    @Override
    protected void formRemove() {
        Long id = Utils.toLong(formFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.dialogMessage(true, "Brand not selected!");
            return;
            
        }
        ResponseDto response = this.brandService.remove(id);
        Dialogs.dialogMessage(response);
        
        cleanForm();
        cleanFilter();
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {100, 980}, BrandDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() { 
        HashMap<String, String> filters = new HashMap();
        filters.put("id", filterFieldId.getText());
        filters.put("name", filterFieldName.getText());

        cleanFilter();
        ArrayList<BrandDto> brands = brandService.get(filters);
        updateTable(brands);
    }

    @Override
    protected void updateTable() {
         ArrayList<BrandDto> brands =  brandService.getAll();
         updateTable(brands);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, brandService.toObjectArray((ArrayList<BrandDto>) list));
    }

    @Override
    protected void updateForm() {
        formFieldId.setText(Utils.getTableColumnValue(table, 0));
        formFieldName.setText(Utils.getTableColumnValue(table, 1));        
    }

 

    
}
