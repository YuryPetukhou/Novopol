package lv.javaguru.novopol.logic.api.surfacetype;

import java.util.UUID;

public class RemoveSurfaceTypeRequest {
	private final String surfaceType;
	private UUID id;

	public RemoveSurfaceTypeRequest(String surfaceType) {
		this.surfaceType = surfaceType;
	}

	public RemoveSurfaceTypeRequest(String surfaceType, UUID id) {
		this.surfaceType = surfaceType;
		this.id = id;
	}

	public String getSurfaceType() {
		return surfaceType;
	}

	public UUID getId() {
		return id;
	}

}
