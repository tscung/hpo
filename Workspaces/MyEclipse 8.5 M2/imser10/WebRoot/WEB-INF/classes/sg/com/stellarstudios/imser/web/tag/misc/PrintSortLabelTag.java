package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.common.WebConstants;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintSortLabelTag extends BaseTag {
	private String urlPageVar;

	private String type;

	private String label;

	private String objectPageVar;
	
	private String field;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		try {
			StringBuffer output = new StringBuffer("");

			HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
			HttpServletResponse response = (HttpServletResponse) this.pageContext.getResponse();

			String sortByParam = request.getParameter("sortBy");
			String sortOrderParam = request.getParameter("sortOrder");

			if (sortByParam == null)
				sortByParam = "";
			if (sortOrderParam == null)
				sortOrderParam = "";

			String sortOrder = "";
			String sortByThisFieldLabel = "";

			if (sortByParam.equals(getField()) && sortOrderParam.equals(GlobalKeys.SORTORDER_ASC)) {
				sortOrder = GlobalKeys.SORTORDER_DESC;
			}
			if (!sortByParam.equals(getField()) || sortByParam.equals(getField()) && sortOrderParam.equals(GlobalKeys.SORTORDER_DESC)) {
				sortOrder = GlobalKeys.SORTORDER_ASC;
			}
			if (sortByParam.equals(getField())) {
				if (sortOrder.equals(GlobalKeys.SORTORDER_ASC))
					sortByThisFieldLabel = "(Asc)";
				if (sortOrder.equals(GlobalKeys.SORTORDER_DESC))
					sortByThisFieldLabel = "(Desc)";
			}

			String url = (String) this.pageContext.getAttribute(getUrlPageVar());
			if (url == null)
				url = getUrlPageVar();

			String encodedURL = response.encodeURL(url + "?cmd=sort&" + WebConstants.PARAM_SORTBY + "=" + getField() + "&" + WebConstants.PARAM_SORTTYPE + "=" + getType() + "&" + WebConstants.PARAM_SORTORDER + "=" + sortOrder);
			// MessageResources resources =
			// ((BaseDispatchAction)ServiceLocator.getInstance().getApplicationContext().getBean("/crm/customer")).getResources(request);
			// String labelOut = "", label =
			// resources.getMessage(getLabelKey());
			// if (label != null && !label.equals("")) labelOut = label;
			// else labelOut = getLabelKey();

			output.append("<a href=\"" + encodedURL + "\">" + getLabel() + " " + sortByThisFieldLabel + "</a>");

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrlPageVar() {
		return urlPageVar;
	}

	public void setUrlPageVar(String urlPageVar) {
		this.urlPageVar = urlPageVar;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getObjectPageVar() {
		return objectPageVar;
	}

	public void setObjectPageVar(String objectPageVar) {
		this.objectPageVar = objectPageVar;
	}
}
