package lv.javaguru.novopol.logic.api.product;

import java.util.UUID;

public class RemoveProductRequest {
	private final UUID id;

	public RemoveProductRequest(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
