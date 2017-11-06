package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.UUID;

import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Producer;

public class CollectionBuilder {
	
	private UUID id;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private String createdBy;
	private String updatedBy;
	private String name;
	private Producer producer;
	private String description;

	
	public static CollectionBuilder createCollection() {
		return new CollectionBuilder();
	}
	
	public CollectionBuilder withName(String name) {
		this.name = name;
		return this;
	}
	public CollectionBuilder withProducer(Producer producer) {
		this.producer = producer;
		return this;
	}
	public CollectionBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public CollectionBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public CollectionBuilder withUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public CollectionBuilder withCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public CollectionBuilder withUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	public CollectionBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public Collection build() {
		Collection collection = new Collection();
		collection.setId(id);
		collection.setCreatedDateTime(createdDateTime);
		collection.setUpdatedDateTime(updatedDateTime);
		collection.setCreatedBy(createdBy);
		collection.setUpdatedBy(updatedBy);
		collection.setDescription(description);
		collection.setName(name);
		collection.setProducer(producer);
		return collection;
	}

}
