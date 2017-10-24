package lv.javaguru.novopol.logic.service.news;

import lv.javaguru.novopol.logic.api.news.RemoveNewsRequest;
import lv.javaguru.novopol.logic.api.news.RemoveNewsResponse;

public interface RemoveNewsService {
	RemoveNewsResponse removeNews (RemoveNewsRequest request);
}
