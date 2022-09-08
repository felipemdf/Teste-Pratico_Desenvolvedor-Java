package com.felipemdf.client.controllers;


import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CarDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ComboBoxDto;
import com.felipemdf.client.interfaces.IFormController;
import com.felipemdf.client.utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class CarController implements IFormController<CarDto>{

    public static  ArrayList<CarDto> carDatabase = new ArrayList<>(); //USADO PARA SIMULAR O BANCO

    @Override
    public boolean save(CarDto customerDto) {
        try {
            if(customerDto.getId() == null || customerDto.getId() == 0) {
                carDatabase.add(customerDto);
                return true;
            }
            
            CarDto customer = carDatabase.stream().filter(c -> c.getId() == customerDto.getId()).findFirst().get();
            customer.setName(customerDto.getName());
            return true;
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }

    }

    @Override
    public boolean remove(int id) {
        try {
             CarDto customer = carDatabase.stream().filter(c -> c.getId() == id).findFirst().get();
             carDatabase.remove(customer);
             return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }     
    }

    @Override
    public ArrayList<CarDto> getAll() {
        return carDatabase;
    }

    @Override
    public ArrayList<CarDto> get(CarDto filter) {
        
        return (ArrayList<CarDto>) carDatabase.stream().filter(c ->{
            return (
                    (filter.getId() != null ? c.getId() == filter.getId(): true) &&
                    (!Utils.isEmpty(filter.getName())? c.getName().equals(filter.getName()) : true) &&
                    (!Utils.isEmpty(filter.getLicensePlate())? c.getLicensePlate().equals(filter.getLicensePlate()) : true)
            );
        }).collect(toList());
       
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CarDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(c -> {
            data.add(new Object[] {c.getId(), c.getName(), c.getDescription(), c.getDailyRate(), c.getAvaliable(), c.getLicensePlate(), c.getBrandId(), c.getCategoryId(), c.getColor()});
        });
        return data;
    }
    
      public ArrayList<ComboBoxDto> getAllCategoriesComboBox() {
        ArrayList<CategoryDto> categories = new ArrayList<>();
        categories.add(new CategoryDto(1, "teste 1"));
        categories.add(new CategoryDto(2, "teste 2"));
        
        ArrayList<ComboBoxDto> comboBox = new ArrayList<>();
        categories.forEach(c -> comboBox.add(new ComboBoxDto(c.getId(), c.getName())));
        
        
        return comboBox;
    }
      
    public ArrayList<ComboBoxDto> getAllBrandsComboBox() {
        ArrayList<BrandDto> brands = new ArrayList<>();
        brands.add(new BrandDto(1, "teste 3"));
        brands.add(new BrandDto(2, "teste 4"));
        
        ArrayList<ComboBoxDto> comboBox = new ArrayList<>();
        brands.forEach(c -> comboBox.add(new ComboBoxDto(c.getId(), c.getName())));
        
        
        return comboBox;
    }

}
