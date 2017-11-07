package lv.javaguru.novolpol.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.ProducerDAOImpl;
import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.Producer;
import lv.javaguru.novopol.domain.builder.ArticleBuilder;
import lv.javaguru.novopol.domain.builder.ProducerBuilder;

public class ProducerDAOTest {

	private static final String SQL_DELETE_ALL_PRODUCERS = "DELETE FROM public.producers";

	private static UUID idToRemove=null;
	
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_PRODUCERS)) {
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		clearTable();
		ProducerDAO dao = new ProducerDAOImpl();
		Producer producer =dao.addProducer(createProducer());
		producer.setName("Vasil Lohankins");
		Producer producerToRemove =dao.addProducer(createProducer());
		idToRemove = producerToRemove.getId();
		System.out.println(idToRemove);
		
		dao.updateProducer(producer);
		Assert.assertNotNull(producer.getId());
	}
	
	private Producer createProducer() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		Producer producer = ProducerBuilder.createProducer().withName("Viktor Pipiskin").withCountry("Belarus").withCity("Miensk").build();
		return producer;
	}

	@Test
	public void selectAllTest() {
		ProducerDAO dao = new ProducerDAOImpl();
		List<Producer> list=dao.getAllProducers();
		System.out.println(list);
	}
	
	@Test
	public void deleteTest() {
		ProducerDAO dao = new ProducerDAOImpl();
		dao.removeProducer(idToRemove);
	}


}
