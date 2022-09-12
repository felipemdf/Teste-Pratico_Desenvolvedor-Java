package com.felipemdf.client.views;

import com.felipemdf.client.services.SpecificationService;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.felipemdf.client.dtos.SpecificationDto;
import com.felipemdf.client.views.components.Dialogs;
import com.felipemdf.client.utils.Utils;
import java.awt.Font;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Specification extends DefaultFormAndTable {

    SpecificationService specificationService;

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

    public Specification(SpecificationService specificationController) {
        setTitle("Rental Cars - Specification");
        this.specificationService = specificationController;

        updateTable();
    }

    @Override
    public void initializeComponents() {

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
        specificationFilterLabelName.setBounds(specificationFilterFieldId.getX() + specificationFilterFieldId.getWidth() + 30, specificationFilterLabelId.getY(), 100, 35);

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

        if (!validateForm()) {
            Dialogs.dialogMessage(true, "Please fill out all required fields!");
            cleanForm();
            return;
        }

        Long id = Utils.toLong(specificationFormFieldId.getText());
        String name = specificationFormFieldName.getText();
        String description = specificationFormFieldDescription.getText();

        SpecificationDto specificationDto = new SpecificationDto(id, name, description);
        ResponseDto response;
        if (id == null) {
            response = this.specificationService.save(specificationDto);
        } else {
            response = this.specificationService.update(id, specificationDto);
        }

        Dialogs.dialogMessage(response);
        cleanForm();

        updateTable();

    }

    @Override
    protected void formRemove() {
        Long id = Utils.toLong(specificationFormFieldId.getText());

        if (id == null || id == 0) {
            Dialogs.dialogMessage(true, "Specification not selected!");
            return;

        }
        ResponseDto response = this.specificationService.remove(id);
        Dialogs.dialogMessage(response);

        cleanForm();
        cleanFilter();
        updateTable();
    }

    private boolean validateForm() {

        if (Utils.isEmpty(specificationFormFieldName.getText())) {
            return false;
        }

        if (Utils.isEmpty(specificationFormFieldDescription.getText())) {
            return false;
        }

        return true;

    }

    @Override
    protected void createTable() {
        table = tableManager.createTable(defaultPaneTable, new Object[]{100, 245, 735}, SpecificationDto.class);
        tableModel = (DefaultTableModel) table.getModel();

    }

    @Override
    protected void search() {
        HashMap<String, String> filters = new HashMap();
        filters.put("id", specificationFilterFieldId.getText());
        filters.put("name", specificationFilterFieldName.getText());

        cleanFilter();
        ArrayList<SpecificationDto> brands = specificationService.get(filters);
        updateTable(brands);
    }

    @Override
    protected void updateTable() {
        ArrayList<SpecificationDto> specifications = specificationService.getAll();
        updateTable(specifications);
    }

    @Override
    protected void updateTable(ArrayList<?> list) {
        tableManager.insertData(tableModel, specificationService.toObjectArray((ArrayList<SpecificationDto>) list));
    }

    @Override
    protected void updateForm() {
        specificationFormFieldId.setText(Utils.getTableColumnValue(table, 0));
        specificationFormFieldName.setText(Utils.getTableColumnValue(table, 1));
        specificationFormFieldDescription.setText(Utils.getTableColumnValue(table, 2));
    }
}
