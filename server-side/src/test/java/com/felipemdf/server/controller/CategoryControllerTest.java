package com.felipemdf.server.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.felipemdf.server.dto.CategoryDto;
import com.felipemdf.server.model.CategoryModel;
import com.felipemdf.server.service.CategoryService;

@SpringBootTest(classes = {CategoryController.class, CategoryService.class})
public class CategoryControllerTest {

	@Autowired
	CategoryController categoryController;
	
	@MockBean
	CategoryService categoryService;
	
	static ArrayList<CategoryModel> categories;
	static ArrayList<CategoryModel> categoriesWithFilter;
	static CategoryModel category;
	
	
	@BeforeAll
	static void setup () {
		categories = new ArrayList<>();
		categories.add(new CategoryModel((long) 1, "Felipe", "descricao 1"));
		categories.add(new CategoryModel((long) 2, "Joao", "descricao 2"));
		categories.add(new CategoryModel((long) 3, "Marcelo", "descricao 3"));
		
		category = categories.get(0);
		
		categoriesWithFilter = new ArrayList<>();
		categoriesWithFilter.add(categories.get(0));
	}

	@Test
	void whenFindAllThenReturnAListOfBrands () {
		when(categoryService.findAll()).thenReturn(categories);
		
		ResponseEntity<ArrayList<CategoryDto>> response = categoryController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(3, response.getBody().size(), "Should return size 3");
		Assertions.assertEquals(CategoryDto.class, response.getBody().get(0).getClass(), "Should return a list of CategoryDto");
	}
	
	@Test
	void whenFindAllThenReturnAEmptyList () {
		when(categoryService.findAll()).thenReturn(new ArrayList<CategoryModel>());
		
		ResponseEntity<ArrayList<CategoryDto>> response = categoryController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(0, response.getBody().size(), "Should return size 0");
	}
	
	@Test
	void whenFindWithFilterThenReturnAListOfBrands () {
		when(categoryService.findWithFilters(any(), any())).thenReturn(categoriesWithFilter);
		
		ResponseEntity<ArrayList<CategoryDto>> response = categoryController.search(Optional.of(Long.parseLong("1")), Optional.of("Felipe"));
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(1, response.getBody().size(), "Should return size 1");
		Assertions.assertEquals(CategoryDto.class, response.getBody().get(0).getClass(), "Should return a list of CategoryDto");
	}
	
	@Test
	void whenCreateThenReturnSuccess() {
		doNothing().when(categoryService).save(any(CategoryModel.class));
		ResponseEntity<String> response = categoryController.create(category);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Should return a status code 201");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully created", response.getBody());
	}
	
	@Test
	void whenCreateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(categoryService).save(any());
		ResponseEntity<String> response = categoryController.create(category);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to save!", response.getBody());
	}	
	
	@Test
	void whenUpdateThenReturnSuccess() {
		when(categoryService.findById(any(Long.class))).thenReturn(Optional.of(category));
		doNothing().when(categoryService).save(any(CategoryModel.class));
		doNothing().when(categoryService).save(any(CategoryModel.class));
		ResponseEntity<String> response = categoryController.update((long) 1, category);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully updated", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnNotFound() {
		when(categoryService.findById(any(Long.class))).thenReturn(Optional.empty());
		doNothing().when(categoryService).save(any(CategoryModel.class));
		doNothing().when(categoryService).save(any(CategoryModel.class));
		ResponseEntity<String> response = categoryController.update((long) 9, category);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 404");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(categoryService).findById(any());
		doNothing().when(categoryService).save(any(CategoryModel.class));
		doNothing().when(categoryService).save(any(CategoryModel.class));
		ResponseEntity<String> response = categoryController.update((long) 9, category);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to update!", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnSuccess() {
		doNothing().when(categoryService).delete(any(Long.class));
		ResponseEntity<String> response = categoryController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals("Successfully deleted", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnNotFound() {
		doThrow(IllegalArgumentException.class).when(categoryService).delete(any());
		ResponseEntity<String> response = categoryController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 204");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
}
