package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class BuildMaintainEntityControlsTag extends BaseTag {
	private String entity;
	private String create;
	private String search;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		try {
			StringBuffer output = new StringBuffer("");
			//output.append("[");
			if (create == null || (create != null && create.equals(GlobalKeys.YES_VALUE))) {
				output.append("<a href=\"preloadCreate" + getEntity() + "." + pageContext.getAttribute(WebKeys.ACTION_EXTENSION_PAGEKEY) + "?contentOnly=true\" target=\"embeddedFrame\">Create</a>");
			}
			//if have both
			if ((create == null || (create != null && create.equals(GlobalKeys.YES_VALUE))) &&
					(search == null || (search != null && search.equals(GlobalKeys.YES_VALUE)))) {
				output.append("/");				
			}
			if (search == null || (search != null && search.equals(GlobalKeys.YES_VALUE))) {
				output.append("<a href=\"preloadSearch" + getEntity() + "." + pageContext.getAttribute(WebKeys.ACTION_EXTENSION_PAGEKEY) + "\" target=\"_top\"/>Search</a>");
			}
			//if have either one
			if ((create == null || (create != null && create.equals(GlobalKeys.YES_VALUE))) ||
					(search == null || (search != null && search.equals(GlobalKeys.YES_VALUE)))) {
				output.append("/");
			}
			output.append("<a href=\"#\" onclick=\"refresh()\">Refresh</a>");
			//output.append("]");
			pageContext.getOut().write(output.toString());
			
		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}