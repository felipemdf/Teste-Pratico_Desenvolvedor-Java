/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ComboBoxDto{
    private Long id;
    private String value;

    public ComboBoxDto() {}
    public ComboBoxDto(Long id, String value) {
        this.id = id;
        this.value = value;
    }
    
    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    public static ComboBoxDto[] toArray(ArrayList<ComboBoxDto> list) {
       ComboBoxDto[] comboBoxArray = new ComboBoxDto[list.size()];

        for (int i = 0; i < list.size(); i++) {
            comboBoxArray[i] = list.get(i);
        }
      
        return comboBoxArray;
    }
}
