package com.felipemdf.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipemdf.server.repository.CarRepository;
import com.felipemdf.server.repository.CategoryRepository;
import com.felipemdf.server.repository.CustomerRepository;
import com.felipemdf.server.repository.RentalRepository;
import com.felipemdf.server.repository.SpecificationRepository;

@Service
public class RentalService {

	Logger log = LoggerFactory.getLogger(RentalService.class);
	
	@Autowired
	private RentalRepository rentalRepository;
}
