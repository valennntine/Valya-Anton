<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <link href="/templates/parts/style.css" rel="stylesheet">
    <!---->
    <div>Список Ресторанов</div>
    <form method="get" action="/restaurant/find">
        <div class="md-form active-cyan-2 mb-3">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search" name="name">

        </div>

    </form>

    <table class="table">
        <caption>Restaurant catalog</caption>
        <thead>
        <tr>
            <th scope="col">image</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Count of free Places</th>
            <#if userRole =="ADMIN">
                <th scope="col">Editor</th>
                <th scope="col">Delete</th>
                <th><a href="/restaurant/adder"><button type="button" class="btn btn-outline-info">+</button></a></th>
            </#if>

        </tr>
        </thead>
        <tbody>
        <#list restaurants as restaurant>
        <tr>
            <th scope="col" >
                <#if restaurant.getFilename()??>
                    <img width="200" height="200" class="img-thumbnail" src="/img/${restaurant.getFilename()}" alt="Image"/>
                </#if>
            </th>

            <th scope="col"><a href="/restaurant/${restaurant.getName()}/page">${restaurant.getName()}</a></th>
            <th scope="col">${restaurant.getAddress()}</th>
            <th scope="col">${restaurant.getCountOfPlaces()}</th>
            <#if userRole =="USER">
                <th scope="col"><a href="/restaurant/${restaurant.getName()}/Book"><button class="btn btn-outline-success my-2 my-sm-0" >BOOK</button></a></th>
            </#if>
            <#if userRole =="ADMIN">
                <th scope="col"><a href = "/restaurant/${restaurant.getId()}">edit</a></th>
                <th scope="col">
                    <form action="/restaurant/del" method="get">
                        <input type="hidden" value="${restaurant.getId()}" name ="restaurantId">
                        <button class="btn btn-outline-success my-2 my-sm-0" >delete</button>
                    </form>
                </th>
            </#if>
        <tr>
            <#else >
                <b>No restaurants</b>
            </#list>

        </tbody>
    </table>

</@c.page>