package lv.javaguru.novopol.logic.api.supplier;

import java.util.UUID;

public class RemoveSupplierRequest {
	private final UUID id;

	public RemoveSupplierRequest (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
