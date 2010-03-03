package sg.com.stellarstudios.imser.service;

import java.util.HashMap;
import java.util.Map;

import sg.com.stellarstudios.imser.common.LocalCache;
import sg.com.stellarstudios.imser.dao.UserDAO;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.exception.ServiceException;
import sg.com.stellarstudios.imser.helper.EmailHelper;

public class UserService extends BaseService {
	private EmailHelper emailHelper;
	public void setEmailHelper(EmailHelper emailHelper) { this.emailHelper = emailHelper; }
	
	public Boolean isEmailRegistered(String email) throws ServiceException {
		Boolean ret = false;
		
		Map emailCache = (Map) LocalCache.getInstance().get("isEmailRegistered");
		if (emailCache == null) {
			emailCache = new HashMap();
			LocalCache.getInstance().put("isEmailRegistered", emailCache);
		}
		if (emailCache.get(email) != null) ret = (Boolean) emailCache.get(email);
		else {
			try {
				ret = ((UserDAO)dao).isEmailRegistered(email);
				emailCache.put(email, ret);
			}
			catch (HelperException e) {
				logHelper.error(e);
				throw new ServiceException(e);
			}
		}
		
		return ret;
	}
	public User retrieveForLogin(String email) throws ServiceException {
		User ret = null;
		
		try {
			ret = ((UserDAO)dao).retrieveRecordForLogin(email);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	public Boolean requestForPassword(String email) {
		Boolean ret = false;
		try {
			User user = retrieveForLogin(email);
			if (user != null) {
				emailHelper.sendRequestForPasswordEmail(user);
				ret = true;
			}
			else ret = false;
		}
		catch (Exception e) {
			logHelper.error(e);
			ret = false;
		}
		
		return ret;
	}

}
