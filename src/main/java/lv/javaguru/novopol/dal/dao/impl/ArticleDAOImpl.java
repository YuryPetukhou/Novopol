package lv.javaguru.novopol.dal.dao.impl;

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

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.KeywordDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.ArticleSQLFactory;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;

public class ArticleDAOImpl extends DAOImpl implements ArticleDAO {

	private ArticleSQLFactory sqlFactory = new ArticleSQLFactory();

	public ArticleDAOImpl() {
		super();
	}

	public ArticleDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber, entriesPerPage);
	}

	public Article addArticle(Article article) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertArticleStatement(connection, article);
				ResultSet rs = statement.executeQuery();) {

			if (rs.next()) {
				article.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

		if (article.getKeywords() != null) {
			for (String keyword : article.getKeywords()) {
				insertKeywordLine(keyword, article);
			}
		}

		return article;
	}

	private void insertKeywordLine(String keyword, Article article) {
		KeywordDAO keywordDAO = new KeywordDAOImpl();
		UUID keywordId = keywordDAO.getKeywordId(keyword);
		if (keywordId == null) {
			keywordId = keywordDAO.insertKeyword(keyword);
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertArticleKeyword(connection, article, keywordId);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
	}


	public boolean updateArticle(Article article) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateArticleStatement(connection, article);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
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
		List<String> newKeywordsList = new ArrayList<String>(article.getKeywords());
		newKeywordsList.removeAll(keywordsMap.keySet());
		for (String keyword : newKeywordsList) {
			insertKeywordLine(keyword, article);
		}
		
	}

	private void removeArticleKeywords(Article article,List<UUID> removeIds) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeArticleKeywords(connection, article, removeIds);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		
	}

	private Map<String,UUID> getKeywordsMap(Article article) {
		Map<String,UUID> keywordsMap = new HashMap<String,UUID>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getArticleKeywords(connection, article);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				keywordsMap.put (resultSet.getString(2),(UUID) resultSet.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return keywordsMap;
	}

	public List<Article> getAllArticles() {
		List<Article> articlesList = new ArrayList<Article>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectAllStatement(connection, pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Article article = prepareArticle(resultSet);
				articlesList.add(article);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return articlesList;
	}

	private List<String> getArticleKeywords(Article article) {
		List<String> keywords = new ArrayList<String>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getArticleKeywords(connection, article);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {				
				keywords.add(resultSet.getString(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return keywords;
	}

	private Article prepareArticle(ResultSet resultSet) throws SQLException {
		Date postDate = (Date) resultSet.getObject(6);
		LocalDateTime postDateTime = LocalDateTime.ofInstant(postDate.toInstant(), ZoneId.systemDefault());
		
		Article article = ArticleBuilder.createArticle().withId((UUID) resultSet.getObject(1))
				.withPostDate(postDateTime).withHeader(resultSet.getString(7)).withContent(resultSet.getString(8))
				.withSummary(resultSet.getString(9)).withSource(resultSet.getString(10))
				.withAuthor(resultSet.getString(11)).build();
		article.setKeywords(getArticleKeywords(article));
		// id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content,
		// abstract,source, author
		return article;
	}

	public List<Article> getArticlesByKeywords(List<String> keywords) {
		List<Article> articlesList = new ArrayList<Article>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getArticlesByKeywords(connection, keywords,pageNumber,entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Article article = prepareArticle(resultSet);
				articlesList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return articlesList;
	}

	public List<Article> getArticlesByAuthor(String author) {
		List<Article> articlesList = new ArrayList<Article>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectByAuthorStatement(connection, author,pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Article article = prepareArticle(resultSet);
				articlesList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return articlesList;
	}

	public List<Article> getArticlesByDates(LocalDate startDate, LocalDate finishDate) {
		List<Article> articlesList = new ArrayList<Article>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectByDateStatement(connection, startDate,finishDate,pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Article article = prepareArticle(resultSet);
				articlesList.add(article);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return articlesList;
	}

	public boolean removeArticle(Article article) {
		return removeArticle(article.getId());
	}

	@Override
	public boolean removeArticle(UUID articleId) {
		if (articleId==null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeArticleStatement(connection, articleId)) {
			statement.executeUpdate();			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

}
