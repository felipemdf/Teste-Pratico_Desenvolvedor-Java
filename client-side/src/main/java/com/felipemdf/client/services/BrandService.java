package com.felipemdf.client.services;

import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.felipemdf.client.views.Main;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.felipemdf.client.interfaces.IFormService;
import com.felipemdf.client.utils.HttpRequest;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class BrandService implements IFormService<BrandDto> {

    private final String BASE_URL = "http://" + Main.HOST + ":" + Main.PORT + "/brand";

    Logger logger = Logger.getLogger(BrandService.class.getName());

    HttpRequest<BrandDto> http;

    public BrandService() {
        http = new HttpRequest(BASE_URL);
    }

    @Override
    public ResponseDto save(BrandDto brandDto) {

        try {
            ResponseDto response = http.save(BASE_URL,brandDto);
            
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }

    }

    @Override
    public ResponseDto update(Long id, BrandDto brandDto) {
        try {
            ResponseDto response = http.update(BASE_URL, id, brandDto);
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
    public ArrayList<BrandDto> getAll() {
        ArrayList<BrandDto> brands = new ArrayList<>();
        try {
            brands = http.getAll(BASE_URL, new TypeToken<ArrayList<BrandDto>>() {});
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return brands;
    }

    @Override
    public ArrayList<BrandDto> get(HashMap<String, String> filter) {

        ArrayList<BrandDto> brands = new ArrayList<>();
        try {
            brands = http.get(BASE_URL, new TypeToken<ArrayList<BrandDto>>() {}, filter);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return brands;
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<BrandDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(brand -> {
            data.add(new Object[]{brand.getId(), brand.getName()});
        });
        return data;
    }
}
