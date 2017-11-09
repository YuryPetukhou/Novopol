package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lv.javaguru.novopol.domain.Product;

@Component
public class ProductSQLFactory extends SQLStatementFactory {

	private static final String SQL_INSERT_PRODUCT = "INSERT INTO public.items (id,created_dt, updated_dt, created_by,updated_by,size_one, size_two, size_three,strength_grade, wear_resistance_class,code_number,name,price_displayed,price_real,image_thumbnail,image_fullsize,number_in_pack,meters_in_pack) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";
	private static final String SQL_INSERT_PRODUCT_SURFACE_TYPE = "INSERT INTO public.items_surface_types (created_dt, updated_dt, created_by,updated_by,item_id,surface_type_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_INSERT_PRODUCT_COLLECTION = "INSERT INTO public.items_collections (created_dt, updated_dt, created_by,updated_by,item_id,collection_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_INSERT_PRODUCT_SUPPLIER = "INSERT INTO public.items_suppliers (created_dt, updated_dt, created_by,updated_by,item_id,supplier_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_UPDATE_PRODUCT_COLLECTION = "UPDATE public.items_collections SET updated_dt=now(), updated_by='Auto', collection_id=? WHERE item_id=?";
	private static final String SQL_UPDATE_PRODUCT_SURFACE_TYPE = "UPDATE public.items_surface_types SET updated_dt=now(), updated_by='Auto', surface_type_id=? WHERE item_id=?";
	private static final String SQL_UPDATE_PRODUCT_SUPPLIER = "UPDATE public.items_suppliers SET updated_dt=now(), updated_by='Auto', supplier_id=? WHERE item_id=?";
	private static final String SQL_DELETE_PRODUCT_COLLECTION = "DELETE FROM public.items_collections WHERE item_id=?";
	private static final String SQL_DELETE_PRODUCT_SURFACE_TYPE = "DELETE FROM public.items_surface_types WHERE item_id=?";
	private static final String SQL_DELETE_PRODUCT_SUPPLIER = "DELETE FROM public.items_suppliers WHERE item_id=?";
	private static final String SQL_UPDATE_PRODUCT = "UPDATE public.items SET updated_dt=now(), updated_by='Auto',size_one=?, size_two=?, size_three=?,strength_grade=?, wear_resistance_class=?,code_number=?,name=?,price_displayed=?,price_real=?,image_thumbnail=?,image_fullsize=?,number_in_pack=?,meters_in_pack=? WHERE id=?";
	private static final String SQL_SELECT_ALL_PRODUCTS = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,a.name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g.id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id LIMIT ? OFFSET ?";
	private static final String SQL_SELECT_PRODUCTS_BY_SURFACE_TYPE = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE c.type=? LIMIT ? OFFSET ?";
	private static final String SQL_SELECT_PRODUCTS_BY_SUPPLIER = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE g.name=? LIMIT ? OFFSET ?";
	private static final String SQL_SELECT_PRODUCTS_BY_PRODUCER = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE i.name=? LIMIT ? OFFSET ?";
	private static final String SQL_SELECT_PRODUCTS_BY_COLLECTION = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE e.name=? LIMIT ? OFFSET ?";
	private static final String SQL_SELECT_PRODUCTS_BY_PRICE_DISPLAYED = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE a.price_displayed>=? AND a.price_displayed<=? LIMIT ? OFFSET ?";
	//private static final String SQL_SELECT_PRODUCTS_BY_PRICE_REAL = "SELECT a.id,a.created_dt, a.updated_dt, a.created_by,a.updated_by,a.size_one, a.size_two, a.size_three,a.strength_grade, a.wear_resistance_class,a.code_number,name,a.price_displayed,a.price_real,a.image_thumbnail,a.image_fullsize,a.number_in_pack,a.meters_in_pack, c.type, e.id, e.name,g,id,g.name,i.id,i.name FROM items AS a LEFT JOIN public.items_surface_types AS b ON a.id=b.item_id LEFT JOIN public.surface_types AS c ON b.surface_type_id=c.id LEFT JOIN public.items_collections AS d ON a.id=d.item_id LEFT JOIN public.collections AS e ON d.collection_id=e.id LEFT JOIN public.items_suppliers AS f ON a.id=f.item_id LEFT JOIN public.suppliers AS g LEFT JOIN ON f.supplier_id=g.id LEFT JOIN public.collections_producers AS h ON e.id=h.collection_id LEFT JOIN public.producers AS i ON h.producer_id=i.id WHERE a.price_real>=? AND a.price_real<=? LIMIT ? OFFSET ?";
	private static final String SQL_DELETE_PRODUCT_BY_ID ="DELETE FROM public.items WHERE id=?";
	
	
	public PreparedStatement insertProductStatement(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT);
		setProductParameters(product, statement);
		return statement;
	}

	public PreparedStatement insertProductSurfaceType(Connection connection, Product product, UUID surfaceTypeId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT_SURFACE_TYPE);
		statement.setObject(1, product.getId());
		statement.setObject(2, surfaceTypeId);
		return statement;
	}

	public PreparedStatement insertProductCollection(Connection connection, Product product, UUID collectionId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT_COLLECTION);
		statement.setObject(1, product.getId());
		statement.setObject(2, collectionId);
		return statement;
	}

	public PreparedStatement insertProductSupplier(Connection connection, Product product, UUID supplierId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT_SUPPLIER);
		statement.setObject(1, product.getId());
		statement.setObject(2, supplierId);
		return statement;
	}

	public PreparedStatement updateProductCollection(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT_COLLECTION);
		statement.setObject(1, product.getCollection().getId());
		statement.setObject(2, product.getId());
		return statement;
	}

	public PreparedStatement updateProductSurfaceType(Connection connection, Product product, UUID surfaceTypeId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT_SURFACE_TYPE);
		statement.setObject(1, surfaceTypeId);
		statement.setObject(2, product.getId());
		return statement;
	}

	public PreparedStatement updateProductTable(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT);

		setProductParameters(product, statement);
		statement.setObject(14, product.getId());
		return statement;
	}

	private void setProductParameters(Product product, PreparedStatement statement) throws SQLException {
		statement.setInt(1, product.getSizeOne());
		statement.setInt(2, product.getSizeTwo());
		statement.setInt(3, product.getSizeThree());
		statement.setInt(4, product.getStrengthGrade());
		statement.setString(5, product.getWearResistanceGrade());
		statement.setString(6, product.getCodeNumber());
		statement.setString(7, product.getName());
		statement.setDouble(8, product.getPriceDisplayed());
		statement.setDouble(9, product.getPriceReal());
		statement.setString(10, product.getThumbnailImageUri());
		statement.setString(11, product.getFullsizeImageUri());
		statement.setInt(12, product.getNumberInPack());
		statement.setDouble(13, product.getMetersInPack());
	}

	public PreparedStatement updateProductSupplier(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCT_SUPPLIER);
		statement.setObject(1, product.getSupplier().getId());
		statement.setObject(2, product.getId());
		return statement;
	}

	public PreparedStatement removeProductSurfaceType(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCT_SURFACE_TYPE);
		statement.setObject(1, product.getId());
		return statement;
	}

	public PreparedStatement removeProductSupplier(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCT_SUPPLIER);
		statement.setObject(1, product.getId());
		return statement;
	}

	public PreparedStatement removeProductCollection(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCT_COLLECTION);
		statement.setObject(1, product.getId());
		return statement;
	}

	public PreparedStatement getAllProductsStatement(Connection connection, int pageNumber, int entriesPerPage)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_PRODUCTS);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstEntryNumber);
		return statement;
	}

	public PreparedStatement getProductsBySurfaceTypeStatement(Connection connection, String surfaceType, int pageNumber,
			int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCTS_BY_SURFACE_TYPE);
		statement.setString(1, surfaceType);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(2, entriesPerPage);
		statement.setInt(3, firstEntryNumber);
		return statement;
	}

	public PreparedStatement getProductsBySupplierStatement(Connection connection, String supplierName, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCTS_BY_SUPPLIER);
		statement.setString(1, supplierName);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(2, entriesPerPage);
		statement.setInt(3, firstEntryNumber);
		return statement;
	}

	public PreparedStatement getProductsByProducerStatement(Connection connection, String producerName, int pageNumber,
			int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCTS_BY_PRODUCER);
		statement.setString(1, producerName);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(2, entriesPerPage);
		statement.setInt(3, firstEntryNumber);
		return statement;
	}

	public PreparedStatement getProductsByPricesStatement(Connection connection, Double minPrice, Double maxPrice,
			int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCTS_BY_PRICE_DISPLAYED);
		Double minPriceToEnter = minPrice==null ? Double.MIN_VALUE : minPrice;
		Double maxPriceToEnter = maxPrice==null ? Double.MAX_VALUE : maxPrice;
		statement.setDouble(1, minPriceToEnter);
		statement.setDouble(2, maxPriceToEnter);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(3, entriesPerPage);
		statement.setInt(4, firstEntryNumber);
		return statement;
	}

	public PreparedStatement getProductsByCollectionStatement(Connection connection, String collectionName, int pageNumber,
			int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_SELECT_PRODUCTS_BY_COLLECTION);
		statement.setString(1, collectionName);
		int firstEntryNumber = pageNumber * entriesPerPage;
		statement.setInt(2, entriesPerPage);
		statement.setInt(3, firstEntryNumber);
		return statement;
	}
	
	public PreparedStatement removeProductStatement(Connection connection, UUID productId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCT_BY_ID);
		statement.setObject(1, productId);
		return statement;
	}
}
