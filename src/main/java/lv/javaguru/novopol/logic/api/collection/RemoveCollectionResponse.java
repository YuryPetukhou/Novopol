package lv.javaguru.novopol.logic.api.collection;


public class RemoveCollectionResponse {
	private final boolean id;

	public RemoveCollectionResponse (boolean id) {
		this.id = id;
	}

	public boolean getId() {
		return id;
	}
}
