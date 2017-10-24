package lv.javaguru.novopol.logic.api.product;

import java.util.UUID;

public class AddProductResponse {
	private final UUID id;

	public AddProductResponse(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
