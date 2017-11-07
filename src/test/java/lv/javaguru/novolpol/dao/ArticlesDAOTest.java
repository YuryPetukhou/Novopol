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
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;

public class ArticlesDAOTest {
	private static final String SQL_DELETE_ALL_ARTICLES = "DELETE FROM public.articles";

	private static UUID idToRemove=null;
	
	@Before
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_ARTICLES)) {
	//		statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		ArticleDAO dao = new ArticleDAOImpl();
		Article article =dao.addArticle(createArticle());
		article.setAuthor("Vasil Lohankins");
		Article articleToRemove =dao.addArticle(createArticle());
		idToRemove = articleToRemove.getId();
		System.out.println(idToRemove);
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		keywords.add("Test keyword2");
		article.setKeywords(keywords);
		dao.updateArticle(article);
		Assert.assertNotNull(article.getId());
	}
	
	private Article createArticle() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		Article article = ArticleBuilder.createArticle().withAuthor("Viktor Pipiskin").withHeader("Dead header").withKeywords(keywords)
				.withPostDate(LocalDateTime.now()).withSource("http://sb.by").withSummary("PIpipi").withContent("Not safe for work").build();
		return article;
	}

	@Test
	public void selectAllTest() {
		ArticleDAO dao = new ArticleDAOImpl();
		List<Article> list=dao.getAllArticles();
		System.out.println(list);
	}
	
	@Test
	public void deleteTest() {
		ArticleDAO dao = new ArticleDAOImpl();
		dao.removeArticle(idToRemove);
	}
	

}
