package lv.javaguru.novopol.logic.api.surfacetype;

public class AddSurfaceTypeResponse {
	private final String surfaceType;

	public AddSurfaceTypeResponse (String surfaceType) {
		super();
		this.surfaceType = surfaceType;
	}

	public String getSupplier() {
		return surfaceType;
	}
}
