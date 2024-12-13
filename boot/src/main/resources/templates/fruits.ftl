<#list item as i>
fruits: ${i}
</#list>

<#assign num=[56,89,32,34,67,22,88,99]>
numbers: ${num[2]}<#-- Using index -->

<#assign list = ["apple", "banana", "cherry"]>
Second fruit: ${list[1]}

<#list 1..3 as i>${i}</#list>

<#list 1..13 as o>
<#if o%5==0>
${o}
</#if>
</#list> <#-- if condition -->


<#list item as it>
<#if it?has_content>
"${it}"
</#if>
</#list>




<#-- Ternary operator: ${o%5==0?then(yes,no)} -->