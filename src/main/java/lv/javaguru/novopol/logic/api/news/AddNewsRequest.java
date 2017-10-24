package lv.javaguru.novopol.logic.api.news;

import lv.javaguru.novopol.domain.News;

public class AddNewsRequest {
	private final News news;

	public AddNewsRequest(News news) {
		super();
		this.news = news;
	}

	public News getNews() {
		return news;
	}

	

}
