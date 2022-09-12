package com.felipemdf.client.controllers;

import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.interfaces.IFormController;
import com.felipemdf.client.utils.Utils;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class BrandController implements IFormController<BrandDto>{

    public static  ArrayList<BrandDto> brandDatabase = new ArrayList<>(); 

    @Override
    public boolean save(BrandDto brandDto) {
        try {
            if(brandDto.getId() == null) {
                brandDatabase.add(brandDto);
                return true;
            }
            
            BrandDto category = brandDatabase.stream().filter(c -> c.getId() == brandDto.getId()).findFirst().get();
            category.setName(brandDto.getName());
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    @Override
    public boolean remove(int id) {
        try {
             BrandDto brand = brandDatabase.stream().filter(c -> c.getId() == id).findFirst().get();
             brandDatabase.remove(brand);
             return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }     
    }

    @Override
    public ArrayList<BrandDto> getAll() {
        return brandDatabase;
    }

    @Override
    public ArrayList<BrandDto> get(BrandDto filter) {
        
        return (ArrayList<BrandDto>) brandDatabase.stream().filter(c ->{
            return (
                    (filter.getId() != null ? c.getId() == filter.getId(): true) &&
                    (!Utils.isEmpty(filter.getName())? c.getName().equals(filter.getName()) : true)
            );
        }).collect(toList());
       
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<BrandDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        
        list.forEach(category -> {
            data.add(new Object[] {category.getId(), category.getName()});
        });
        return data;
    }
    
   

}
