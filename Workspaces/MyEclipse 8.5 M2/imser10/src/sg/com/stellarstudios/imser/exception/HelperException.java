package sg.com.stellarstudios.imser.exception;

public class HelperException extends BaseException {
	public HelperException() {
		super();
	}
	public HelperException(Exception e) {
		super(e);
	}
	public HelperException(String message) {
		super(message);
	}
}
