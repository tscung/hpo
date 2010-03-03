package sg.com.stellarstudios.imser.web.tag.misc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class SetActionCommandAsPageAttributeTag extends BaseTag {
	private String pageVar;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		//request attribute is set in action's prepare method
		String actionCommand = (String) request.getAttribute(WebKeys.ACTION_COMMAND);
		pageContext.setAttribute(getPageVar(), actionCommand);
		
		return super.doEndTag();
	}

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}

	
}