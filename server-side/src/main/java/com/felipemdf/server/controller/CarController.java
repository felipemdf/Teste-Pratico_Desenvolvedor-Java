package com.felipemdf.server.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipemdf.server.dto.CarDto;
import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;
	
	@GetMapping
	public ResponseEntity<ArrayList<CarDto>> findAll() {
		ArrayList<CarModel> listCars = carService.findAll();
		
		return ResponseEntity.ok().body(CarDto.toListDto(listCars));
	}
	
	@GetMapping("/search")
	public ResponseEntity<ArrayList<CarDto>> search(@RequestParam Optional<Long> id, @RequestParam Optional<String> name, @RequestParam Optional<String> licensePlate) {
		ArrayList<CarModel> listBrands = carService.findWithFilters(id, name, licensePlate);
		return ResponseEntity.ok().body(CarDto.toListDto(listBrands));
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody CarModel car) {
		try {
			carService.save(car);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST	).body(e.getMessage());
		}
		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody CarModel car) {
		
		try {
			Optional<CarModel> updateCar = carService.findById(id);
			if(updateCar.isPresent()) {
				updateCar.get().setName(car.getName());
				carService.save(updateCar.get());
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
			}
			
			return ResponseEntity.status(HttpStatus.OK).body("Successfully updated");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update!");
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			carService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
		}

	}
}
