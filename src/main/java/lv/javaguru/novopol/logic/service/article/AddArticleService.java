package lv.javaguru.novopol.logic.service.article;

import lv.javaguru.novopol.logic.api.article.AddArticleRequest;
import lv.javaguru.novopol.logic.api.article.AddArticleResponse;

public interface AddArticleService {
	AddArticleResponse addArticle (AddArticleRequest request);
}
