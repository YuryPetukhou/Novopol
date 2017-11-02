package lv.javaguru.novopol.dal.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Article;

public interface ArticleDAO {
	Article addArticle(Article article);
	boolean updateArticle(Article article);
	List<Article> getAllArticles ();
	List<Article> getArticlesByKeywords (List<String> keywords);
	List<Article> getArticlesByAuthor (String author);
	List<Article> getArticlesByDates (LocalDate startDate, LocalDate finishDate);
	boolean removeArticle(Article article);
	
}
