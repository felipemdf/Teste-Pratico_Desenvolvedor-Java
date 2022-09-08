package com.felipemdf.client.views;

import com.felipemdf.client.controllers.BrandController;
import com.felipemdf.client.controllers.CategoryController;
import com.felipemdf.client.controllers.CustomerController;
import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.utils.Dialogs;
import com.felipemdf.client.utils.Utils;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;


import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fmari_v4rpu9g
 */
public class Brand extends DefaultFormAndTable{
    
    BrandController brandController;
    // FORM ------------------------------------------
    JLabel formLabelName;
    JTextField formFieldName;
    
    JLabel formLabelId;
    JTextField formFieldId;
    
    JLabel formLabelDriverLicense;
    JTextField formFieldDriverLicense;
    
    JLabel formLabelBirthDate;
    JDateChooser jcalendar;
    
    JLabel formLabelEmail;
    JTextField formFieldEmail;
    
    JLabel formLabelAddress;
    JTextField formFieldAddress;
    
    JLabel formLabelPhoneNumber;
    JTextField formFieldPhoneNumber;
    // ---------------------------------------------------------------
    
    // FILTER -------------------------------------------------------
    JLabel filterLabelId;
    JTextField filterFieldId;

    JLabel filterLabelName;
    JTextField filterFieldName;
    
    JLabel filterLabelDriverLicense;
    JTextField filterFieldDriverLicense;
    // ---------------------------------------------------------------
    
    public Brand (BrandController brandController) {
         setTitle("Rental Cats - Brand");
         this.brandController = brandController;
         
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
           Dialogs.DialogError("Please fill out all required fields!");
           cleanForm();
           return;
        }
        
        Integer id = Utils.isEmpty(formFieldId.getText()) ? null: Integer.valueOf(formFieldId.getText());
        String name = formFieldName.getText();
      


        BrandDto brandDto = new BrandDto(id, name);
        this.brandController.save(brandDto);
        
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
        Integer id = Utils.toInteger(formFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.DialogError("Brand not selected!");
            return;
            
        }
        this.brandController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {100, 980}, BrandDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        Integer id = Utils.toInteger(filterFieldId.getText());
        String name = filterFieldName.getText();

        cleanFilter();
        
        ArrayList<BrandDto> brands = brandController.get(new BrandDto(id, name));
        updateTable(brands);
    }

    @Override
    protected void updateTable() {
         ArrayList<BrandDto> brands =  brandController.getAll();
         updateTable(brands);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, brandController.toObjectArray((ArrayList<BrandDto>) list));
    }

    @Override
    protected void updateForm() {
        formFieldId.setText(Utils.getTableColumnValue(table, 0));
        formFieldName.setText(Utils.getTableColumnValue(table, 1));        
    }

 

    
}
