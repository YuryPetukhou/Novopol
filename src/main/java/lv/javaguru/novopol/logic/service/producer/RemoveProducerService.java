package lv.javaguru.novopol.logic.service.producer;

import lv.javaguru.novopol.logic.api.producer.RemoveProducerRequest;
import lv.javaguru.novopol.logic.api.producer.RemoveProducerResponse;

public interface RemoveProducerService {
	RemoveProducerResponse removeProducer (RemoveProducerRequest request);
}
