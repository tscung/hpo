package sg.com.stellarstudios.imser.web.struts.action;

import java.util.Calendar;

import javax.servlet.http.Cookie;

import org.directwebremoting.WebContextFactory;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.LocalCache;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.entity.UserRegistration;
import sg.com.stellarstudios.imser.service.UserRegistrationService;
import sg.com.stellarstudios.imser.service.UserService;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.struts.ModelDrivenAction;

import com.opensymphony.xwork2.Preparable;

public class UserAction extends ModelDrivenAction implements Preparable {
	private UserRegistrationService userRegistrationService;

	public void prepare() throws Exception {
		super.prepare();
	}
	
	public BaseEntity getNewModel() {
		return new UserRegistration();
	}

	//************************************ FREE ACCESS METHODS ************************************
	public String preloadLogin() throws Exception {
		UserRegistration userRegistration = (UserRegistration)getModel();
		userRegistration.setUser(new User());
		userRegistration.getUser().setRememberLogin(false);

		//check for remember site login.
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			String email = "", password = "";
			for (int i = 0; i < cookies.length; i++) {
				String cookieName = cookies[i].getName();
				String cookieValue = cookies[i].getValue();
				
				if (cookieName.equals(WebKeys.REMEMBER_LOGIN_EMAIL)) email = cookieValue;
				if (cookieName.equals(WebKeys.REMEMBER_LOGIN_PASSWORD)) password = cookieValue;
			}
			
			if (!email.equals("") && !password.equals("")) {
				User retrievedUser = ((UserService)service).retrieveForLogin(email);
				if (retrievedUser != null) {
					session.put(WebKeys.USER_OBJECT_PRINCIPAL, retrievedUser);
					return "preloadHome";
				}
			}
		}
		
		request.setAttribute(WebKeys.ACTION_COMMAND, "preloadLogin");
		
		return "preloadLogin";
	}
	public String preloadRequestForPassword() throws Exception {
		request.setAttribute(WebKeys.ACTION_COMMAND, "preloadRequestForPassword");
		return "preloadRequestForPassword";
	}
	
	//************************************ RESTRICTED METHODS ************************************
	public String preloadHome() throws Exception {
		User retrievedUser = (User) session.get(WebKeys.USER_OBJECT_PRINCIPAL);
		
		if (retrievedUser != null && retrievedUser.getRememberLogin() != null && retrievedUser.getRememberLogin()) {
			Cookie newCookieEmail = new Cookie(WebKeys.REMEMBER_LOGIN_EMAIL, retrievedUser.getEmail());
			Cookie newCookiePassword = new Cookie(WebKeys.REMEMBER_LOGIN_PASSWORD, retrievedUser.getPassword());
			response.addCookie(newCookieEmail);
			response.addCookie(newCookiePassword);
		}
		
		request.setAttribute(WebKeys.ACTION_COMMAND, "preloadHome");
		return "home";
//		if (retrievedUser.getUserRegistration().getCompletedEvaluation()) {
//			return "home";
//		}
//		else {
//			setUserRegistrationId(retrievedUser.getUserRegistration().getId());
//			return "evaluationForm";
//		}
	}	

	public String preloadChangePassword() throws Exception {
		request.setAttribute(WebKeys.ACTION_COMMAND, "preloadChangePassword");
		return "preloadChangePassword";
	}
	
	public String logout() throws Exception {
		session.remove(WebKeys.USER_OBJECT_PRINCIPAL);
		request.getSession().invalidate();
		request.setAttribute(WebKeys.ACTION_COMMAND, "logout");
		
		Cookie[]cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if (cookie.getName().contains(WebKeys.REMEMBER_LOGIN_EMAIL) || cookie.getName().contains(WebKeys.REMEMBER_LOGIN_PASSWORD)) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		return "logout";
	}
	
	//************************************ DWR METHOD ******************************************
	public Boolean isEmailRegistered(String email) throws Exception {
		return ((UserService)service).isEmailRegistered(email);
	}
	
	public Boolean isOldPasswordMatched(String oldPassword) throws Exception {
		User user = (User) WebContextFactory.get().getSession().getAttribute(WebKeys.USER_OBJECT_PRINCIPAL);
		return user.getPassword().equals(oldPassword);
	}
	
	public Boolean changePassword(String oldPassword, String newPassword, String reenterPassword) throws Exception {
		Boolean ret = false;
		
		if (newPassword.equals(reenterPassword)) {
			if (isOldPasswordMatched(oldPassword)) {
				User user = (User) WebContextFactory.get().getSession().getAttribute(WebKeys.USER_OBJECT_PRINCIPAL);
				user.setPassword(newPassword);
				service.update(user);
				ret = true;
				
				WebContextFactory.get().getSession().setAttribute(WebKeys.USER_OBJECT_PRINCIPAL, user);
			}
		}
		
		return ret;
	}
	
	public Boolean loginAJAX(String email, String password, int type, boolean rememberLogin) throws Exception {
		User retrievedUser = ((UserService)service).retrieveForLogin(email);

		Boolean loggedIn = false;
		//if found email && password is not the same
		if (retrievedUser != null && !retrievedUser.getPassword().equalsIgnoreCase(password)) {
			loggedIn = false;
		}
		else {
			if (retrievedUser == null) {
				//if no email found for administrator login, deny.
				if (type == 0) { loggedIn = false; }
				//if no email found for site login...
				else {
					//only allow login for new user if entered default password
					//4 Mar 08 - changed login pwd to restricted. have done for all users that have not completed evaluation too.
					String FEEDBACK_PASSWORD = "restricted";
//					if (password.equals(configurationService.getUserDefaultPassword()) ||
//							password.equals(configurationService.getF5StaffDefaultPassword()) ||
//							password.equals(configurationService.getPrivilegedUserDefaultPassword()) ||
//							password.equals(FEEDBACK_PASSWORD)) {
					if (password.equals(FEEDBACK_PASSWORD)) {
						//create new entry
						retrievedUser = new User();
						retrievedUser.setEmail(email);
						UserRegistration userRegistration = new UserRegistration();
						userRegistration.setUser(retrievedUser);
						userRegistration.setRegistrationStatus(GlobalKeys.REGISTRATION_STATUS_SAVED);
						userRegistration.setApprovedStatus(GlobalKeys.REGISTRATION_NOT_APPROVED_YET);
						userRegistration.setDateSaved(Calendar.getInstance());

						if (password.equals(configurationService.getUserDefaultPassword())) userRegistration.setF5Staff(false);
						if (password.equals(configurationService.getF5StaffDefaultPassword())) userRegistration.setF5Staff(true);

						if (password.equals(configurationService.getPrivilegedUserDefaultPassword())) userRegistration.setPrivilegedUser(true);
						else userRegistration.setPrivilegedUser(false);
						if (userRegistration.getF5Staff() == null) userRegistration.setF5Staff(false);
						
						retrievedUser.setPassword(password);
						
						userRegistrationService.saveOnly(userRegistration);
						LocalCache.getInstance().clearEmailRegisteredCache();

						loggedIn = true;
					}
					//or deny access.
					else {
						loggedIn = false;
					}
				}
			}
			else {
				loggedIn = true;
			}
			
			if (loggedIn) {
				WebContextFactory.get().getSession().setAttribute(WebKeys.USER_OBJECT_PRINCIPAL, retrievedUser);
				retrievedUser.setRememberLogin(rememberLogin);
			}
		}
		
		return loggedIn;
	}
	
	public Boolean requestForPassword(String email) throws Exception {
		return ((UserService)service).requestForPassword(email);
	}

	//****************************** GET/SET METHODS ********************************
	private Integer userRegistrationId; 
	
	public Integer getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Integer userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

	public void setUserRegistrationService(
			UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}
}
