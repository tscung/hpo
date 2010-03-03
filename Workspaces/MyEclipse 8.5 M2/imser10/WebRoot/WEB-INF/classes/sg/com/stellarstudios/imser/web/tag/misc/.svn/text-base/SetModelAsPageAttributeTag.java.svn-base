package sg.com.stellarstudios.imser.web.tag.misc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class SetModelAsPageAttributeTag extends BaseTag {
	private String pageVar;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Object model = request.getAttribute(WebKeys.SINGLE_OBJECT);
		pageContext.setAttribute(getPageVar(), model);
		
		return super.doEndTag();
	}

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}

	
}