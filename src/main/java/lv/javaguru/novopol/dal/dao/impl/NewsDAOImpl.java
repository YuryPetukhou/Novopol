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
import lv.javaguru.novopol.dal.dao.KeywordDAO;
import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.NewsSQLFactory;
import lv.javaguru.novopol.domain.News;
import lv.javaguru.novopol.domain.builder.NewsBuilder;

public class NewsDAOImpl extends DAOImpl implements NewsDAO {
	private NewsSQLFactory sqlFactory = new NewsSQLFactory();

	public NewsDAOImpl() {
		super();
	}

	public NewsDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber, entriesPerPage);
	}

	@Override
	public News addNews(News news) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertNewsStatement(connection, news);
				ResultSet rs = statement.executeQuery();) {

			if (rs.next()) {
				news.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

		if (news.getKeywords() != null) {
			for (String keyword : news.getKeywords()) {
				insertKeywordLine(keyword, news);
			}
		}

		return news;
	}

	private void insertKeywordLine(String keyword, News news) {
		KeywordDAO keywordDAO = new KeywordDAOImpl();
		UUID keywordId = keywordDAO.getKeywordId(keyword);
		if (keywordId == null) {
			keywordId = keywordDAO.insertKeyword(keyword);
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertNewsKeyword(connection, news, keywordId);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
	}

	@Override
	public boolean updateNews(News news) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateNewsStatement(connection, news);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		updateKeywords(news);
		return true;
	}

	private void updateKeywords(News news) {
		Map<String,UUID> keywordsMap = getKeywordsMap(news);
		List<String> removeList =new ArrayList<String>(keywordsMap.keySet());
		removeList.removeAll(news.getKeywords());
		List<UUID> removeIds = new ArrayList<UUID>();
		for (String removeKeyword : removeList) {
			removeIds.add(keywordsMap.get(removeKeyword));
		}
		if (!removeIds.isEmpty()) {
		removeNewsKeywords (news,removeIds);
		}
		List<String> newKeywordsList = new ArrayList<String>(news.getKeywords());
		newKeywordsList.removeAll(keywordsMap.keySet());
		for (String keyword : newKeywordsList) {
			insertKeywordLine(keyword, news);
		}
		
	}

	private void removeNewsKeywords(News news,List<UUID> removeIds) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeNewsKeywords(connection, news, removeIds);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		
	}

	private Map<String,UUID> getKeywordsMap(News news) {
		Map<String,UUID> keywordsMap = new HashMap<String,UUID>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getNewsKeywords(connection, news);
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

	@Override
	public List<News> getAllNews() {
		List<News> newsList = new ArrayList<News>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectAllStatement(connection, pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				News news = prepareNews(resultSet);
				newsList.add(news);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return newsList;
	}

	private List<String> getNewsKeywords(News news) {
		List<String> keywords = new ArrayList<String>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getNewsKeywords(connection, news);
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

	private News prepareNews(ResultSet resultSet) throws SQLException {
		Date postDate = (Date) resultSet.getObject(6);
		LocalDateTime postDateTime = LocalDateTime.ofInstant(postDate.toInstant(), ZoneId.systemDefault());
		
		News news = NewsBuilder.createNews().withId((UUID) resultSet.getObject(1))
				.withPostDate(postDateTime).withHeader(resultSet.getString(7)).withText(resultSet.getString(8))
				.withSummary(resultSet.getString(9)).withSource(resultSet.getString(10))
				.withAuthor(resultSet.getString(11)).build();
		news.setKeywords(getNewsKeywords(news));
		// id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content,
		// abstract,source, author
		return news;
	}

	@Override
	public List<News> getNewsByKeywords(List<String> keywords) {
		List<News> newsList = new ArrayList<News>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getNewsByKeywords(connection, keywords);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				News news = prepareNews(resultSet);
				newsList.add(news);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return newsList;

	}

	@Override
	public List<News> getNewsByAuthor(String author) {
		List<News> newsList = new ArrayList<News>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectByAuthorStatement(connection, author,pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				News news = prepareNews(resultSet);
				newsList.add(news);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByDates(LocalDate startDate, LocalDate finishDate) {
		List<News> newsList = new ArrayList<News>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getSelectByDateStatement(connection, startDate,finishDate,pageNumber, entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				News news = prepareNews(resultSet);
				newsList.add(news);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return newsList;
	}

	@Override
	public boolean removeNews(News news) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeNewsStatement(connection, news);
				ResultSet rs = statement.executeQuery();) {

			if (rs.next()) {
				news.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

}
