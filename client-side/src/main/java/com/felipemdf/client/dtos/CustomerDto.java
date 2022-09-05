package com.felipemdf.client.dtos;

import java.util.Date;


public class CustomerDto {
    private Integer id; //
    private String name; 
    private Date birthDate; 
    private String email;  
    private String driverLicense; 
    private String address; 
    private String phoneNumber;

     public CustomerDto(Integer id, String name, String driverLicense) {
        this(id, name, null, null, driverLicense, null, null);
    }
     
    public CustomerDto(Integer id, String name, Date birthDate, String email, String driverLicense, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.driverLicense = driverLicense;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
                
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    
}
