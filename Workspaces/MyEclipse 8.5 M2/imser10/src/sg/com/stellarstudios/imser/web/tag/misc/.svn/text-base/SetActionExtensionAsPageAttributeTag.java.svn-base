package sg.com.stellarstudios.imser.web.tag.misc;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class SetActionExtensionAsPageAttributeTag extends BaseTag {
	private String pageVar;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		pageContext.setAttribute(getPageVar(), WebKeys.ACTION_EXTENSION);
		
		return super.doEndTag();
	}

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}

	
}