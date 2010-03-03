<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="pnp"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>
<br/><br/>

<table class="content_table_main">
        <tr>
        	<td colspan="2" align="center" class="allheader">Thank you for your feedback!</td>
        </tr>
        <tr><td colspan="2">&nbsp;</td></tr>

		<tr align="center">
		  <td align="center"><table width="550px" border="0" cellspacing="0" cellpadding="0">
            <tr><td><a href="pnpPresentations.hi5"><img src="<c:url value="/images/button_present.jpg"/>" border="0"/></a><br></td><td>&nbsp;</td></tr>
			<tr><td><a href="pnpAlbums.hi5"><img src="<c:url value="/images/button_photos.jpg"/>" border="0"/></a><br></td><td>&nbsp;</td></tr>
			<tr><td><a href="pnpVideos.hi5"><img src="<c:url value="/images/button_vid.jpg"/>" border="0"/></a><br></td><td>&nbsp;</td></tr>
            <tr><td valign="middle"><a href="http://www.theinfluence3.com/bingo" target="_blank"><img src="<c:url value="/images/button_play.jpg"/>" border="0"/></a></td><td valign="middle"><span class="agendared">(Increase your deal size when you sell F5 products and software.)</span></td></tr>
          </table></td>
		</tr>

</table>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>