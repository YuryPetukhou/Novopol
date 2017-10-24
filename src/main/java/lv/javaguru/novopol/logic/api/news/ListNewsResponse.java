package lv.javaguru.novopol.logic.api.news;

import java.util.List;

import lv.javaguru.novopol.domain.News;

public class ListNewsResponse {
	private final List<News> news;

	public ListNewsResponse(List<News> news) {
		super();
		this.news = news;
	}

	public List<News> getNews() {
		return news;
	}
}
