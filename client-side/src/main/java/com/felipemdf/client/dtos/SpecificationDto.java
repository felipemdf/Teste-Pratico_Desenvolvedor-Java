package com.felipemdf.client.dtos;


public class SpecificationDto {
    private Integer id;
    private String specification;


     public SpecificationDto(String specification) {
        this.specification = specification;
    }
    
    public SpecificationDto(Integer id, String specification) {
        this.id = id;
        this.specification = specification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
    
    
}
