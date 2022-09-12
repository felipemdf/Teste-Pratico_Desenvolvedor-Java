package com.felipemdf.client.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.felipemdf.client.dtos.BrandDto;
import com.felipemdf.client.dtos.CarDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.ComboBoxDto;
import com.felipemdf.client.dtos.CarImageDto;
import com.felipemdf.client.dtos.ResponseDto;

import java.util.ArrayList;

import com.felipemdf.client.interfaces.IFormService;
import com.felipemdf.client.utils.HttpRequest;
import com.felipemdf.client.views.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarService implements IFormService<CarDto> {

    public static ArrayList<CarDto> localData = new ArrayList<>();
    
    private final String BASE_URL = "http://" + Main.HOST + ":" + Main.PORT + "/car";
    Logger logger = Logger.getLogger(CarService.class.getName());

    HttpRequest<CarDto> http;

    public CarService() {
        http = new HttpRequest(BASE_URL);
        /**
         * Para não ter que adicionar todos os dados na tabela ou buscar no
         * banco sempre que quiser exibir no formulario criei um array que é
         * atualizado sempre que acesso o banco
         */
        localData = new ArrayList<>();
    }

    @Override
    public ResponseDto save(CarDto carDto) {
        try {
            ResponseDto response = http.save(BASE_URL, carDto);
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ResponseDto(true, e.getMessage());
        }

    }

    @Override
    public ResponseDto update(Long id, CarDto carDto) {
        try {
            ResponseDto response = http.update(BASE_URL, id, carDto);
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
    public ArrayList<CarDto> getAll() {
        Gson gson = new Gson();
        ArrayList<CarDto> cars = new ArrayList<>();
        try {
            cars = http.getAll(BASE_URL, new TypeToken<ArrayList<CarDto>>() {});
            fillLocalData(cars);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return cars;
    }

    @Override
    public ArrayList<CarDto> get(HashMap<String, String> filter) {

        ArrayList<CarDto> cars = new ArrayList<>();
        try {
            cars = http.get(BASE_URL, new TypeToken<ArrayList<CarDto>>() {}, filter);
            fillLocalData(cars);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return cars;
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CarDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(c -> {
            data.add(new Object[]{c.getId(), c.getName(), c.getDailyRate(), c.getLicensePlate(), c.getBrand().getName(), c.getCategory().getName(), c.getColor()});
        });
        return data;
    }

    public ArrayList<ComboBoxDto> getAllCategoriesToComboBox() {
        String url = "http://" + Main.HOST + ":" + Main.PORT + "/category";
        try {
            ArrayList<CategoryDto> categories = http.getAll(url, new TypeToken<ArrayList<CategoryDto>>() {
            });
            ArrayList<ComboBoxDto> comboBox = new ArrayList<>();

            for (CategoryDto category : categories) {
                comboBox.add(new ComboBoxDto(category.getId(), category.getName()));
            }

            return comboBox;

        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ArrayList<ComboBoxDto>();
        }
    }

    public ArrayList<ComboBoxDto> getAllBrandsToComboBox() {
        String url = "http://" + Main.HOST + ":" + Main.PORT + "/brand";
        try {
            ArrayList<BrandDto> brands = http.getAll(url, new TypeToken<ArrayList<BrandDto>>() {
            });
            ArrayList<ComboBoxDto> comboBox = new ArrayList<>();

            for (BrandDto brand : brands) {
                comboBox.add(new ComboBoxDto(brand.getId(), brand.getName()));
            }

            return comboBox;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return new ArrayList<ComboBoxDto>();
        }
    }

    public void fillLocalData(ArrayList<CarDto> cars) {
        this.localData = cars;
    }
    
    public CarDto getLocalDataById(Long id) {
        for (CarDto car : localData) {
            if(car.getId() == id)
                return car;
        }
        
        return new CarDto();
    }
}
