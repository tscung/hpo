package sg.com.stellarstudios.imser.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import sg.com.stellarstudios.imser.helper.LogHelper;

public class ServiceLocator implements ApplicationContextAware {
	private static ServiceLocator me;

	public static ServiceLocator getInstance() {
		if (me == null)
			me = new ServiceLocator();

		return me;
	}
	
	public ServiceLocator() { me = this; }

	private ApplicationContext applicationContext;

	private LogHelper logHelper;

	public LogHelper getLogHelper() {
		return logHelper;
	}

	public void setLogHelper(LogHelper logHelper) {
		this.logHelper = logHelper;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	//**************************** CONVENIENCE METHODS ***********************************	
	public Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}
