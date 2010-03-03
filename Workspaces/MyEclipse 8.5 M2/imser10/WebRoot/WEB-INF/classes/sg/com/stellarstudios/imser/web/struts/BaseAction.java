package sg.com.stellarstudios.imser.web.struts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.LabelValueBean;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.helper.LogHelper;
import sg.com.stellarstudios.imser.service.BaseService;
import sg.com.stellarstudios.imser.service.ConfigurationService;
import sg.com.stellarstudios.imser.service.PreloadDataService;
import sg.com.stellarstudios.imser.web.common.WebConstants;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.common.WebUtility;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction extends ActionSupport
		implements SessionAware, ServletRequestAware, ServletResponseAware, ParameterAware, Preparable {
	protected Map session;
	protected Map rawParams;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public void setSession(Map session) { this.session = session; }
	public void setParameters(Map rawParams) { this.rawParams = rawParams; }
	public void setServletRequest(HttpServletRequest request) { this.request = request; }
	public void setServletResponse(HttpServletResponse response) { this.response = response; }
	public Map getSession() { return session; }
	public Map getRawParams() { return rawParams; }
	public HttpServletRequest getRequest() { return request; }
	public HttpServletResponse getResponse() { return response; }
	
	//********************************** SERVICE LAYER INTEGRATION *******************************
	protected BaseService service;
	public void setService(BaseService service) { this.service = service; }
	protected PreloadDataService preloadDataService;
	public void setPreloadDataService(PreloadDataService preloadDataService) { this.preloadDataService = preloadDataService; }
	protected ConfigurationService configurationService;
	public void setConfigurationService(ConfigurationService configurationService) { this.configurationService = configurationService; }

	//*********************************** DATA HOLDERS *******************************************
	protected Map preloadData;
	public void setPreloadData(Map preloadData) { this.preloadData = preloadData; }
	public Map getPreloadData() { return this.preloadData; }
	protected Map formData;
	public Map getFormData() { return formData; }
	public void setFormData(Map formData) { this.formData = formData; }
	//*********************************** MY PARAMS *******************************************
	protected Map params;
	public Map getParams() { return params; }
	public void setParams(Map params) { this.params = params; }	

	protected LogHelper logHelper;
	public void setLogHelper(LogHelper logHelper) { this.logHelper = logHelper; }

	public void prepare() throws Exception {
		preloadData = new HashMap();
		formData = new HashMap();
		
		//load up parameters myself
		//WebUtility.getInstance().setMapValuesOntoAction(this, params);
		params = WebUtility.getInstance().buildParamsMapWithStringFromStringArray(rawParams);
	}
	public void init() { }
	
	protected void buildPagePreloadData(String command, BaseEntity model) throws Exception {
		Map[]preloadDataWithDefaultValues = buildPagePreloadData(command, params, preloadData, formData, model, session);
		preloadData.putAll(preloadDataWithDefaultValues[0]);
		WebUtility.getInstance().setPreloadDataDefaultValues(this, preloadDataWithDefaultValues[1]);
		request.setAttribute(WebKeys.SINGLE_OBJECT, model);
		request.setAttribute(WebKeys.PRELOAD_DATA, preloadData);
	}

	//********************************** PRELOAD DATA METHODS ************************************
	protected Map[] buildPagePreloadData(String command, Map myParams, Map preloadData, Map formData, BaseEntity abstractModel, Map session) throws Exception {
		Map defaultValues = new HashMap();
		
		//common preloads
		List yesNoTypes = new ArrayList();
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_YES_LABEL, WebConstants.PRELOAD_YES_VALUE));
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_NO_LABEL, WebConstants.PRELOAD_NO_VALUE));
		preloadData.put("yesNoTypes", yesNoTypes);
		
		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADCREATE)) {

		}
		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADUPDATE)) {

		}
		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADSEARCH)) {
			// build boolean types options
			List searchBooleanTypes = new ArrayList();
			searchBooleanTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
			searchBooleanTypes.add(new LabelValueBean(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_AND_LABEL, WebConstants.PRELOAD_SEARCHBOOLEANTYPES_AND_VALUE));
			searchBooleanTypes.add(new LabelValueBean(WebConstants.PRELOAD_SEARCHBOOLEANTYPES_OR_LABEL, WebConstants.PRELOAD_SEARCHBOOLEANTYPES_OR_VALUE));
			preloadData.put(WebKeys.SEARCH_BOOLEANTYPES, searchBooleanTypes);
			defaultValues.put("searchBooleanType", WebConstants.PRELOAD_SEARCHBOOLEANTYPES_OR_VALUE);

			// build match types options
			List searchMatchTypes = new ArrayList();
			searchMatchTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
			searchMatchTypes.add(new LabelValueBean(WebConstants.PRELOAD_SEARCHMATCHTYPES_FULL_LABEL, WebConstants.PRELOAD_SEARCHMATCHTYPES_FULL_VALUE));
			searchMatchTypes.add(new LabelValueBean(WebConstants.PRELOAD_SEARCHMATCHTYPES_PARTIAL_LABEL, WebConstants.PRELOAD_SEARCHMATCHTYPES_PARTIAL_VALUE));
			preloadData.put(WebKeys.SEARCH_MATCHTYPES, searchMatchTypes);
			defaultValues.put("searchMatchType", WebConstants.PRELOAD_SEARCHMATCHTYPES_PARTIAL_VALUE);

			// build results per page options
			List searchResultsPerPageTypes = new ArrayList();
			searchResultsPerPageTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_10).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_10).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_20).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_20).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_50).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_50).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_100).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_100).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_200).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_200).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_500).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_500).toString()));
			searchResultsPerPageTypes.add(new LabelValueBean(new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_1000).toString(), new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_1000).toString()));
			preloadData.put(WebKeys.SEARCH_RESULTSPERPAGETYPES, searchResultsPerPageTypes);
			defaultValues.put("resultsPerPage", new Integer(WebConstants.PRELOAD_SEARCH_RESULTSPERPAGE_20).toString());
		}
		
		return new Map[] {preloadData, defaultValues};
	}
	protected Map[] buildPagePreloadDataEmbeddedForm(String command, Map myParams, Map preloadData, Map formData, Map session, String embeddedFormPageId) throws Exception {
		Map defaultValues = new HashMap();
		
		//common preloads
		List yesNoTypes = new ArrayList();
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_YES_LABEL, WebConstants.PRELOAD_YES_VALUE));
		yesNoTypes.add(new LabelValueBean(WebConstants.PRELOAD_NO_LABEL, WebConstants.PRELOAD_NO_VALUE));
		preloadData.put("yesNoTypes", yesNoTypes);
		
		return new Map[] {preloadData, defaultValues};
	}
	protected Map[] buildPagePreloadDataWizardForm(String command, Map myParams, Map preloadData, Map formData, Map session, String formId, String pageId) throws Exception {
		Map defaultValues = new HashMap();
		return new Map[] {preloadData, defaultValues};
	}
	protected void removeSessionObjects(Map session) { }
}