package sg.com.stellarstudios.imser.web.common;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.search.PickCriteria;
import sg.com.stellarstudios.imser.entity.search.SearchCriteria;
import sg.com.stellarstudios.imser.exception.ServiceException;

import com.opensymphony.xwork2.ActionContext;

public class WebUtility {
	private static WebUtility me;

	public static WebUtility getInstance() {
		if (me == null)
			me = new WebUtility();

		return me;
	}

	public String getRequestPage(HttpServletRequest request) {
        String requestPg = request.getContextPath() + request.getRequestURI().substring(request.getContextPath().length());
        if (request.getQueryString() != null) requestPg += "?" + request.getQueryString();
        
        return requestPg;
    }
	public HttpServletRequest getServletRequest(ActionContext context) {
		HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
		return request;
	}
	public HttpServletResponse getServletResponse(ActionContext context) {
	    HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
		return response;
	}
	
	//**************************************** CONVENIENCE METHODS **************************************
	public Map buildParamsMapWithStringFromStringArray(Map params) {
		Map ret = new HashMap();
		
		for (Iterator itr = params.keySet().iterator(); itr.hasNext(); ) {
			String fieldName = itr.next().toString();
			Object paramsValueObj = params.get(fieldName);
			
			if (paramsValueObj.getClass().isAssignableFrom(String[].class)) {
				String[] paramsValueArr = (String[]) paramsValueObj;

//				Class classType = tryGetClassFromArray(paramsValueArr);
//				if (classType != null) {
//					//put into array
//					if (paramsValueArr.length > 1) {
//						Object paramsValueArray = Array.newInstance(classType, paramsValueArr.length);
//						for (int i = 0; i < paramsValueArr.length; i++) {
//							Array.set(paramsValueArray, i, tryConvertParamIntoObject(paramsValueArr[i]));
//						}
//						ret.put(fieldName, paramsValueArray);
//					}
//					else {
//						ret.put(fieldName, tryConvertParamIntoObject(paramsValueArr[0]));
//					}
//				}
				if (paramsValueArr.length == 0) ret.put(fieldName, "");
				else if (paramsValueArr.length == 1) ret.put(fieldName, tryConvertParamIntoObject(paramsValueArr[0]));
				else if (paramsValueArr.length > 1) ret.put(fieldName, paramsValueArr);
			}
		}
		
		return ret;
	}
	private Class tryGetClassFromArray(String[]arr) {
		Class ret = null;
		
		for (int i = 0; i < arr.length; i++) {
			String arrValue = arr[i];
			Object arrValueObj = tryConvertParamIntoObject(arr[i]);
			if (arrValueObj != null) {
				ret = arrValueObj.getClass();
				break;
			}
		}
		
		return ret;
	}
	private Object tryConvertParamIntoObject(String value) {
		Object ret = null;

		//************* TRY CONVERT TO INTEGER ******************
		try {
			if (ret == null) {
				Integer.parseInt(value);
				ret = new Integer(value);
			}
		}
		catch (Exception e) {
			//do nothing
		}
		//************* TRY CONVERT TO DOUBLE ******************
		try {
			if (ret == null) {
				Double.parseDouble(value);
				ret = new Double(value);
			}
		}
		catch (Exception e) {
			//do nothing
		}
		
		if (ret == null) ret = value;
		if (value.equals("")) ret = null;
		
		return ret;
	}
	public void setMapValuesOntoAction(Object action, Map paramsMap) {
		for (Iterator itr = paramsMap.keySet().iterator(); itr.hasNext(); ) {
			String fieldName = itr.next().toString();
			Object mapObject = paramsMap.get(fieldName);
			String value = null;
			if (mapObject.getClass().isAssignableFrom(String[].class))
				value = ((String[])paramsMap.get(fieldName))[0];
			else
				value = paramsMap.get(fieldName).toString();
			
			try {
				action.getClass().getMethod(Utility.getInstance().buildFieldSetter(fieldName), new Class[]{String.class}).invoke(action, value);
			}
			catch (Exception e) {
				//ignore cos some parameters are not accessible via setter method
				//ServiceLocator.getInstance().getLogHelper().error(e);
			}
		}
	}
	public void setPreloadDataDefaultValues(Object action, Map defaultValues) {
		for (Iterator itr = defaultValues.keySet().iterator(); itr.hasNext(); ) {
			String fieldName = itr.next().toString();
			String defaultValue = defaultValues.get(fieldName).toString();
			try {
				action.getClass().getMethod(Utility.getInstance().buildFieldSetter(fieldName), new Class[]{String.class}).invoke(action, defaultValue);
			}
			catch (Exception e) {
				ServiceLocator.getInstance().getLogHelper().error(e);
			}
		}
	}
	
	public Comparator buildSortComparator(String sortBy, String sortType, String sortOrder) throws ServiceException {
		Comparator ret = null;

		if (sortType.equals(WebConstants.SORTTYPE_STRING))
			ret = new StringComparator(sortBy, sortOrder);
		if (sortType.equals(WebConstants.SORTTYPE_DATE))
			ret = new DateComparator(sortBy, sortOrder);
		if (sortType.equals(WebConstants.SORTTYPE_DOUBLE))
			ret = new DoubleComparator(sortBy, sortOrder);

		return ret;
	}
	
	//********************************** SEARCH CRITERIA METHODS *******************************
	public SearchCriteria addPickCriteria(SearchCriteria criteria, String pickCriteriaName, String criteriaInput, String criteriaInput2, int matchType) {
		if (!criteriaInput.equals("") && !criteriaInput2.equals("") && ((!criteriaInput.equals("0") && !criteriaInput.equals("0.0")) || (!criteriaInput2.equals("0") && !criteriaInput2.equals("0.0")))) {
			criteria.getPickCriteria().add(new PickCriteria(pickCriteriaName, new String[] { criteriaInput, criteriaInput2 }, matchType));
		}
		
		return criteria;
	}
	public SearchCriteria addPickCriteria(SearchCriteria criteria, String objectName, String criteriaInputName, Map params, int matchType) {
		if (params.get(criteriaInputName) != null)
			return addPickCriteria(criteria,objectName+criteriaInputName,params.get(criteriaInputName).toString(),matchType);
		else
			return criteria;
	}
	public SearchCriteria addPickCriteria(SearchCriteria criteria, String pickCriteriaName, String criteriaInput, int matchType) {
		// integer can be returned as string after toString() method
		if (!criteriaInput.equals("") && (!criteriaInput.equals("0") && !criteriaInput.equals("0.0")))
			criteria.getPickCriteria().add(new PickCriteria(pickCriteriaName, new String[] { criteriaInput }, matchType));

		return criteria;
	}
}
