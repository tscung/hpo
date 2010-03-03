<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="home"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<script src="<c:url value="/dwr/interface/UserAction.js"/>"></script>
<%@include file="/jspf/jsLoadAjaxDWR.jspf" %>

<body onload="disableRequestButtons();"/>

<script>
var isEmailRegisteredBoolean = false;
function isEmailRegistered() {
	form = document.forgotPasswordForm;
	var email = form.email.value;
	if (email != '') UserAction.isEmailRegistered(email, isEmailRegistered_callback);
}
function isEmailRegistered_callback(data) {
	isEmailRegisteredBoolean = data;
	if (isEmailRegisteredBoolean) {
		dwr.util.setValue("isEmailRegisteredStatus", "E-mail found. Please proceed to request.");
		enableRequestButtons();
	}
	else {
		dwr.util.setValue("isEmailRegisteredStatus", "E-mail not found. Please try again.");
		disableRequestButtons();
	}
}
function requestForPassword() {
	form = document.forgotPasswordForm;
	var email = form.email.value;
	if (email != '' && isEmailRegisteredBoolean) UserAction.requestForPassword(email, requestForPassword_callback);
}
function requestForPassword_callback(data) {
	if (data) {
		dwr.util.setValue("requestForPasswordStatus", "Password request successful. Please check your e-mail for login information.");
		disableRequestButtons();
	}
	else {
		dwr.util.setValue("requestForPasswordStatus", "Unable to send password. Please try again.");
		enableRequestButtons();
	}
}
function enableRequestButtons() {
	document.forgotPasswordForm.Request.disabled = false;
}
function disableRequestButtons() {
	document.forgotPasswordForm.Request.disabled = true;
}
</script>

	<s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>
	<s:form name="forgotPasswordForm" theme="qxhtml" cssClass="content_table_main" onsubmit="return false;">
      <tr>
        <td class="allheader">Request for Password</td>
      </tr>
      <tr>
        <td><table class="subTable" align="center" cellpadding="5" cellspacing="0">
          <tr>
            <td class="tdLabel">* E-mail</td>
            <td class="tdContent">
              <s:textfield name="email" cssClass="form_obj" size="35" onkeyup="isEmailRegistered();" onkeypress="if (!submitenter(this,event)) requestForPassword();" theme="simple"/>
              <br/><span id="isEmailRegisteredStatus" class="noteblack"/>
          	</td>
          </tr>
          <tr><td colspan="2" align="center" class="tdContent"><span id="requestForPasswordStatus" class="noteblack"/></td></tr>
          <tr>
            <td class="tdContent" colspan="2" align="center">
              <input name="Request" type="button" class="form_button" id="Request" value="Request" onclick="requestForPassword()"/>
            </td>
          </tr>
        </table></td>
      </tr>
    </s:form>
    
<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>