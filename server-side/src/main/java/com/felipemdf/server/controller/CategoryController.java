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

import com.felipemdf.server.dto.CategoryDto;
import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.model.CategoryModel;
import com.felipemdf.server.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<ArrayList<CategoryDto>> findAll() {
		ArrayList<CategoryModel> listBrands = categoryService.findAll();
		
		return ResponseEntity.ok().body(CategoryDto.toListDto(listBrands));
	}
	
	@GetMapping("/search")
	public ResponseEntity<ArrayList<CategoryDto>> search(@RequestParam Optional<Long> id, @RequestParam Optional<String> name) {
		ArrayList<CategoryModel> listBrands = categoryService.findWithFilters(id, name);
		return ResponseEntity.ok().body(CategoryDto.toListDto(listBrands));
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody CategoryModel category) {
		try {
			categoryService.save(category);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST	).body("Failed to save!");
		}
		
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody CategoryModel category) {
		
		try {
			Optional<CategoryModel> updateCategory = categoryService.findById(id);
			if(updateCategory.isPresent()) {
				updateCategory.get().setName(category.getName());
				updateCategory.get().setDescription(category.getName());
				categoryService.save(updateCategory.get());
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
			categoryService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found!");
		}

	}
}
