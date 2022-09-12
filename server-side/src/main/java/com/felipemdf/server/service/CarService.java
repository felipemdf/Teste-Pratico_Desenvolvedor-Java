package com.felipemdf.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.repository.CarRepository;

@Service
public class CarService {

	Logger log = LoggerFactory.getLogger(CarService.class);
	
	@Autowired
	private CarRepository carRepository;
	
	
	public ArrayList<CarModel> findAll() {
		return (ArrayList<CarModel>) carRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public ArrayList<CarModel> findWithFilters(Optional<Long> id, Optional<String> name, Optional<String> licensePlate) {
		return (ArrayList<CarModel>) carRepository.findWithFilters(id, name, licensePlate);
	}


	public void save(CarModel car)throws IllegalArgumentException  {
		carRepository.save(car);
		
	}


	public void delete(Long id) {
		carRepository.deleteById(id);
	}


	public Optional<CarModel> findById(Long id) {
		return carRepository.findById(id);
		
	}

}
