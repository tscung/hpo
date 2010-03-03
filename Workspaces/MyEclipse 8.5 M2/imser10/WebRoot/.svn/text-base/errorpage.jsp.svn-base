<%@ page isErrorPage="true" %>
<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<s:set name="s2exp" value="exception"/>
<%
	sg.com.stellarstudios.imser.helper.LogHelper logHelper = (sg.com.stellarstudios.imser.helper.LogHelper) sg.com.stellarstudios.imser.common.ServiceLocator.getInstance().getLogHelper();
	if (exception == null) {
		logHelper.error((Exception)pageContext.getAttribute("s2exp"));
	}
	else {
		logHelper.error(exception);
	}
%>

<table class="content_table_main">
  <tr><td>Your action have just triggered an error within the system.<br/><br/>We will look into this problem as soon as possible.<br/><br/>Thank you.</td></tr>
</table>