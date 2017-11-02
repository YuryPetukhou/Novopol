package lv.javaguru.novolpol.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;

public class ArticlesDAOTest {
	private static final String SQL_DELETE_ALL_ARTICLES = "DELETE FROM public.articles";

	@Before
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_ARTICLES)) {
//			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		ArticleDAO dao = new ArticleDAOImpl();
		Article article =dao.addArticle(createArticle());
	}
	
	private Article createArticle() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		Article article = ArticleBuilder.createArticle().withAuthor("Viktor Pipiskin").withHeader("Dead header").withKeywords(keywords)
				.withPostDate(LocalDateTime.now()).withSource("http://sb.by").withSummary("PIpipi").withContent("Not safe for work").build();
		return article;
	}

//	@Test
	public void selectAllTest() {
		ArticleDAO dao = new ArticleDAOImpl();
		List<Article> list=dao.getAllArticles();
		System.out.println(list);
		Assert.assertTrue(list.size()>0);
	}
	
	
	

}
