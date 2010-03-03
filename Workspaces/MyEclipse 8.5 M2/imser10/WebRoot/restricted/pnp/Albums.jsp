<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="pnp"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>
<%@ include file="/jspf/execDefaultMultipageSettings.jspf" %>

<%
java.util.List list = new java.util.ArrayList();
for (int i = 1; i <= 479; i++) {
	list.add("a01p" + sg.com.stellarstudios.imser.common.Utility.getInstance().buildDigitNumber(i,3));
}
pageContext.setAttribute("list",list);
%>

<c:set var="columns" value="5"/>

<s:url value="" includeParams="get" id="strutsurl">
  <s:param name="currentPage" value=""/><s:param name="resultsPerPage" value=""/>
</s:url>
<s:set name="url" value="strutsurl"/>

<table class="content_table_main">
		<tr>
			<td class="allheader">Photos</td>
		</tr>
		<tr>
			<td><a href="http://www.hi5event.com/gallery/photos.zip">Click here to download album</a></td>
		</tr>
		<tr>
		  <td colspan="<c:out value="${columns}"/>" align="right"><misc:printMultiPage urlPageVar="url" resultsPerPagePageVar="resultsPerPage" currentPagePageVar="currentPage" collectionPageVar="list"/></td>
		</tr>
		<tr>
		  <td>
	      	<table width="100%">
			  <c:forEach var="item" items="${list}" varStatus="status" begin="${resultsPerPage * currentPage}" end="${(resultsPerPage * currentPage) + (resultsPerPage - 1)}">
				<c:if test="${(status.index+columns)%columns == 0}"><tr></c:if>
				<td valign="middle" width="20%" style="text-align:center;"><a href="http://www.hi5event.com/gallery/r/<c:out value="${item}"/>.jpg" target="_blank"><img src="http://www.hi5event.com/gallery/t/<c:out value="${item}"/>.jpg" border="0"></a></td>
			    <c:if test="${(status.index+columns)%columns == (columns-1)}"></tr></c:if>
			    
			    <c:if test="${(status.index+columns)%columns != (columns-1) and status.last}">
			      <c:set var="toRepeat" value="${(columns-(status.index+columns)%columns)-1}"/>
			      <c:forEach begin="1" end="${toRepeat}"><td>&nbsp;</td></c:forEach>
			      </tr>
			    </c:if>
			  </c:forEach>
	      	</table>
		  </td>
		</tr>
		<tr>
		  <td colspan="<c:out value="${columns}"/>" align="right"><misc:printMultiPage urlPageVar="url" resultsPerPagePageVar="resultsPerPage" currentPagePageVar="currentPage" collectionPageVar="list"/></td>
		</tr>
</table>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>