/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;


public class CategoryDto {
    private Integer id;
    private String name;
    private String description;


    public CategoryDto(String name) {
        this(null, name, null);
    }
    
    public CategoryDto(Integer id, String name) {
       this(id, name, null);
    }
     
     public CategoryDto(String name, String description) {
       this(null, name, description);
    }
    
    public CategoryDto(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    
    
}
