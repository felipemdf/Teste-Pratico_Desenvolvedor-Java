package com.felipemdf.client.controllers;

import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.SpecificationDto;
import com.felipemdf.client.interfaces.IFormController;
import com.felipemdf.client.utils.Utils;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class SpecificationController implements IFormController<SpecificationDto>{

    public static  ArrayList<SpecificationDto> specificationDatabase = new ArrayList<>(); //USADO PARA SIMULAR O BANCO

    @Override
    public boolean save(SpecificationDto specificationDto) {
        try {
            if(specificationDto.getId() == null) {
                specificationDatabase.add(specificationDto);
                return true;
            }
            
            SpecificationDto specification = specificationDatabase.stream().filter(c -> c.getId() == specificationDto.getId()).findFirst().get();
            specification.setName(specificationDto.getName());
            specification.setDescription(specificationDto.getDescription());
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    @Override
    public boolean remove(int id) {
        try {
             SpecificationDto specification = specificationDatabase.stream().filter(c -> c.getId() == id).findFirst().get();
             specificationDatabase.remove(specification);
             return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }     
    }

    @Override
    public ArrayList<SpecificationDto> getAll() {
        return specificationDatabase;
    }

    @Override
    public ArrayList<SpecificationDto> get(SpecificationDto filter) {
        
        return (ArrayList<SpecificationDto>) specificationDatabase.stream().filter(c ->{
            return (
                    (filter.getId() != null ? c.getId() == filter.getId(): true) &&
                    (!Utils.isEmpty(filter.getName())? c.getName().equals(filter.getName()) : true)
            );
        }).collect(toList());
       
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<SpecificationDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        
        list.forEach(category -> {
            data.add(new Object[] {category.getId(), category.getName(), category.getDescription()});
        });
        return data;
    }
    
   

}
