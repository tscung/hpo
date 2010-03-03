package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.helper.LogHelper;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintDateTag extends BaseTag {
	private LogHelper logHelper;

	private String property;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		StringBuffer output = new StringBuffer("");

		try {
			String pageVar = "", property = "";
			if (this.getProperty().indexOf(GlobalKeys.OBJECT_DELIM) != -1) {
				pageVar = this.getProperty().substring(0, this.getProperty().indexOf(GlobalKeys.OBJECT_DELIM));
				property = this.getProperty().substring(this.getProperty().indexOf(GlobalKeys.OBJECT_DELIM)+1, this.getProperty().length());
			}
			
			Object obj = this.pageContext.getAttribute(pageVar);
			if (obj != null) {
				// build getter method
				//String getterMethod = Utility.getInstance().buildFieldGetter(this.getProperty());

				// dates are guaranteed to be stored as a Calendar object
				Object toExtract = Utility.getInstance().getObjectValue(obj,property);
				Calendar cal = (Calendar) toExtract;
				if (cal != null)
					output.append(Utility.getInstance().buildStringFromCalendar(cal));
			}
			
			this.pageContext.getOut().write(output.toString());
		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}
}
