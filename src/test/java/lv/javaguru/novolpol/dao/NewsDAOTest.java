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
import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.NewsDAOImpl;
import lv.javaguru.novopol.domain.News;
import lv.javaguru.novopol.domain.builder.NewsBuilder;

public class NewsDAOTest {
	private static final String SQL_DELETE_ALL_ARTICLES = "DELETE FROM public.news";

	@Before
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_ARTICLES)) {
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		NewsDAO dao = new NewsDAOImpl();
		News news =dao.addNews(createNews());
		news.setAuthor("Vasil Lohankins");
		
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		keywords.add("Test keyword2");
		news.setKeywords(keywords);
		dao.updateNews(news);
		Assert.assertNotNull(news.getId());
	}
	
	private News createNews() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		News news = NewsBuilder.createNews().withAuthor("Viktor Pipiskin").withHeader("Dead header").withKeywords(keywords)
				.withPostDate(LocalDateTime.now()).withSource("http://sb.by").withSummary("PIpipi").withContent("Not safe for work").build();
		return news;
	}

	@Test
	public void selectAllTest() {
		NewsDAO dao = new NewsDAOImpl();
		List<News> list=dao.getAllNews();
		System.out.println(list);
	}

}
