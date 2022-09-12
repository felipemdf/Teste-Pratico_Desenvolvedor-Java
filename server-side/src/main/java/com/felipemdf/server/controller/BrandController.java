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
import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;
	
	@GetMapping
	public ResponseEntity<ArrayList<BrandDto>> findAll() {
		ArrayList<BrandModel> listBrands = brandService.findAll();
		
		return ResponseEntity.ok().body(BrandDto.toListDto(listBrands));
	}
	
	@GetMapping("/search")
	public ResponseEntity<ArrayList<BrandDto>> search(@RequestParam Optional<Long> id, @RequestParam Optional<String> name) {
		ArrayList<BrandModel> listBrands = brandService.findWithFilters(id, name);
		return ResponseEntity.ok().body(BrandDto.toListDto(listBrands));
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody BrandModel brand) {
		try {
			brandService.save(brand);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST	).body("Failed to save!");
		}
		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody BrandModel brand) {
		
		try {
			Optional<BrandModel> updateBrand = brandService.findById(id);
			if(updateBrand.isPresent()) {
				updateBrand.get().setName(brand.getName());
				brandService.save(updateBrand.get());
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
			brandService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
		}

	}

	
}
