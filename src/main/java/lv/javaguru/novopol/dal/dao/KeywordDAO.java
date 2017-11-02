package lv.javaguru.novopol.dal.dao;

import java.util.UUID;

public interface KeywordDAO {
	UUID insertKeyword(String keyword);
	UUID getKeywordId(String keyword);
}
