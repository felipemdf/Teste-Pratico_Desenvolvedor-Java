package com.felipemdf.client.dtos;

import java.math.BigDecimal;
import java.util.Date;


public class CarDto {
    private Integer id; //
    private String name; 
    private String description; 
    private BigDecimal dailyRate;  
    private Boolean avaliable;
    private String licensePlate; 
    private Integer brandId; 
    private Integer categoryId;
    private String color;

  public CarDto(Integer id, String name, String licensePlate) {
      this.id = id;
      this.name = name;
      this.licensePlate = licensePlate;
  }
    public CarDto() {}
    public CarDto(Integer id, String name, String description, BigDecimal dailyRate, Boolean avaliable, String licensePlate, Integer brandId, Integer categoryId, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dailyRate = dailyRate;
        this.avaliable = avaliable;
        this.licensePlate = licensePlate;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.color = color;
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
