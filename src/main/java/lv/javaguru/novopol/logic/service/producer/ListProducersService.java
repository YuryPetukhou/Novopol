package lv.javaguru.novopol.logic.service.producer;

import lv.javaguru.novopol.logic.api.producer.ListProducersRequest;
import lv.javaguru.novopol.logic.api.producer.ListProducersResponse;

public interface ListProducersService {
	ListProducersResponse getProducers (ListProducersRequest request);
}
