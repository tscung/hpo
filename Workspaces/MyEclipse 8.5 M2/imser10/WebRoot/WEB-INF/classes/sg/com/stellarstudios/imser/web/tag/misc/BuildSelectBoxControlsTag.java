package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class BuildSelectBoxControlsTag extends BaseTag {
	private String propertyName;
	private String folder;
	private String mapping;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		try {
			StringBuffer output = new StringBuffer("");

			output.append("<a href=\"#\" onclick=\"popup('../" + getFolder() + "/preloadCreate-" + getMapping() +
					"." + pageContext.getAttribute(WebKeys.ACTION_EXTENSION_PAGEKEY) + "?contentOnly=true&isPopup=true')\"/>Create</a>/");
			output.append("<a href=\"#\" onclick=\"popupAppendSelectedId('../" + getFolder() + "/preloadUpdate-" + getMapping() +
					"." + pageContext.getAttribute(WebKeys.ACTION_EXTENSION_PAGEKEY) + "?contentOnly=true&isPopup=true',document.forms[0].elements['" + getPropertyName() + "'])\"/>Update</a>/");
			output.append("<a href=\"#\" onclick=\"popupAppendSelectedIdWithConfirmation('../" + getFolder() + "/delete-" + getMapping() +
					"." + pageContext.getAttribute(WebKeys.ACTION_EXTENSION_PAGEKEY) + "?contentOnly=true&isPopup=true',document.forms[0].elements['" + getPropertyName() + "'])\"/>Delete</a>");

			pageContext.getOut().write(output.toString());
			
		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}
	
	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getMapping() {
		return mapping;
	}

	public void setMapping(String mapping) {
		this.mapping = mapping;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}