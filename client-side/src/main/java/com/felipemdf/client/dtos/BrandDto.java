/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;

import java.io.Serializable;


public class BrandDto implements Serializable{
    private Long id;
    private String name;


    public BrandDto() {}
    
    public BrandDto(Long id) {
         this.id = id;   
    }
    
    public BrandDto(String name) {
         this.name = name;   
    }
    
    public BrandDto(Long id, String name) {
         this.name = name;   
         this.id = id;
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
}
