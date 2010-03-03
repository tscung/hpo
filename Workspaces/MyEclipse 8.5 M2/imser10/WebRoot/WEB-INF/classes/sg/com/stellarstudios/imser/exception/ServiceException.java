package sg.com.stellarstudios.imser.exception;

public class ServiceException extends BaseException {
	public ServiceException() {
		super();
	}
	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message) {
		super(message);
	}
}
