package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.UUID;

import lv.javaguru.novopol.domain.Producer;
import lv.javaguru.novopol.domain.Supplier;

public class SupplierBuilder {
	private UUID id;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private String createdBy;
	private String updatedBy;
	private String name;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String street;
	private String house;
	private String office;
	private String phone;
	private String email;
	private String website;
	private String contactPerson;
	

	
	public static SupplierBuilder createSupplier() {
		return new SupplierBuilder();
	}
	
	public SupplierBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public SupplierBuilder withCountry(String country) {
		this.country= country;
		return this;
	}
	public SupplierBuilder withState(String state) {
		this.state= state;
		return this;
	}
	public SupplierBuilder withCity(String city) {
		this.city= city;
		return this;
	}
	public SupplierBuilder withZipCode(String zipCode) {
		this.zipCode= zipCode;
		return this;
	}
	public SupplierBuilder withStreet(String street) {
		this.street= street;
		return this;
	}
	public SupplierBuilder withHouse(String house) {
		this.house= house;
		return this;
	}
	public SupplierBuilder withOffice(String office) {
		this.office= office;
		return this;
	}
	public SupplierBuilder withPhone(String phone) {
		this.phone= phone;
		return this;
	}
	public SupplierBuilder withEmail(String email) {
		this.email= email;
		return this;
	}
	public SupplierBuilder withWebsite(String website) {
		this.website=website ;
		return this;
	}
	public SupplierBuilder withContactPerson(String contactPerson) {
		this.contactPerson=contactPerson;
		return this;
	}
	public SupplierBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public SupplierBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public SupplierBuilder withupdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public SupplierBuilder withcreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public SupplierBuilder withupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	public Supplier build() {
		Supplier producer = new Supplier();
		producer.setId(id);
		producer.setCreatedDateTime(createdDateTime);
		producer.setUpdatedDateTime(updatedDateTime);
		producer.setCreatedBy(createdBy);
		producer.setUpdatedBy(updatedBy);
		producer.setName(name);
		producer.setCountry(country);
		producer.setState(state);
		producer.setCity(city);
		producer.setZipcode(zipCode);
		producer.setStreet(street);
		producer.setHouse(house);
		producer.setOffice(office);
		producer.setPhone(phone);
		producer.setEmail(email);
		producer.setWebsite(website);
		producer.setContactPerson(contactPerson);	
		return producer;
	}
}
