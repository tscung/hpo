package sg.com.stellarstudios.imser.service;

import java.util.List;

import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.exception.ServiceException;

public class PreloadDataService extends BaseService {
	private static final int CACHE_CHECK = 0;
	private static final int CACHE_SAVE = 1;
	
	public List retrieveAll(Class classType) throws ServiceException {
		List ret = null;
		
		try {
			ret = hitCacheIfAny(classType, CACHE_CHECK, null);
			if (ret == null) {
				ret = dao.retrieveRecords(classType,"");
				hitCacheIfAny(classType, CACHE_SAVE, ret);
			}
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
		
		return ret;
	}
	public List retrieveAll(Class classType,String sortBy) throws ServiceException {
		List ret = null;
		
		try {
			ret = hitCacheIfAny(classType, CACHE_CHECK, null);
			if (ret == null) {
				ret = dao.retrieveRecords(classType,sortBy);
				hitCacheIfAny(classType, CACHE_SAVE, ret);
			}
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
		
		return ret;
	}
	private List hitCacheIfAny(Class classType, int action, List results) {
		List ret = null;

		return ret;
	}
	public List retrieveDistinctField(Class classType,String fieldName) throws ServiceException {
		List ret = null;
		
		try {
			ret = dao.retrieveDistinctField(classType,fieldName);
		}
		catch (HelperException e) {
			logHelper.error(e);
			throw new ServiceException();
		}
		
		return ret;
	}
}
