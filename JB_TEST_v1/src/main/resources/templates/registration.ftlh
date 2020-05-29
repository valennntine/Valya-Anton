<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<h1 align="center">Add new user</h1>
    ${message?ifExists}
    <div style="margin-left: 20% ; margin-right: 20%">
        <form action="/registration" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="text" name="username" class="form-control"/>
                <small id="emailHelp" class="form-text text-muted">We'll never share your username and password with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="text" name="password" class="form-control" />
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Email</label>
                <input type="email" name="email" class="form-control" placeholder="some@some.com" />
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</@c.page>