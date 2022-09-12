package com.felipemdf.client.controllers;

import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.interfaces.IFormController;
import com.felipemdf.client.utils.Utils;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class CategoryController implements IFormController<CategoryDto>{

    public static  ArrayList<CategoryDto> categoriesDatabase = new ArrayList<>(); //USADO PARA SIMULAR O BANCO
    public static  ArrayList<CategoryDto> categories = new ArrayList<>();

    @Override
    public boolean save(CategoryDto categoryDto) {
        try {
            if(categoryDto.getId() == null) {
                categoriesDatabase.add(categoryDto);
                return true;
            }
            
            CategoryDto category = categoriesDatabase.stream().filter(c -> c.getId() == categoryDto.getId()).findFirst().get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    @Override
    public boolean remove(int id) {
        try {
             CategoryDto category = categoriesDatabase.stream().filter(c -> c.getId() == id).findFirst().get();
             categoriesDatabase.remove(category);
             return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }     
    }

    @Override
    public ArrayList<CategoryDto> getAll() {
        return categoriesDatabase;
    }

    @Override
    public ArrayList<CategoryDto> get(CategoryDto filter) {
        
        return (ArrayList<CategoryDto>) categoriesDatabase.stream().filter(c ->{
            return (
                    (filter.getId() != null ? c.getId() == filter.getId(): true) &&
                    (!Utils.isEmpty(filter.getName())? c.getName().equals(filter.getName()) : true)
            );
        }).collect(toList());
       
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CategoryDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        
        list.forEach(category -> {
            data.add(new Object[] {category.getId(), category.getName(), category.getDescription()});
        });
        return data;
    }
    
   

}
