package com.felipemdf.server.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "customers")
@Entity
public class CustomerModel extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	
	@Column(nullable = false)
	private String email;
	
	@Column(name = "driver_license", nullable = false, unique = true)
	private String driverLicense;
	
	@Column(nullable = false)
	private String address;
	
	@Column(name = "phone_numbe", nullable = false)
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<RentalModel> rentals;

	public CustomerModel(Long id, String name, LocalDate birthDate, String email, String driverLicense, String address,
			String phoneNumber, List<RentalModel> rentals) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.driverLicense = driverLicense;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rentals = rentals;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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

	public List<RentalModel> getRentals() {
		return rentals;
	}

	public void setRentals(List<RentalModel> rentals) {
		this.rentals = rentals;
	}
	
	
}
