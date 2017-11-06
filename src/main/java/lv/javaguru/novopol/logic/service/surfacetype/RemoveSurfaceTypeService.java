package lv.javaguru.novopol.logic.service.surfacetype;

import lv.javaguru.novopol.logic.api.surfacetype.RemoveSurfaceTypeRequest;
import lv.javaguru.novopol.logic.api.surfacetype.RemoveSurfaceTypeResponse;

public interface RemoveSurfaceTypeService {
	RemoveSurfaceTypeResponse removeSurfaceType (RemoveSurfaceTypeRequest request);
}
