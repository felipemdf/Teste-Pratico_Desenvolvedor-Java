package com.felipemdf.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.felipemdf.server.model.CarImageModel;


public interface CarImageRepository extends JpaRepository<CarImageModel, Long>{

	@Query(
			value = "SELECT * from car_images c  "
				  + "WHERE c.car_id = :carId "
				  + "ORDER BY c.id ASC", 
			nativeQuery = true)
	List<CarImageModel> findByCarId(@Param("carId") Long carId);
}
