package lv.javaguru.novopol.logic.api.surfacetype;

public class RemoveSurfaceTypeResponse {
	private final boolean removed;

	public RemoveSurfaceTypeResponse(boolean removed) {
		this.removed = removed;
	}

	public boolean isRemoved() {
		return removed;
	}
}
