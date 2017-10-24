package lv.javaguru.novopol.logic.service.article;

import lv.javaguru.novopol.logic.api.article.UpdateArticleRequest;
import lv.javaguru.novopol.logic.api.article.UpdateArticleResponse;

public interface UpdateArticleService {
	UpdateArticleResponse updateArticle (UpdateArticleRequest request);
}
