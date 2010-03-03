<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userRegistrations"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<script>function validate() { return true; }</script>

  <s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>
  <s:form name="mainForm" target="_top" cssClass="content_table_main" action="searchUserRegistration.${ext}" onsubmit="return validate();" theme="qxhtml">
    <s:hidden name="contentOnly" value="${param.contentOnly}" theme="simple"/>
    <s:hidden name="isPopup" value="${param.isPopup}" theme="simple"/>
    
    <tr>
      <td class="allheader" colspan="2">Search for User Accounts</td>
	</tr>
	
    <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <td>Search Type </td>
      <td>
        <s:select name="searchBooleanType" cssClass="form_obj" multiple="false" size="1" list="preloadData.searchBooleanTypes" listKey="value" listValue="label" theme="simple"/>
		<s:select name="searchMatchType" cssClass="form_obj" multiple="false" size="1" list="preloadData.searchMatchTypes" listKey="value" listValue="label" theme="simple"/>
	  </td>
    </tr>
    <tr>
      <td>Results per page </td>
      <td><s:select name="resultsPerPage" cssClass="form_obj" multiple="false" size="1" list="preloadData.resultsPerPageTypes" listKey="value" listValue="label" theme="simple"/></td>
    </tr>
    
    <s:textfield cssClass="form_obj" name="firstName" size="35" label="First Name"/>
    <s:textfield cssClass="form_obj" name="lastName" size="20" label="Last Name" />
    <s:textfield cssClass="form_obj" name="user.email" size="35" label="Email" />
    <s:select name="country.id" cssClass="form_obj" multiple="false" size="1" list="preloadData.countryTypes" listKey="value" listValue="label" label="Country" />

    <tr>
      <td colspan="2" align="center" class="tdContent">
        <input type="button" value="Search" class="form_button" onclick="this.form.submit();"/>
        <s:reset value="Reset" cssClass="form_button" theme="simple"/>
      </td>
    </tr>
    </table></td></tr>
    
    <tr>
      <td colspan="2"><iframe name="embeddedFrame" height="0" width="100%" frameborder="0" marginwidth="0" marginheight="0" id="genericEmbeddedFrame" scrolling="<c:out value="${iframeScolling}"/>">Sorry but your browser doesn't support inline frames. Please get a newer browser.</iframe></td>
    </tr>
  </s:form>          
<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>