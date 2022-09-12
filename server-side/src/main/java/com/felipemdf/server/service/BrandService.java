package com.felipemdf.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felipemdf.server.dto.BrandDto;
import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.repository.BrandRepository;

@Service
public class BrandService {

	Logger log = LoggerFactory.getLogger(BrandService.class);
	
	@Autowired
	private BrandRepository brandRepository;
	
	
	public ArrayList<BrandModel> findAll() {
		return (ArrayList<BrandModel>) brandRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public ArrayList<BrandModel> findWithFilters(Optional<Long> id, Optional<String> name) {
		return (ArrayList<BrandModel>) brandRepository.findWithFilters(id, name);
	}


	public void save(BrandModel brand)throws IllegalArgumentException  {
		brandRepository.save(brand);
		
	}


	public void delete(Long id) {
		brandRepository.deleteById(id);
	}


	public Optional<BrandModel> findById(Long id) {
		return brandRepository.findById(id);
		
	}
}
