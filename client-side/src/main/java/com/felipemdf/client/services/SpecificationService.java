package com.felipemdf.client.services;

import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.felipemdf.client.dtos.SpecificationDto;
import java.util.ArrayList;
import com.felipemdf.client.interfaces.IFormService;
import com.felipemdf.client.utils.HttpRequest;
import com.felipemdf.client.views.Main;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpecificationService implements IFormService<SpecificationDto> {

    private final String BASE_URL = "http://" + Main.HOST + ":" + Main.PORT + "/specification";
    Logger logger = Logger.getLogger(SpecificationService.class.getName());
    HttpRequest<SpecificationDto> http;

    public SpecificationService() {
        http = new HttpRequest(BASE_URL);
    }

    @Override
    public ResponseDto save(SpecificationDto specificationDto) {
        try {
            ResponseDto response = http.save(BASE_URL, specificationDto);
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }

    }

    @Override
    public ResponseDto update(Long id, SpecificationDto specificationDto) {
        try {
            ResponseDto response = http.update(BASE_URL, id, specificationDto);
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }
    }

    @Override
    public ResponseDto remove(Long id) {
        try {
            ResponseDto response = http.delete(BASE_URL, id);
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }
    }

    @Override
    public ArrayList<SpecificationDto> getAll() {
        ArrayList<SpecificationDto> specifications = new ArrayList<>();
        try {
            specifications = http.getAll(BASE_URL, new TypeToken<ArrayList<SpecificationDto>>() {});
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return specifications;
    }

    @Override
    public ArrayList<SpecificationDto> get(HashMap<String, String> filter) {

        ArrayList<SpecificationDto> specifications = new ArrayList<>();
        try {
            specifications = http.get(BASE_URL, new TypeToken<ArrayList<SpecificationDto>>() {}, filter);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return specifications;
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<SpecificationDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(category -> {
            data.add(new Object[]{category.getId(), category.getName(), category.getDescription()});
        });
        return data;
    }

}
