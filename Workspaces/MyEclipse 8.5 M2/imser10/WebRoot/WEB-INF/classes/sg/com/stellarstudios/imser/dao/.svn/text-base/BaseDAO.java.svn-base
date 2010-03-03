package sg.com.stellarstudios.imser.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateSystemException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.search.PickCriteria;
import sg.com.stellarstudios.imser.entity.search.SearchCriteria;
import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.helper.LogHelper;
import sg.com.stellarstudios.imser.service.ConfigurationService;

public class BaseDAO {
	private static final int SEARCHSQL_RETRIEVEFIELDS = 0;
	private static final int SEARCHSQL_TARGETOBJECTS = 1;
	private static final int SEARCHSQL_JOINCONDITIONS = 2;
	private static final int SEARCHSQL_PICKCRITERIA = 3;
	private static final int SEARCHSQL_CUSTOMCRITERIA = 4;
	private static final int SEARCHSQL_ORDERBY = 5;
	private static final int SEARCHSQL_GROUPBY = 6;
	
	private static final int RETRIEVE_RECORDS_NO_LIMIT = 0;

	protected LogHelper logHelper;
	protected HibernateTemplate hibernateTemplate;
	protected ConfigurationService configurationService;

	// injector method(s)
	public void setLogHelper(LogHelper logHelper) { this.logHelper = logHelper; }
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { this.hibernateTemplate = hibernateTemplate; }
	public void setConfigurationService(ConfigurationService configurationService) { this.configurationService = configurationService; }
	
	public void explicitCommit() throws HelperException {
		try {
			hibernateTemplate.getSessionFactory().getCurrentSession().connection().commit();
		} catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		} catch (SQLException e) {
			logHelper.error(e);
			throw new HelperException();
		}
	}
	public BaseEntity createRecord(BaseEntity obj) throws HelperException {
		try {
			if (obj != null) {
				hibernateTemplate.saveOrUpdate(obj);
				//hibernateTemplate.evict(obj);
			}
		} catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		}
		
		return obj;
	}
	public BaseEntity createOrUpdateRecord(BaseEntity obj) throws HelperException {
		try {
			if (obj != null) {
				hibernateTemplate.saveOrUpdate(obj);
				//hibernateTemplate.evict(obj);
			}
		} catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		}
		
		return obj;
	}
	public BaseEntity updateRecord(BaseEntity obj) throws HelperException {
		try {
			if (obj != null) {
				hibernateTemplate.update(obj);
				//hibernateTemplate.evict(obj);
			}
		}
		catch(HibernateSystemException e) {
			hibernateTemplate.merge(obj);
		}
		catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		}
		
		return obj;
	}
	public BaseEntity deleteRecord(BaseEntity obj) throws HelperException {
		try {
			if (obj != null) {
				hibernateTemplate.delete(obj);
				//hibernateTemplate.evict(obj);
			}
		} catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		}
		
		return obj;
	}	
	protected boolean findRecord(Collection col,BaseEntity obj) {
		boolean found = false;
		if (col != null && obj != null) {
			for (Iterator itr = col.iterator(); itr.hasNext(); ) {
				BaseEntity setObj = (BaseEntity) itr.next();
				if (setObj.getId() != null && setObj.getId().equals(obj.getId())) found = true;
			}
		}
		return found;
	}
	protected String findPersistedRecordsIds(Collection col) {
		StringBuffer sb = new StringBuffer();
		
		int count = 0;
		for (Iterator itr = col.iterator(); itr.hasNext(); ) {
			BaseEntity entity = (BaseEntity) itr.next();
			if (entity.getId() != null) {
				if (count != 0) sb.append(",");
				sb.append("'" + entity.getId() + "'");
				count++;
			}			
		}
		//remove last comma
		String ret = sb.toString().substring(0,sb.toString().length());
		
		return ret;
	}
	public List searchRecords(SearchCriteria criteria) throws HelperException {
		StringBuffer sql = new StringBuffer();

		// if retrievefields and target objects are present
		if (!criteria.getRetrieveFields().isEmpty() && !criteria.getTargetObjects().isEmpty()) {
			sql = buildSearchSql(sql, criteria, SEARCHSQL_RETRIEVEFIELDS);
			sql = buildSearchSql(sql, criteria, SEARCHSQL_TARGETOBJECTS);

			// if join conditions are present
			if (!criteria.getJoinConditions().isEmpty()) {
				sql = buildSearchSql(sql, criteria, SEARCHSQL_JOINCONDITIONS);
			}
			// if pick criteria are present
			if (!criteria.getPickCriteria().isEmpty()) {
				sql = buildSearchSql(sql, criteria, SEARCHSQL_PICKCRITERIA);
			}
			if (!criteria.getCustomCriteria().isEmpty()) {
				sql = buildSearchSql(sql, criteria, SEARCHSQL_CUSTOMCRITERIA);
			}
			if (!criteria.getOrderBy().isEmpty()) {
				sql = buildSearchSql(sql, criteria, SEARCHSQL_ORDERBY);
			}
			if (!criteria.getGroupBy().isEmpty()) {
				sql = buildSearchSql(sql, criteria, SEARCHSQL_GROUPBY);
			}
		}
		logHelper.info(sql.toString());
		return retrieveRecords(sql.toString(), true, false);
	}
	private StringBuffer buildSearchSql(StringBuffer sql, SearchCriteria criteria, int type) {
		// if is retrievefields, targetobjects, joinconditions
		if (type == SEARCHSQL_RETRIEVEFIELDS || type == SEARCHSQL_TARGETOBJECTS || type == SEARCHSQL_JOINCONDITIONS) {
			List inputs = null;
			// append initial keyword
			switch (type) {
			case SEARCHSQL_RETRIEVEFIELDS:
				sql.append("SELECT ");
				if (criteria.isDistinct())
					sql.append("DISTINCT ");
				inputs = criteria.getRetrieveFields();
				break;
			case SEARCHSQL_TARGETOBJECTS:
				sql.append("FROM ");
				inputs = criteria.getTargetObjects();
				break;
			case SEARCHSQL_JOINCONDITIONS:
				sql.append("WHERE ");
				inputs = criteria.getJoinConditions();
				break;
			}

			for (Iterator itr = inputs.iterator(); itr.hasNext();) {
				// append value(s)
				//sql.append("(");
				sql.append(itr.next().toString());
				//sql.append(")");
				// append space after value
				sql.append(" ");

				if (type == SEARCHSQL_RETRIEVEFIELDS || type == SEARCHSQL_TARGETOBJECTS) {
					// if have next, append comma, otherwise append space
					if (itr.hasNext())
						sql.append(", ");
					else
						sql.append(" ");
				}
				if (type == SEARCHSQL_JOINCONDITIONS) {
					// if have next, append AND keyword, otherwise append space
					if (itr.hasNext())
						sql.append("AND ");
					else
						sql.append(" ");
				}
			}
		}
		if (type == SEARCHSQL_PICKCRITERIA) {
			// append WHERE keyword if doesn't exist
			if (sql.indexOf("WHERE") == -1) sql.append("WHERE ");
			else sql.append("AND ");

			// inputs will be a map
			List inputs = criteria.getPickCriteria();
			for (Iterator itr = inputs.iterator(); itr.hasNext();) {
				// get pick criteria
				PickCriteria pickCriteria = (PickCriteria) itr.next();

				int matchType = pickCriteria.getMatchType();
				if (matchType != PickCriteria.KEY_BETWEEN_TWO_VALUES_AND && matchType != PickCriteria.KEY_BETWEEN_TWO_VALUES_OR) {
					sql.append("(");
					for (Iterator valuesItr = pickCriteria.getValues().iterator(); valuesItr.hasNext();) {
						sql.append(pickCriteria.getKey());
						switch (pickCriteria.getMatchType()) {
						case PickCriteria.KEY_FULL_MATCHES_ALL_VALUES:
							sql.append(" = '" + valuesItr.next().toString() + "'");
							if (valuesItr.hasNext())
								sql.append(" AND ");
							break;
						case PickCriteria.KEY_FULL_MATCHES_ANYONE_VALUE:
							sql.append(" = '" + valuesItr.next().toString() + "'");
							if (valuesItr.hasNext())
								sql.append(" OR ");
							break;
						case PickCriteria.KEY_PARTIAL_MATCHES_ALL_VALUE:
							sql.append(" LIKE '%" + valuesItr.next().toString() + "%'");
							if (valuesItr.hasNext())
								sql.append(" AND ");
							break;
						case PickCriteria.KEY_PARTIAL_MATCHES_ANYONE_VALUE:
							sql.append(" LIKE '%" + valuesItr.next().toString() + "%'");
							if (valuesItr.hasNext())
								sql.append(" OR ");
							break;
						}
					}
					sql.append(")");
				}
				if (matchType == PickCriteria.KEY_BETWEEN_TWO_VALUES_AND || matchType == PickCriteria.KEY_BETWEEN_TWO_VALUES_OR) {
					sql.append("(");
					// only 2 values
					sql.append(pickCriteria.getKey() + " >= '" + pickCriteria.getValues().get(0).toString() + "' AND " + pickCriteria.getKey() + " <= '" + pickCriteria.getValues().get(1).toString() + "'");
					sql.append(") ");
				}

				if (itr.hasNext()) {
					switch (matchType) {
					case PickCriteria.KEY_FULL_MATCHES_ALL_VALUES:
							sql.append(" AND ");
						break;
					case PickCriteria.KEY_FULL_MATCHES_ANYONE_VALUE:
							sql.append(" OR ");
						break;
					case PickCriteria.KEY_PARTIAL_MATCHES_ALL_VALUE:
							sql.append(" AND ");
						break;
					case PickCriteria.KEY_PARTIAL_MATCHES_ANYONE_VALUE:
							sql.append(" OR ");
						break;
					case PickCriteria.KEY_BETWEEN_TWO_VALUES_AND:
						sql.append(" AND ");
						break;
					case PickCriteria.KEY_BETWEEN_TWO_VALUES_OR:
						sql.append(" OR ");
						break;
					}
				}
			}
		}
		if (type == SEARCHSQL_CUSTOMCRITERIA) {
			// append WHERE keyword if doesn't exist
			if (sql.indexOf("WHERE") == -1) sql.append("WHERE ");
			else sql.append("AND ");
			
			List inputs = criteria.getCustomCriteria();
			for (Iterator itr = inputs.iterator(); itr.hasNext(); ) {
				String customCriteria = itr.next().toString();
				sql.append(customCriteria);
				sql.append(" ");
			}
		}
		if (type == SEARCHSQL_ORDERBY) {
			sql.append(" ORDER BY ");
			sql.append(criteria.getOrderBy().get(0).toString());
			sql.append(" ");
			if (((Integer) criteria.getOrderBy().get(1)).intValue() == SearchCriteria.ORDERBY_ASC)
				sql.append("ASC");
			if (((Integer) criteria.getOrderBy().get(1)).intValue() == SearchCriteria.ORDERBY_DESC)
				sql.append("DESC");
		}
		if (type == SEARCHSQL_GROUPBY) {
			sql.append("GROUP BY ");
			for (Iterator groupByItr = criteria.getGroupBy().iterator(); groupByItr.hasNext(); ) {
				sql.append(groupByItr.next().toString());
				if (groupByItr.hasNext()) sql.append(" "); 
			}
		}

		return sql;
	}

	public BaseEntity retrieveRecord(BaseEntity obj) throws HelperException {
		return retrieveRecord(obj, true, true);
	}
	public BaseEntity retrieveRecord(BaseEntity obj, boolean initProxies, boolean fullInit) throws HelperException {
		BaseEntity entity = null;

		try {
			if (obj != null) {
				//retrieve non-init object first. then init from below
				List ret = retrieveRecords("from " + obj.getClass().getName() + " as o where o.id='" + obj.getId() + "'", false, false);
				//List ret = hibernateTemplate.findByExample(obj);
				if (ret != null && ret.size() > 0) {
					entity = (BaseEntity) ret.get(0);
					//entity = (BaseEntity) hibernateTemplate.load(obj.getClass(), (Serializable)obj.getId());
					
					if (initProxies) initProxies(entity,fullInit);
					
					//hibernateTemplate.evict(entity);
				}
			}
		} catch (Exception e) {
			throw new HelperException(e);
		}

		return entity;
	}
	public List retrieveRecords(Class entity, String sortBy, Integer noOfItems) throws HelperException {
		return retrieveRecords(entity, sortBy, noOfItems, true, false);
	}
	public List retrieveRecords(Class entity, String sortBy) throws HelperException {
		return retrieveRecords(entity, sortBy, RETRIEVE_RECORDS_NO_LIMIT, true, false);
	}
	public List retrieveRecords(Class entity, String sortBy, Integer noOfItems, boolean initProxies, boolean fullInit) throws HelperException {
		List list = null;

		try {
			String sql = "from " + entity.getName() + " as o";
			if (!sortBy.equals(""))
				sql += " order by o." + sortBy;

			list = retrieveRecords(sql, noOfItems, initProxies, fullInit);
		} catch (HelperException e) {
			throw e;
		}

		return list;
	}
	
	public List retrieveDistinctField(Class entity, String fieldName) throws HelperException {
		return retrieveDistinctField(entity, fieldName, true, false);
	}
	public List retrieveDistinctField(Class entity, String fieldName, boolean initProxies, boolean fullInit) throws HelperException {
		List list = null;

		try {
			String sql = "select distinct o." + fieldName + " from " + entity.getName() + " as o order by o." + fieldName;
			list = retrieveRecords(sql, initProxies, fullInit);
		} catch (HelperException e) {
			throw e;
		}

		return list;
	}
	public List retrieveRecords(String hqlStr) throws HelperException {
		return retrieveRecords(hqlStr, true, false);
	}
	public List retrieveRecords(String hqlStr, boolean initProxies, boolean fullInit) throws HelperException {
		return retrieveRecords(hqlStr, RETRIEVE_RECORDS_NO_LIMIT, initProxies, fullInit);
	}
	public List retrieveRecords(String hqlStr, Integer noOfItems, boolean initProxies, boolean fullInit) throws HelperException {
		List list = null;

		try {
			hibernateTemplate.setMaxResults(noOfItems);
			list = hibernateTemplate.find(hqlStr);
			//hibernateTemplate.getSessionFactory().getStatistics().logSummary();
			if (initProxies) {
				for (Iterator itr = list.iterator(); itr.hasNext(); ) {
					initProxies(itr.next(),fullInit);
				}
			}
			//reset to default
			hibernateTemplate.setMaxResults(RETRIEVE_RECORDS_NO_LIMIT);
		} catch (DataAccessException e) {
			logHelper.error(e);
			throw new HelperException();
		}

		return list;
	}
	//adapter method so that not all daos have to override
	protected void initProxies(Object abstractEntity,boolean fullInit) { }
	
	protected void deleteEntitiesNotFoundInCollectionThenSaveEntitiesWithoutIds(String entityName, Collection collection, String parentIdName, Object parentId) throws HelperException {
		String nonDeleteIds = findPersistedRecordsIds(collection);
		hibernateTemplate.bulkUpdate("delete from " + entityName + " as o where " + parentIdName + " = '" + parentId + "'" +
				(!nonDeleteIds.equals("")?" and o.id not in (" + nonDeleteIds + ")":""));
		for (Iterator itr = collection.iterator(); itr.hasNext(); ) {
			BaseEntity entity = (BaseEntity) itr.next();
			try { hibernateTemplate.saveOrUpdate(entity); }
			catch(HibernateSystemException e) { hibernateTemplate.merge(entity); }
		}
	}
}
