package lv.javaguru.novopol.dal.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.domain.Product;

public class ProductDAOImpl extends DAOImpl implements ProductDAO {

	public ProductDAOImpl() {
		super();
	}
	
	public ProductDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber,entriesPerPage);
	}
	
	public UUID addProduct(Product Product) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateProduct(Product Product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByKeywords(List<String> keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsBySurfaceType(String surfaceType) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByCollection(String collection) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByProducer(String producer) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsBySupplier(String supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByPrice(Integer minPrice, Integer maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductsByDates(LocalDate startDate, LocalDate finishDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeProduct(Product Product) {
		// TODO Auto-generated method stub
		return false;
	}

}
