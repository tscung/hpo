package sg.com.stellarstudios.imser.service;

import java.util.Map;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.helper.LogHelper;
import sg.com.stellarstudios.imser.web.common.WebKeys;

public class ConfigurationService extends BaseService {
	protected LogHelper logHelper;
	
	private Map declarativeProperties;
	public Map getDeclarativeProperties() { return declarativeProperties; }
	public void setDeclarativeProperties(Map declarativeProperties) { this.declarativeProperties = declarativeProperties; }

	public String getWebActionExtension() {
		return WebKeys.ACTION_EXTENSION;
	}
	
	//-------------------------- PROP FILE CONFIGURABLES ---------------------------
	public String getAppWebRoot() {
		return declarativeProperties.get("conf.appWebroot").toString();
	}
	public String getAppRoot() {
		return declarativeProperties.get("conf.appRoot").toString();
	}
	public String[] getAuthorizedModules() {
		return Utility.getInstance().buildStringArrayFromString(declarativeProperties.get("conf.authorizedModules").toString(), GlobalKeys.CONFIGURATION_DELIM);
	}
	public String[] getAuthorizedModulesLabel() {
		return Utility.getInstance().buildStringArrayFromString(declarativeProperties.get("conf.authorizedModulesLabel").toString(), GlobalKeys.CONFIGURATION_DELIM);
	}
	public String[] getWebNoauthUrls() {
		return Utility.getInstance().buildStringArrayFromString(declarativeProperties.get("conf.webNoauthUrls").toString(), GlobalKeys.CONFIGURATION_DELIM);
	}	
	public String[] getWebAuthUrls() {
		return Utility.getInstance().buildStringArrayFromString(declarativeProperties.get("conf.webAuthUrls").toString(), GlobalKeys.CONFIGURATION_DELIM);
	}
	public String getWebAdminFolder() {
		return declarativeProperties.get("conf.webAdminFolder").toString();
	}
	public String[] getAdminNoAuthModules() {
		return Utility.getInstance().buildStringArrayFromString(declarativeProperties.get("conf.adminNoAuthModules").toString(), GlobalKeys.CONFIGURATION_DELIM);
	}
	public String getUserDefaultPassword() {
		return declarativeProperties.get("conf.userDefaultPassword").toString();
	}
	public String getF5StaffDefaultPassword() {
		return declarativeProperties.get("conf.f5StaffDefaultPassword").toString();
	}
	public String getPrivilegedUserDefaultPassword() {
		return declarativeProperties.get("conf.privilegedUserDefaultPassword").toString();
	}
}
