package com.felipemdf.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipemdf.server.model.RentalModel;

public interface RentalRepository extends JpaRepository<RentalModel, Long>{

}
