package sg.com.stellarstudios.imser.entity.search;

import java.util.ArrayList;
import java.util.List;

import sg.com.stellarstudios.imser.entity.BaseEntity;

public class SearchCriteria extends BaseEntity {
	// select fields
	private List retrieveFields;

	// distinct selection
	private boolean distinct;

	// from where
	private List targetObjects;

	// join conditions
	private List joinConditions;

	// where conditions
	private List pickCriteria;
	
	// custom conditions
	private List customCriteria;
	
	// group by
	private List groupBy;

	// order by - 1st is field, 2nd is ASC/DESC
	private List orderBy;

	public static final int ORDERBY_ASC = 0;

	public static final int ORDERBY_DESC = 1;

	// Overwrite abstract method
	public Object getId() {
		return null;
	}

	public void setId(Object id) {
		// do nothing
	}

	public SearchCriteria() {
		retrieveFields = new ArrayList();
		targetObjects = new ArrayList();
		joinConditions = new ArrayList();
		pickCriteria = new ArrayList();
		customCriteria = new ArrayList();
		orderBy = new ArrayList();
		groupBy = new ArrayList();
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public List getJoinConditions() {
		return joinConditions;
	}

	public void setJoinConditions(List joinConditions) {
		this.joinConditions = joinConditions;
	}

	public List getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List orderBy) {
		this.orderBy = orderBy;
	}

	public List getPickCriteria() {
		return pickCriteria;
	}

	public void setPickCriteria(List pickCriteria) {
		this.pickCriteria = pickCriteria;
	}

	public List getRetrieveFields() {
		return retrieveFields;
	}

	public void setRetrieveFields(List retrieveFields) {
		this.retrieveFields = retrieveFields;
	}

	public List getTargetObjects() {
		return targetObjects;
	}

	public void setTargetObjects(List targetObjects) {
		this.targetObjects = targetObjects;
	}

	public List getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(List groupBy) {
		this.groupBy = groupBy;
	}

	public List getCustomCriteria() {
		return customCriteria;
	}

	public void setCustomCriteria(List customCriteria) {
		this.customCriteria = customCriteria;
	}

}
