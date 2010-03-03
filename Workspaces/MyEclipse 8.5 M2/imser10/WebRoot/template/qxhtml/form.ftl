<#include "/${parameters.templateDir}/${parameters.theme}/form-validate.ftl" />
<#include "/${parameters.templateDir}/simple/form.ftl" />
<table class="${parameters.cssClass?default('wwFormTable')?html}"<#rt/>
<#if parameters.cssStyle?exists> style="${parameters.cssStyle?html}"<#rt/>
</#if>
>
