package com.felipemdf.server.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "specification")
@Entity
public class SpecificationModel extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 500)
	private String description;
	
	@ManyToMany(mappedBy = "specifications")
	private List<CarModel> cars;

	public SpecificationModel() {}
	
	public SpecificationModel(Long id, String name, String description, List<CarModel> cars) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.cars = cars;
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

	public List<CarModel> getCars() {
		return cars;
	}

	public void setCars(List<CarModel> cars) {
		this.cars = cars;
	}

	
	
}
