<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="airfare"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

	 	<table class="content_table_main">
		<tr>
            <td class="allheader">Air Fare </td>
        </tr>
		<tr>
            <td class="content">The cost for airfare will NOT be borne by F5 Networks. You will need to arrange for your own flight and please remember to
              provide your confirmed flight details during registration.<br>
			  <br>Also, please check if you require a visa to enter Malaysia.
			  </td>
        </tr>
        </table>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>