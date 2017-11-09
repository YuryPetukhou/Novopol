package lv.javaguru.novopol.logic.api.surfacetype;

import lv.javaguru.novopol.domain.Supplier;

public class AddSurfaceTypeRequest {
	private final String surfaceType;

	public AddSurfaceTypeRequest(String surfaceType) {
		super();
		this.surfaceType = surfaceType;
	}

	public String getSurfaceType() {
		return surfaceType;
	}
}
