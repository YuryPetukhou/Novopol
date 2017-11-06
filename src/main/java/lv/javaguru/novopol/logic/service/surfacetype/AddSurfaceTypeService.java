package lv.javaguru.novopol.logic.service.surfacetype;

import lv.javaguru.novopol.logic.api.surfacetype.AddSurfaceTypeRequest;
import lv.javaguru.novopol.logic.api.surfacetype.AddSurfaceTypeResponse;

public interface AddSurfaceTypeService {
	AddSurfaceTypeResponse addSurfaceType(AddSurfaceTypeRequest request);
}
