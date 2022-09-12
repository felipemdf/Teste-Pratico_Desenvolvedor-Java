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

import com.felipemdf.server.dto.SpecificationDto;
import com.felipemdf.server.model.SpecificationModel;
import com.felipemdf.server.service.SpecificationService;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
	@Autowired
	SpecificationService specificationService;
	
	@GetMapping
	public ResponseEntity<ArrayList<SpecificationDto>> findAll() {
		ArrayList<SpecificationModel> listSpecifications = specificationService.findAll();
		
		return ResponseEntity.ok().body(SpecificationDto.toListDto(listSpecifications));
	}
	
	@GetMapping("/search")
	public ResponseEntity<ArrayList<SpecificationDto>> search(@RequestParam Optional<Long> id, @RequestParam Optional<String> name) {
		ArrayList<SpecificationModel> listSpecifications = specificationService.findWithFilters(id, name);
		return ResponseEntity.ok().body(SpecificationDto.toListDto(listSpecifications));
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody SpecificationModel specification) {
		try {
			specificationService.save(specification);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST	).body("Failed to save!");
		}
		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody SpecificationModel category) {
		
		try {
			Optional<SpecificationModel> updateSpecification = specificationService.findById(id);
			if(updateSpecification.isPresent()) {
				updateSpecification.get().setName(category.getName());
				updateSpecification.get().setDescription(category.getName());
				specificationService.save(updateSpecification.get());
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
			specificationService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
		}

	}
}
