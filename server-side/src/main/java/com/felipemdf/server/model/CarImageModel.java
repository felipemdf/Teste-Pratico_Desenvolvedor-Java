package com.felipemdf.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Table(name = "car_images")
@Entity
public class CarImageModel extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
	private CarModel car;
	
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] image;


	public CarImageModel() {}
	
	public CarImageModel(CarModel car, byte[] image) {
		this.car = car;
		this.image = image;
	}
	
	public CarImageModel(Long id, CarModel car, byte[] image) {
		this.id = id;
		this.car = car;
		this.image = image;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarModel getCar() {
		return car;
	}

	public void setCar(CarModel car) {
		this.car = car;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}
