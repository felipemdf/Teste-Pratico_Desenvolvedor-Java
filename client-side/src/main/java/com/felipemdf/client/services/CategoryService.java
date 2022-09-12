package com.felipemdf.client.services;

import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ResponseDto;
import java.util.ArrayList;
import com.felipemdf.client.interfaces.IFormService;
import com.felipemdf.client.utils.HttpRequest;
import com.felipemdf.client.views.Main;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoryService implements IFormService<CategoryDto> {

    private final String BASE_URL = "http://" + Main.HOST + ":" + Main.PORT + "/category";
    Logger logger = Logger.getLogger(CategoryService.class.getName());

    HttpRequest<CategoryDto> http;

    public CategoryService() {
        http = new HttpRequest(BASE_URL);
    }

    @Override
    public ResponseDto save(CategoryDto categoryDto) {
        try {
            ResponseDto response = http.save(BASE_URL, categoryDto);
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }

    }

    @Override
    public ResponseDto update(Long id, CategoryDto categoryDto) {
        try {
            ResponseDto response = http.update(BASE_URL, id, categoryDto);
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
    public ArrayList<CategoryDto> getAll() {
        ArrayList<CategoryDto> categories = new ArrayList<>();
        try {
            categories = http.getAll(BASE_URL, new TypeToken<ArrayList<CategoryDto>>() {});
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return categories;
    }

    @Override
    public ArrayList<CategoryDto> get(HashMap<String, String> filter) {

        ArrayList<CategoryDto> categories = new ArrayList<>();
        try {
            categories = http.get(BASE_URL, new TypeToken<ArrayList<CategoryDto>>() {}, filter);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return categories;
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CategoryDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(category -> {
            data.add(new Object[]{category.getId(), category.getName(), category.getDescription()});
        });
        return data;
    }

}
