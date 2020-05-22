<#import "parts/common.ftlh" as c>
<@c.page>
    ${message?ifExists}
<h1 align="center">Login page</h1>
    <div style="margin-left: 20% ; margin-right: 20%">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="text" name="username" class="form-control">
                <small id="emailHelp" class="form-text text-muted">We'll never share your username and password with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="text" name="password" class="form-control" >
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
<a href = "/registration" style="margin-left: 20% ; margin-right: 20%">Add new User</a>
</@c.page>

