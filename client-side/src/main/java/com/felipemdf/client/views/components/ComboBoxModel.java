/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.views.components;

import com.felipemdf.client.dtos.ComboBoxDto;
import java.util.ArrayList;
import javax.swing.AbstractListModel;




public class ComboBoxModel extends AbstractListModel<ComboBoxDto> implements javax.swing.ComboBoxModel<ComboBoxDto>{

    private ArrayList<ComboBoxDto> list;
    private ComboBoxDto selectedItem;
    
    public ComboBoxModel(ArrayList<ComboBoxDto> list) {
        this.list = list;
        //setSelectedItem(this.list.get(0));
    }
        
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (ComboBoxDto) anItem;
        fireContentsChanged(list, 0, list.size());
    }

    @Override
    public Object getSelectedItem() {
         return selectedItem;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public ComboBoxDto getElementAt(int index) {
        return list.get(index);
    }

    public void clean () {
        setSelectedItem(getElementAt(0));
    }
    
    public void setSelectedItemById(int id) {
        ComboBoxDto item = list.stream().filter(i -> i.getId() == id).findFirst().get();
        
        selectedItem = item;
        fireContentsChanged(list, 0, list.size());
    }
}
