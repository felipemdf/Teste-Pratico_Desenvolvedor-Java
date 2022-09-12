/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipemdf.client.dtos;

import java.io.Serializable;

public class CategoryDto implements Serializable{

    private Long id;
    private String name;
    private String description;

    public CategoryDto() {
    }
      
    public CategoryDto(Long id) {
        this.id = id;
    }

    public CategoryDto(String name) {
        this(null, name, null);
    }

    public CategoryDto(Long id, String name) {
        this(id, name, null);
    }

    public CategoryDto(String name, String description) {
        this(null, name, description);
    }

    public CategoryDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

}
