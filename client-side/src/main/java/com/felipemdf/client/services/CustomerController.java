package com.felipemdf.client.controllers;


import com.felipemdf.client.dtos.CustomerDto;
import com.felipemdf.client.interfaces.IFormController;
import com.felipemdf.client.utils.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class CustomerController implements IFormController<CustomerDto>{

    public static  ArrayList<CustomerDto> customerDatabase = new ArrayList<>(); //USADO PARA SIMULAR O BANCO

    @Override
    public boolean save(CustomerDto customerDto) {
        try {
            if(customerDto.getId() == null) {
                customerDatabase.add(customerDto);
                return true;
            }
            
            CustomerDto customer = customerDatabase.stream().filter(c -> c.getId() == customerDto.getId()).findFirst().get();
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
             CustomerDto customer = customerDatabase.stream().filter(c -> c.getId() == id).findFirst().get();
             customerDatabase.remove(customer);
             return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }     
    }

    @Override
    public ArrayList<CustomerDto> getAll() {
        return customerDatabase;
    }

    @Override
    public ArrayList<CustomerDto> get(CustomerDto filter) {
        
        return (ArrayList<CustomerDto>) customerDatabase.stream().filter(c ->{
            return (
                    (filter.getId() != null ? c.getId() == filter.getId(): true) &&
                    (!Utils.isEmpty(filter.getName())? c.getName().equals(filter.getName()) : true)
            );
        }).collect(toList());
       
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CustomerDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(customer -> {
            data.add(new Object[] {customer.getId(), customer.getName(), Utils.formatDateToString(customer.getBirthDate()), customer.getEmail(), customer.getDriverLicense(), customer.getAddress(), customer.getPhoneNumber()});
        });
        return data;
    }
    
   

}
