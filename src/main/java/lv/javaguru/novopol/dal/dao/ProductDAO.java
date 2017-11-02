package lv.javaguru.novopol.dal.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Product;

public interface ProductDAO {
	Product addProduct(Product Product);
	boolean updateProduct(Product Product);
	List<Product> getAllProducts ();
	List<Product> getProductsByKeywords (List<String> keywords);
	List<Product> getProductsBySurfaceType (String surfaceType);
	List<Product> getProductsByCollection (String collection);
	List<Product> getProductsByProducer (String producer);
	List<Product> getProductsBySupplier (String supplier);
	List<Product> getProductsByPrice (Integer minPrice, Integer maxPrice);
	List<Product> getProductsByDates (LocalDate startDate, LocalDate finishDate);
	boolean removeProduct(Product Product);
}
