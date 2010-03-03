package sg.com.stellarstudios.imser.web.tag.jsvalidate;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintRequireSelectTag extends BaseTag {
	private String field;
	private String label;
	private String message;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		StringBuffer output = new StringBuffer("");

		try {
			output.append("for (i = 0; i < form.elements.length; i++) {\n");
			output.append("\tif (form.elements[i].name == '" + getField() + "' && form.elements[i].value == '') {");
			output.append("\n");
			output.append("\t\tsuccess = false");
			output.append("\n");
			
			if (getMessage() == null)
				output.append("\t\talert('Please select "+getLabel()+".');");
			else
				output.append("\t\talert('"+getMessage()+"');");

			output.append("\n");
			output.append("\t\tform.elements[i].focus();");			
			output.append("\n}");
			output.append("\n}");
			
			this.pageContext.getOut().write(output.toString());

		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
		
		return super.doEndTag();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}