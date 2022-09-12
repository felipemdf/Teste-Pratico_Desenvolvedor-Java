package com.felipemdf.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felipemdf.server.model.CategoryModel;
import com.felipemdf.server.repository.CategoryRepository;

@Service
public class CategoryService {

	Logger log = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ArrayList<CategoryModel> findAll() {
		return (ArrayList<CategoryModel>) categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public ArrayList<CategoryModel> findWithFilters(Optional<Long> id, Optional<String> name) {
		return (ArrayList<CategoryModel>) categoryRepository.findWithFilters(id, name);
	}


	public void save(CategoryModel brand)throws IllegalArgumentException  {
		categoryRepository.save(brand);
		
	}


	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}


	public Optional<CategoryModel> findById(Long id) {
		return categoryRepository.findById(id);
		
	}
}
