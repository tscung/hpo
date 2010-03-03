package sg.com.stellarstudios.imser.web.tag.misc;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class ConvertDateToStringAsPageAttributeTag extends BaseTag {
	private String toPageVar;

	private String fromPageVar;

	private String fromPageVarProperty;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		StringBuffer output = new StringBuffer("");

		try {
			// get page scope object
			Object obj = this.pageContext.getAttribute(this.getFromPageVar());

			if (obj != null) {
				// build getter method
				String getterMethod = Utility.getInstance().buildFieldGetter(this.getFromPageVarProperty());

				// dates are guaranteed to be stored as a Calendar object
				Calendar cal = (Calendar) obj.getClass().getDeclaredMethod(getterMethod, null).invoke(obj, null);
				if (cal != null)
					output.append(cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
			}
			this.pageContext.setAttribute(this.getToPageVar(), output.toString());
		} catch (InvocationTargetException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		} catch (NoSuchMethodException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		} catch (IllegalAccessException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}

	public String getFromPageVar() {
		return fromPageVar;
	}

	public void setFromPageVar(String fromPageVar) {
		this.fromPageVar = fromPageVar;
	}

	public String getFromPageVarProperty() {
		return fromPageVarProperty;
	}

	public void setFromPageVarProperty(String fromPageVarProperty) {
		this.fromPageVarProperty = fromPageVarProperty;
	}

	public String getToPageVar() {
		return toPageVar;
	}

	public void setToPageVar(String toPageVar) {
		this.toPageVar = toPageVar;
	}
}