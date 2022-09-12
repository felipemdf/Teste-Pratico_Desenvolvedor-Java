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

import com.felipemdf.server.dto.BrandDto;
import com.felipemdf.server.dto.CarImageDto;
import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.model.CarImageModel;
import com.felipemdf.server.service.BrandService;
import com.felipemdf.server.service.CarImageService;

@RestController
@RequestMapping("/image")
public class CarImageController {

	@Autowired
	CarImageService imageService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ArrayList<CarImageDto>> findAll(@PathVariable("id") Long id) {
		ArrayList<CarImageModel> listImages = imageService.findAll(id);
		
		return ResponseEntity.ok().body(CarImageDto.toListDto(listImages));
	}
	


	@PostMapping
	public ResponseEntity<String> create(@RequestBody CarImageDto imageDto) {
		try {
			imageService.save(imageDto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST	).body("Failed to save!");
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			imageService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
		}

	}

	
}
