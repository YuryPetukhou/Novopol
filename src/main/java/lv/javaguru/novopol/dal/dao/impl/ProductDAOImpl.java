package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.ProductSQLFactory;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Product;
import lv.javaguru.novopol.domain.Supplier;
import lv.javaguru.novopol.domain.builder.CollectionBuilder;
import lv.javaguru.novopol.domain.builder.ProductBuilder;
import lv.javaguru.novopol.domain.builder.SupplierBuilder;

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
			insertSupplierLine(product);
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

	private void insertSupplierLine(Product product) {
		Supplier supplier = product.getSupplier();
		if (supplier != null) {
			UUID supplierId = supplier.getId();
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.insertProductSupplier(connection, product, supplierId);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
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

	public boolean updateProduct(Product product) {
		updateProductTable(product);
		updateProductSurfaceType(product);
		updateProductCollection(product);
		updateProductSupplier(product);
		return false;
	}

	private void updateProductSupplier(Product product) {
		if (product.getSupplier() != null) {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.updateProductSupplier(connection, product);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		} else {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.removeProductSupplier(connection, product);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		}

	}

	private void updateProductCollection(Product product) {
		if (product.getCollection() != null) {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.updateProductCollection(connection, product);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		} else {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.removeProductCollection(connection, product);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		}
	}

	private void updateProductSurfaceType(Product product) {
		if (product.getSurfaceType() != null) {
			UUID surfaceTypeId = (new SurfaceTypeDAOImpl()).getSurfaceTypeId(product.getSurfaceType());
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.updateProductSurfaceType(connection, product,
							surfaceTypeId);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		} else {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.removeProductSurfaceType(connection, product);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		}

	}

	private void updateProductTable(Product product) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateProductTable(connection, product);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

	}

	public List<Product> getAllProducts() {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getAllProductsStatement(connection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;
	}

	private Product prepareProduct(ResultSet resultSet) throws SQLException {
		Supplier supplier = SupplierBuilder.createSupplier().withId((UUID) resultSet.getObject(20))
				.withName(resultSet.getString(21)).build();
		Collection collection = CollectionBuilder.createCollection().withId((UUID) resultSet.getObject(22))
				.withName(resultSet.getString(23)).build();
		Product product = ProductBuilder.createProduct().withId((UUID) resultSet.getObject(1))
				.withCreatedDateTime((LocalDateTime) resultSet.getObject(2))
				.withupdatedDateTime((LocalDateTime) resultSet.getObject(3)).withcreatedBy(resultSet.getString(4))
				.withupdatedBy(resultSet.getString(5)).withSizeOne(resultSet.getInt(6)).withSizeTwo(resultSet.getInt(7))
				.withSizeThree(resultSet.getInt(8)).withStrengthGrade(resultSet.getInt(9))
				.withWearResistanceGrade(resultSet.getString(10)).withCodeNumber(resultSet.getString(11))
				.withName(resultSet.getString(12)).withPriceDisplayed(resultSet.getDouble(13))
				.withPriceReal(resultSet.getDouble(14)).withThumbnailImageUri(resultSet.getString(15))
				.withFullsizeImageUri(resultSet.getString(16)).withNumberInPack(resultSet.getInt(17))
				.withMetersInPack(resultSet.getDouble(18)).withSurfaceType(resultSet.getString(19))
				.withSupplier(supplier).withCollection(collection).build();
		return product;
	}

	public List<Product> getProductsBySurfaceType(String surfaceType) {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getProductsBySurfaceTypeStatement(connection, surfaceType,pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;
	}

	public List<Product> getProductsByCollection(String collection) {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getProductsByCollectionStatement(connection, collection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;
	}

	public List<Product> getProductsByProducer(String producer) {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getProductsByProducerStatement(connection, producer,pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;
	}

	public List<Product> getProductsBySupplier(String supplier) {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getProductsBySupplierStatement(connection, supplier, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;
	}

	public List<Product> getProductsByPrice(Double minPrice, Double maxPrice) {
		List<Product> productsList = new ArrayList<Product>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getProductsByPricesStatement(connection, minPrice, maxPrice, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Product article = prepareProduct(resultSet);
				productsList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return productsList;	}


	public boolean removeProduct(Product product) {
		return removeProduct(product.getId());
	}

	@Override
	public boolean removeProduct(UUID productId) {
		if (productId==null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeProductStatement(connection, productId)) {
			statement.executeUpdate();			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

	
}
