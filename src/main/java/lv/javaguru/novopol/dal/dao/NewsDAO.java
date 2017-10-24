package lv.javaguru.novopol.dal.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.News;

public interface NewsDAO {
	UUID addNews(News news);
	boolean updateNews(News news);
	List<News> getAllNewss ();
	List<News> getNewssByKeywords (List<String> keywords);
	List<News> getNewssByAuthor (String author);
	List<News> getNewssByDates (LocalDate startDate, LocalDate finishDate);
	boolean removeNews(News News);
}
