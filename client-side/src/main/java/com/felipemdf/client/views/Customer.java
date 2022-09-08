package com.felipemdf.client.views;

import com.felipemdf.client.controllers.CategoryController;
import com.felipemdf.client.controllers.CustomerController;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.CustomerDto;
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
public class Customer extends DefaultFormAndTable{
    
    CustomerController customerController;
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
    
    public Customer (CustomerController customerController) {
         setTitle("Rental Cats - Customer");
         this.customerController = customerController;
         
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
        //------------------------------------------------------------------------------------------------------
        
        // DRIVER LICENSE ------------------------------------------------------------------------------------------------
        formLabelDriverLicense = new JLabel("Driver License");
        formLabelDriverLicense.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelDriverLicense.setBounds(formFieldName.getX() + formFieldName.getWidth() + 30, formLabelName.getY(), 150, 35);  
        
        formFieldDriverLicense = new JTextField("");
        formFieldDriverLicense.setBounds(formLabelDriverLicense.getX() - 1, formFieldName.getY(), 250, 35);
        formFieldDriverLicense.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelDriverLicense);
        defaultPaneForm.add(formFieldDriverLicense);
        //------------------------------------------------------------------------------------------------------
      
        // BIRTHDATE ------------------------------------------------------------------------------------------------
        formLabelBirthDate = new JLabel("Birth Date");
        formLabelBirthDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelBirthDate.setBounds(formFieldDriverLicense.getX() + formFieldDriverLicense.getWidth() + 30, formLabelDriverLicense.getY(), 150, 35);  
      
        
        jcalendar = new JDateChooser();
        jcalendar.setBounds(formLabelBirthDate.getX(), formFieldDriverLicense.getY(), 150, 35);  
        
        defaultPaneForm.add(formLabelBirthDate);
        defaultPaneForm.add(jcalendar);
        //------------------------------------------------------------------------------------------------------
        
        // EMAIL ------------------------------------------------------------------------------------------------
        formLabelEmail = new JLabel("Email");
        formLabelEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelEmail.setBounds(formFieldId.getX(), formFieldId.getY() + 40, 150, 35);  
      
        
        formFieldEmail = new JTextField("");
        formFieldEmail.setBounds(formLabelEmail.getX() - 1, formLabelEmail.getY() + 40, 400, 35);
        formFieldEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelEmail);
        defaultPaneForm.add(formFieldEmail);
        //------------------------------------------------------------------------------------------------------
        
        // ADDRESS ------------------------------------------------------------------------------------------------
        formLabelAddress = new JLabel("Address");
        formLabelAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelAddress.setBounds(formFieldEmail.getX() + formFieldEmail.getWidth() + 30, formLabelEmail.getY(), 150, 35);  
        
        
        formFieldAddress = new JTextField("");
        formFieldAddress.setBounds(formLabelAddress.getX() - 1, formFieldEmail.getY(), 400, 35);
        formFieldAddress.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelAddress);
        defaultPaneForm.add(formFieldAddress);
        //------------------------------------------------------------------------------------------------------
        
         // PHONE NUMBER ------------------------------------------------------------------------------------------------
        formLabelPhoneNumber = new JLabel("Phone Number");
        formLabelPhoneNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelPhoneNumber.setBounds(formFieldAddress.getX() + formFieldAddress.getWidth() + 30, formLabelAddress.getY(), 150, 35);  
        
        
        formFieldPhoneNumber = new JTextField("");
        formFieldPhoneNumber.setBounds(formLabelPhoneNumber.getX() - 1, formFieldAddress.getY(), 200, 35);
        formFieldPhoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelPhoneNumber);
        defaultPaneForm.add(formFieldPhoneNumber);
        //------------------------------------------------------------------------------------------------------
        
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
                 // FILTER NAME --------------------------------------------------------------------------------------------
                 
        filterLabelDriverLicense = new JLabel("Driver License");
        filterLabelDriverLicense.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filterLabelDriverLicense.setBounds(filterFieldName.getX()  + filterFieldName.getWidth() + 30, filterLabelName.getY(), 100, 35);
        
        filterFieldDriverLicense = new JTextField("");
        filterFieldDriverLicense.setBounds(filterLabelDriverLicense.getX(), filterFieldName.getY(), 250, 35);
        
        defaultPaneFilter.add(filterLabelDriverLicense);
        defaultPaneFilter.add(filterFieldDriverLicense);
        
        // ------------------------------------------------------------------------------------------------------
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        formFieldName.setEnabled(isEditing);
        formFieldName.setEnabled(isEditing);
        jcalendar.setEnabled(isEditing);
        formFieldEmail.setEnabled(isEditing);
        formFieldAddress.setEnabled(isEditing);
        formFieldPhoneNumber.setEnabled(isEditing);
        formFieldDriverLicense.setEnabled(isEditing);
    }
    
    @Override
    public void cleanForm() {
       formFieldName.setText("");  
       formFieldId.setText("");
       formFieldEmail.setText("");
       formFieldDriverLicense.setText("");
       formFieldAddress.setText("");
       formFieldPhoneNumber.setText("");
       jcalendar.cleanup();
    }
    
    @Override
    public void cleanFilter() {
       filterFieldId.setText("");  
       filterFieldName.setText("");
       filterFieldDriverLicense.setText("");
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
        Date birthDate = jcalendar.getDate();
        String email = formFieldEmail.getText();
        String driverLicense = formFieldDriverLicense.getText();
        String address = formFieldAddress.getText();
        String phoneNumber = formFieldPhoneNumber.getText();


        CustomerDto categoryDto = new CustomerDto(id, name, birthDate, email, driverLicense, address, phoneNumber);
        this.customerController.save(categoryDto);
        
        cleanForm();
        
        updateTable();
        
    }
    
    private boolean validateForm() {
        String name = formFieldName.getText();
        String birthDate = jcalendar.getDateFormatString();
        String email = formFieldEmail.getText();
        String driverLicense = formFieldDriverLicense.getText();
        String address = formFieldAddress.getText();
        String phoneNumber = formFieldPhoneNumber.getText();
        
        if(Utils.isEmpty(name) || Utils.isEmpty(birthDate) || Utils.isEmpty(email) || Utils.isEmpty(driverLicense) || Utils.isEmpty(address) || Utils.isEmpty(phoneNumber)) 
            return false;
     
        return true;
            
    }
        

    @Override
    protected void formRemove() {
        Integer id = Utils.toInteger(formFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.DialogError("Category not selected!");
            return;
            
        }
        this.customerController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {50, 220, 170, 240, 140, 250, 140}, CustomerDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        Integer id = Utils.toInteger(filterFieldId.getText());
        String name = filterFieldName.getText();
        String driverLicense = filterFieldDriverLicense.getText();
        
        cleanFilter();
        
        ArrayList<CustomerDto> customers = customerController.get(new CustomerDto(id, name, driverLicense));
        updateTable(customers);
    }

    @Override
    protected void updateTable() {
         ArrayList<CustomerDto> customers =  customerController.getAll();
         updateTable(customers);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, customerController.toObjectArray((ArrayList<CustomerDto>) list));
    }

    @Override
    protected void updateForm() {
        formFieldId.setText(Utils.getTableColumnValue(table, 0));
        formFieldName.setText(Utils.getTableColumnValue(table, 1));
        //jcalendar.setText(Utils.getTableColumnValue(table, 1));
        formFieldEmail.setText(Utils.getTableColumnValue(table, 3));
        formFieldDriverLicense.setText(Utils.getTableColumnValue(table, 4));
        formFieldAddress.setText(Utils.getTableColumnValue(table, 5));
        formFieldPhoneNumber.setText(Utils.getTableColumnValue(table, 6));
        
    }

   
}
