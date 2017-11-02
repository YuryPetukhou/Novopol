package lv.javaguru.novopol.dal.dao;

import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Producer;

public interface ProducerDAO {
	Producer addProducer(Producer producer);
	boolean updateProducer(Producer producer);
	List<Producer> getAllProducers ();
	boolean removeProducer(Producer producer);
	boolean removeProducer(UUID producerId);
}
