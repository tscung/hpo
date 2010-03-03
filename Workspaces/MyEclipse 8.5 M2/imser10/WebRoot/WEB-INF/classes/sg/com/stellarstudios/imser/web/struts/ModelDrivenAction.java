package sg.com.stellarstudios.imser.web.struts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.embeddedform.EmbeddedForm;
import sg.com.stellarstudios.imser.entity.search.PickCriteria;
import sg.com.stellarstudios.imser.entity.search.SearchCriteria;
import sg.com.stellarstudios.imser.exception.DoesntExistException;
import sg.com.stellarstudios.imser.web.common.WebConstants;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.common.WebUtility;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class ModelDrivenAction extends BaseAction implements ModelDriven, Preparable {
	//************************************ PROPERTIES FOR THIS ACTION **********************************
	private BaseEntity model;
	public BaseEntity getModel() { return this.model; }
	public void setModel(BaseEntity model) { this.model = model; }

	//************************************ COMMON PROPERTIES **********************************
	protected String searchBooleanType, searchMatchType, resultsPerPage;
	public String getSearchBooleanType() { return searchBooleanType; }
	public String getSearchMatchType() { return searchMatchType; }
	public String getResultsPerPage() { return resultsPerPage; }
	public void setSearchBooleanType(String searchBooleanType) { this.searchBooleanType = searchBooleanType; }
	public void setSearchMatchType(String searchMatchType) { this.searchMatchType = searchMatchType; }
	public void setResultsPerPage(String resultsPerPage) { this.resultsPerPage = resultsPerPage; }
	protected Integer maxNoOfItems;
	public Integer getMaxNoOfItems() { return maxNoOfItems; }
	public void setMaxNoOfItems(Integer maxNoOfItems) { this.maxNoOfItems = maxNoOfItems; }
	
	//*********************************** INIT/PREPARE *******************************************
	public void init() {
		super.init();
	}
	public void prepare() throws Exception {
		super.prepare();
		setModel(getModel(params,getModel()));
	}
	
	//********************************** MODEL RELATED METHODS ************************************
	public BaseEntity getModel(Map params,BaseEntity abstractExistingModel) throws Exception {
		BaseEntity model = abstractExistingModel;
		
		Object idParam = (Object)params.get("id");
		if (idParam != null && !idParam.equals("")) {
			//Object id = getModelId(idParam);
			Object id = idParam;
			
			//if no model, retrieve from db
			if (model == null) {
				BaseEntity toRetrieve = getNewModel();
				toRetrieve.setId(id);

				model = service.retrieve(toRetrieve);
			}
			//else just set the id
			else {
				model.setId(id);
			}
		}
		
		if (model == null) model = getNewModel();
		
		return model;
	}
	public abstract BaseEntity getNewModel();
	public BaseEntity intercept(String command, Map myParams, Map formData, Map session, BaseEntity model) throws Exception { return model; }

	//********************************** SEARCH RELATED METHODS ************************************
	//for searching purposes
	public SearchCriteria buildSearchDetails(Map myParams, BaseEntity model) throws Exception { return null; }
	public BaseEntity buildEntityFromSearchResults(List resultRecords, int count) throws Exception { return null; }
	
	//converts hibernate's returns as a standard list format
	public List buildSearchResults(List results) throws Exception {
		List ret = new ArrayList();

		boolean singleResult = true;
		for (int i = 0; i < results.size(); i++) {
			Object obj = results.get(i);

			if (singleResult) {
				// if is multiple result
				if (obj.getClass().isAssignableFrom(Object[].class)) {
					singleResult = false;
				}
				// single result
				else {
					ret.add(buildEntityFromSearchResults(results, i));

					// break out of loop
					//i = results.size();
				}
			}
			if (!singleResult) {
				Object[] record = (Object[]) obj;

				List recs = new ArrayList();
				Collections.addAll(recs, record);
				ret.add(buildEntityFromSearchResults(recs, i));
			}
		}

		return ret;
	}

	protected SearchCriteria addPickCriteria(SearchCriteria criteria, String objectName, String fieldName, BaseEntity model, int matchType) {
		try {
			Object fieldValue = Utility.getInstance().getObjectValue(model, fieldName);
			//Object fieldValue = model.getClass().getMethod(Utility.getInstance().buildFieldGetter(fieldName), null).invoke(model, null);
			if (fieldValue != null && !fieldValue.toString().equals(""))
				return addPickCriteria(criteria,objectName+fieldName,fieldValue.toString(),matchType);
			else
				return criteria;
		}
		catch (Exception e) { logHelper.error(e); }
		
		return criteria;
	}
	protected SearchCriteria addPickCriteria(SearchCriteria criteria, String pickCriteriaName, String criteriaInput, String criteriaInput2, int matchType) {
		if (!criteriaInput.equals("") && !criteriaInput2.equals("") && ((!criteriaInput.equals("0") && !criteriaInput.equals("0.0")) || (!criteriaInput2.equals("0") && !criteriaInput2.equals("0.0")))) {
			criteria.getPickCriteria().add(new PickCriteria(pickCriteriaName, new String[] { criteriaInput, criteriaInput2 }, matchType));
		}
		
		return criteria;
	}
	protected SearchCriteria addPickCriteria(SearchCriteria criteria, String objectName, String criteriaInputName, Map params, int matchType) {
		if (params.get(criteriaInputName) != null)
			return addPickCriteria(criteria,objectName+criteriaInputName,params.get(criteriaInputName).toString(),matchType);
		else
			return criteria;
	}
	protected SearchCriteria addPickCriteria(SearchCriteria criteria, String pickCriteriaName, String criteriaInput, int matchType) {
		// integer can be returned as string after toString() method
		if (!criteriaInput.equals("") && (!criteriaInput.equals("0") && !criteriaInput.equals("0.0")))
			criteria.getPickCriteria().add(new PickCriteria(pickCriteriaName, new String[] { criteriaInput }, matchType));

		return criteria;
	}
	protected int resolveSearchMatchType(String searchbooleantype, String searchmatchtype) {
		//defaults to partial, or
		int matchType = PickCriteria.KEY_PARTIAL_MATCHES_ANYONE_VALUE;
		if (searchmatchtype.equals(WebConstants.PRELOAD_SEARCHMATCHTYPES_FULL_VALUE) && searchbooleantype.equals(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_AND_VALUE)) {
			matchType = PickCriteria.KEY_FULL_MATCHES_ALL_VALUES;
		}
		if (searchmatchtype.equals(WebConstants.PRELOAD_SEARCHMATCHTYPES_FULL_VALUE) && searchbooleantype.equals(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_OR_VALUE)) {
			matchType = PickCriteria.KEY_FULL_MATCHES_ANYONE_VALUE;
		}
		if (searchmatchtype.equals(WebConstants.PRELOAD_SEARCHMATCHTYPES_PARTIAL_VALUE) && searchbooleantype.equals(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_AND_VALUE)) {
			matchType = PickCriteria.KEY_PARTIAL_MATCHES_ALL_VALUE;
		}
		if (searchmatchtype.equals(WebConstants.PRELOAD_SEARCHMATCHTYPES_PARTIAL_VALUE) && searchbooleantype.equals(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_OR_VALUE)) {
			matchType = PickCriteria.KEY_PARTIAL_MATCHES_ANYONE_VALUE;
		}

		return matchType;
	}
	
	//************************************ CREATE, UPDATE ******************************************
	public String preloadCreate() throws Exception {
		removeSessionObjects(session);
		super.buildPagePreloadData(WebConstants.ACTIONCOMMAND_PRELOADCREATE, getModel());
		
		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_PRELOADCREATE);
		return WebConstants.SUCCESS_PRELOADCREATE;
	}
	public String preloadUpdate() throws Exception {
		removeSessionObjects(session);
		super.buildPagePreloadData(WebConstants.ACTIONCOMMAND_PRELOADUPDATE, getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_PRELOADUPDATE);
		return WebConstants.SUCCESS_PRELOADUPDATE;
	}
	public String create() throws Exception {
		setModel(intercept(WebConstants.ACTIONCOMMAND_CREATE, params, formData, session, getModel()));
		setModel(service.create(getModel()));
		request.setAttribute(WebKeys.SINGLE_OBJECT, getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_CREATE);
		return WebConstants.SUCCESS_CREATE + ((params.get("isPopup") != null && new Boolean(params.get("isPopup").toString()).booleanValue())?WebConstants.SUCCESS_RESULTPAGE_SUFFIX:"");
	}
	public String update() throws Exception {
		setModel(intercept(WebConstants.ACTIONCOMMAND_UPDATE, params, formData, session, getModel()));
		setModel(service.update(getModel()));
		request.setAttribute(WebKeys.SINGLE_OBJECT, getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_UPDATE);
		return WebConstants.SUCCESS_UPDATE + ((params.get("isPopup") != null && new Boolean(params.get("isPopup").toString()).booleanValue())?WebConstants.SUCCESS_RESULTPAGE_SUFFIX:"");
	}

	//*************************************** RETRIEVES ******************************************
	public String retrieve() throws Exception {
		super.buildPagePreloadData(WebConstants.ACTIONCOMMAND_RETRIEVE, getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_RETRIEVE);
		return WebConstants.SUCCESS_RETRIEVE;
	}
	public String retrieveAll() throws Exception {
		// remove result from session
		if (session.get(WebKeys.LIST_OBJECT) != null) { session.remove(WebKeys.LIST_OBJECT); }

		String sortBy = (this.sortBy == null) ? "" : this.sortBy;
		
		List retrievedList = null;
		if (maxNoOfItems != null && maxNoOfItems != 0) retrievedList = (List) service.retrieve(getModel().getClass(),sortBy,maxNoOfItems);
		else retrievedList = (List) service.retrieve(getModel().getClass(),sortBy);

		//put result in session, for resorting
		session.put(WebKeys.LIST_OBJECT, retrievedList);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_RETRIEVEALL);
		return WebConstants.SUCCESS_RETRIEVEALL;
	}

	//***************************************** DELETE ******************************************
	public String delete() throws Exception {
		setModel(intercept(WebConstants.ACTIONCOMMAND_DELETE, params, formData, session, getModel()));
		setModel(service.delete(getModel()));
		request.setAttribute(WebKeys.SINGLE_OBJECT, getModel());
		
		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_DELETE);
		return WebConstants.SUCCESS_DELETE + ((params.get("isPopup") != null && new Boolean(params.get("isPopup").toString()).booleanValue())?WebConstants.SUCCESS_RESULTPAGE_SUFFIX:"");
	}

	//***************************************** SEARCH ******************************************
	public String preloadSearch() throws Exception {
		super.buildPagePreloadData(WebConstants.ACTIONCOMMAND_PRELOADSEARCH, null);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_PRELOADSEARCH);
		return WebConstants.SUCCESS_PRELOADSEARCH;
	}
	public String search() throws Exception {
		// if search result is stored in session, remove it upon researching
		if (session.get(WebKeys.LIST_OBJECT) != null) { session.remove(WebKeys.LIST_OBJECT); }

		SearchCriteria criteria = buildSearchDetails(params, getModel());

		List results = service.search(criteria);
		List resultList = null;

		// if got result
		if (results.size() > 0) resultList = buildSearchResults(results);

		// put the search result in session
		session.put(WebKeys.LIST_OBJECT, resultList);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_SEARCH);
		return WebConstants.SUCCESS_SEARCH;
	}

	//***************************************** SORT ******************************************
	protected String sortBy, sortType, sortOrder;
	public String getSortBy() { return sortBy; }
	public String getSortOrder() { return sortOrder; }
	public String getSortType() { return sortType; }
	public void setSortBy(String sortBy) { this.sortBy = sortBy; }
	public void setSortOrder(String sortOrder) { this.sortOrder = sortOrder; }
	public void setSortType(String sortType) { this.sortType = sortType; }

	public String sort() throws Exception {
		String sortBy = this.sortBy;
		String sortType = this.sortType;
		String sortOrder = this.sortOrder;

		// get list
		List resultList = (List) session.get(WebKeys.LIST_OBJECT);

		// sort it accordingly first
		if (resultList != null) Collections.sort(resultList, WebUtility.getInstance().buildSortComparator(sortBy, sortType, sortOrder));

		session.put(WebKeys.LIST_OBJECT, resultList);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_SORT);
		return WebConstants.SUCCESS_SORT;
	}
	
	//***************************************** WIZARD FORM ******************************************
	protected void buildPagePreloadDataWizardForm(String command) throws Exception {
		Map[]preloadDataWithDefaultValues = buildPagePreloadDataWizardForm(command, params, preloadData, formData, session, params.get("formId").toString(), params.get("pageId").toString());
		preloadData.putAll(preloadDataWithDefaultValues[0]);
		WebUtility.getInstance().setPreloadDataDefaultValues(this, preloadDataWithDefaultValues[1]);
		request.setAttribute(WebKeys.SINGLE_OBJECT, model);
		request.setAttribute(WebKeys.WIZARDFORM_PARENTID, params.get("parentId"));
		request.setAttribute(WebKeys.PRELOAD_DATA, preloadData);
	}
	public String preloadWizardPage() throws Exception {
		this.buildPagePreloadDataWizardForm(WebConstants.ACTIONCOMMAND_RETRIEVE);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_RETRIEVE);
		return params.get("pageId").toString();
	}
	public String handleWizardPage() throws Exception {
		return WebConstants.WIZARD_FORM_END_PAGE;
	}
	
	//***************************************** EMBEDDED FORM ******************************************
	protected void buildPagePreloadDataEmbeddedForm(String command) throws Exception {
		Map[]preloadDataWithDefaultValues = buildPagePreloadDataEmbeddedForm(command, params, preloadData, formData, session, params.get("pageId").toString());
		preloadData.putAll(preloadDataWithDefaultValues[0]);
		WebUtility.getInstance().setPreloadDataDefaultValues(this, preloadDataWithDefaultValues[1]);
		if (params.get("parentId") != null) request.setAttribute(WebKeys.EMBEDDEDFORM_PARENTID,params.get("parentId").toString());
		request.setAttribute(WebKeys.PRELOAD_DATA, preloadData);
	}
	
	public String preloadCreateEmbeddedPage() throws Exception {
		this.buildPagePreloadDataEmbeddedForm(WebConstants.ACTIONCOMMAND_PRELOADCREATE);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_PRELOADCREATE);
		return WebConstants.SUCCESS_PRELOADCREATE;
	}
	public String preloadUpdateEmbeddedPage() throws Exception {
		this.buildPagePreloadDataEmbeddedForm(WebConstants.ACTIONCOMMAND_PRELOADUPDATE);

		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_PRELOADUPDATE);
		return WebConstants.SUCCESS_PRELOADUPDATE;
	}
	public String retrieveEmbeddedPage() throws Exception {
		this.buildPagePreloadDataEmbeddedForm(WebConstants.ACTIONCOMMAND_RETRIEVE);
		
		request.setAttribute(WebKeys.ACTION_COMMAND, WebConstants.ACTIONCOMMAND_RETRIEVE);
		return WebConstants.SUCCESS_RETRIEVE;
	}
	
	public String handleEmbeddedPageLine() throws Exception {
		int flag = 0;
		if (params.get("cmd").toString().equals(WebConstants.EMBEDDED_FORM_CMD_ADDLINE)) flag = GlobalKeys.ADD_FLAG;
		if (params.get("cmd").toString().equals(WebConstants.EMBEDDED_FORM_CMD_REMOVELINE)) flag = GlobalKeys.REMOVE_FLAG;
		if (params.get("parentId") != null) request.setAttribute(WebKeys.EMBEDDEDFORM_PARENTID, params.get("parentId").toString());
		
		//form info
		String pageId = params.get("pageId").toString();
		String lineUniqueKey = params.get("lineUniqueKey").toString();
		
		EmbeddedForm embeddedForm = (EmbeddedForm) session.get(pageId);
		//get embedded form
		if (embeddedForm == null) {
			embeddedForm = new EmbeddedForm(pageId);
			session.put(pageId, embeddedForm);
		}
		
		//get lines map
		Map linesMap = embeddedForm.getLinesMap();
		
		if (flag == GlobalKeys.ADD_FLAG) {
			//try to get existing line first - for update purposes
			Map line = (Map) linesMap.get(lineUniqueKey);
			if (line == null) line = new HashMap();
			
			line.putAll(rawParams);
			//TO USE MY PARAMS INSTEAD LATER WHEN I'M MORE FREE!
			//for struts 2, values are all String[]. hence must convert
			for (Iterator itr = rawParams.keySet().iterator(); itr.hasNext(); ) {
				String key = itr.next().toString();
				Object value = rawParams.get(key);
				if (value.getClass().isAssignableFrom(String[].class)) {
					//get first index, since all are just textfields
					String valueString = ((String[])value)[0];
					line.put(key, valueString);
				}
			}
			
			//put serial number of this line
			//line.put(WebKeys.EMBEDDEDFORM_LINESERIALNO, new Integer(linesMap.size()));
			
			//put line to line table
			linesMap.put(lineUniqueKey, line);
		}
		if (flag == GlobalKeys.REMOVE_FLAG) {
			//remove line from line table
			linesMap.remove(lineUniqueKey);
		}
		
		session.put(pageId,embeddedForm);
		formData.clear();

		//NONEED TO SET ACTIONCOMMAND COS RESULT IS REDIRECTED-ACTION TO PRELOADCREATE/UPDATE
		
		if (params.get("parentCmd").toString().equals(WebConstants.PRELOAD_PAGE_CREATE)) return WebConstants.SUCCESS_CREATE;
		if (params.get("parentCmd").toString().equals(WebConstants.PRELOAD_PAGE_UPDATE)) return WebConstants.SUCCESS_UPDATE;
		return SUCCESS;
	}
	
	public String handleEmbeddedPageLineDetail() throws Exception {
		int flag = 0;
		if (params.get("cmd").toString().equals(WebConstants.EMBEDDED_FORM_CMD_ADDLINE)) flag = GlobalKeys.ADD_FLAG;
		if (params.get("cmd").toString().equals(WebConstants.EMBEDDED_FORM_CMD_REMOVELINE)) flag = GlobalKeys.REMOVE_FLAG;
		if (params.get("parentId") != null) request.setAttribute(WebKeys.EMBEDDEDFORM_PARENTID,params.get("parentId").toString());
		
		//form info
		String pageId = params.get("pageId").toString();
		String lineUniqueKey = params.get("lineUniqueKey").toString();
		
		//line detail info
		String detailKey = params.get("detailKey").toString();
		String detailValue = params.get("detailValue").toString();

		EmbeddedForm embeddedForm = (EmbeddedForm) session.get(pageId);
		//get embedded form
		if (embeddedForm == null) {
			throw new DoesntExistException();
		}
		
		//get lines map
		Map linesMap = embeddedForm.getLinesMap();
		
		//line won't be null as it is chosen through a dropdown box
		Map line = (Map) linesMap.get(lineUniqueKey);
		if (line == null) {
			throw new DoesntExistException();
		}
		
		//get details list
		List details = (List) line.get(detailKey);
		
		if (flag == GlobalKeys.ADD_FLAG) {
			if (details == null) {
				//init new detail list
				details = new ArrayList();
				line.put(detailKey, details);
			}
			//if detail not in detail list
			if (!details.contains(detailValue)) {
				//add detail to detail list
				details.add(detailValue);
			}
		}
		if (flag == GlobalKeys.REMOVE_FLAG) {
			//remove detail from detail list
			details.remove(detailValue);
		}
		
		session.put(pageId,embeddedForm);
		formData.clear();

		//NONEED TO SET ACTIONCOMMAND COS RESULT IS REDIRECTED-ACTION TO PRELOADCREATE/UPDATE
		
		if (params.get("parentCmd").toString().equals(WebConstants.PRELOAD_PAGE_CREATE)) return WebConstants.SUCCESS_CREATE;
		if (params.get("parentCmd").toString().equals(WebConstants.PRELOAD_PAGE_UPDATE)) return WebConstants.SUCCESS_UPDATE;
		return SUCCESS;
	}
}