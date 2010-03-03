<#if (actionErrors?exists && actionErrors?size > 0)>
	<#list actionErrors as error>
		<span class="highlightRed">${error}</span><br/>
	</#list>
</#if>
