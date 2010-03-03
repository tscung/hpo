package sg.com.stellarstudios.imser.dao;

import java.util.List;

import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.exception.HelperException;

public class UserDAO extends BaseDAO {
	protected void initProxies(Object abstractEntity,boolean fullInit) {
		//if retrieve records thru' search, do not init proxies.
		if (abstractEntity.getClass().isAssignableFrom(Object[].class)) return;
	}
	public Boolean isEmailRegistered(String email) throws HelperException {
		List res = super.retrieveRecords("select count(*) from User as o where o.email = '" + email + "'", false, false);
		return (Long)res.get(0) != 0;
	}
	public User retrieveRecordForLogin(String email) throws HelperException {
		List res = super.retrieveRecords("from User as o where o.email = '" + email + "'", false, false);
		if (res.size() > 0) {
			return (User) res.get(0);
		}
		else return null;
	}
	public void verifyEmail(String email) throws HelperException {
		hibernateTemplate.bulkUpdate("update User as o set o.enabled = 'Yes' where o.email = '" + email + "'");
	}
}
