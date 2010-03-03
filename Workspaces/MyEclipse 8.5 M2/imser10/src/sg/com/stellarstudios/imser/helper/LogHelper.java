package sg.com.stellarstudios.imser.helper;

import org.apache.log4j.Logger;

public class LogHelper extends BaseHelper {
	private final static String EXCEPTIONMSG = "SYSEXCEPTION:";

	private Logger logger = Logger.getRootLogger();

	public void info(String message) {
		logger.info(message);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void error(Exception exception) {
		logger.error(EXCEPTIONMSG, exception);
	}
	public void error(Throwable exception) {
		logger.error(EXCEPTIONMSG, exception);
	}
}
