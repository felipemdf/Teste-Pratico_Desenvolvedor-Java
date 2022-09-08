package com.felipemdf.client.views;

import com.felipemdf.client.controllers.CarController;
import com.felipemdf.client.controllers.ImageController;

import com.felipemdf.client.dtos.CarDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ComboBoxDto;
import com.felipemdf.client.utils.ComboBoxModel;
import com.felipemdf.client.utils.Dialogs;
import com.felipemdf.client.utils.Utils;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;


import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fmari_v4rpu9g
 */
public class Car extends DefaultFormAndTable{
    
    CarController carController;
    // FORM ------------------------------------------
    JLabel formLabelName;
    JTextField formFieldName;
    
    JLabel formLabelId;
    JTextField formFieldId;
  
    JLabel formLabelLicensePlate;
    JTextField formFieldLicensePlate;
    
    
    JLabel formLabelDailyRate;
    JTextField formFieldDailyRate;
    
    JLabel formLabelColor;
    JTextField formFieldColor;
    
    JLabel formLabelBrand;
    JComboBox  formFieldBrand;
    ComboBoxModel modelComboBoxBrand;
    
    JLabel formLabelCategory;
    JComboBox<ComboBoxDto>  formFieldCategory;
    ComboBoxModel modelComboBoxCategory;
            
    JLabel formLabelDescription;
    JTextField formFieldDescription;
    
    JButton formFieldImage;
    
  
    // ---------------------------------------------------------------
    
    // FILTER -------------------------------------------------------
    JLabel filterLabelId;
    JTextField filterFieldId;

    JLabel filterLabelName;
    JTextField filterFieldName;
    
    JLabel filterLabelLicensePlate;
    JTextField filterFieldLicensePlate;
    // ---------------------------------------------------------------
    
    public Car (CarController carController) {
         setTitle("Rental Cats - Car");
         this.carController = carController;
         
         updateTable();
         fillComboBox();
    }
    
    @Override
    public void initializeComponents () {
        // ID ------------------------------------------------------------------------------------------------------
        formLabelId = new JLabel("Id");
        formLabelId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelId.setBounds(defaultTitleRegister.getX(), defaultTitleRegister.getY() + 40, 50, 35);
        
        formFieldId = new JTextField("");
        formFieldId.setBounds(formLabelId.getX() - 1, formLabelId.getY() + 40, 80, 35);
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
        formFieldName.setBounds(formLabelName.getX() - 1, formFieldId.getY(), 400, 35);
        formFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelName);
        defaultPaneForm.add(formFieldName);
        //------------------------------------------------------------------------------------------------------
        
        // LICENSE PLATE ------------------------------------------------------------------------------------------------
        formLabelLicensePlate = new JLabel("License Plate");
        formLabelLicensePlate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelLicensePlate.setBounds(formFieldName.getX() + formFieldName.getWidth() + 30, formLabelName.getY(), 100, 35);   
      
        
        formFieldLicensePlate = new JTextField("");
        formFieldLicensePlate.setBounds(formLabelLicensePlate.getX() - 1, formFieldName.getY(), 200, 35);
        formFieldLicensePlate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelLicensePlate);
        defaultPaneForm.add(formFieldLicensePlate);
        //------------------------------------------------------------------------------------------------------
        
        
        // DAILY RATE ------------------------------------------------------------------------------------------------
        formLabelDailyRate = new JLabel("Dayle Rate");
        formLabelDailyRate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelDailyRate.setBounds(formFieldLicensePlate.getX() + formFieldLicensePlate.getWidth() + 30, formLabelLicensePlate.getY(), 100, 35);  
        
        formFieldDailyRate = new JTextField("");
        formFieldDailyRate.setBounds(formLabelDailyRate.getX() - 1, formFieldLicensePlate.getY(), 100, 35);
        formFieldDailyRate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelDailyRate);
        defaultPaneForm.add(formFieldDailyRate);
        //------------------------------------------------------------------------------------------------------
        
         // COLOR ------------------------------------------------------------------------------------------------
        formLabelColor = new JLabel("Color");
        formLabelColor.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelColor.setBounds(formFieldDailyRate.getX() + formFieldDailyRate.getWidth() + 30, formLabelDailyRate.getY(), 100, 35);  
        
        formFieldColor = new JTextField("");
        formFieldColor.setBounds(formLabelColor.getX() - 1, formFieldDailyRate.getY(), 170, 35);
        formFieldColor.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelColor);
        defaultPaneForm.add(formFieldColor);
        //------------------------------------------------------------------------------------------------------
      
      
        // BRAND ------------------------------------------------------------------------------------------------
        formLabelBrand = new JLabel("Brand");
        formLabelBrand.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelBrand.setBounds(formLabelId.getX(), formFieldId.getY() + 40, 150, 35);  
      
        
        formFieldBrand = new JComboBox<ComboBoxDto>();
        formFieldBrand.setBounds(formLabelBrand.getX() - 1, formLabelBrand.getY() + 40, 150, 35);
        formFieldBrand.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelBrand);
        defaultPaneForm.add(formFieldBrand);
        //------------------------------------------------------------------------------------------------------
        
        // CATEGORY ------------------------------------------------------------------------------------------------
        formLabelCategory = new JLabel("Category");
        formLabelCategory.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelCategory.setBounds(formFieldBrand.getX() + formFieldBrand.getWidth() + 30, formLabelBrand.getY(), 150, 35);  
      
        formFieldCategory = new JComboBox<ComboBoxDto>();
        formFieldCategory.setBounds(formLabelCategory.getX() - 1, formFieldBrand.getY(), 150, 35);
        formFieldCategory.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelCategory);
        defaultPaneForm.add(formFieldCategory);
        //------------------------------------------------------------------------------------------------------
        
        // DESCRIPTION  ------------------------------------------------------------------------------------------------
        formLabelDescription = new JLabel("Description");
        formLabelDescription.setFont(new Font("Segoe UI", Font.BOLD, 14));
        formLabelDescription.setBounds(formFieldCategory.getX() + formFieldCategory.getWidth() + 30, formLabelCategory.getY(), 150, 35);  
      
        
        formFieldDescription = new JTextField("");
        formFieldDescription.setBounds(formLabelDescription.getX() - 1, formFieldCategory.getY(), 520, 35);
        formFieldDescription.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        
        defaultPaneForm.add(formLabelDescription);
        defaultPaneForm.add(formFieldDescription);
        //------------------------------------------------------------------------------------------------------
        
        // IMAGES  ------------------------------------------------------------------------------------------------
  
        formFieldImage = new JButton("Images");
        formFieldImage.setBounds(formFieldDescription.getX() + formFieldDescription.getWidth() + 30, formFieldDescription.getY(), 100, 35);
        formFieldImage.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        configButtonImageListener();
        defaultPaneForm.add(formFieldImage);
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
         // FILTER LICENSE PLATE--------------------------------------------------------------------------------------------
        filterLabelLicensePlate = new JLabel("License Plate");
        filterLabelLicensePlate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        filterLabelLicensePlate.setBounds(filterFieldName.getX()  + filterFieldName.getWidth() + 30, filterLabelName.getY(), 100, 35);
        
        filterFieldLicensePlate = new JTextField("");
        filterFieldLicensePlate.setBounds(filterLabelLicensePlate.getX(), filterFieldName.getY(), 200, 35);
        
        defaultPaneFilter.add(filterLabelLicensePlate);
        defaultPaneFilter.add(filterFieldLicensePlate);
        
  
      
    }

    @Override
    public void alterFormComponentsStatesWhenEditing(boolean isEditing) {
        formFieldName.setEnabled(isEditing);
        formFieldBrand.setEnabled(isEditing);
        formFieldCategory.setEnabled(isEditing);
        formFieldColor.setEnabled(isEditing);
        formFieldDailyRate.setEnabled(isEditing);
        formFieldDescription.setEnabled(isEditing);
        formFieldBrand.setEnabled(isEditing);
        formFieldLicensePlate.setEnabled(isEditing);
        formFieldImage.setEnabled(isEditing);
        
    }
    
    @Override
    public void cleanForm() { 
       formFieldId.setText("");
       formFieldName.setText("");
       modelComboBoxCategory.clean();
       modelComboBoxBrand.clean();
       
       formFieldColor.setText("");
       formFieldDailyRate.setText("");
       formFieldDescription.setText("");
       formFieldLicensePlate.setText("");
    }
    
    @Override
    public void cleanFilter() {
       filterFieldId.setText("");  
       filterFieldName.setText("");
       filterFieldLicensePlate.setText("");
    }

       @Override
    protected void formSave() {    
        if(!validateForm()) {
           Dialogs.DialogError("Please fill out all required fields!");
           cleanForm();
           return;
        }
        
           try {
                Integer id = Utils.isEmpty(formFieldId.getText()) ? 0: Integer.valueOf(formFieldId.getText());
                String name = formFieldName.getText();
                String color = formFieldColor.getText();
                String licensePlate = formFieldLicensePlate.getText();
                String description = formFieldDescription.getText();
                BigDecimal dayleRate = new BigDecimal(formFieldDailyRate.getText());
                ComboBoxDto brand = (ComboBoxDto) formFieldBrand.getSelectedItem();
                ComboBoxDto category = (ComboBoxDto) formFieldCategory.getSelectedItem();
                
                CarDto categoryDto = new CarDto(
                        id,
                        name, 
                        description,
                        dayleRate,
                        true,
                        licensePlate,
                        brand.getId(),
                        category.getId(),
                        color
                );
                this.carController.save(categoryDto);

                cleanForm();

                updateTable();
           } catch (Exception e) {
               cleanForm();
               System.err.println(e);
           }
        
    }
    
    private boolean validateForm() {
        String name = formFieldName.getText();
        String color = formFieldColor.getText();
        String licensePlate = formFieldLicensePlate.getText();
        String description = formFieldDescription.getText();
        String dayleRate = formFieldDailyRate.getText();
        Object brand = formFieldBrand.getSelectedItem();
        Object category = formFieldBrand.getSelectedItem();
        
        if(
                Utils.isEmpty(name) ||
                Utils.isEmpty(color) || 
                Utils.isEmpty(licensePlate) || 
                Utils.isEmpty(description) || 
                Utils.isEmpty(dayleRate) || 
                brand == null ||
                category == null
        ) 
            return false;
     
        return true;
            
    }
        

    @Override
    protected void formRemove() {
        Integer id = Utils.toInteger(formFieldId.getText());

        if(id == null || id == 0) {
            Dialogs.DialogError("Car not selected!");
            return;
            
        }
        this.carController.remove(id);
        
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable( defaultPaneTable,  new Object[] {50, 220, 170, 240, 140, 250, 140}, CarDto.class );
        tableModel = (DefaultTableModel)table.getModel();

    }

    @Override
    protected void search() {
        Integer id = Utils.toInteger(filterFieldId.getText());
        String name = filterFieldName.getText();
        String licensePlate = filterFieldLicensePlate.getText();
        
        cleanFilter();
        
        ArrayList<CarDto> cars = carController.get(new CarDto(id, name, licensePlate));
        updateTable(cars);
    }

    @Override
    protected void updateTable() {
         ArrayList<CarDto> customers =  carController.getAll();
         updateTable(customers);
    }
    
    @Override
    protected void updateTable(ArrayList<?> list) {
         tableManager.insertData(tableModel, carController.toObjectArray((ArrayList<CarDto>) list));
    }

    @Override
    protected void updateForm() {
       formFieldId.setText(Utils.getTableColumnValue(table, 0));
       formFieldName.setText(Utils.getTableColumnValue(table, 1));
       formFieldDescription.setText(Utils.getTableColumnValue(table, 2));
       formFieldDailyRate.setText(Utils.getTableColumnValue(table, 3));
       formFieldLicensePlate.setText(Utils.getTableColumnValue(table, 5));
       
       modelComboBoxBrand.setSelectedItemById(Utils.toInteger(Utils.getTableColumnValue(table, 6)));
       modelComboBoxCategory.setSelectedItemById(Utils.toInteger(Utils.getTableColumnValue(table, 7)));
       formFieldColor.setText(Utils.getTableColumnValue(table, 8));
       
       
       
        
  
        
    }
    
    public void configButtonImageListener () {
        formFieldImage.addActionListener((e) -> {
            ImageViewer imageViwer = new ImageViewer(new ImageController(Utils.toInteger(formFieldId.getText())));
            imageViwer.setVisible(true);
        });
    }
    
    public void fillComboBox() {
      
        ArrayList<ComboBoxDto> categories = carController.getAllCategoriesComboBox();
        ArrayList<ComboBoxDto> brands = carController.getAllBrandsComboBox();
        
        modelComboBoxCategory = new ComboBoxModel(categories);
        formFieldCategory.setModel(modelComboBoxCategory);
        
        modelComboBoxBrand = new ComboBoxModel(brands);
        formFieldBrand.setModel(modelComboBoxBrand);
    }
}
