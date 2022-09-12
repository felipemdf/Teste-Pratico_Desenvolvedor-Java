
package com.felipemdf.client.dtos;

import java.io.Serializable;


public class CarImageDto implements Serializable{
    private Long id;
    private CarDto car;
    private String image;


    public CarImageDto () {}
    
    public CarImageDto(String image) {
        this.image = image;
        this.car = new CarDto();
    }
    
    public CarImageDto(Long id, CarDto car,String image) {
        this.id = id;
        this.image = image;
        this.car = car;
    }

        public CarImageDto(Long id, String image) {
        this.id = id;
        this.image = image;
        this.car = new CarDto();
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

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

}
