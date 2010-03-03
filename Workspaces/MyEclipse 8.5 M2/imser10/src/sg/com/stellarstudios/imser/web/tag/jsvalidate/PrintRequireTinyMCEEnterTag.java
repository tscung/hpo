package sg.com.stellarstudios.imser.web.tag.jsvalidate;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintRequireTinyMCEEnterTag extends BaseTag {
	private String label;
	private String message;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		StringBuffer output = new StringBuffer("");

		try {
			output.append("\tif (tinyMCE.getContent() == '') {");
			output.append("\n");
			output.append("\t\tsuccess = false");
			output.append("\n");
			
			if (getMessage() == null)
				output.append("\t\talert('Please enter "+getLabel()+".');");
			else
				output.append("\t\talert('"+getMessage()+"');");
			
			output.append("\n}");
			
			this.pageContext.getOut().write(output.toString());

		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
		
		return super.doEndTag();
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