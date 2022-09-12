package com.felipemdf.server.dto;


import java.io.Serializable;
import java.util.ArrayList;

import com.felipemdf.server.model.BrandModel;
import com.felipemdf.server.model.CategoryModel;


public class CategoryDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	
	
	public CategoryDto() {
		
	}
	
	public CategoryDto(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public CategoryDto(Long categoryId) {
		this.id = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static ArrayList<CategoryDto> toListDto(ArrayList<CategoryModel> listCategories) {
		
		ArrayList<CategoryDto> listDtos = new ArrayList<>();
		
		listCategories.forEach(c -> listDtos.add(new CategoryDto(c.getId(), c.getName(), c.getDescription())));
		
		return listDtos;
	}
	
	public static CategoryDto toDto(CategoryModel category) {
			return new CategoryDto(category.getId(), category.getName(), category.getDescription());
	}
}
