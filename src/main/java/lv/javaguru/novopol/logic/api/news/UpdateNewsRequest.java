package lv.javaguru.novopol.logic.api.news;

import lv.javaguru.novopol.domain.News;

public class UpdateNewsRequest {
	private final News news;

	public UpdateNewsRequest(News news) {
		super();
		this.news = news;
	}

	public News getNews() {
		return news;
	}
}
