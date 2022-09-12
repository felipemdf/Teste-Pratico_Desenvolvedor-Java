package com.felipemdf.server.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipemdf.server.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	@Query(
			value = "SELECT * from categories c  "
				  + "WHERE (:id IS NULL OR c.id = :id) "
				  + "AND (:name IS NULL OR c.name like '%'  || :name || '%') "
				  + "ORDER BY c.id ASC", 
			nativeQuery = true)
	ArrayList<CategoryModel> findWithFilters(Optional<Long> id, Optional<String> name);

}
