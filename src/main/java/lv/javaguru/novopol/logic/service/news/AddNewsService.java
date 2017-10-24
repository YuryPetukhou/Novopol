package lv.javaguru.novopol.logic.service.news;

import lv.javaguru.novopol.logic.api.news.AddNewsRequest;
import lv.javaguru.novopol.logic.api.news.AddNewsResponse;

public interface AddNewsService {
	AddNewsResponse addNews (AddNewsRequest request);
}
