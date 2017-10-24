package lv.javaguru.novopol.dal.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.domain.Article;

public class ArticleDAOImpl extends DAOImpl implements ArticleDAO {

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
		// TODO Auto-generated method stub
		return null;
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
