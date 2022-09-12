package com.felipemdf.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipemdf.server.repository.CarRepository;
import com.felipemdf.server.repository.CategoryRepository;
import com.felipemdf.server.repository.CustomerRepository;
import com.felipemdf.server.repository.SpecificationRepository;

@Service
public class CustomerService {

	Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;
}
