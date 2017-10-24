package lv.javaguru.novopol.domain;

import java.io.FileInputStream;
import java.util.UUID;

public class Product extends Entity {
	
	private UUID id;
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
	private Producer producer;
	private Supplier supplier;
	private String surfaceType;	
	private String thumbnailImageFileName;
	private FileInputStream thumbnailImageStream;
	private String fullsizeImageFileName;
	private FileInputStream fullsizeImageStream;
	
	public Product() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codeNumber == null) ? 0 : codeNumber.hashCode());
		result = prime * result + ((collection == null) ? 0 : collection.hashCode());
		result = prime * result + ((fullsizeImageFileName == null) ? 0 : fullsizeImageFileName.hashCode());
		result = prime * result + ((fullsizeImageStream == null) ? 0 : fullsizeImageStream.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(metersInPack);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		result = prime * result + ((thumbnailImageFileName == null) ? 0 : thumbnailImageFileName.hashCode());
		result = prime * result + ((thumbnailImageStream == null) ? 0 : thumbnailImageStream.hashCode());
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
		if (fullsizeImageFileName == null) {
			if (other.fullsizeImageFileName != null)
				return false;
		} else if (!fullsizeImageFileName.equals(other.fullsizeImageFileName))
			return false;
		if (fullsizeImageStream == null) {
			if (other.fullsizeImageStream != null)
				return false;
		} else if (!fullsizeImageStream.equals(other.fullsizeImageStream))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(metersInPack) != Double.doubleToLongBits(other.metersInPack))
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
		if (thumbnailImageFileName == null) {
			if (other.thumbnailImageFileName != null)
				return false;
		} else if (!thumbnailImageFileName.equals(other.thumbnailImageFileName))
			return false;
		if (thumbnailImageStream == null) {
			if (other.thumbnailImageStream != null)
				return false;
		} else if (!thumbnailImageStream.equals(other.thumbnailImageStream))
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
		return "Product [id=" + id + ", sizeOne=" + sizeOne + ", sizeTwo=" + sizeTwo + ", sizeThree=" + sizeThree
				+ ", strengthGrade=" + strengthGrade + ", wearResistanceGrade=" + wearResistanceGrade + ", codeNumber="
				+ codeNumber + ", priceDisplayed=" + priceDisplayed + ", priceReal=" + priceReal + ", numberInPack="
				+ numberInPack + ", metersInPack=" + metersInPack + ", collection=" + collection + ", producer="
				+ producer + ", supplier=" + supplier + ", surfaceType=" + surfaceType + ", thumbnailImageFileName="
				+ thumbnailImageFileName + ", thumbnailImageStream=" + thumbnailImageStream + ", fullsizeImageFileName="
				+ fullsizeImageFileName + ", fullsizeImageStream=" + fullsizeImageStream + "]";
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getThumbnailImageFileName() {
		return thumbnailImageFileName;
	}

	public void setThumbnailImageFileName(String thumbnailImageFileName) {
		this.thumbnailImageFileName = thumbnailImageFileName;
	}

	public FileInputStream getThumbnailImageStream() {
		return thumbnailImageStream;
	}

	public void setThumbnailImageStream(FileInputStream thumbnailImageStream) {
		this.thumbnailImageStream = thumbnailImageStream;
	}

	public String getFullsizeImageFileName() {
		return fullsizeImageFileName;
	}

	public void setFullsizeImageFileName(String fullsizeImageFileName) {
		this.fullsizeImageFileName = fullsizeImageFileName;
	}

	public FileInputStream getFullsizeImageStream() {
		return fullsizeImageStream;
	}

	public void setFullsizeImageStream(FileInputStream fullsizeImageStream) {
		this.fullsizeImageStream = fullsizeImageStream;
	}
}
