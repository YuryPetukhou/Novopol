package lv.javaguru.novopol.logic.api.product;

import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Producer;
import lv.javaguru.novopol.domain.Supplier;

public class ListProductsRequest {

	private UUID id;
	private List<UUID> ids;
	private int strengthGradeMin;
	private int strengthGradeMax;
	private String wearResistanceGradeMin;
	private String wearResistanceGradeMax;
	private String codeNumber;
	private double priceDisplayedMin;
	private double priceDisplayedMax;
	private double priceRealMin;
	private double priceRealMinMax;
	private Collection collection;
	private Producer producer;
	private Supplier supplier;
	private String surfaceType;
	
	public ListProductsRequest() {
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public List<UUID> getIds() {
		return ids;
	}
	public void setIds(List<UUID> ids) {
		this.ids = ids;
	}
	public int getStrengthGradeMin() {
		return strengthGradeMin;
	}
	public void setStrengthGradeMin(int strengthGradeMin) {
		this.strengthGradeMin = strengthGradeMin;
	}
	public int getStrengthGradeMax() {
		return strengthGradeMax;
	}
	public void setStrengthGradeMax(int strengthGradeMax) {
		this.strengthGradeMax = strengthGradeMax;
	}
	public String getWearResistanceGradeMin() {
		return wearResistanceGradeMin;
	}
	public void setWearResistanceGradeMin(String wearResistanceGradeMin) {
		this.wearResistanceGradeMin = wearResistanceGradeMin;
	}
	public String getWearResistanceGradeMax() {
		return wearResistanceGradeMax;
	}
	public void setWearResistanceGradeMax(String wearResistanceGradeMax) {
		this.wearResistanceGradeMax = wearResistanceGradeMax;
	}
	public String getCodeNumber() {
		return codeNumber;
	}
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}
	public double getPriceDisplayedMin() {
		return priceDisplayedMin;
	}
	public void setPriceDisplayedMin(double priceDisplayedMin) {
		this.priceDisplayedMin = priceDisplayedMin;
	}
	public double getPriceDisplayedMax() {
		return priceDisplayedMax;
	}
	public void setPriceDisplayedMax(double priceDisplayedMax) {
		this.priceDisplayedMax = priceDisplayedMax;
	}
	public double getPriceRealMin() {
		return priceRealMin;
	}
	public void setPriceRealMin(double priceRealMin) {
		this.priceRealMin = priceRealMin;
	}
	public double getPriceRealMinMax() {
		return priceRealMinMax;
	}
	public void setPriceRealMinMax(double priceRealMinMax) {
		this.priceRealMinMax = priceRealMinMax;
	}
	public Collection getCollection() {
		return collection;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getSurfaceType() {
		return surfaceType;
	}
	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}	

	
	
}
