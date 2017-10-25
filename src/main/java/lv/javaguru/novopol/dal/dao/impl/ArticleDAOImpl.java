package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.domain.Article;

public class ArticleDAOImpl extends DAOImpl implements ArticleDAO {

	private static final String SQL_GET_ALL_ARTICLES = "SELECT id, header, created_date, created_time, html_abstract FROM articles ORDER BY created_date, created_time LIMIT ? OFFSET ?";;

	public ArticleDAOImpl() {
		super();
	}
	
	public ArticleDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber,entriesPerPage);
	}
	
	public UUID addArticle(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateArticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Article> getAllArticles() {
		List<Article> articlesList = new ArrayList<Article>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = getSelectAllStatement(
						connection, pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				
			}

		} catch (Throwable e) {
			e.printStackTrace();
            throw new DBException(e);
		}
		return abstractsList;
	}

	private PreparedStatement getSelectAllStatement(Connection connection, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = null;
		statement = connection.prepareStatement(SQL_GET_ALL_ARTICLES);
		int firstArticleNumber = pageNumber*entriesPerPage-1;
		statement.setInt(1, firstArticleNumber);
		statement.setInt(2, entriesPerPage);
		return statement;
	}

	public List<Article> getArticlesByKeywords(List<String> keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> getArticlesByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> getArticlesByDates(LocalDate startDate, LocalDate finishDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeArticle(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

}
