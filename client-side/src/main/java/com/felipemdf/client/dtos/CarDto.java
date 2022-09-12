package com.felipemdf.client.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CarDto implements Serializable{

    private Long id; //
    private String name;
    private String description;
    private BigDecimal dailyRate;
    private Boolean avaliable;
    private String licensePlate;
    private BrandDto brand;
    private CategoryDto category;
    private ArrayList<SpecificationDto> specifications;
    private String color;

    public CarDto() {}

    public CarDto(Long id, String name, String licensePlate) {
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
    }

    public CarDto(Long id, String name, String description, BigDecimal dailyRate, Boolean avaliable, String licensePlate, BrandDto brand, CategoryDto category, ArrayList<SpecificationDto> specifications, String color) {
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

    public void setSpecifications(ArrayList<SpecificationDto> specifications) {
        this.specifications = specifications;
    }


    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

}
