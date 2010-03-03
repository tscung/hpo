<%@ include file="/jspf/execTaglibImports.jspf" %>
<%@ include file="/jspf/execStandard.jspf" %>

<c:import url="/header.jsp"><c:param name="currentPg" value="evaluationForm"/><c:param name="currentAction" value="${actionCommand}"/><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>

  <s:bean name="java.util.HashMap" id="qTableLayout"><s:param name="tablecolspan" value="2"/></s:bean>
  <s:form name="mainForm" target="_top" cssClass="content_table_main" theme="qxhtml" onsubmit="return validate();" namespace="/restricted" action="updateEvaluationFormUserRegistration">

    <s:hidden name="id" value="${model.id}" theme="simple"/>
    <s:hidden name="user.id" value="${model.user.id}" theme="simple"/>
          
    <tr><td colspan="2" class="allheader">Hi-5 Pump it Up 2008 Partner Summit  - Feedback</td></tr>
	<tr><td colspan="2">
		Thank you for taking the time to complete the following feedback form. Your feedback is important in helping us deliver a valuable and successful event next year.<br/><br/>
		Your feedback is strictly confidential and will not be shared outside of F5 APAC. Simply click on your choice of answers and complete the open fields with your comments. <br/><br/>
		Once completed, hit the "Submit" button and you will automatically be forwarded to the secure Hi-5 2008 presentations, video and photos download site. You can enjoy repeated access to the presentation downloads and photos until 29 February 2008 without having to complete the evaluation form again.<br/><br/>
		
		Thank you in advance for your input and we look forward to seeing you again next year.
	</td></tr>
    <tr><td colspan="2">&nbsp;</td></tr>   
	<tr><td class="registerred" colspan="2">Note: All fields are mandatory except "Comments" fields.<br/><br/>1 to 5 scale with 1 = Poor and 5 = Excellent.<br/><br/><s:actionmessage theme="simple" /></td></tr>

	  <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
        <tr><td colspan="2" class="headerRow">Evaluation of Hi-5 Presenters and Content Evaluation on Jan 29</td></tr> 
        <tr><td colspan="2"><b>Song Tang Yih (F5): Opening Address - APAC Overview and Outlook</b></td></tr>      
        <tr><td width="25%">Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker01Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker01Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker01Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker01Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>John McAdam (F5): Keynote Address -State of the Union</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker02Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker02Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker02Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker02Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Dan Matte (F5): A Growing ADN Opportunity</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker03Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker03Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker03Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker03Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Erik Giesa (F5): Next-generation Application Delivery</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker04Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker04Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker04Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker04Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Darien Nagle (Microsoft): Microsoft & F5 Partnership</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker05Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker05Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker05Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker05Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Mark Fabbi (Gartner): Application Fluency: New Network Infrastructure for New Application</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker06Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker06Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker06Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker06Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Erik Giesa (F5): F5's Product Roadmap </b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker07Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker07Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker07Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker07Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Mark Anderson (F5): Solution Selling in Practice</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker08Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker08Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker08Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker08Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Michael Dodds (F5): Solution Selling in Practice</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker09Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker09Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker09Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker09Cr</s:param></s:fielderror></td></tr>   
        <tr><td colspan="2"><b>Jack Poon (F5) APAC Partner Program Update</b></td></tr>      
        <tr><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker10Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker10Pq</s:param></s:fielderror></td></tr>   
        <tr><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker10Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker10Cr</s:param></s:fielderror></td></tr>   
		<tr><td colspan="2">&nbsp;</td></tr>      
		<tr><td colspan="2"><br/></td></tr>      
        
		<script>
		function displaySelectedTrack(track) {
		  if (track == 1) {
		  	document.getElementById("row101").style.display = '';
		  	document.getElementById("row102").style.display = '';
		  	document.getElementById("row103").style.display = '';
		  	document.getElementById("row104").style.display = '';
		  	document.getElementById("row105").style.display = '';
		  	document.getElementById("row106").style.display = '';
		  	document.getElementById("row107").style.display = '';
		  	document.getElementById("row108").style.display = '';
		  	document.getElementById("row109").style.display = '';
		  	document.getElementById("row110").style.display = '';
		  	document.getElementById("row111").style.display = '';
		  	document.getElementById("row112").style.display = '';
		  	document.getElementById("row113").style.display = '';
		  	document.getElementById("row114").style.display = '';
		  	document.getElementById("row115").style.display = '';
		  	document.getElementById("row201").style.display = 'none';
		  	document.getElementById("row202").style.display = 'none';
		  	document.getElementById("row203").style.display = 'none';
		  	document.getElementById("row204").style.display = 'none';
		  	document.getElementById("row205").style.display = 'none';
		  	document.getElementById("row206").style.display = 'none';
		  	document.getElementById("row207").style.display = 'none';
		  	document.getElementById("row208").style.display = 'none';
		  	document.getElementById("row209").style.display = 'none';
		  	document.getElementById("row210").style.display = 'none';
		  	document.getElementById("row211").style.display = 'none';
		  	document.getElementById("row212").style.display = 'none';
		  	document.getElementById("row301").style.display = 'none';
		  	document.getElementById("row302").style.display = 'none';
		  	document.getElementById("row303").style.display = 'none';
		  	document.getElementById("row304").style.display = 'none';
		  	
		  	for (i = 0; i < 5; i++) {
		  		document.mainForm.speaker16Pq[i].checked = false;
			  	document.mainForm.speaker17Pq[i].checked = false;
			  	document.mainForm.speaker18Pq[i].checked = false;
			  	document.mainForm.speaker19Pq[i].checked = false;
			  	document.mainForm.speaker20Pq[i].checked = false;
			  	document.mainForm.speaker16Cr[i].checked = false;
			  	document.mainForm.speaker17Cr[i].checked = false;
			  	document.mainForm.speaker18Cr[i].checked = false;
			  	document.mainForm.speaker19Cr[i].checked = false;
			  	document.mainForm.speaker20Cr[i].checked = false;
		  	}
			document.mainForm.participateAgain[0].checked = false;
			document.mainForm.participateAgain[1].checked = false;
		  }
		  if (track == 2) {
		  	document.getElementById("row101").style.display = 'none';
		  	document.getElementById("row102").style.display = 'none';
		  	document.getElementById("row103").style.display = 'none';
		  	document.getElementById("row104").style.display = 'none';
		  	document.getElementById("row105").style.display = 'none';
		  	document.getElementById("row106").style.display = 'none';
		  	document.getElementById("row107").style.display = 'none';
		  	document.getElementById("row108").style.display = 'none';
		  	document.getElementById("row109").style.display = 'none';
		  	document.getElementById("row110").style.display = 'none';
		  	document.getElementById("row111").style.display = 'none';
		  	document.getElementById("row112").style.display = 'none';
		  	document.getElementById("row113").style.display = 'none';
		  	document.getElementById("row114").style.display = 'none';
		  	document.getElementById("row115").style.display = 'none';
		  	document.getElementById("row201").style.display = '';
		  	document.getElementById("row202").style.display = '';
		  	document.getElementById("row203").style.display = '';
		  	document.getElementById("row204").style.display = '';
		  	document.getElementById("row205").style.display = '';
		  	document.getElementById("row206").style.display = '';
		  	document.getElementById("row207").style.display = '';
		  	document.getElementById("row208").style.display = '';
		  	document.getElementById("row209").style.display = '';
		  	document.getElementById("row210").style.display = '';
		  	document.getElementById("row211").style.display = '';
		  	document.getElementById("row212").style.display = '';
		  	document.getElementById("row301").style.display = 'none';
		  	document.getElementById("row302").style.display = 'none';
		  	document.getElementById("row303").style.display = 'none';
		  	document.getElementById("row304").style.display = 'none';
		  	
		  	for (i = 0; i < 5; i++) {
			  	document.mainForm.speaker11Pq[i].checked = false;
			  	document.mainForm.speaker12Pq[i].checked = false;
			  	document.mainForm.speaker13Pq[i].checked = false;
			  	document.mainForm.speaker14Pq[i].checked = false;
			  	document.mainForm.speaker15Pq[i].checked = false;		  	
			  	document.mainForm.speaker20Pq[i].checked = false;
			  	document.mainForm.speaker11Cr[i].checked = false;
			  	document.mainForm.speaker12Cr[i].checked = false;
			  	document.mainForm.speaker13Cr[i].checked = false;
			  	document.mainForm.speaker14Cr[i].checked = false;
			  	document.mainForm.speaker15Cr[i].checked = false;
			  	document.mainForm.speaker20Cr[i].checked = false;
		  	}
			document.mainForm.participateAgain[0].checked = false;
			document.mainForm.participateAgain[1].checked = false;
		  }
		  if (track == 3) {
		  	document.getElementById("row101").style.display = 'none';
		  	document.getElementById("row102").style.display = 'none';
		  	document.getElementById("row103").style.display = 'none';
		  	document.getElementById("row104").style.display = 'none';
		  	document.getElementById("row105").style.display = 'none';
		  	document.getElementById("row106").style.display = 'none';
		  	document.getElementById("row107").style.display = 'none';
		  	document.getElementById("row108").style.display = 'none';
		  	document.getElementById("row109").style.display = 'none';
		  	document.getElementById("row110").style.display = 'none';
		  	document.getElementById("row111").style.display = 'none';
		  	document.getElementById("row112").style.display = 'none';
		  	document.getElementById("row113").style.display = 'none';
		  	document.getElementById("row114").style.display = 'none';
		  	document.getElementById("row115").style.display = 'none';
		  	document.getElementById("row201").style.display = 'none';
		  	document.getElementById("row202").style.display = 'none';
		  	document.getElementById("row203").style.display = 'none';
		  	document.getElementById("row204").style.display = 'none';
		  	document.getElementById("row205").style.display = 'none';
		  	document.getElementById("row206").style.display = 'none';
		  	document.getElementById("row207").style.display = 'none';
		  	document.getElementById("row208").style.display = 'none';
		  	document.getElementById("row209").style.display = 'none';
		  	document.getElementById("row210").style.display = 'none';
		  	document.getElementById("row211").style.display = 'none';
		  	document.getElementById("row212").style.display = 'none';
		  	document.getElementById("row301").style.display = '';
		  	document.getElementById("row302").style.display = '';
		  	document.getElementById("row303").style.display = '';
		  	document.getElementById("row304").style.display = '';
		  	
		  	for (i = 0; i < 5; i++) {
			  	document.mainForm.speaker11Pq[i].checked = false;
			  	document.mainForm.speaker12Pq[i].checked = false;
			  	document.mainForm.speaker13Pq[i].checked = false;
			  	document.mainForm.speaker14Pq[i].checked = false;
		  		document.mainForm.speaker15Pq[i].checked = false;
			  	document.mainForm.speaker16Pq[i].checked = false;
			  	document.mainForm.speaker17Pq[i].checked = false;
			  	document.mainForm.speaker18Pq[i].checked = false;
			  	document.mainForm.speaker19Pq[i].checked = false;
			  	
			  	document.mainForm.speaker11Cr[i].checked = false;
			  	document.mainForm.speaker12Cr[i].checked = false;
			  	document.mainForm.speaker13Cr[i].checked = false;
			  	document.mainForm.speaker14Cr[i].checked = false;			  	
			  	document.mainForm.speaker15Cr[i].checked = false;
			  	document.mainForm.speaker16Cr[i].checked = false;
			  	document.mainForm.speaker17Cr[i].checked = false;
			  	document.mainForm.speaker18Cr[i].checked = false;
			  	document.mainForm.speaker19Cr[i].checked = false;
		  	}
		  }
		  if (track == 4) {
		  	document.getElementById("row101").style.display = 'none';
		  	document.getElementById("row102").style.display = 'none';
		  	document.getElementById("row103").style.display = 'none';
		  	document.getElementById("row104").style.display = 'none';
		  	document.getElementById("row105").style.display = 'none';
		  	document.getElementById("row106").style.display = 'none';
		  	document.getElementById("row107").style.display = 'none';
		  	document.getElementById("row108").style.display = 'none';
		  	document.getElementById("row109").style.display = 'none';
		  	document.getElementById("row110").style.display = 'none';
		  	document.getElementById("row111").style.display = 'none';
		  	document.getElementById("row112").style.display = 'none';
		  	document.getElementById("row113").style.display = 'none';
		  	document.getElementById("row114").style.display = 'none';
		  	document.getElementById("row115").style.display = 'none';
		  	document.getElementById("row201").style.display = 'none';
		  	document.getElementById("row202").style.display = 'none';
		  	document.getElementById("row203").style.display = 'none';
		  	document.getElementById("row204").style.display = 'none';
		  	document.getElementById("row205").style.display = 'none';
		  	document.getElementById("row206").style.display = 'none';
		  	document.getElementById("row207").style.display = 'none';
		  	document.getElementById("row208").style.display = 'none';
		  	document.getElementById("row209").style.display = 'none';
		  	document.getElementById("row210").style.display = 'none';
		  	document.getElementById("row211").style.display = 'none';
		  	document.getElementById("row212").style.display = 'none';
		  	document.getElementById("row301").style.display = 'none';
		  	document.getElementById("row302").style.display = 'none';
		  	document.getElementById("row303").style.display = 'none';
		  	document.getElementById("row304").style.display = 'none';
		  	
		  	for (i = 0; i < 5; i++) {
			  	document.mainForm.speaker11Pq[i].checked = false;
			  	document.mainForm.speaker12Pq[i].checked = false;
			  	document.mainForm.speaker13Pq[i].checked = false;
			  	document.mainForm.speaker14Pq[i].checked = false;
		  		document.mainForm.speaker15Pq[i].checked = false;
			  	document.mainForm.speaker16Pq[i].checked = false;
			  	document.mainForm.speaker17Pq[i].checked = false;
			  	document.mainForm.speaker18Pq[i].checked = false;
			  	document.mainForm.speaker19Pq[i].checked = false;
			  	document.mainForm.speaker20Pq[i].checked = false;
			  	
			  	document.mainForm.speaker11Cr[i].checked = false;
			  	document.mainForm.speaker12Cr[i].checked = false;
			  	document.mainForm.speaker13Cr[i].checked = false;
			  	document.mainForm.speaker14Cr[i].checked = false;			  	
			  	document.mainForm.speaker15Cr[i].checked = false;
			  	document.mainForm.speaker16Cr[i].checked = false;
			  	document.mainForm.speaker17Cr[i].checked = false;
			  	document.mainForm.speaker18Cr[i].checked = false;
			  	document.mainForm.speaker19Cr[i].checked = false;
			  	document.mainForm.speaker20Cr[i].checked = false;
		  	}
			document.mainForm.participateAgain[0].checked = false;
			document.mainForm.participateAgain[1].checked = false;
		  }
		}
		</script>        
        <tr><td colspan="2">
          <b>I attended the following track:</b><br/>
          <s:radio list="#{'1':'Sales Track','2':'Technical Track','3':'Business Track','4':'I Did Not Attend'}" theme="simple" cssClass="form_obj" name="track" onclick="displaySelectedTrack(this.value);"/>
        </td></tr>           

        <tr id="row101"><td colspan="2"><b>Jason Needham (F5): Sales Track - Selling and Winning Against the Competition</b></td></tr>      
        <tr id="row102"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker11Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker11Pq</s:param></s:fielderror></td></tr>   
        <tr id="row103"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker11Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker11Cr</s:param></s:fielderror></td></tr>   
        <tr id="row104"><td colspan="2"><b>Calvin Rowland (F5): Sales Track  - Application Ready Networks Sales Essentials</b></td></tr>      
        <tr id="row105"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker12Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker12Pq</s:param></s:fielderror></td></tr>   
        <tr id="row106"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker12Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker12Cr</s:param></s:fielderror></td></tr>   
        <tr id="row107"><td colspan="2"><b>Sean Wong (F5): Sales Track - Intelligent File Virtualization</b></td></tr>      
        <tr id="row108"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker13Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker13Pq</s:param></s:fielderror></td></tr>   
        <tr id="row109"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker13Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker13Cr</s:param></s:fielderror></td></tr>   
        <tr id="row110"><td colspan="2"><b>Vladimir Yordanov (F5): Sales Track - Industry Solution Case Studies</b></td></tr>      
        <tr id="row111"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker14Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker14Pq</s:param></s:fielderror></td></tr>   
        <tr id="row112"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker14Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker14Cr</s:param></s:fielderror></td></tr>   
        <tr id="row113"><td colspan="2"><b>Martin Wooding (F5): Sales Track - Collaborating to Deliver Excellence</b></td></tr>      
        <tr id="row114"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker15Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker15Pq</s:param></s:fielderror></td></tr>   
        <tr id="row115"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker15Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker15Cr</s:param></s:fielderror></td></tr>   
        <tr id="row201"><td colspan="2"><b>Sean Wong (F5): Technical Track -  Intelligent File Virtualization </b></td></tr>      
        <tr id="row202"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker16Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker16Pq</s:param></s:fielderror></td></tr>   
        <tr id="row203"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker16Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker16Cr</s:param></s:fielderror></td></tr>   
        <tr id="row204"><td colspan="2"><b>Jason Needham (F5): Technical Track - Technical Solution Case Studies - A Global Perspective</b></td></tr>      
        <tr id="row205"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker17Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker17Pq</s:param></s:fielderror></td></tr>   
        <tr id="row206"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker17Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker17Cr</s:param></s:fielderror></td></tr>   
        <tr id="row207"><td colspan="2"><b>Colin Walker (F5): Technical Track - Leveraging DevCentral and iRules</b></td></tr>      
        <tr id="row208"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker18Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker18Pq</s:param></s:fielderror></td></tr>   
        <tr id="row209"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker18Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker18Cr</s:param></s:fielderror></td></tr>   
        <tr id="row210"><td colspan="2"><b>Jason Needham (F5): Technical Track - Selling and winning against the competition</b></td></tr>      
        <tr id="row211"><td>Presenter Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker19Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker19Pq</s:param></s:fielderror></td></tr>   
        <tr id="row212"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker19Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker19Cr</s:param></s:fielderror></td></tr>   
        
        <tr id="row301"><td colspan="2"><b>Business Track - 1st APAC Partner Advisory Council</b></td></tr>      
        <tr id="row302"><td>Agenda/Format</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker20Pq" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker20Pq</s:param></s:fielderror></td></tr>   
        <tr id="row303"><td>Content Relevance</td><td><s:radio theme="simple" cssClass="form_obj" name="speaker20Cr" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>speaker20Cr</s:param></s:fielderror></td></tr>   
        <tr id="row304"><td>Would you want to participate again?</td><td><s:radio theme="simple" cssClass="form_obj" name="participateAgain" list="#{'true':'Yes','false':'No'}"/><s:fielderror theme="simple"><s:param>participateAgain</s:param></s:fielderror></td></tr>   

        <tr><td colspan="2">&nbsp;</td></tr>   
        <tr><td colspan="2">
          Please share any other comments about the morning session or the afternoon tracks on Jan 29 here:<br/>
          <s:textarea theme="simple" name="commentsMorning" rows="5" cols="60" cssClass="form_obj"/>
        </td></tr> 
      </table></td></tr>
      
	  <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
        <tr><td colspan="2" class="headerRow">Evaluation of Hi-5 Pumped Up Social Activities</td></tr>    
        <tr><td colspan="2">
          <b>Welcome Cocktail - evening of Jan 28th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking01" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>networking01</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>Hi-5 Pump it Up Awards Party on Jan 29th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking02" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>networking02</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>Third F5 Hi-5 Golf Tournament at Glenmarie Coutnry Club on Jan 30th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking03" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'I did not attend this event'}"/><s:fielderror theme="simple"><s:param>networking03</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>Go-Kart at Sepang International Circuit on Jan 30th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking04" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'I did not attend this event'}"/><s:fielderror theme="simple"><s:param>networking04</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>Horse Back Riding at Taman Equine Club on Jan 30th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking05" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'I did not attend this event'}"/><s:fielderror theme="simple"><s:param>networking05</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>Spa Indrani at StarHill Gallery on Jan 30th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking06" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'I did not attend this event'}"/><s:fielderror theme="simple"><s:param>networking06</s:param></s:fielderror>
        </td></tr>   
   		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2">
          <b>City Tour of Kuala Lumpur on Jan 30th </b><br/>
          <s:radio theme="simple" cssClass="form_obj" name="networking07" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'I did not attend this event'}"/><s:fielderror theme="simple"><s:param>networking07</s:param></s:fielderror>
        </td></tr>  
        <tr><td colspan="2">&nbsp;</td></tr>   
        <tr><td colspan="2">
          Please share any other comments about the Hi-5 social events here:<br/>
          <s:textarea theme="simple" name="commentsNetworking" rows="5" cols="60" cssClass="form_obj"/>
        </td></tr>  
      </table></td></tr>
      
	  <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
        <tr><td colspan="2" class="headerRow">Hotel and Event Services</td></tr>    
		<tr><td colspan="2"><b>Ground transportation</b></td></tr>      
        <tr><td width="25%">Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="services01a" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services01a</s:param></s:fielderror></td></tr>   
        <tr><td>Ease of use</td><td><s:radio theme="simple" cssClass="form_obj" name="services01b" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services01b</s:param></s:fielderror></td></tr>   
		<tr><td colspan="2"><b>Your hotel room</b></td></tr>      
        <tr><td>Comfort</td><td><s:radio theme="simple" cssClass="form_obj" name="services02a" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services02a</s:param></s:fielderror></td></tr>   
        <tr><td>Cleanliness</td><td><s:radio theme="simple" cssClass="form_obj" name="services02b" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services02b</s:param></s:fielderror></td></tr>   
		<tr><td colspan="2"><b>Event food</b></td></tr>      
        <tr><td>Quality</td><td><s:radio theme="simple" cssClass="form_obj" name="services03a" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services03a</s:param></s:fielderror></td></tr>   
        <tr><td>Tastiness</td><td><s:radio theme="simple" cssClass="form_obj" name="services03b" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services03b</s:param></s:fielderror></td></tr>   
		<tr><td colspan="2"><b>Hotel service overall</b></td></tr>      
        <tr><td>Politeness</td><td><s:radio theme="simple" cssClass="form_obj" name="services04a" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services04a</s:param></s:fielderror></td></tr>   
        <tr><td>Usefulness</td><td><s:radio theme="simple" cssClass="form_obj" name="services04b" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services04b</s:param></s:fielderror></td></tr>   
		<tr><td colspan="2"><b>Hi-5 2008 Registration Desk/Secretariat</b></td></tr>      
        <tr><td>Usefulness</td><td><s:radio theme="simple" cssClass="form_obj" name="services05a" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services05a</s:param></s:fielderror></td></tr>   
        <tr><td>Hours of operation</td><td><s:radio theme="simple" cssClass="form_obj" name="services05b" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services05b</s:param></s:fielderror></td></tr>   
        <tr><td>Staff</td><td><s:radio theme="simple" cssClass="form_obj" name="services05c" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>services05c</s:param></s:fielderror></td></tr>   
                
        <tr><td colspan="2">&nbsp;</td></tr>   
        <tr><td colspan="2">
          Please share any other comments about hotel or F5 service here:<br/>
          <s:textarea theme="simple" name="commentsServices" rows="5" cols="60" cssClass="form_obj"/>
        </td></tr> 
      </table></td></tr>         
      
	  <tr><td colspan="2"><table class="subTable" align="center" cellpadding="5" cellspacing="0">
        <tr><td colspan="2" class="headerRow">General Event Evaluation</td></tr>    
        <tr><td width="25%">Usefulness of the event for my business </td><td><s:radio theme="simple" cssClass="form_obj" name="general01" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general01</s:param></s:fielderror></td></tr>   
        <tr><td>Level of enjoyment I got from Hi-5 2008<br/><span style="color: #CA003A">(1=lo/5=hi)</span></td><td><s:radio theme="simple" cssClass="form_obj" name="general02" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general02</s:param></s:fielderror></td></tr>   
        <tr><td>Length of event<br/><span style="color: #CA003A">(1=too short/5=too long)</span></td><td><s:radio theme="simple" cssClass="form_obj" name="general03" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general03</s:param></s:fielderror></td></tr>           
		<tr><td colspan="2">&nbsp;</td>
        <tr><td colspan="2"><b>Overall organization of the Hi-5 2008 event:</b></td></tr>    
        <tr><td>Logistics</td><td><s:radio theme="simple" cssClass="form_obj" name="general04" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general04</s:param></s:fielderror></td></tr>           
        <tr><td>Look and feel</td><td><s:radio theme="simple" cssClass="form_obj" name="general05" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general05</s:param></s:fielderror></td></tr>           
        <tr><td>Pre-event communications</td><td><s:radio theme="simple" cssClass="form_obj" name="general06" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general06</s:param></s:fielderror></td></tr>           
        <tr><td>On-site communications</td><td><s:radio theme="simple" cssClass="form_obj" name="general07" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general07</s:param></s:fielderror></td></tr>           
        <tr><td>Event website</td><td><s:radio theme="simple" cssClass="form_obj" name="general08" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}"/><s:fielderror theme="simple"><s:param>general08</s:param></s:fielderror></td></tr>           

        <tr><td colspan="2">&nbsp;</td></tr>   
        <tr><td colspan="2">
          Please share any other comments that you may have about the overall event here:<br/>
          <s:textarea theme="simple" name="commentsGeneral" rows="5" cols="60" cssClass="form_obj"/>
        </td></tr> 
      </table></td></tr>         
      
	  <tr>
		<td colspan="2" align="center">
		  <s:submit value="Submit" cssClass="form_button" theme="simple"/>
		</td>
      </tr>
  </s:form>

<c:import url="/footer.jsp"><c:param name="contentOnly" value="${param.contentOnly}"/></c:import>