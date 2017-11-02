package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.News;

public class NewsSQLFactory extends SQLStatementFactory {
	private static final String SQL_GET_ALL_NEWS = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.news ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_INSERT_NEWS = "INSERT INTO public.news (id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?) RETURNING id";
	private static final String SQL_UPDATE_NEWS = "UPDATE public.news SET updated_dt=now(), updated_by='Auto',post_dt=?,header=?, content=?, abstract=?,source=?, author=? WHERE id = ?";
	private static final String SQL_INSERT_NEWS_KEYWORD = "INSERT INTO public.news_keywords (created_dt, updated_dt, created_by,updated_by,news_id,keyword_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_GET_NEWS_KEYWORDS = "SELECT a.id, b.keyword FROM public.news_keywords AS a JOIN public.keywords AS b ON a.keyword_id=b.id WHERE news_id=?";
	private static final String SQL_DELETE_NEWS_KEYWORDS = "DELETE FROM news_keywords WHERE id IN (?)";
	private static final String SQL_GET_NEWS_BY_AUTHOR = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.news WHERE author=? ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_GET_NEWS_WITHIN_DATES = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.news WHERE post_dt>=? AND post_dt<=? ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_DELETE_NEWS_BY_ID = "DELETE FROM news WHERE id=?";
	private static final String SQL_GET_NEWS_BY_KEYWORDS = "SELECT c.id, COUNT(b.keyword) AS d FROM public.keywords AS b JOIN public.news_keywords AS a ON a.keyword_id=b.id JOIN public.news AS c ON a.news_id=c.id WHERE b.keyword IN(?) GROUP BY c.id ORDER BY d DESC";

	public PreparedStatement insertNewsKeyword(Connection connection, News article, UUID keywordId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_NEWS_KEYWORD);
		statement.setObject(1, article.getId());
		statement.setObject(2, keywordId);
		return statement;
	}

	public PreparedStatement insertNewsStatement(Connection connection, News article) throws SQLException {
		PreparedStatement statement = null;
		statement = connection.prepareStatement(SQL_INSERT_NEWS);
		statement.setTimestamp(1, Timestamp.valueOf(article.getPostDate()));
		statement.setString(2, article.getHeader());
		statement.setString(3, article.getText());
		statement.setString(4, article.getSummary());
		statement.setString(5, article.getSource());
		statement.setString(6, article.getAuthor());
		return statement;
	}

	public PreparedStatement updateNewsStatement(Connection connection, News article) throws SQLException {
		PreparedStatement statement = null;
		statement = connection.prepareStatement(SQL_UPDATE_NEWS);
		statement.setTimestamp(1, Timestamp.valueOf(article.getPostDate()));
		statement.setString(2, article.getHeader());
		statement.setString(3, article.getText());
		statement.setString(4, article.getSummary());
		statement.setString(5, article.getSource());
		statement.setString(6, article.getAuthor());
		statement.setObject(7, article.getId());
		return statement;
	}

	public PreparedStatement getSelectAllStatement(Connection connection, int pageNumber, int entriesPerPage)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_NEWS);
		int firstNewsNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstNewsNumber);
		return statement;
	}

	public PreparedStatement getNewsKeywords(Connection connection, News article) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_NEWS_KEYWORDS);
		statement.setObject(1, article.getId());
		return statement;
	}

	public PreparedStatement removeNewsKeywords(Connection connection, News article, List<UUID> removeIds)
			throws SQLException {

		String sql = SQL_DELETE_NEWS_KEYWORDS;
		String parameterSubstring = "";
		for (int i = 0; i < removeIds.size(); ++i) {
			sql += i > 1 ? "," : "";
			sql += "?";
		}
		sql.replace("?", parameterSubstring);

		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < removeIds.size(); ++i) {
			statement.setString(i, removeIds.get(i).toString());
		}

		return statement;
	}

	public PreparedStatement getSelectByAuthorStatement(Connection connection, String author, int pageNumber,
			int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_NEWS_BY_AUTHOR);
		statement.setObject(1, author);
		return statement;
	}

	public PreparedStatement getSelectByDateStatement(Connection connection, LocalDate startDate, LocalDate finishDate,
			int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_NEWS_WITHIN_DATES);
		statement.setObject(1, startDate);
		statement.setObject(2, finishDate);
		return statement;
	}

	public PreparedStatement removeNewsStatement(Connection connection, UUID id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_NEWS_BY_ID);
		statement.setObject(1, id);
		return statement;
	}

	public PreparedStatement getNewsByKeywords(Connection connection, List<String> keywords) throws SQLException {
		String sql = SQL_GET_NEWS_BY_KEYWORDS;
		String parameterSubstring = "";
		for (int i = 0; i < keywords.size(); ++i) {
			sql += i > 1 ? "," : "";
			sql += "?";
		}
		sql.replace("?", parameterSubstring);
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < keywords.size(); ++i) {
			statement.setString(i, keywords.get(i).toString());
		}

		return statement;
	}

}
