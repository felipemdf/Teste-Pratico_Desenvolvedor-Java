package com.felipemdf.client.views;

import com.felipemdf.client.services.CategoryService;
import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CategoryDto;
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
public class Category extends DefaultFormAndTable {

    CategoryService categoryService;

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

    public Category(CategoryService categoryController) {
        setTitle("Rental Cars - Category");
        this.categoryService = categoryController;
        updateTable();
    }

    @Override
    public void initializeComponents() {

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
        categoryFilterLabelName.setBounds(categoryFilterFieldId.getX() + categoryFilterFieldId.getWidth() + 30, categoryFilterLabelId.getY(), 100, 35);

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

        if (!validateForm()) {
            Dialogs.dialogMessage(true, "Please fill out all required fields!");
            cleanForm();
            return;
        }

        Long id = Utils.toLong(categoryFormFieldId.getText());
        String name = categoryFormFieldName.getText();
        String description = categoryFormFieldDescription.getText();

        CategoryDto categoryDto = new CategoryDto(id, name, description);
        ResponseDto response;
        if (id == null) {
            response = this.categoryService.save(categoryDto);
        } else {
            response = this.categoryService.update(id, categoryDto);
        }

        Dialogs.dialogMessage(response);
        cleanForm();

        updateTable();

    }

    private boolean validateForm() {

        if (Utils.isEmpty(categoryFormFieldName.getText())) {
            return false;
        }

        if (Utils.isEmpty(categoryFormFieldDescription.getText())) {
            return false;
        }

        return true;

    }

    @Override
    protected void formRemove() {
        Long id = Utils.toLong(categoryFormFieldId.getText());

        if (id == null || id == 0) {
            Dialogs.dialogMessage(true, "Category not selected!");
            return;

        }
        ResponseDto response = this.categoryService.remove(id);
        Dialogs.dialogMessage(response);

        cleanForm();
        cleanFilter();
        updateTable();
    }

    @Override
    protected void createTable() {
        table = tableManager.createTable(defaultPaneTable, new Object[]{100, 245, 735}, CategoryDto.class);
        tableModel = (DefaultTableModel) table.getModel();

    }

    @Override
    protected void search() {
        HashMap<String, String> filters = new HashMap();
        filters.put("id", categoryFilterFieldId.getText());
        filters.put("name", categoryFilterFieldName.getText());

        cleanFilter();
        ArrayList<CategoryDto> categories = categoryService.get(filters);
        updateTable(categories);
    }

    @Override
    protected void updateTable() {
        ArrayList<CategoryDto> categories = categoryService.getAll();
        updateTable(categories);
    }

    @Override
    protected void updateTable(ArrayList<?> list) {
        tableManager.insertData(tableModel, categoryService.toObjectArray((ArrayList<CategoryDto>) list));
    }

    @Override
    protected void updateForm() {
        categoryFormFieldId.setText(Utils.getTableColumnValue(table, 0));
        categoryFormFieldName.setText(Utils.getTableColumnValue(table, 1));
        categoryFormFieldDescription.setText(Utils.getTableColumnValue(table, 2));
    }

}
