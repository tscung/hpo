package sg.com.stellarstudios.imser.web.struts.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.service.ConfigurationService;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.common.WebUtility;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {
	private static final String CHANGE_PASSWORD_ACTIONCOMMAND = "preloadChangePassword";
	protected ConfigurationService configurationService;
	
	public void init() {
		configurationService = (ConfigurationService) ServiceLocator.getInstance().getApplicationContext().getBean("configurationService");
	}
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = WebUtility.getInstance().getServletRequest(actionInvocation.getInvocationContext());
	    HttpServletResponse response = WebUtility.getInstance().getServletResponse(actionInvocation.getInvocationContext());

	    HttpSession session =  request.getSession(true);	    
		User user = (User) session.getAttribute(WebKeys.USER_OBJECT_PRINCIPAL);
		String requestURL = request.getRequestURL().toString();
		String requestPg = WebUtility.getInstance().getRequestPage(request);

		boolean performAuth = false;
		if (requestPg.contains(configurationService.getWebAdminFolder())) {
			performAuth = true;
		}
		else {
			//check if request uri is restricted
			String[] authWebURLs = configurationService.getWebAuthUrls();
			for (int i = 0; i < authWebURLs.length; i++) {
				String authWebURL = authWebURLs[i];
				if (requestURL.contains(authWebURL)) {
					performAuth = true;
					break;
				}
			}
		}
		
		//if logged in but not accessing admin folder
		if (user != null && !request.getRequestURL().toString().contains(configurationService.getWebAdminFolder()) && !request.getRequestURL().toString().contains(CHANGE_PASSWORD_ACTIONCOMMAND)) {
    		//if password is not changed, redirect.
    		ConfigurationService configurationService = (ConfigurationService) ServiceLocator.getInstance().getBean("configurationService");

    		if (user.getPassword().equals(configurationService.getUserDefaultPassword()) || user.getPassword().equals(configurationService.getF5StaffDefaultPassword()) || user.getPassword().equals(configurationService.getPrivilegedUserDefaultPassword())) {
    			String url = request.getContextPath()+"/preloadChangePasswordUser." + WebKeys.ACTION_EXTENSION;
    			response.sendRedirect(url);
    			return null;
    		}
    		else return actionInvocation.invoke();
		}

	    if (performAuth) {
	    	//check if is in noauth
			String[] webNoauthUrls = configurationService.getWebNoauthUrls();
	    	for (int i = 0; i < webNoauthUrls.length; i++) {
	    		String webNoauthUrl = webNoauthUrls[i];
	    		if (requestURL.contains(webNoauthUrl)) return actionInvocation.invoke();
	    	}
	    	
	    	boolean forwardToLoginPage = false;
	    	//if logged in
	    	if (user != null) {
	    		//if accessing admin folder, need to check userauthmodule
	    		if (request.getRequestURL().toString().contains(configurationService.getWebAdminFolder())) {
	    			//admin users will have a userauthorizedmodule
	    			if (user.getAuthorizedModules() != null) {
	    				//see if is accessing admin no auth
	    				String[] adminNoAuthModules = configurationService.getAdminNoAuthModules();
	    				for (int i = 0; i < adminNoAuthModules.length; i++) {
	    					if (requestURL.contains(adminNoAuthModules[i])) {
	    						return actionInvocation.invoke();
	    					}
	    				}
	    				
	    				//else check for auth modules
	    				String[] userAuthorizedModuleArr = Utility.getInstance().buildStringArrayFromString(user.getAuthorizedModules(), GlobalKeys.CONFIGURATION_DELIM);
	    				for (int i = 0; i < userAuthorizedModuleArr.length; i++) {
	    					String userAuthorizedModuleStr = userAuthorizedModuleArr[i];
	    					if (requestURL.contains(userAuthorizedModuleStr)) {
	    						return actionInvocation.invoke();
	    					}						
	    				}
	    			}
	    			//if no auth modules found, forward to login.
	    			forwardToLoginPage = true;
	    		}
	    	}
	    	//if not logged in, forward to login
	    	else forwardToLoginPage = true;

	    	if (forwardToLoginPage) {
	    		boolean isPopup = false, contentOnly = false;
	    		//check for isPopup and contentOnly
	    		if (request.getParameter("isPopup") != null && request.getParameter("isPopup").equals("true")) isPopup = true;
	    		if (request.getParameter("contentOnly") != null && request.getParameter("contentOnly").equals("true")) contentOnly = true;
	    		
	    		//include request page as forwardPg in login
	    		String url = "";
	    		//forward to admin login
	    		if (requestPg.contains(configurationService.getWebAdminFolder())) url = request.getContextPath()+"/admin/preloadLoginUser." + WebKeys.ACTION_EXTENSION + "?&restricted=true" + ((contentOnly)?"&contentOnly=true":"") + ((isPopup)?"&isPopup=true":"") + "&forwardPg=" + URLEncoder.encode(requestPg,"iso-8859-1");
	    		else url = request.getContextPath()+"/preloadLoginUser." + WebKeys.ACTION_EXTENSION + "?&restricted=true" + ((contentOnly)?"&contentOnly=true":"") + ((isPopup)?"&isPopup=true":"") + "&forwardPg=" + URLEncoder.encode(requestPg,"iso-8859-1");

	    		response.sendRedirect(url);
	    	}
	    }
	    else return actionInvocation.invoke();
	    return null;
	}
}
