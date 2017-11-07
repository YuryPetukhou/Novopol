package lv.javaguru.novolpol.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.ProductDAOImpl;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.Product;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;
import lv.javaguru.novopol.domain.builder.ProductBuilder;

public class ProductDAOTest {

	private static final String SQL_DELETE_ALL_PRODUCTS = "DELETE FROM public.items";

	private static UUID idToRemove=null;
	
	
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_PRODUCTS)) {
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		clearTable();
		ProductDAO dao = new ProductDAOImpl();
		Product product =dao.addProduct(createProduct());
		product.setCodeNumber("UpCodeNumber");
		Product productToRemove =dao.addProduct(createProduct());
		idToRemove = productToRemove.getId();
		System.out.println(idToRemove);
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		keywords.add("Test keyword2");
//		product.setKeywords(keywords);
		dao.updateProduct(product);
		Assert.assertNotNull(product.getId());
	}
	
	private Product createProduct() {

		Product product = ProductBuilder.createProduct().withPriceDisplayed(100.05).withCodeNumber("DDAS").withName("ProductName").withStrengthGrade(300).withWearResistanceGrade("WRG").build();
		return product;
	}

	@Test
	public void selectAllTest() {
		ProductDAO dao = new ProductDAOImpl();
		List<Product> list=dao.getAllProducts();
		System.out.println(list);
	}
	
	@Test
	public void deleteTest() {
		ProductDAO dao = new ProductDAOImpl();
		dao.removeProduct(idToRemove);
	}


}
