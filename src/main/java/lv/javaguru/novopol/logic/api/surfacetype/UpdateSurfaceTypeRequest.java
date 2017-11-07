package lv.javaguru.novopol.logic.api.surfacetype;

import lv.javaguru.novopol.domain.Supplier;

public class UpdateSurfaceTypeRequest {
	private final String surfaceType;

	public UpdateSurfaceTypeRequest(String surfaceType) {
		this.surfaceType = surfaceType;
	}
	
	public String getSurfaceType() {
		return surfaceType;
	}
}
