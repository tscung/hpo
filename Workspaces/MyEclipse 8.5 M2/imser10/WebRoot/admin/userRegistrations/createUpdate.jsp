<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userRegistrations"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<%@include file="/jspf/jsLoadCalendar.jspf" %>
<script>function validate() { return true; }</script>
	
<body id="iframeSelf" onload="resizeIframe('iframeSelf','genericEmbeddedFrame')">
<s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>

<s:form name="mainForm" target="_top" cssClass="content_table_main" theme="qxhtml" onsubmit="return validate();">
  <tr><td colspan="2" class="allheader">Update</td></tr>
  <tr><td colspan="2">* Indicates a required field.<br/><br/><s:actionmessage theme="simple" /><s:actionerror theme="simple" /></td></tr>

  <c:set var="showActivities" value="false"/>
  <%@include file="/jspf/templateRegister.jspf" %>
	  
  <tr><td colspan="2">&nbsp;</td></tr>
  <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
  <tr><td colspan="2" class="headerRow">Registration Status</td></tr>
  <s:radio name="registrationStatus" list="#{'1':'Saved<br/>', '2':'Submitted'}" label="Registration Status"/>
  </table></td></tr>

  <tr><td colspan="2">&nbsp;</td></tr>
  <tr><td colspan="2" align="center" class="highlight">User registration last saved on <misc:printDateTime property="model.dateSaved"/>.</td></tr>
  <tr><td colspan="2">&nbsp;</td></tr>

  <tr><td colspan="2" align="center" class="highlight">Please review your information prior to submitting your registration.</td></tr>
  <tr>
    <td colspan="2" align="center">
      <input type="button" value="Save" class="form_button" onclick="this.form.action='<c:url value="updateUserRegistration.${ext}"/>';this.form.submit();"/>
      <s:reset value="Reset Form" cssClass="form_button" theme="simple"/>          
    </td>
  </tr>
</s:form>

<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>