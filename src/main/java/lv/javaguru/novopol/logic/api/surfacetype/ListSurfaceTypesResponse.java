package lv.javaguru.novopol.logic.api.surfacetype;

import java.util.List;

public class ListSurfaceTypesResponse {
	private final List<String> surfaceTypes;

	public ListSurfaceTypesResponse(List<String> surfaceTypes) {
		super();
		this.surfaceTypes = surfaceTypes;
	}

	public List<String> getSurfaceTypes() {
		return surfaceTypes;
	}
}
