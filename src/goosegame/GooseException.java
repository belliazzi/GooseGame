package goosegame;

public class GooseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message ;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GooseException(String message) {
		super();
		this.message = message;
	}
	
}
