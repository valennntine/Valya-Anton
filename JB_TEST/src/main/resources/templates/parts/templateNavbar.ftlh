<#import "login.ftlh" as l>
<#import  "security.ftlh" as s>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">JB</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/cafe">Cafes</a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="/restaurant">Restaurants</a>
            </li>
            <#if s.user??>
            <li class="nav-item active">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            </#if>
            <#if s.isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/user">Users</a>
                </li>
            </#if>
        </ul>

    </div>
    <#if s.user??>
        <@l.logout></@l.logout>
    </#if>
</nav>