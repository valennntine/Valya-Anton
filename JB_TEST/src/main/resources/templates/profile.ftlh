<#import "parts/common.ftlh" as c>
<@c.page>
    <h5 align="center">${name}</h5>
    <div style="margin-left: 20% ; margin-right: 20%">
        <form method="post" >
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="text" name="password" class="form-control" value="${password}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Email</label>
                <input type="email" name="email" class="form-control" placeholder="some@some.com"  value="${email!''}">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>

    <table class="table" style="margin-top: 5%">
        <caption>My Books</caption>
        <thead>
        <tr>
            <th scope="col">Restaurant name</th>
            <th scope="col">date</th>
            <th scope="col">code Word</th>
        </tr>
        </thead>
        <tbody>
        <#list books as book>
        <tr>
            <th scope="col" >${book.getName()}</th>

            <th scope="col">${book.getTime()}</th>
            <th scope="col">${book.getCodeWord()}</th>
            <th scope="col">
                <form action="/user/delete" method="get">
                    <input type="hidden" value="${book.getId()}" name ="bookId">
                    <button class="btn btn-outline-success my-2 my-sm-0" >сancel</button>
                </form>
            </th>
        <tr>
            <#else >
                <b>No Books</b>
            </#list>

        </tbody>
    </table>
</@c.page>