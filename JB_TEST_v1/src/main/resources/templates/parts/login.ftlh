<#macro login path>

<#--    <form action="${path}" method="post">-->
<#--        <div><label> User Name : <input type="text" name="username"/> </label></div>-->
<#--        <div><label> Password: <input type="password" name="password"/> </label></div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--        <div><input type="submit" value="Sign In"/></div>-->
<#--    </form>-->
    <div style="margin-left: 20% ; margin-right: 20%">
        <form action="${path}" method="post">
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
</#macro>

<#macro  logout>
    <div>
        <form action = "/logout" method = "post" class="form-inline my-2 my-lg-0" style="align-content: end">
            <button class="btn btn-outline-success my-2 my-sm-0" type = "submit" value = "Sign Out">Sign Out</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>
</#macro>