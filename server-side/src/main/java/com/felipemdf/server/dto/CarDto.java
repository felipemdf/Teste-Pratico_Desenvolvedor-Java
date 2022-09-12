package com.felipemdf.server.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.felipemdf.server.model.CarImageModel;
import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.model.SpecificationModel;


public class CarDto implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String name;
	private String description;
	private BigDecimal dailyRate;
	private Boolean avaliable;
	private String licensePlate;
	private BrandDto brand;
	private CategoryDto category;
    private ArrayList<SpecificationDto> specifications;
    private String color;

    
    
    public CarDto() {};
    
	public CarDto(
			Long id,
			String name, 
			String description, 
			BigDecimal dailyRate, 
			Boolean avaliable, 
			String licensePlate,
			BrandDto brand, 
			CategoryDto category, 
			ArrayList<SpecificationDto> specifications,
			String color
	) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dailyRate = dailyRate;
		this.avaliable = avaliable;
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.category = category;
		this.specifications = specifications;
		this.color = color;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(BigDecimal dailyRate) {
		this.dailyRate = dailyRate;
	}

	public Boolean getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(Boolean avaliable) {
		this.avaliable = avaliable;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public BrandDto getBrand() {
		return brand;
	}

	public void setBrand(BrandDto brand) {
		this.brand = brand;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public ArrayList<SpecificationDto> getSpecifications() {
		return specifications;
	}

	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpecifications(ArrayList<SpecificationDto> specifications) {
		this.specifications = specifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static ArrayList<CarDto> toListDto(ArrayList<CarModel> listCar) {
		
		ArrayList<CarDto> listDtos = new ArrayList<>();
		ArrayList<Long> specificationsId;


		for (CarModel car : listCar) {
			listDtos.add(new CarDto(
					car.getId(),
					car.getName(),
					car.getDescription(),
					car.getDailyRate(),
					car.getAvaliable(),
					car.getLicensePlate(),
					BrandDto.toDto(car.getBrand()),
					CategoryDto.toDto(car.getCategory()),
					SpecificationDto.toListDto(car.getSpecifications()),
					car.getColor()
			));
		}

		return listDtos;
	}
	
	public static CarDto toDto(CarModel car) {
	
		return new CarDto(
				car.getId(),
				car.getName(),
				car.getDescription(),
				car.getDailyRate(),
				car.getAvaliable(),
				car.getLicensePlate(),
				BrandDto.toDto(car.getBrand()),
				CategoryDto.toDto(car.getCategory()),
				SpecificationDto.toListDto((ArrayList<SpecificationModel>)car.getSpecifications()),
				car.getColor()
		);
	}
	
}
