package lv.javaguru.novopol.logic.api.surfacetype;

import java.util.UUID;

public class AddSurfaceTypeResponse {
	private final UUID surfaceType;

	public AddSurfaceTypeResponse (UUID surfaceType) {
		super();
		this.surfaceType = surfaceType;
	}

	public UUID getSupplier() {
		return surfaceType;
	}
}
