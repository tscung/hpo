package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintDecimalTag extends BaseTag {
	private String pageVar;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		try {
			Double amount = (Double) pageContext.getAttribute(getPageVar());
			String str = Utility.getInstance().formatDecimal(amount);
			pageContext.getOut().write(str);
		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}

	public String getPageVar() {
		return pageVar;
	}

	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}
	
}