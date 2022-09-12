package com.felipemdf.server.dto;


import java.io.Serializable;
import java.util.ArrayList;

import com.felipemdf.server.model.BrandModel;


public class BrandDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	
	public BrandDto() {
		
	}
	
	public BrandDto(Long id) {
		this.id = id;
	}
	
	public BrandDto(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static ArrayList<BrandDto> toListDto(ArrayList<BrandModel> listBrands) {
		
		ArrayList<BrandDto> listDtos = new ArrayList<>();
		
		listBrands.forEach(b -> listDtos.add(new BrandDto(b.getId(), b.getName())));
		
		return listDtos;
	}
	
public static BrandDto toDto(BrandModel brand) {
		return new BrandDto(brand.getId(), brand.getName());
	}
}
