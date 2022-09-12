package com.felipemdf.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felipemdf.server.dto.CarImageDto;
import com.felipemdf.server.model.CarImageModel;
import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.repository.CarImageRepository;
import com.felipemdf.server.repository.CarRepository;

@Service
public class CarImageService {

	Logger log = LoggerFactory.getLogger(CarImageService.class);
	
	@Autowired
	private CarImageRepository carImageRepository;
	
	
	public ArrayList<CarImageModel> findAll(Long id) {
		return (ArrayList<CarImageModel>) carImageRepository.findByCarId(id);
	}

	public void save(CarImageDto carDto)throws IllegalArgumentException  {
		CarImageModel car = CarImageDto.toModel(carDto);
		
		carImageRepository.save(car);
		
	}

	public void delete(Long id) {
		carImageRepository.deleteById(id);
	}


}
