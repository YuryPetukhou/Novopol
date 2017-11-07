package lv.javaguru.novopol.logic.api.surfacetype;

import java.util.UUID;

public class RemoveSurfaceTypeRequest {
	private final UUID id;

	public RemoveSurfaceTypeRequest (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
