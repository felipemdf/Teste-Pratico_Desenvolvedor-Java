package com.felipemdf.client.services;

import com.felipemdf.client.dtos.CarImageDto;
import com.felipemdf.client.dtos.CategoryDto;
import com.felipemdf.client.dtos.CarImageDto;
import com.felipemdf.client.dtos.ResponseDto;
import com.felipemdf.client.views.Main;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.felipemdf.client.interfaces.IFormService;
import com.felipemdf.client.utils.HttpRequest;
import com.felipemdf.client.utils.Utils;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

public class CarImageService implements IFormService<CarImageDto> {

    private static ArrayList<CarImageDto> localImages;
    private static Long carId;

    private final String BASE_URL = "http://" + Main.HOST + ":" + Main.PORT + "/image";

    Logger logger = Logger.getLogger(CarImageService.class.getName());

    HttpRequest<CarImageDto> http;

    public CarImageService(Long carId) {
        this.http = new HttpRequest(BASE_URL);
        this.localImages = new ArrayList<>();
        this.carId = carId;
    }

    @Override
    public ResponseDto save(CarImageDto imageDto) {

        try {
            imageDto.getCar().setId(carId);
            ResponseDto response = http.save(BASE_URL, imageDto);

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
    public ArrayList<CarImageDto> getAll() {
        ArrayList<CarImageDto> images = new ArrayList<>();
        try {
            images = http.getAll(BASE_URL + "/" + carId, new TypeToken<ArrayList<CarImageDto>>() {
            });
            fillLocalData(images);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }

        return images;
    }

    @Override
    public ArrayList<CarImageDto> get(HashMap<String, String> filter) {
        return null;
    }

    @Override
    public ArrayList<Object[]> toObjectArray(ArrayList<CarImageDto> list) {
        ArrayList<Object[]> data = new ArrayList<>();

        list.forEach(brand -> {
            data.add(new Object[]{brand.getId(), brand.getImage()});
        });
        return data;
    }

    @Override
    public ResponseDto update(Long id, CarImageDto object) {
        return null;
    }

    public void fillLocalData(ArrayList<CarImageDto> images) {
        this.localImages = images;
    }

    public byte[] getLocalDataById(Long id) {
        try {
            for (CarImageDto localImage : localImages) {
                if (localImage.getId() == id) {
                    return Utils.base64ToByteArray(localImage.getImage());
                }
            }

            return null;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            return null;
        }
    }
}
