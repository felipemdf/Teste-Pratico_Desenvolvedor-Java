package com.felipemdf.server.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.felipemdf.server.model.BrandModel;

public interface BrandRepository extends JpaRepository<BrandModel, Long>{
	
	@Query(
			value = "SELECT * from brands b  "
				  + "WHERE (:id IS NULL OR b.id = :id) "
				  + "AND (:name IS NULL OR b.name like '%'  || :name || '%') "
				  + "ORDER BY b.id ASC", 
			nativeQuery = true)
	ArrayList<BrandModel> findWithFilters(@Param("id") Optional<Long> id, @Param("name") Optional<String> name);
	
}
