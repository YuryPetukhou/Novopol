package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.ProductSQLFactory;
import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Product;

public class ProductDAOImpl extends DAOImpl implements ProductDAO {

	private ProductSQLFactory sqlFactory = new ProductSQLFactory();

	public ProductDAOImpl() {
		super();
	}

	public ProductDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber, entriesPerPage);
	}

	public Product addProduct(Product product) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertProductStatement(connection, product);
				ResultSet rs = statement.executeQuery();) {
			if (rs.next()) {
				product.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

		if (product.getCollection() != null) {
			insertCollectionLine(product);
		}
		if (product.getSupplier() != null) {
			insertCollectionLine(product);
		}
		if (product.getSurfaceType() != null) {
			insertSurfaceTypeLine(product);
		}

		return product;

	}

	private void insertSurfaceTypeLine(Product product) {
		String surfaceType = product.getSurfaceType();
		SurfaceTypeDAO surfaceTypeDAO = new SurfaceTypeDAOImpl();
		UUID surfaceTypeId = surfaceTypeDAO.getSurfaceTypeId(surfaceType);
		if (surfaceTypeId == null) {
			surfaceTypeId = surfaceTypeDAO.insertSurfaceType(surfaceType);
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertProductSurfaceType(connection, product,
						surfaceTypeId);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

	}

	private void insertCollectionLine(Product product) {
		Collection collection = product.getCollection();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertProductCollection(connection, product,
						collection.getId());) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

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
