package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.KeywordDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.KeywordSQLFactory;

@Component
public class KeywordDAOImpl extends DAOImpl implements KeywordDAO {
	@Autowired
	private KeywordSQLFactory sqlFactory;// = new KeywordSQLFactory();
	
	@Override
	public UUID insertKeyword(String keyword) {
		UUID id = null;
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertKeyword(connection, keyword);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				id = (UUID) resultSet.getObject(1);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return id;

	}

	@Override
	public UUID getKeywordId(String keyword) {
		UUID id = null;
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getKeyWordId(connection, keyword);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				id = (UUID) resultSet.getObject(1);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return id;
	}


	

}
