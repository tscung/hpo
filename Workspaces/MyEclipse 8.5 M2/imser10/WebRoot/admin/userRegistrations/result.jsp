<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/${adminFolder}/header.jsp"><c:param name="currentPg" value="userRegistrations"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

<script src="<c:url value="/dwr/interface/UserRegistrationAction.js"/>"></script>
<%@include file="/jspf/jsLoadAjaxDWR.jspf" %>
<script>
function approve(id) {
	UserRegistrationAction.updateApprovedStatus(id, true, approve_callback);
}
function approve_callback(data) {
	if (data) {
		alert('Email for user registration sent.');
	}
	else {
		alert('Please try again.');
	}
}
</script>
  <table class="content_table_main">
    <tr>
      <td>
        <c:if test="${actionCommand == 'create'}">User registration record successfully added.</c:if>
        <c:if test="${actionCommand == 'update'}">User registration record successfully updated.</c:if>
        <c:if test="${actionCommand == 'delete'}">User registration record successfully deleted.</c:if>
        
        <c:if test="${actionCommand == 'create' or actionCommand == 'update'}">
          <br/><br/>
          Available action(s):<br/>
          &nbsp;&nbsp;<a href="<c:url value="preloadUpdateUserRegistration.${ext}?id=${model.id}&contentOnly=${param.contentOnly}&isPopup=${param.isPopup}"/>">Modify</a><br/>
          &nbsp;&nbsp;<a href="#" onclick="approve(<c:out value="${model.id}"/>, true);">Send email</a>
        </c:if>
      </td>
    </tr>
  </table>
            
<c:import url="/${adminFolder}/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>