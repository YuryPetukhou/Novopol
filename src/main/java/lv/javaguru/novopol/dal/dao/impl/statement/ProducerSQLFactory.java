package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lv.javaguru.novopol.domain.Producer;

@Component
public class ProducerSQLFactory extends SQLStatementFactory {
	private static final String SQL_GET_ALL_PRODUCERS = "SELECT id,created_dt, updated_dt, created_by,updated_by,name,country,city,state,zipcode,street,house,office,phone,email,website,contact_person FROM public.producers ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_INSERT_PRODUCER = "INSERT INTO public.producers (id,created_dt, updated_dt, created_by,updated_by,name,country,city,state,zipcode,street,house,office,phone,email,website,contact_person) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";
	private static final String SQL_UPDATE_PRODUCER = "UPDATE public.producers SET updated_dt=now(), updated_by='Auto',name=?,country=?,city=?,state=?,zipcode=?,street=?,house=?,office=?,phone=?,email=?,website=?,contact_person=? WHERE id = ?";
	private static final String SQL_DELETE_PRODUCER_BY_ID = "DELETE FROM public.producers WHERE id=?";
	
	public PreparedStatement updateProducerStatement(Connection connection, Producer producer) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PRODUCER);
		statement.setString(1, producer.getName());
		statement.setString(2, producer.getCountry());
		statement.setString(3, producer.getCity());
		statement.setString(4, producer.getState());
		statement.setString(5, producer.getZipcode());
		statement.setString(6, producer.getStreet());
		statement.setString(7, producer.getHouse());
		statement.setString(8, producer.getOffice());
		statement.setString(9, producer.getPhone());
		statement.setString(10, producer.getEmail());
		statement.setString(11, producer.getWebsite());
		statement.setString(12, producer.getContactPerson());
		statement.setObject(13, producer.getId());
		return statement;
	}

	public PreparedStatement insertProducerStatement(Connection connection, Producer producer) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCER);
		//name,country,city,state,zipcode,street,house,office,email,website,contact_person
		statement.setString(1, producer.getName());
		statement.setString(2, producer.getCountry());
		statement.setString(3, producer.getCity());
		statement.setString(4, producer.getState());
		statement.setString(5, producer.getZipcode());
		statement.setString(6, producer.getStreet());
		statement.setString(7, producer.getHouse());
		statement.setString(8, producer.getOffice());
		statement.setString(9, producer.getPhone());
		statement.setString(10, producer.getEmail());
		statement.setString(11, producer.getWebsite());
		statement.setString(12, producer.getContactPerson());
		return statement;
	}

	public PreparedStatement removeProducerStatement(Connection connection, UUID producerId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PRODUCER_BY_ID);
		statement.setObject(1, producerId);
		return statement;
	}

	public PreparedStatement getAllProducersStatement(Connection connection, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_PRODUCERS);
		int firstNewsNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstNewsNumber);
		return statement;
	}

}
