package lv.javaguru.novopol.dal;

public class DBException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6266442987950779098L;

	public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}
