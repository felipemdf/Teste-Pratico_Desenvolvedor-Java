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

import com.felipemdf.server.dto.BrandDto;
import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.service.BrandService;

@SpringBootTest(classes = {BrandController.class, BrandService.class})
public class BrandControllerTest {

	@Autowired
	BrandController brandController;
	
	@MockBean
	BrandService brandService;
	
	static ArrayList<BrandModel> brands;
	static ArrayList<BrandModel> brandsWithFilter;
	static BrandModel brand;
	
	
	@BeforeAll
	static void setup () {
		brands = new ArrayList<>();
		brands.add(new BrandModel((long) 1, "Felipe"));
		brands.add(new BrandModel((long) 2, "Joao"));
		brands.add(new BrandModel((long) 3, "Marcelo"));
		
		brand = brands.get(0);
		
		brandsWithFilter = new ArrayList<>();
		brandsWithFilter.add(brands.get(0));
	}

	@Test
	void whenFindAllThenReturnAListOfBrands () {
		when(brandService.findAll()).thenReturn(brands);
		
		ResponseEntity<ArrayList<BrandDto>> response = brandController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(3, response.getBody().size(), "Should return size 3");
		Assertions.assertEquals(BrandDto.class, response.getBody().get(0).getClass(), "Should return a list of BrandResponseDto");
	}
	
	@Test
	void whenFindAllThenReturnAEmptyList () {
		when(brandService.findAll()).thenReturn(new ArrayList<BrandModel>());
		
		ResponseEntity<ArrayList<BrandDto>> response = brandController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(0, response.getBody().size(), "Should return size 0");
	}
	
	@Test
	void whenFindWithFilterThenReturnAListOfBrands () {
		when(brandService.findWithFilters(any(), any())).thenReturn(brandsWithFilter);
		
		ResponseEntity<ArrayList<BrandDto>> response = brandController.search(Optional.of(Long.parseLong("1")), Optional.of("Felipe"));
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(1, response.getBody().size(), "Should return size 1");
		Assertions.assertEquals(BrandDto.class, response.getBody().get(0).getClass(), "Should return a list of BrandResponseDto");
	}
	
	@Test
	void whenCreateThenReturnSuccess() {
		doNothing().when(brandService).save(any(BrandModel.class));
		ResponseEntity<String> response = brandController.create(brand);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Should return a status code 201");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully created", response.getBody());
	}
	
	@Test
	void whenCreateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(brandService).save(any());
		ResponseEntity<String> response = brandController.create(brand);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to save!", response.getBody());
	}	
	
	@Test
	void whenUpdateThenReturnSuccess() {
		when(brandService.findById(any(Long.class))).thenReturn(Optional.of(brand));
		doNothing().when(brandService).save(any(BrandModel.class));
		doNothing().when(brandService).save(any(BrandModel.class));
		ResponseEntity<String> response = brandController.update((long) 1, brand);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully updated", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnNotFound() {
		when(brandService.findById(any(Long.class))).thenReturn(Optional.empty());
		doNothing().when(brandService).save(any(BrandModel.class));
		doNothing().when(brandService).save(any(BrandModel.class));
		ResponseEntity<String> response = brandController.update((long) 9, brand);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 404");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(brandService).findById(any());
		doNothing().when(brandService).save(any(BrandModel.class));
		doNothing().when(brandService).save(any(BrandModel.class));
		ResponseEntity<String> response = brandController.update((long) 9, brand);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to update!", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnSuccess() {
		doNothing().when(brandService).delete(any(Long.class));
		ResponseEntity<String> response = brandController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals("Successfully deleted", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnNotFound() {
		doThrow(IllegalArgumentException.class).when(brandService).delete(any());
		ResponseEntity<String> response = brandController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 204");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
}
