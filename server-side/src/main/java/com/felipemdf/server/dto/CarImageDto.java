package com.felipemdf.server.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.felipemdf.server.model.CarImageModel;
import com.felipemdf.server.model.CarModel;
import com.felipemdf.server.model.SpecificationModel;


public class CarImageDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CarDto car;
	private String image;
	
	
	public CarImageDto() {
		
	}
	
	public CarImageDto(Long id, byte[] image) {
		this.id = id;
		this.image = Base64.getEncoder().encodeToString(image);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public CarDto getCar() {
		return car;
	}

	public void setCar(CarDto car) {
		this.car = car;
	}

	public static ArrayList<CarImageDto> toListDto(List<CarImageModel> listCarImage) {
		
		ArrayList<CarImageDto> listDtos = new ArrayList<>();
		
		listCarImage.forEach(s -> listDtos.add(new CarImageDto(s.getId(), s.getImage())));
		
		return listDtos;
	}
	
	public static CarImageDto toDto(CarImageModel carImage) {
			return new CarImageDto(carImage.getId(), carImage.getImage());
	}
	
	public static CarImageModel toModel(CarImageDto dto) {
		byte[] imageBytes = DatatypeConverter.parseBase64Binary(dto.getImage());
		return new CarImageModel(new CarModel(dto.getCar().getId()), imageBytes);
}
}
