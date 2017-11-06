package lv.javaguru.novopol.logic.service.producer;

import lv.javaguru.novopol.logic.api.producer.UpdateProducerRequest;
import lv.javaguru.novopol.logic.api.producer.UpdateProducerResponse;

public interface UpdateProducerService {
	UpdateProducerResponse updateProducer (UpdateProducerRequest request);

}
