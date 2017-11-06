package lv.javaguru.novopol.logic.service.surfacetype;

import lv.javaguru.novopol.logic.api.surfacetype.ListSurfaceTypesRequest;
import lv.javaguru.novopol.logic.api.surfacetype.ListSurfaceTypesResponse;

public interface ListSurfaceTypeService {
	ListSurfaceTypesResponse getSurfaceTypes (ListSurfaceTypesRequest request);
}
