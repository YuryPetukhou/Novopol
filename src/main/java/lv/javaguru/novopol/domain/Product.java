package lv.javaguru.novopol.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="public.items")
public class Product extends DomainObject {
	
	
	private int sizeOne;
	private int sizeTwo;
	private int sizeThree;
	private int strengthGrade;
	private String wearResistanceGrade;
	private String codeNumber;
	private String name;
	private double priceDisplayed;
	private double priceReal;
	private int numberInPack;
	private double metersInPack;
	private Collection collection;
	private Producer producer;
	private Supplier supplier;
	private String surfaceType;
	private String thumbnailImageUri;
	private String fullsizeImageUri;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeNumber == null) ? 0 : codeNumber.hashCode());
		result = prime * result + ((collection == null) ? 0 : collection.hashCode());
		result = prime * result + ((fullsizeImageUri == null) ? 0 : fullsizeImageUri.hashCode());
		long temp;
		temp = Double.doubleToLongBits(metersInPack);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberInPack;
		temp = Double.doubleToLongBits(priceDisplayed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceReal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + sizeOne;
		result = prime * result + sizeThree;
		result = prime * result + sizeTwo;
		result = prime * result + strengthGrade;
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		result = prime * result + ((surfaceType == null) ? 0 : surfaceType.hashCode());
		result = prime * result + ((thumbnailImageUri == null) ? 0 : thumbnailImageUri.hashCode());
		result = prime * result + ((wearResistanceGrade == null) ? 0 : wearResistanceGrade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (codeNumber == null) {
			if (other.codeNumber != null)
				return false;
		} else if (!codeNumber.equals(other.codeNumber))
			return false;
		if (collection == null) {
			if (other.collection != null)
				return false;
		} else if (!collection.equals(other.collection))
			return false;
		if (fullsizeImageUri == null) {
			if (other.fullsizeImageUri != null)
				return false;
		} else if (!fullsizeImageUri.equals(other.fullsizeImageUri))
			return false;
	
		if (Double.doubleToLongBits(metersInPack) != Double.doubleToLongBits(other.metersInPack))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberInPack != other.numberInPack)
			return false;
		if (Double.doubleToLongBits(priceDisplayed) != Double.doubleToLongBits(other.priceDisplayed))
			return false;
		if (Double.doubleToLongBits(priceReal) != Double.doubleToLongBits(other.priceReal))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (sizeOne != other.sizeOne)
			return false;
		if (sizeThree != other.sizeThree)
			return false;
		if (sizeTwo != other.sizeTwo)
			return false;
		if (strengthGrade != other.strengthGrade)
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		if (surfaceType == null) {
			if (other.surfaceType != null)
				return false;
		} else if (!surfaceType.equals(other.surfaceType))
			return false;
		if (thumbnailImageUri == null) {
			if (other.thumbnailImageUri != null)
				return false;
		} else if (!thumbnailImageUri.equals(other.thumbnailImageUri))
			return false;
		if (wearResistanceGrade == null) {
			if (other.wearResistanceGrade != null)
				return false;
		} else if (!wearResistanceGrade.equals(other.wearResistanceGrade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [sizeOne=" + sizeOne + ", sizeTwo=" + sizeTwo + ", sizeThree=" + sizeThree
				+ ", strengthGrade=" + strengthGrade + ", wearResistanceGrade=" + wearResistanceGrade + ", codeNumber="
				+ codeNumber + ", name=" + name + ", priceDisplayed=" + priceDisplayed + ", priceReal=" + priceReal
				+ ", numberInPack=" + numberInPack + ", metersInPack=" + metersInPack + ", collection=" + collection
				+ ", producer=" + producer + ", supplier=" + supplier + ", surfaceType=" + surfaceType
				+ ", thumbnailImageUri=" + thumbnailImageUri + ", fullsizeImageUri=" + fullsizeImageUri + "]";
	}

	public Product() {
	}

	public int getSizeOne() {
		return sizeOne;
	}

	public void setSizeOne(int sizeOne) {
		this.sizeOne = sizeOne;
	}

	public int getSizeTwo() {
		return sizeTwo;
	}

	public void setSizeTwo(int sizeTwo) {
		this.sizeTwo = sizeTwo;
	}

	public int getSizeThree() {
		return sizeThree;
	}

	public void setSizeThree(int sizeThree) {
		this.sizeThree = sizeThree;
	}

	public int getStrengthGrade() {
		return strengthGrade;
	}

	public void setStrengthGrade(int strengthGrade) {
		this.strengthGrade = strengthGrade;
	}

	public String getWearResistanceGrade() {
		return wearResistanceGrade;
	}

	public void setWearResistanceGrade(String wearResistanceGrade) {
		this.wearResistanceGrade = wearResistanceGrade;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public double getPriceDisplayed() {
		return priceDisplayed;
	}

	public void setPriceDisplayed(double priceDisplayed) {
		this.priceDisplayed = priceDisplayed;
	}

	public double getPriceReal() {
		return priceReal;
	}

	public void setPriceReal(double priceReal) {
		this.priceReal = priceReal;
	}

	public int getNumberInPack() {
		return numberInPack;
	}

	public void setNumberInPack(int numberInPack) {
		this.numberInPack = numberInPack;
	}

	public double getMetersInPack() {
		return metersInPack;
	}

	public void setMetersInPack(double metersInPack) {
		this.metersInPack = metersInPack;
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

	public String getThumbnailImageUri() {
		return thumbnailImageUri;
	}

	public void setThumbnailImageUri(String thumbnailImageUri) {
		this.thumbnailImageUri = thumbnailImageUri;
	}

	public String getFullsizeImageUri() {
		return fullsizeImageUri;
	}

	public void setFullsizeImageUri(String fullsizeImageUri) {
		this.fullsizeImageUri = fullsizeImageUri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
