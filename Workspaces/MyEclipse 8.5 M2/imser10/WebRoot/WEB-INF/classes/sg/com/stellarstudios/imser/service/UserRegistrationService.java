package sg.com.stellarstudios.imser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.dao.UserRegistrationDAO;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.UserRegistration;
import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.exception.ServiceException;
import sg.com.stellarstudios.imser.helper.EmailHelper;
import sg.com.stellarstudios.imser.web.common.WebConstants;

public class UserRegistrationService extends BaseService {
	private EmailHelper emailHelper;
	public void setEmailHelper(EmailHelper emailHelper) { this.emailHelper = emailHelper; }

	public BaseEntity makeNew(BaseEntity entity) throws ServiceException {
		return super.create(entity);
	}
	public void sendUserRegistrationEmail(UserRegistration entity) throws ServiceException {
		emailHelper.sendUserRegistrationEmail(entity);
	}
	public BaseEntity saveOnly(BaseEntity entity) throws ServiceException {
		return super.create(entity);
	}
	
	public void sendReminderEmail(String emailsStr,String emailSubject) throws ServiceException {
		if (emailsStr != null) {
			List emailsList = new ArrayList();
			emailsStr = Utility.getInstance().replace(emailsStr, "\r\n", WebConstants.REMINDER_EMAIL_DELIM);
			StringTokenizer st = new StringTokenizer(emailsStr,WebConstants.REMINDER_EMAIL_DELIM);
			while (st.hasMoreTokens()) {
				String email = st.nextToken().trim();
				emailsList.add(email);
			}
			
			String[]emails = new String[emailsList.size()];
			for (int i = 0; i < emailsList.size(); i++) emails[i] = emailsList.get(i).toString();
			
			emailHelper.sendReminderEmail(emails,emailSubject);
		}
	}
	public List retrieveAll(Integer status) throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveAll(status);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}	
	
	public List retrieveSubmitted(String date) throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveSubmitted(date);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	
	public List retrieveDistinctSaveDates() throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveDistinctSaveDates();
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	
	public List retrieveDataFigures() throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveDataFigures();
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	
	//used to retrieve count for display on page.
	public List retrieveCountByCoolDownSocialEvents(Integer excludeId) throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveCountByCoolDownSocialEvents(excludeId);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	//used to validate selected event against that in the database to see if busted. hence shud exclude ownself.
	public Long retrieveCountByCoolDownSocialEvent(Integer event,Integer excludeId) throws ServiceException {
		Long ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveCountByCoolDownSocialEvent(event,excludeId);
			ret += getReservedSeats(event);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	public List retrieveAllUserRegistrationsWhoCompletedEvaluationForm() throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveAllUserRegistrationsWhoCompletedEvaluationForm();
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	public List retrieveUserRegistrationsByApprovedStatus(Integer approvedStatus) throws ServiceException {
		List ret = null;
		
		try {
			ret = ((UserRegistrationDAO)dao).retrieveUserRegistrationsByApprovedStatus(approvedStatus);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	public int updateField(Integer id, String fieldName, String fieldValue, Integer methodParamType) throws ServiceException {
		int ret = 0;
		
		try {
			ret = ((UserRegistrationDAO)dao).updateField(id, fieldName, fieldValue, methodParamType);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException(e);
		}
		
		return ret;
	}
	public Integer getReservedSeats(Integer event) {
		/* Removed all reservations on 11th Jan 08.
		 * 
		//golf 1 : Song Tang Yih
		if (event == 1) return 15;
		//go kart 1 : Dave Dormer
		if (event == 2) return 12;
		if (event == 3) return 12;
		if (event == 4) return 8;
		if (event == 5) return 10;
		if (event == 6) return 0;
		 */
		
		return 0;
	}
}
