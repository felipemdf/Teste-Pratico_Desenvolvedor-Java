package com.felipemdf.server.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "cars")
@Entity
public class CarModel extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 500)
	private String description;
	
	@Column(name = "daily_rate", nullable = false, length = 500)
	private BigDecimal dailyRate;
	
	@Column(nullable = false, columnDefinition = "boolean default true")
	private Boolean avaliable;
	
	@Column(name = "license_plate", nullable = false)
	private String licensePlate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private BrandModel brand;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private CategoryModel category;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.MERGE)
    private List<CarImageModel> images;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.MERGE)
    private List<RentalModel> rentals;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "car_specifications", 
		joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "specification_id", referencedColumnName = "id"))
    private List<SpecificationModel> specifications;
	
	@Column(nullable = false)
	private String color;

	public CarModel() {}
	
	public CarModel(Long id) {
		this.id = id;
	}
	public CarModel(
			Long id,
			String name, 
			String description, 
			BigDecimal dailyRate, 
			Boolean avaliable,
			String licensePlate, 
			BrandModel brand, 
			CategoryModel category, 
			List<CarImageModel> images,
			List<RentalModel> rentals, 
			List<SpecificationModel> specifications, 
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
		this.images = images;
		this.rentals = rentals;
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

	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public List<CarImageModel> getImages() {
		return images;
	}

	public void setImages(List<CarImageModel> images) {
		this.images = images;
	}

	public List<RentalModel> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentalModel> rentals) {
		this.rentals = rentals;
	}

	public List<SpecificationModel> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<SpecificationModel> specifications) {
		this.specifications = specifications;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	
	
}
