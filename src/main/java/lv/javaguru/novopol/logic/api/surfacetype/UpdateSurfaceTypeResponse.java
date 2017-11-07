package lv.javaguru.novopol.logic.api.surfacetype;

public class UpdateSurfaceTypeResponse {
private final boolean updated;
	
	public UpdateSurfaceTypeResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}

}
