package sg.com.stellarstudios.imser.service;

import java.util.List;

import sg.com.stellarstudios.imser.dao.BaseDAO;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.search.SearchCriteria;
import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.exception.ServiceException;
import sg.com.stellarstudios.imser.helper.LogHelper;

public class BaseService {
	protected LogHelper logHelper;
	protected BaseDAO dao;
	protected ConfigurationService configurationService;
	
	public void setConfigurationService(ConfigurationService configurationService) { this.configurationService = configurationService; }
	public void setLogHelper(LogHelper logHelper) { this.logHelper = logHelper; }
	public void setDao(BaseDAO dao) { this.dao = dao; }

	public BaseEntity create(BaseEntity entity) throws ServiceException {
		try {
			return dao.createRecord(entity);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
	}

	public BaseEntity update(BaseEntity entity) throws ServiceException {
		try {
			return dao.updateRecord(entity);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
	}

	public BaseEntity delete(BaseEntity entity) throws ServiceException {
		try {
			return dao.deleteRecord(entity);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
	}

	public BaseEntity retrieve(BaseEntity entity) throws ServiceException {
		BaseEntity ret = null;

		try {
			ret = dao.retrieveRecord(entity);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}             
        
		return ret;
	}

	public List retrieve(Class classType,String sortBy) throws ServiceException {
		List ret = null;

		try {
			ret = dao.retrieveRecords(classType, sortBy);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}

		return ret;
	}
	public List retrieve(Class classType,String sortBy, Integer noOfItems) throws ServiceException {
		List ret = null;

		try {
			ret = dao.retrieveRecords(classType, sortBy, noOfItems);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}

		return ret;
	}

	public List search(SearchCriteria criteria) throws ServiceException {
		List ret = null;

		try {
			ret = dao.searchRecords(criteria);
		} catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}

		return ret;
	}
}
