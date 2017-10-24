package lv.javaguru.novopol.logic.service.news;

import lv.javaguru.novopol.logic.api.news.UpdateNewsRequest;
import lv.javaguru.novopol.logic.api.news.UpdateNewsResponse;

public interface UpdateNewsService {
	UpdateNewsResponse updateNews (UpdateNewsRequest request);
}
