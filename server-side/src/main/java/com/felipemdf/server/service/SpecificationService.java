package com.felipemdf.server.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.felipemdf.server.model.SpecificationModel;
import com.felipemdf.server.repository.SpecificationRepository;

@Service
public class SpecificationService {

	Logger log = LoggerFactory.getLogger(SpecificationService.class);
	
	@Autowired
	private SpecificationRepository specificationRepository;
	
	public ArrayList<SpecificationModel> findAll() {
		return (ArrayList<SpecificationModel>) specificationRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public ArrayList<SpecificationModel> findWithFilters(Optional<Long> id, Optional<String> name) {
		return (ArrayList<SpecificationModel>) specificationRepository.findWithFilters(id, name);
	}


	public void save(SpecificationModel specification)throws IllegalArgumentException  {
		specificationRepository.save(specification);
		
	}


	public void delete(Long id) {
		specificationRepository.deleteById(id);
	}


	public Optional<SpecificationModel> findById(Long id) {
		return specificationRepository.findById(id);
		
	}
}
