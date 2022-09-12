package com.felipemdf.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipemdf.server.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

}
