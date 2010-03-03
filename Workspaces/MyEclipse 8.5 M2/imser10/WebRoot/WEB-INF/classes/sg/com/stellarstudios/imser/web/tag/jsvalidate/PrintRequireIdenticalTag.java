package sg.com.stellarstudios.imser.web.tag.jsvalidate;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintRequireIdenticalTag extends BaseTag {
	private String field1;
	private String field2;
	private String label;
	private String message;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		StringBuffer output = new StringBuffer("");

		try {
			output.append("\tif (form.elements['"+getField1()+"'].value != '' && form.elements['"+getField2()+"'].value != '') {");
			output.append("\t\tif (form.elements['"+getField1()+"'].value != form.elements['"+getField2()+"'].value) {");
			output.append("\n");
			output.append("\t\tsuccess = false");
			output.append("\n");
			
			if (getMessage() == null)
				output.append("\t\talert('Please ensure "+getLabel()+" are identical.');");
			else
				output.append("\t\talert('"+getMessage()+"');");

			output.append("\n");
			output.append("\t\tform.elements['"+getField1()+"'].focus();");			
			output.append("\n}");	
			output.append("\n}");
			
			this.pageContext.getOut().write(output.toString());

		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
		
		return super.doEndTag();
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
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