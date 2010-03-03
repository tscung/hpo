<#include "/${parameters.templateDir}/${parameters.theme}/controlheader-core.ftl" />
<#if parameters.inputcolspan?exists>
	<#assign inputColumnSpan = parameters.inputcolspan />
<#else>
	<#assign inputColumnSpan = 1 />
</#if>
<td colspan="${inputColumnSpan}" class="tdContent">
<#if qTableLayout?exists && qTableLayout.tablecolspan?exists >
	<#assign columnCount = qTableLayout.currentColumnCount + inputColumnSpan />	
	<#-- update the value of the qTableLayout.currentColumnCount bean on the value stack. -->
	${stack.setValue('#qTableLayout.currentColumnCount', columnCount)}
</#if>
