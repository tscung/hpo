package sg.com.stellarstudios.imser.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.UserRegistration;
import sg.com.stellarstudios.imser.exception.HelperException;

public class UserRegistrationDAO extends BaseDAO {
	public BaseEntity createRecord(BaseEntity obj) throws HelperException {
		UserRegistration entity = (UserRegistration) obj;
		super.createRecord(entity.getUser());
		super.createRecord(entity);
		
		entity.getUser().getUserRegistrations().add(entity);
		
		return entity;
	}
	public BaseEntity updateRecord(BaseEntity obj) throws HelperException {
		UserRegistration entity = (UserRegistration) obj;
		//user acc is loaded eagerly. so already in session.
		super.updateRecord(entity.getUser());		
		super.updateRecord(entity);

		entity.getUser().getUserRegistrations().add(entity);
		
		return entity;
	}
	public BaseEntity deleteRecord(BaseEntity obj) throws HelperException {
		UserRegistration entity = (UserRegistration) obj;
		//deleting user will cascade delete for userregistration
		entity = (UserRegistration) retrieveRecord(obj);
		super.deleteRecord(entity.getUser());
		return obj;
	}	
	public BaseEntity retrieveRecord(BaseEntity obj) throws HelperException {
		UserRegistration entity = (UserRegistration) super.retrieveRecord(obj);

		if (entity.getUser().getAuthorizedModules() != null) {
			//convert string into array
			String[] userAuthorizedModuleArr = Utility.getInstance().buildStringArrayFromString(entity.getUser().getAuthorizedModules(), GlobalKeys.CONFIGURATION_DELIM);
			
			for (int i = 0; i < userAuthorizedModuleArr.length; i++) {
				String module = userAuthorizedModuleArr[i];
				entity.getUser().getAuthorizedModulesBoolean().put(module, new String[]{"true"});
			}
		}
		
		return entity;
	}
	protected void initProxies(Object abstractEntity,boolean fullInit) {
		//if retrieve records thru' search, do not init proxies.
		if (abstractEntity.getClass().isAssignableFrom(Object[].class)) return;
	}
	
	public List retrieveAll(Integer status) throws HelperException {
		return super.retrieveRecords("from UserRegistration as o where o.registrationStatus = " + status + " order by o.dateSaved desc");
	}	
	
	public List retrieveSubmitted(String date) throws HelperException {
		return super.retrieveRecords("from UserRegistration as o where o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SUBMITTED + "" +
				" and date(o.dateSaved) = '" + Utility.getInstance().convertDDMMYYtoYYMMDDDelimDash(date) + "' order by o.dateSaved desc");
	}
	
	public List retrieveDistinctSaveDates() throws HelperException {
		List ret = new ArrayList();
		List dates = super.retrieveRecords("select distinct date(o.dateSaved) from UserRegistration as o where o.user.id != " + GlobalKeys.ADMIN_USER_ID + "order by date(o.dateSaved) desc");
		for (Iterator itr = dates.iterator(); itr.hasNext(); ) {
			Date date = (Date) itr.next();
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);
			
			ret.add(cal);
		}
		return ret;
	}
	
	public List retrieveDataFigures() throws HelperException {
		List ret = new ArrayList();

		ret.add(super.retrieveRecords("select count(*) from UserRegistration as o where o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SUBMITTED + "").get(0));
		ret.add(super.retrieveRecords("select count(*) from UserRegistration as o where o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SAVED + "").get(0));

		return ret;
	}	
	public List retrieveCountByCoolDownSocialEvents(Integer excludeId) throws HelperException {
		String excludeSql = "";
		if (excludeId != null) excludeSql = "o.id != " + excludeId + " and ";
		return super.retrieveRecords("select count(*), o.coolDownSocialEvents from UserRegistration as o where " + excludeSql + "o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SUBMITTED + " group by o.coolDownSocialEvents order by o.coolDownSocialEvents");
	}
	public Long retrieveCountByCoolDownSocialEvent(Integer event,Integer excludeId) throws HelperException {
		String excludeSql = "";
		if (excludeId != null) excludeSql = "o.id != " + excludeId + " and ";
		return (Long)super.retrieveRecords("select count(*) from UserRegistration as o where " + excludeSql + "o.coolDownSocialEvents = " + event + " and o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SUBMITTED + "").get(0);
	}
	public List retrieveUserRegistrationsByApprovedStatus(Integer approvedStatus) throws HelperException {
//		String hql = "from UserRegistration as o where o.approvedStatus = :approvedStatus and o.registrationStatus = :registrationStatus order by o.dateSaved";
//		return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql)
//			.setInteger("approvedStatus", approvedStatus)
//			.setInteger("registrationStatus", GlobalKeys.REGISTRATION_STATUS_SUBMITTED)
//			.list();
		return super.retrieveRecords("from UserRegistration as o where o.approvedStatus = " + approvedStatus + " and o.registrationStatus = " + GlobalKeys.REGISTRATION_STATUS_SUBMITTED + " order by o.dateSaved");
	}
	public List retrieveAllUserRegistrationsWhoCompletedEvaluationForm() throws HelperException {
		return super.retrieveRecords("from UserRegistration as o where o.completedEvaluation = 1 order by o.dateCompletedEvaluation");
	}
	public int updateField(Integer id, String fieldName, String fieldValue, Integer methodParamType) throws HelperException {
		int ret = 0;
		
		String hql = "update UserRegistration as o set o." + fieldName +" = :fieldValue where o.id = :id";

		if (methodParamType == GlobalKeys.PARAM_TYPE_STRING || methodParamType == GlobalKeys.PARAM_TYPE_INTEGER) {
			hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql)
			.setString("fieldValue", fieldValue)
			.setInteger("id", id)
			.executeUpdate();
		}
		if (methodParamType == GlobalKeys.PARAM_TYPE_CALENDAR) {
			ret = hibernateTemplate.bulkUpdate("update UserRegistration as o set o." + fieldName +" = '" + fieldValue + "' where o.id = " + id);
		}
		if (methodParamType == GlobalKeys.PARAM_TYPE_BOOLEAN) {
			hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql)
			.setBoolean("fieldValue", new Boolean(fieldValue))
			.setInteger("id", id)
			.executeUpdate();
		}
		
		return ret;
	}
}
