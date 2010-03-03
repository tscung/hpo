<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <title>Pump It Up Hi-5 2008</title>
    <link href="<c:url value="/css/styles.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/css/table.css"/>" rel="stylesheet" type="text/css" />
  </head>

  <%@include file="/jspf/jsAdmin.jspf" %>

  <body>
        
<script src="<c:url value="/dwr/interface/UserAction.js"/>"></script>
<%@include file="/jspf/jsLoadAjaxDWR.jspf" %>
<script>
var loginBoolean = false;
function login() {
	form = document.mainForm;
	success = true;

	<jsvalidate:printRequireEnter field="email" label="email"/>

	if (success) {
	  var email = form.email.value;
	  var password = form.password.value;
	  UserAction.loginAJAX(email, password, 0, false, login_callback);
	}	
}
function login_callback(data) {
	if (data) {
		dwr.util.setValue("loginStatus", "Logging in...");
		form = document.mainForm;
		form.submit();
	}
	else {
		dwr.util.setValue("loginStatusRed", "Invalid email/password. Please try again.");
	}
}
</script>
      
<s:form action="/${adminFolder}/preloadHomeUser.${ext}" name="mainForm" target="_top" theme="simple">
  
<table class="indexTable" align="center">
  <tr>
    <td colspan="2"><img src="<c:url value="/images/log-in-banner.jpg"/>" width="800" height="414"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><table>
      <tr>
        <td class="allheader">Administrator Log-in</td>
      </tr>
      <tr>
        <td class="indexcontent">Please enter your email address and password to log in</td>
      </tr>
      <tr>
        <td><table>
            <tr>
              <td class="indexcontent">E-mail: </td>
              <td><s:textfield name="email" cssClass="form_obj" size="30"/></td>
              <td>&nbsp;</td>
              <td class="indexcontent">Password:</td>
              <td><s:password name="password" cssClass="form_obj" size="20" onkeypress="if (!submitenter(this,event)) login();"/></td>
              <td valign="middle">
                <input type="button" value="Log-in" class="tight_button" onclick="login();"/>
              </td>
            </tr>
        </table></td>
      </tr>
      <tr><td><span id="loginStatus" class="highlight"/><span id="loginStatusRed" class="highlightRed"/></td></tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="15%">&nbsp;</td>
    <td><div align="right"><img src="<c:url value="/images/logo.jpg"/>"></div></td>
  </tr>
</table>
</s:form>

</html>