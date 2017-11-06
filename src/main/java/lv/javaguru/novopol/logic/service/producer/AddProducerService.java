package lv.javaguru.novopol.logic.service.producer;

import lv.javaguru.novopol.logic.api.producer.AddProducerRequest;
import lv.javaguru.novopol.logic.api.producer.AddProducerResponse;

public interface AddProducerService {
	AddProducerResponse addProducer(AddProducerRequest request);
}
