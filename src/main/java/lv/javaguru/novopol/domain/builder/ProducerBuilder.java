package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.UUID;

import lv.javaguru.novopol.domain.Producer;

public class ProducerBuilder {
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
	

	
	public static ProducerBuilder createProducer() {
		return new ProducerBuilder();
	}
	
	public ProducerBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public ProducerBuilder withCountry(String country) {
		this.country= country;
		return this;
	}
	public ProducerBuilder withState(String state) {
		this.state= state;
		return this;
	}
	public ProducerBuilder withCity(String city) {
		this.city= city;
		return this;
	}
	public ProducerBuilder withZipCode(String zipCode) {
		this.zipCode= zipCode;
		return this;
	}
	public ProducerBuilder withStreet(String street) {
		this.street= street;
		return this;
	}
	public ProducerBuilder withHouse(String house) {
		this.house= house;
		return this;
	}
	public ProducerBuilder withOffice(String office) {
		this.office= office;
		return this;
	}
	public ProducerBuilder withPhone(String phone) {
		this.phone= phone;
		return this;
	}
	public ProducerBuilder withEmail(String email) {
		this.email= email;
		return this;
	}
	public ProducerBuilder withWebsite(String website) {
		this.website=website ;
		return this;
	}
	public ProducerBuilder withContactPerson(String contactPerson) {
		this.contactPerson=contactPerson;
		return this;
	}
	public ProducerBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public ProducerBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public ProducerBuilder withupdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public ProducerBuilder withcreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public ProducerBuilder withupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	public Producer build() {
		Producer producer = new Producer();
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
