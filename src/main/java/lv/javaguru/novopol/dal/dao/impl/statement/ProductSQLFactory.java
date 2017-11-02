package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import lv.javaguru.novopol.domain.Product;

public class ProductSQLFactory extends SQLStatementFactory {

	private static final String SQL_INSERT_PRODUCT = "INSERT INTO public.items (id,created_dt, updated_dt, created_by,updated_by,size_one, size_two, size_three,strength_grade, wear_resistance_class,code_number,name,price_displayed,price_real,image_thumbnail,image_fullsize,number_in_pack,meters_in_pack) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";
	private static final String SQL_INSERT_PRODUCT_SURFACE_TYPE = "INSERT INTO public.items_surface_types (created_dt, updated_dt, created_by,updated_by,item_id,surface_type_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_INSERT_PRODUCT_COLLECTION = "INSERT INTO public.items_collections (created_dt, updated_dt, created_by,updated_by,item_id,collection_id) VALUES (now(),now(),'Auto','Auto',?,?)";;
	
	
	public PreparedStatement insertProductStatement(Connection connection, Product product) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT);
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
		return statement;
	}

	public PreparedStatement insertProductSurfaceType(Connection connection, Product product,UUID surfaceTypeId) 
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT_SURFACE_TYPE);
		statement.setObject(1, product.getId());
		statement.setObject(2, surfaceTypeId);
		return statement;
	}

	public PreparedStatement insertProductCollection(Connection connection, Product product, UUID collectionId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT_COLLECTION);
		statement.setObject(1, product.getId());
		statement.setObject(2, collectionId);
		return statement;
	}
	
}
