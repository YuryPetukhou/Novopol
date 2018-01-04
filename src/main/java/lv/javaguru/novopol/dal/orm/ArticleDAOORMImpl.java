package lv.javaguru.novopol.dal.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.KeywordDAO;
import lv.javaguru.novopol.dal.dao.impl.KeywordDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.statement.ArticleSQLFactory;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;

@Component
public class ArticleDAOORMImpl implements ArticleDAO {
	@Autowired
	private ArticleSQLFactory sqlFactory;// = new ArticleSQLFactory();
	@Autowired
	private SessionFactory sessionFactory;

	public ArticleDAOORMImpl() {
		super();
	}

	
	public Article addArticle(Article article) {
//		sessionFactory.
		return article;
	}

	private void insertKeywordLine(String keyword, Article article) {
		KeywordDAO keywordDAO = new KeywordDAOImpl();
		UUID keywordId = keywordDAO.getKeywordId(keyword);
		if (keywordId == null) {
			keywordId = keywordDAO.insertKeyword(keyword);
		}
	}


	public boolean updateArticle(Article article) {
		updateKeywords(article);
		return true;
	}

	private void updateKeywords(Article article) {
		Map<String,UUID> keywordsMap = getKeywordsMap(article);
		List<String> removeList =new ArrayList<String>(keywordsMap.keySet());
		removeList.removeAll(article.getKeywords());
		List<UUID> removeIds = new ArrayList<UUID>();
		for (String removeKeyword : removeList) {
			removeIds.add(keywordsMap.get(removeKeyword));
		}
		if (!removeIds.isEmpty()) {
		removeArticleKeywords (article,removeIds);
		}
	//	List<String> newKeywordsList = new ArrayList<String>(article.getKeywords());
//		newKeywordsList.removeAll(keywordsMap.keySet());
//		for (String keyword : newKeywordsList) {
//			insertKeywordLine(keyword, article);
//		}
		
	}

	private void removeArticleKeywords(Article article,List<UUID> removeIds) {
		
	}

	private Map<String,UUID> getKeywordsMap(Article article) {
		Map<String,UUID> keywordsMap = new HashMap<String,UUID>();
		return keywordsMap;
	}

	public List<Article> getAllArticles() {
		List<Article> articlesList = new ArrayList<Article>();
		return articlesList;
	}

	private List<String> getArticleKeywords(Article article) {
		List<String> keywords = new ArrayList<String>();
		return keywords;
	}

	private Article prepareArticle(ResultSet resultSet) throws SQLException {
		Date postDate = (Date) resultSet.getObject(6);
		LocalDateTime postDateTime = LocalDateTime.ofInstant(postDate.toInstant(), ZoneId.systemDefault());
		
		Article article = ArticleBuilder.createArticle().withId((UUID) resultSet.getObject(1))
				.withPostDate(postDateTime).withHeader(resultSet.getString(7)).withContent(resultSet.getString(8))
				.withSummary(resultSet.getString(9)).withSource(resultSet.getString(10))
				.withAuthor(resultSet.getString(11)).build();
//		article.setKeywords(getArticleKeywords(article));
		// id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content,
		// abstract,source, author
		return article;
	}

	public List<Article> getArticlesByKeywords(List<String> keywords) {
		List<Article> articlesList = new ArrayList<Article>();
		return articlesList;
	}

	public List<Article> getArticlesByAuthor(String author) {
		List<Article> articlesList = new ArrayList<Article>();
		return articlesList;
	}

	public List<Article> getArticlesByDates(LocalDate startDate, LocalDate finishDate) {
		List<Article> articlesList = new ArrayList<Article>();
		return articlesList;
	}

	public boolean removeArticle(Article article) {
		return removeArticle(article.getId());
	}

	@Override
	public boolean removeArticle(UUID articleId) {
		return true;
	}

}
