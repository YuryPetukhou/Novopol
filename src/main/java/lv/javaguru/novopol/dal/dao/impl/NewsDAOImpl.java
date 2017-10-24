package lv.javaguru.novopol.dal.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.domain.News;

public class NewsDAOImpl extends DAOImpl implements NewsDAO {

	public NewsDAOImpl() {
		super();
	}
	
	public NewsDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber,entriesPerPage);
	}
	
	public UUID addNews(News news) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<News> getAllNewss() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<News> getNewssByKeywords(List<String> keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<News> getNewssByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<News> getNewssByDates(LocalDate startDate, LocalDate finishDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeNews(News News) {
		// TODO Auto-generated method stub
		return false;
	}

}
