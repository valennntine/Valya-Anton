<#import "parts/common.ftlh" as c>
<@c.page>
    Editor
    <form action="/user" method="post">
        <label>
            <input type="text" name = "username" value="${user.getUsername()}">
        </label>
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <label>
            <input type="hidden" value="${user.getId()}" name ="userId">
        </label>
        <label>
            <input type="hidden" name="_csrf" value="${_csrf.token}" >
        </label><!-- Что бы пост форму принимал сервер-->
        <button type="submit">Save</button>
    </form>
</@c.page>