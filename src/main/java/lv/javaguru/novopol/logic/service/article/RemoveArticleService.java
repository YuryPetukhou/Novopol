package lv.javaguru.novopol.logic.service.article;

import lv.javaguru.novopol.logic.api.article.RemoveArticleRequest;
import lv.javaguru.novopol.logic.api.article.RemoveArticleResponse;

public interface RemoveArticleService {
	RemoveArticleResponse removeArticle (RemoveArticleRequest request);
}
