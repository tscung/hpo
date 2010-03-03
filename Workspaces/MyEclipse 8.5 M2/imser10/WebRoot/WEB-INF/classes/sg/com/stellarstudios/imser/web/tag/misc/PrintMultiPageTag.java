package sg.com.stellarstudios.imser.web.tag.misc;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.web.common.WebConstants;
import sg.com.stellarstudios.imser.web.tag.BaseTag;

public class PrintMultiPageTag extends BaseTag {
	private String urlPageVar;

	private String resultsPerPagePageVar;

	private String currentPagePageVar;

	private String collectionPageVar;

	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	public int doEndTag() throws JspException {
		try {
			StringBuffer output = new StringBuffer("");

			HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
			HttpServletResponse response = (HttpServletResponse) this.pageContext.getResponse();

			// parse parameters
			String url = (String) this.pageContext.getAttribute(getUrlPageVar());
			if (url == null) url = getUrlPageVar();
			
			int resultsPerPage = new Integer((String) this.pageContext.getAttribute(getResultsPerPagePageVar())).intValue();
			int currentPage = new Integer((String) this.pageContext.getAttribute(getCurrentPagePageVar())).intValue();
			Collection collection = (Collection) this.pageContext.getAttribute(getCollectionPageVar());
			int totalPages = WebConstants.MULTIPAGE_TOTALPAGES_DEFAULT;
			if (collection != null && collection.size() != resultsPerPage) totalPages = collection.size() / resultsPerPage;

			if (totalPages > 0) {
				String encodedUrl = response.encodeURL(url);
				// if current page is not first page
				if (currentPage != WebConstants.MULTIPAGE_CURRENTPAGE_DEFAULT) {
					output.append(buildLinkLabel(request,encodedUrl, WebConstants.LABEL_MULTIPAGE_PREV, currentPage - 1, resultsPerPage, totalPages));
					output.append(" - ");
				} else {
					output.append(WebConstants.LABEL_MULTIPAGE_PREV);
					output.append(" - ");
				}
				boolean toCap = totalPages > WebConstants.MULTIPAGE_PRINT_MAXPAGE;
				int amtToPrintWhenCapped = WebConstants.MULTIPAGE_PRINT_MAXPAGE / 2;
				for (int i = WebConstants.MULTIPAGE_CURRENTPAGE_DEFAULT; i <= totalPages; i++) {
					if (i != currentPage)
						output.append(buildLinkLabel(request,encodedUrl, new Integer(i + 1).toString(), i, resultsPerPage, totalPages));
					else
						output.append(i + 1);

					output.append(" ");
				}
				// if current page is not last page
				if (currentPage != totalPages) {
					output.append("- ");
					output.append(buildLinkLabel(request,encodedUrl, WebConstants.LABEL_MULTIPAGE_NEXT, currentPage + 1, resultsPerPage, totalPages));
				} else {
					output.append("- ");
					output.append(WebConstants.LABEL_MULTIPAGE_NEXT);
				}

				this.pageContext.getOut().write(output.toString());
			}
		} catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}

		return super.doEndTag();
	}

	private String buildLinkLabel(HttpServletRequest request,String url, String label, int currentPage, int resultsPerPage, int totalPages) {
		String sortBy = request.getParameter(WebConstants.PARAM_SORTBY);
		String sortType = request.getParameter(WebConstants.PARAM_SORTTYPE);
		String sortOrder = request.getParameter(WebConstants.PARAM_SORTORDER);
		
		StringBuffer link = new StringBuffer(url + (url.contains("?")?"&":"?") + WebConstants.PARAM_CURRENTPAGE + "=" + currentPage + "&" + WebConstants.PARAM_RESULTSPERPAGE + "=" + resultsPerPage + "&" + WebConstants.PARAM_TOTALPAGES + "=" + totalPages);
		if (sortBy != null) link.append("&" + WebConstants.PARAM_SORTBY + "=" + sortBy);
		if (sortType != null) link.append("&" + WebConstants.PARAM_SORTTYPE + "=" + sortType);
		if (sortOrder != null) link.append("&" + WebConstants.PARAM_SORTORDER + "=" + sortOrder);
				
		String ret = "<a href=\""+link.toString()+"\">" + label + "</a>";

		return ret;
	}

	public String getCurrentPagePageVar() {
		return currentPagePageVar;
	}

	public void setCurrentPagePageVar(String currentPagePageVar) {
		this.currentPagePageVar = currentPagePageVar;
	}

	public String getResultsPerPagePageVar() {
		return resultsPerPagePageVar;
	}

	public void setResultsPerPagePageVar(String resultsPerPagePageVar) {
		this.resultsPerPagePageVar = resultsPerPagePageVar;
	}

	public String getCollectionPageVar() {
		return collectionPageVar;
	}

	public void setCollectionPageVar(String collectionPageVar) {
		this.collectionPageVar = collectionPageVar;
	}

	public String getUrlPageVar() {
		return urlPageVar;
	}

	public void setUrlPageVar(String urlPageVar) {
		this.urlPageVar = urlPageVar;
	}

}
