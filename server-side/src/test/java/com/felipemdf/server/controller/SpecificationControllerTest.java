package com.felipemdf.server.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.felipemdf.server.dto.SpecificationDto;
import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.model.SpecificationModel;
import com.felipemdf.server.service.SpecificationService;

@SpringBootTest(classes = {SpecificationController.class, SpecificationService.class})
public class SpecificationControllerTest {

	@Autowired
	SpecificationController specificationController;
	
	@MockBean
	SpecificationService specificationService;
	
	static ArrayList<SpecificationModel> specifications;
	static ArrayList<SpecificationModel> specificationsWithFilter;
	static SpecificationModel specification;
	
	
	@BeforeAll
	static void setup () {
		specifications = new ArrayList<>();
		specifications.add(new SpecificationModel((long) 1, "Felipe", "descricao 1", Arrays.asList(new CarModel((long)1))));
		specifications.add(new SpecificationModel((long) 2, "Joao", "descricao 2", Arrays.asList(new CarModel((long)2))));
		specifications.add(new SpecificationModel((long) 3, "Marcelo", "descricao 3", Arrays.asList(new CarModel((long)2))));
		
		specification = specifications.get(0);
		
		specificationsWithFilter = new ArrayList<>();
		specificationsWithFilter.add(specifications.get(0));
	}

	@Test
	void whenFindAllThenReturnAListOfBrands () {
		when(specificationService.findAll()).thenReturn(specifications);
		
		ResponseEntity<ArrayList<SpecificationDto>> response = specificationController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(3, response.getBody().size(), "Should return size 3");
		Assertions.assertEquals(SpecificationDto.class, response.getBody().get(0).getClass(), "Should return a list of SpecificationDto");
	}
	
	@Test
	void whenFindAllThenReturnAEmptyList () {
		when(specificationService.findAll()).thenReturn(new ArrayList<SpecificationModel>());
		
		ResponseEntity<ArrayList<SpecificationDto>> response = specificationController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(0, response.getBody().size(), "Should return size 0");
	}
	
	@Test
	void whenFindWithFilterThenReturnAListOfBrands () {
		when(specificationService.findWithFilters(any(), any())).thenReturn(specificationsWithFilter);
		
		ResponseEntity<ArrayList<SpecificationDto>> response = specificationController.search(Optional.of(Long.parseLong("1")), Optional.of("Felipe"));
		SpecificationDto expectResult = new SpecificationDto((long) 1, "Felipe", "descricao 1");
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ArrayList.class, response.getBody().getClass(), "Should return a ArrayList");
		Assertions.assertEquals(1, response.getBody().size(), "Should return size 1");
		Assertions.assertEquals(SpecificationDto.class, response.getBody().get(0).getClass(), "Should return a list of BrandResponseDto");
		Assertions.assertEquals(expectResult.getId(), response.getBody().get(0).getId());
		Assertions.assertEquals(expectResult.getName(), response.getBody().get(0).getName());
		Assertions.assertEquals(expectResult.getDescription(), response.getBody().get(0).getDescription());
	}
	
	@Test
	void whenCreateThenReturnSuccess() {
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		ResponseEntity<String> response = specificationController.create(specification);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Should return a status code 201");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully created", response.getBody());
	}
	
	@Test
	void whenCreateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(specificationService).save(any());
		ResponseEntity<String> response = specificationController.create(specification);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to save!", response.getBody());
	}	
	
	@Test
	void whenUpdateThenReturnSuccess() {
		when(specificationService.findById(any(Long.class))).thenReturn(Optional.of(specification));
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		ResponseEntity<String> response = specificationController.update((long) 1, specification);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Successfully updated", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnNotFound() {
		when(specificationService.findById(any(Long.class))).thenReturn(Optional.empty());
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		ResponseEntity<String> response = specificationController.update((long) 9, specification);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 404");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
	
	@Test
	void whenUpdateThenReturnBadRequest() {
		doThrow(IllegalArgumentException.class).when(specificationService).findById(any());
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		doNothing().when(specificationService).save(any(SpecificationModel.class));
		ResponseEntity<String> response = specificationController.update((long) 9, specification);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Should return a status code 400");
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals("Failed to update!", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnSuccess() {
		doNothing().when(specificationService).delete(any(Long.class));
		ResponseEntity<String> response = specificationController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode(), "Should return a status code 200");
		Assertions.assertEquals("Successfully deleted", response.getBody());
	}
	
	@Test
	void whenDeleteThenReturnNotFound() {
		doThrow(IllegalArgumentException.class).when(specificationService).delete(any());
		ResponseEntity<String> response = specificationController.delete((long) 1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(ResponseEntity.class, response.getClass(), "Should return a ResponseEntity");
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return a status code 204");
		Assertions.assertEquals("Data not found!", response.getBody());
	}
}
