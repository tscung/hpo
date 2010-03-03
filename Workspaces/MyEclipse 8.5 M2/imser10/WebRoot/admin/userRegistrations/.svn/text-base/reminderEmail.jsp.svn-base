<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userRegistrations"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<s:form action="sendReminderEmailUserRegistration.${ext}" name="mainForm" target="_top" cssClass="content_table_main">
  <table class="content_table_main">
    <tr><td colspan="2" class="allheader">Send Reminder Email</td></tr>
    <tr><td colspan="2"><s:actionmessage theme="simple" /></td></tr>
    <tr>
      <td width="40%">Subject</td>
      <td><s:textfield cssClass="form_obj" size="40" name="emailSubject"/></td>
    </tr>
    <tr>
      <td>List of emails (hit &quot;enter&quot; after every email)</td>
      <td><s:textarea cssClass="form_obj" rows="10" cols="50" name="emails"/></td>
    </tr>
    <tr>
      <td colspan="2"><a href="http://www.hi5event.com/images/email_reminder.jpg" target="_blank">View reminder image.</a></td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    <tr><td colspan="2"><s:submit value="Send Reminder" cssClass="form_button"/></td></tr>
  </table>
</s:form>
            
<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>