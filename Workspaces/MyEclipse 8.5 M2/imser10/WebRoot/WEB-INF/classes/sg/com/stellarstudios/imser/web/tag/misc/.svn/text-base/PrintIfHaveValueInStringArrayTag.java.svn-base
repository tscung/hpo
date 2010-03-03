package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintIfHaveValueInStringArrayTag extends BaseTag {
	private String pageVar;
	private String property;
	private String value;
	public String getPageVar() {
		return pageVar;
	}
	public void setPageVar(String pageVar) {
		this.pageVar = pageVar;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public int doStartTag() throws JspException {
        //calls doInitBody()
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
    	Object obj = this.pageContext.getAttribute(this.getPageVar());
		if (obj != null) {
			String[] arr= (String[]) Utility.getInstance().getObjectValue(obj,this.getProperty());
			if (arr != null) {
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null && arr[i].equalsIgnoreCase(getValue())) {
						try {
	                        bodyContent.writeOut(getPreviousOut());
	                    }
	                    catch (IOException e) {
	                    	ServiceLocator.getInstance().getLogHelper().error(e);
	                    }
					}
				}
			}
		}

        //calls doEndTag()
        return this.SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        //calls release()
        return EVAL_PAGE;
    }
}
