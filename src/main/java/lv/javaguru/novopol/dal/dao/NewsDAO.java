package lv.javaguru.novopol.dal.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.News;

public interface NewsDAO {
	News addNews(News news);
	boolean updateNews(News news);
	List<News> getAllNews ();
	List<News> getNewsByKeywords (List<String> keywords);
	List<News> getNewsByAuthor (String author);
	List<News> getNewsByDates (LocalDate startDate, LocalDate finishDate);
	boolean removeNews(News News);
}
