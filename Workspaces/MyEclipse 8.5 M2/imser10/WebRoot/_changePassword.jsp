<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="home"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<script src="<c:url value="/dwr/interface/UserAction.js"/>"></script>
<%@include file="/jspf/jsLoadAjaxDWR.jspf" %>

<script>
var isOldPasswordMatchedBoolean = false;
function isOldPasswordMatched() {
	form = document.mainForm;
	var oldPassword = form.oldPassword.value;
	UserAction.isOldPasswordMatched(oldPassword, isOldPasswordMatched_callback);
}
function isOldPasswordMatched_callback(data) {
	isOldPasswordMatchedBoolean = data;
	if (isOldPasswordMatchedBoolean) {
		dwr.util.setValue("isOldPasswordMatchedStatus", "Correct password.");
	}
	else {
		dwr.util.setValue("isOldPasswordMatchedStatus", "Incorrect password.");
	}
}
function changePassword() {
	success = true;
	
	form = document.mainForm;

	<jsvalidate:printRequireEnter field="oldPassword" label="old password"/>
	<jsvalidate:printRequireEnter field="password" label="new password"/>
	<jsvalidate:printRequireEnter field="reenterPassword" label="reenter new password"/>
	<jsvalidate:printRequireIdentical field1="password" field2="reenterPassword" label="new passwords"/>

	if (success) {
		if (!isOldPasswordMatchedBoolean) { alert('Incorrect password.'); }
		else {
			var oldPassword = form.oldPassword.value;
			var newPassword = form.password.value;
			var reenterPassword = form.reenterPassword.value;
			UserAction.changePassword(oldPassword, newPassword, reenterPassword, changePassword_callback);
		}
	}
}
function changePassword_callback(data) {
	passwordChanged = data;
	if (passwordChanged) {
		dwr.util.setValue("changePasswordStatus", "Password changed successful.");
		<c:if test="${param.contentOnly != true}">
		  alert('Password successfully changed.\nYou are now being directed to the home page.');
		  window.location.href = '<c:url value="/restricted/getHome.${ext}"/>';
		</c:if>
	}
	else {
		dwr.util.setValue("changePasswordStatus", "Passwords error. Please try again.");
	}
}
</script>

  <s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>
  <s:form name="mainForm" theme="qxhtml" cssClass="content_table_main" onsubmit="return false;">
    <tr>
      <td colspan="2" class="allheader">Change Password</td>
    </tr>
    <tr>
      <td colspan="2">
      <div id="content">
      <table class="subTable" align="center" cellpadding="5" cellspacing="0">
	    <tr>
	      <td class="tdLabel"><span class="requiredasterisk">*</span> Old password</td>
	      <td class="tdContent"><s:password cssClass="form_obj" name="oldPassword" size="10" theme="simple" onblur="isOldPasswordMatched();"/><br/><span id="isOldPasswordMatchedStatus" class="noteblack"/></td>
	    </tr> 
	    <tr>
	      <td class="tdLabel"><span class="requiredasterisk">*</span> New password</td>
	      <td class="tdContent"><s:password cssClass="form_obj" name="password" size="10" theme="simple" /></td>
	    </tr> 
	    <tr>
	      <td class="tdLabel"><span class="requiredasterisk">*</span> Re-enter new password</td>
	      <td class="tdContent"><s:password cssClass="form_obj" name="reenterPassword" size="10" theme="simple" onkeypress="if (!submitenter(this,event)) isOldPasswordMatched();" /></td>
	    </tr>
	           
        <tr><td colspan="2" align="center" class="tdContent"><span id="changePasswordStatus" class="noteblack"/></td></tr>
        <tr>
          <td colspan="2" align="center" class="tdContent">
            <input name="Save" type="button" class="form_button" id="Save" value="Save" onclick="changePassword();"/>
          </td>
        </tr>
      </table>
      </div>
      </td>
    </tr>
  </s:form>
<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>