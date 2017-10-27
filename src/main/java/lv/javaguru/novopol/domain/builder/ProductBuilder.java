package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.UUID;

import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Producer;
import lv.javaguru.novopol.domain.Product;
import lv.javaguru.novopol.domain.Supplier;

public class ProductBuilder {
	private UUID id;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private String createdBy;
	private String updatedBy;
	private int sizeOne;
	private int sizeTwo;
	private int sizeThree;
	private int strengthGrade;
	private String wearResistanceGrade;
	private String codeNumber;
	private double priceDisplayed;
	private double priceReal;
	private int numberInPack;
	private double metersInPack;
	private Collection collection;
	private Supplier supplier;
	private String surfaceType;	
	private String thumbnailImageUri;
	private String fullsizeImageUri;


	
	public static ProductBuilder createProduct() {
		return new ProductBuilder();
	}
	public ProductBuilder withSizeOne(int sizeOne) {
		this.sizeOne = sizeOne;
		return this;
	}
	public ProductBuilder withSizeTwo(int sizeTwo) {
		this.sizeTwo = sizeTwo;
		return this;
	}
	public ProductBuilder withSizeThree(int sizeThree) {
		this.sizeThree = sizeThree;
		return this;
	}	
	public ProductBuilder withStrengthGrade(int strengthGrade) {
		this.strengthGrade = strengthGrade;
		return this;
	}	
	public ProductBuilder withWearResistanceGrade(String wearResistanceGrade) {
		this.wearResistanceGrade = wearResistanceGrade;
		return this;
	}	
	public ProductBuilder withCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
		return this;
	}	
	public ProductBuilder withPriceDisplayed(double priceDisplayed) {
		this.priceDisplayed = priceDisplayed;
		return this;
	}	
	public ProductBuilder withPriceReal(double priceReal) {
		this.priceReal = priceReal;
		return this;
	}	
	public ProductBuilder withMetersInPack(double metersInPack) {
		this.metersInPack= metersInPack;
		return this;
	}	
	public ProductBuilder withNumberInPack(int numberInPack) {
		this.numberInPack= numberInPack;
		return this;
	}	
	public ProductBuilder withCollection(Collection collection) {
		this.collection = collection;
		return this;
	}
	public ProductBuilder withSupplier(Supplier supplier) {
		this.supplier= supplier;
		return this;
	}
	public ProductBuilder withSurfaceType(String surfaceType) {
		this.surfaceType= surfaceType;
		return this;
	}
	public ProductBuilder withThumbnailImageUri(String thumbnailImageUri) {
		this.thumbnailImageUri= thumbnailImageUri;
		return this;
	}
	public ProductBuilder withFullsizeImageUri(String fullsizeImageUri) {
		this.fullsizeImageUri= fullsizeImageUri;
		return this;
	}
	
	public ProductBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public ProductBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public ProductBuilder withupdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public ProductBuilder withcreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public ProductBuilder withupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	public Product build() {
		Product product = new Product();
		product.setId(id);
		product.setCreatedDateTime(createdDateTime);
		product.setUpdatedDateTime(updatedDateTime);
		product.setCreatedBy(createdBy);
		product.setUpdatedBy(updatedBy);
		product.setSizeOne(sizeOne);
		product.setSizeTwo(sizeTwo);
		product.setSizeThree(sizeThree);
		product.setStrengthGrade(strengthGrade);
		product.setWearResistanceGrade(wearResistanceGrade);
		product.setCodeNumber(codeNumber);
		product.setPriceDisplayed(priceDisplayed);
		product.setPriceReal(priceReal);
		product.setNumberInPack(numberInPack);
		product.setMetersInPack(metersInPack);
		product.setCollection(collection);
		product.setSupplier(supplier);
		product.setSurfaceType(surfaceType);	
		product.setThumbnailImageUri(thumbnailImageUri);
		product.setFullsizeImageUri(fullsizeImageUri);

		
		return product;
	}


}
