package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lv.javaguru.novopol.domain.Article;

@Component
public class ArticleSQLFactory extends SQLStatementFactory {

	private static final String SQL_GET_ALL_ARTICLES = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.articles ORDER BY post_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_INSERT_ARTICLE = "INSERT INTO public.articles (id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?) RETURNING id";
	private static final String SQL_UPDATE_ARTICLE = "UPDATE public.articles SET updated_dt=now(), updated_by='Auto',post_dt=?,header=?, content=?, abstract=?,source=?, author=? WHERE id = ?";
	private static final String SQL_INSERT_ARTICLE_KEYWORD = "INSERT INTO public.articles_keywords (created_dt, updated_dt, created_by,updated_by,article_id,keyword_id) VALUES (now(),now(),'Auto','Auto',?,?)";
	private static final String SQL_GET_ARTICLE_KEYWORDS = "SELECT a.id, b.keyword FROM public.articles_keywords AS a JOIN public.keywords AS b ON a.keyword_id=b.id WHERE article_id=?";
	private static final String SQL_DELETE_ARTICLE_KEYWORDS = "DELETE FROM articles_keywords WHERE id IN (?)";
	private static final String SQL_GET_ARTICLE_BY_AUTHOR = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.articles WHERE author=? ORDER BY post_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_GET_ARTICLES_WITHIN_DATES = "SELECT id,created_dt, updated_dt, created_by,updated_by,post_dt,header, content, abstract,source, author FROM public.articles WHERE post_dt>=? AND post_dt<=? ORDER BY post_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_DELETE_ARTICLE_BY_ID = "DELETE FROM articles WHERE id=?";
	private static final String SQL_GET_ARTICLES_BY_KEYWORDS = "SELECT c.id, COUNT(b.keyword) AS d FROM public.keywords AS b JOIN public.articles_keywords AS a ON a.keyword_id=b.id JOIN public.articles AS c ON a.article_id=c.id WHERE b.keyword IN(?) GROUP BY c.id ORDER BY d DESC LIMIT ? OFFSET ?";
	
	public PreparedStatement insertArticleKeyword(Connection connection, Article article, UUID keywordId)
			throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ARTICLE_KEYWORD);
		statement.setObject(1, article.getId());
		statement.setObject(2, keywordId);
		return statement;
	}

	public PreparedStatement insertArticleStatement(Connection connection, Article article) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ARTICLE);
		statement.setTimestamp(1, Timestamp.valueOf(article.getPostDate()));
		statement.setString(2, article.getHeader());
		statement.setString(3, article.getText());
		statement.setString(4, article.getSummary());
		statement.setString(5, article.getSource());
		statement.setString(6, article.getAuthor());
		return statement;
	}

	public PreparedStatement updateArticleStatement(Connection connection, Article article) throws SQLException {
		PreparedStatement statement = null;
		statement = connection.prepareStatement(SQL_UPDATE_ARTICLE);
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
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_ARTICLES);
		int firstArticleNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstArticleNumber);
		return statement;
	}

	

	
	public PreparedStatement getArticleKeywords(Connection connection, Article article) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ARTICLE_KEYWORDS);
		statement.setObject(1, article.getId());
		return statement;
	}

	public PreparedStatement removeArticleKeywords(Connection connection, Article article, List<UUID> removeIds) throws SQLException {
		
		String sql = SQL_DELETE_ARTICLE_KEYWORDS;
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
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ARTICLE_BY_AUTHOR);
		statement.setObject(1, author);
		int firstArticleNumber = pageNumber * entriesPerPage;
		statement.setInt(2, entriesPerPage);
		statement.setInt(3, firstArticleNumber);
	
		return statement;
	}

	public PreparedStatement getSelectByDateStatement(Connection connection, LocalDate startDate, LocalDate finishDate,
			int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ARTICLES_WITHIN_DATES);
		statement.setObject(1, startDate);
		statement.setObject(2, finishDate);
		int firstArticleNumber = pageNumber * entriesPerPage;
		statement.setInt(3, entriesPerPage);
		statement.setInt(4, firstArticleNumber);
		return statement;
	}

	
	
	public PreparedStatement removeArticleStatement(Connection connection, UUID id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ARTICLE_BY_ID);
		statement.setObject(1, id);
		return statement;
	}

	public PreparedStatement getArticlesByKeywords(Connection connection, List<String> keywords,int pageNumber,
			int entriesPerPage) throws SQLException {
		String sql = SQL_GET_ARTICLES_BY_KEYWORDS;
		String parameterSubstring = "(";
		for (int i = 0; i < keywords.size(); ++i) {
			sql += i > 1 ? "," : "";
			sql += "?";
		}
		sql+=")";
		sql.replace("(?)", parameterSubstring);
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < keywords.size(); ++i) {
			statement.setString(i, keywords.get(i).toString());
		}	
		int firstArticleNumber = pageNumber * entriesPerPage;
		statement.setInt(keywords.size()+1, entriesPerPage);
		statement.setInt(keywords.size()+2, firstArticleNumber);
		return statement;
	}

	
}
