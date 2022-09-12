package com.felipemdf.server.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.felipemdf.server.model.SpecificationModel;


public class SpecificationDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	
	
	public SpecificationDto() {
		
	}
	
	public SpecificationDto(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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


	public static ArrayList<SpecificationDto> toListDto(List<SpecificationModel> listSpecifications) {
		
		ArrayList<SpecificationDto> listDtos = new ArrayList<>();
		
		listSpecifications.forEach(s -> listDtos.add(new SpecificationDto(s.getId(), s.getName(), s.getDescription())));
		
		return listDtos;
	}
	
	public static SpecificationDto toDto(SpecificationModel specification) {
			return new SpecificationDto(specification.getId(), specification.getName(), specification.getDescription());
	}
}
