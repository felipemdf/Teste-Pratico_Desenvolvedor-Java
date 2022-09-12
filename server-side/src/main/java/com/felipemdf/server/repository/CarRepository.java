package com.felipemdf.server.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.felipemdf.server.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Long>{

	@Query(
			value = "SELECT * from cars c  "
				  + "WHERE (:id IS NULL OR c.id = :id) "
				  + "AND (:name IS NULL OR c.name like '%'  || :name || '%') "
				  + "AND (:licensePlate IS NULL OR c.license_plate like '%'  || :licensePlate || '%') "
				  + "ORDER BY c.id ASC", 
			nativeQuery = true)
	ArrayList<CarModel> findWithFilters(@Param("id") Optional<Long> id, @Param("name") Optional<String> name, @Param("licensePlate") Optional<String> licensePlate);

}
