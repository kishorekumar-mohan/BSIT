<#-- <#list company.products as product>
    <#if product.name == "SecurePay">
        ${product.name}
    </#if>
</#list> -->


<#-- <#list products.name as product>
    <#if product == "SecurePay">
        Product Name: ${product.name}
        Category: ${product.category}
        Features: 
        <#list product.features as feature>
        ${feature}
        </#list>
        Pricing:
        <#list product.pricing as priceType, priceValue>
            ${priceType}: ${priceValue}
        </#list>
    </#if>
</#list> -->


<#-- FTL Template for Product Data -->
<#-- <products>
    <#list products as product>
    <product>
        <name>${product.name}</name>
        <category>${product.category}</category>
        <features>
            <#list product.features as feature>
            <feature>${feature}</feature>
            </#list>
        </features>
        <pricing>
            <basic>${product.pricing.basic}</basic>
            <pro>${product.pricing.pro}</pro>
            <enterprise>${product.pricing.enterprise}</enterprise>
        </pricing>
    </product>
    </#list>
</products> -->


<#-- FTL Template for Company Data -->
<#-- <company>
    <name>${company.name}</name>
    <founded>${company.founded}</founded>
    <location>
        <headquarters>
            <city>${company.location.headquarters.city}</city>
            <state>${company.location.headquarters.state}</state>
            <country>${company.location.headquarters.country}</country>
        </headquarters>
        <branches>
            <#list company.location.branches as branch>
            <branch>
                <city>${branch.city}</city>
                <state>${branch.state!}</state>
                <country>${branch.country}</country>
            </branch>
            </#list>
        </branches>
    </location>
    <departments>
        <#list company.departments as department>
        <department>
            <name>${department.name}</name>
            <head>${department.head}</head>
            <teams>
                <#list department.teams as team>
                <team>
                    <name>${team.name}</name>
                    <teamLead>${team.teamLead}</teamLead>
                    <members>
                        <#list team.members as member>
                        <member>
                            <name>${member.name}</name>
                            <role>${member.role}</role>
                            <skills>
                                <#list member.skills as skill>
                                <skill>${skill}</skill>
                                </#list>
                            </skills>
                        </member>
                        </#list>
                    </members>
                </team>
                </#list>
            </teams>
        </department>
        </#list>
    </departments>
    <products>
        <#list company.products as product>
        <product>
            <name>${product.name}</name>
            <category>${product.category}</category>
            <features>
                <#list product.features as feature>
                <feature>${feature}</feature>
                </#list>
            </features>
            <pricing>
                <basic>${product.pricing.basic}</basic>
                <pro>${product.pricing.pro}</pro>
                <enterprise>${product.pricing.enterprise}</enterprise>
            </pricing>
        </product>
        </#list>
    </products>
    <analytics>
        <monthlyUsers>${company.analytics.monthlyUsers}</monthlyUsers>
        <activeUsers>
            <daily>${company.analytics.activeUsers.daily}</daily>
            <weekly>${company.analytics.activeUsers.weekly}</weekly>
            <monthly>${company.analytics.activeUsers.monthly}</monthly>
        </activeUsers>
        <engagement>
            <averageSessionDuration>${company.analytics.engagement.averageSessionDuration}</averageSessionDuration>
            <bounceRate>${company.analytics.engagement.bounceRate}</bounceRate>
        </engagement>
    </analytics>
    <contact>
        <email>${company.contact.email}</email>
        <phone>${company.contact.phone}</phone>
        <socialMedia>
            <twitter>${company.contact.socialMedia.twitter}</twitter>
            <facebook>${company.contact.socialMedia.facebook}</facebook>
            <linkedin>${company.contact.socialMedia.linkedin}</linkedin>
        </socialMedia>
    </contact>
</company> -->
 


 <#-- FTL Template for JSON Output -->
<#-- {
  "company": {
    "name": "${name}",
    "founded": ${founded},
    "location": {
      "headquarters": {
        "city": "${location.headquarters.city}",
        "state": "${location.headquarters.state}",
        "country": "${location.headquarters.country}"
      },
      "branches": [
        <#list location.branches.branch as branch>
        {
          "city": "${branch.City}",
          "state": "${branch.state}",
          "country": "${branch.country}"
        }<#if branch_has_next>,</#if>
        </#list>
      ]
    },
    "departments": [
      <#list departments.name as departmentName>
      {
        "name": "${departmentName}",
        "head": "${departments.head[departmentName_index]}",
        "teams": [
          <#list departments.teams[departmentName_index].name as team>
          {
            "name": "${team}",
            "teamLead": "${departments.teams[departmentName_index].teamLead[team_index]}",
           	"members": [
              <#list departments.teams[departmentName_index].members[team_index].name as member>
              {
                "name": "${member}",
                "role": "${departments.teams[departmentName_index].members[team_index].role[member_index]}" ,
                "skills": [<#list departments.teams[departmentName_index].members[team_index].skills[member_index].skill as skill>"${skill}"<#if skill_has_next>, </#if></#list>]
              }<#if member_has_next>,</#if>
              </#list>
            ]
          }<#if team_has_next>,</#if>
          </#list>
        ]
      }<#if departmentName_has_next>,</#if>
      </#list>
    ]
    ,
    "products": [
      <#list products.name as productName>
      {
        "name": "${productName}",
        "category": "${products.category[productName_index]}",
        "features": [
          <#list products.features[productName_index].features as feature>"${feature}"<#if feature_has_next>,</#if></#list>
        ],
        "pricing": {
          "basic": ${products.pricing[productName_index].basic},
          "pro": ${products.pricing[productName_index].pro},
          "enterprise": ${products.pricing[productName_index].enterprise}
        }
      }<#if productName_has_next>,</#if>
      </#list>
    ],
    "contact": {
      "email": "${contact.email}",
      "phone": "${contact.phone}",
      "socialMedia": {
        "twitter": "${contact.socialMedia.twitter}",
        "facebook": "${contact.socialMedia.facebook}",
        "linkedin": "${contact.socialMedia.linkedin}"
      }
    }
  }
} -->
{
  "company": {
    "name": "${name}",
    "founded": ${founded},
    "location": {
      "headquarters": {
        "city": "${location.headquarters.city}",
        "state": "${location.headquarters.state}",
        "country": "${location.headquarters.country}"
      },
      "branches": [
        <#list location.branches.branch as branch>
        {
          "city": "${branch.city}",
          "state": "${branch.state}",
          "country": "${branch.country}"
        }<#if branch_has_next>,</#if>
        </#list>
      ]
    },
    "departments": [
      <#list departments.department as department>
      {
        "name": "${department.name}",
        "head": "${department.head}",
        "teams": [
          <#list department.teams.team as team>
          {
            "name": "${team.name}",
            "teamLead": "${team.teamLead}",
            "members": [
              <#list team.members.member as member>
              {
                "name": "${member.name}",
                "role": "${member.role}",
                "skills": [<#list member.skills.skill as skill>"${skill}"<#if skill_has_next>,</#if></#list>]
              }<#if member_has_next>,</#if>
              </#list>
            ]
          }<#if team_has_next>,</#if>
          </#list>
        ]
      }<#if department_has_next>,</#if>
      </#list>
    ],
    "products": [
      <#list products.product as product>
      {
        "name": "${product.name}",
        "category": "${product.category}",
        "features": [
          <#list product.features.feature as feature>"${feature}"<#if feature_has_next>,</#if></#list>
        ],
        "pricing": {
          "basic": ${product.pricing.basic},
          "pro": ${product.pricing.pro},
          "enterprise": ${product.pricing.enterprise}
        }
      }<#if product_has_next>,</#if>
      </#list>
    ],
    "analytics": {
      "monthlyUsers": "${analytics.monthlyUsers}",
      "activeUsers": {
        "daily": "${analytics.activeUsers.daily}",
        "weekly": "${analytics.activeUsers.weekly}",
        "monthly": "${analytics.activeUsers.monthly}"
      },
      "engagement": {
        "averageSessionDuration": "${analytics.engagement.averageSessionDuration}",
        "bounceRate": "${analytics.engagement.bounceRate}"
      }
    },
    "contact": {
      "email": "${contact.email}",
      "phone": "${contact.phone}",
      "socialMedia": {
        "twitter": "${contact.socialMedia.twitter}",
        "facebook": "${contact.socialMedia.facebook}",
        "linkedin": "${contact.socialMedia.linkedin}"
      }
    }
  }
}