package lv.javaguru.novopol.logic.service.news;

import lv.javaguru.novopol.logic.api.news.ListNewsRequest;
import lv.javaguru.novopol.logic.api.news.ListNewsResponse;

public interface ListNewsService {
	ListNewsResponse getNews (ListNewsRequest request);
}
