package com.felipemdf.server.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipemdf.server.model.SpecificationModel;

public interface SpecificationRepository extends JpaRepository<SpecificationModel, Long>{

	@Query(
			value = "SELECT * from specifications s  "
				  + "WHERE (:id IS NULL OR s.id = :id) "
				  + "AND (:name IS NULL OR s.name like '%'  || :name || '%') "
				  + "ORDER BY s.id ASC", 
			nativeQuery = true)
	ArrayList<SpecificationModel> findWithFilters(Optional<Long> id, Optional<String> name);

}
