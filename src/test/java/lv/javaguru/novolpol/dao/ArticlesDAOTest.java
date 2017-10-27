package lv.javaguru.novolpol.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;

import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;

public class ArticlesDAOTest {
	private static final String SQL_DELETE_ALL_ARTICLES = "DELETE FROM public.articles";

	@Before
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_ARTICLES)) {
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
//		PreparedStatement statement = null;
//		statement = connection.prepareStatement(SQL_DELETE_ALL_NEWS);
//		int firstArticleNumber = pageNumber*entriesPerPage-1;
//		statement.setInt(1, firstArticleNumber);
//		statement.setInt(2, entriesPerPage);
//		return statement;
	}
	
	@Test
	public void insertTest() {
		
	}

}
