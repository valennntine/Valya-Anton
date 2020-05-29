<#import "parts/common.ftlh" as c>
<@c.page>
    list of Users
        <div class="row">
        <div class="col-sm"><b>id</b></div>
        <div class="col-sm"><b>Name</b></div>
        <div class="col-sm"><b>Roles</b></div>
        <div class="col-sm"><b>Editor</b></div>
        </div>
    <#list .vars['All users: '] as user>
        <div class="row">
            <div class="col-sm">${user.getId()}</div>
            <div class="col-sm">${user.getUsername()}</div>
            <div class="col-sm"> <#list user.roles as role>${role} <#sep>, </#list></div>
            <div class="col-sm"><a href = "/user/${user.getId()}">edit</a></div>
        </div>
    </#list>
</@c.page>