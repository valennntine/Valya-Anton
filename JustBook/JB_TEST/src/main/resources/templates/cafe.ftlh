<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
    <#import "parts/footer.ftlh" as f>
<@c.page>
        <link href="/templates/parts/style.css" rel="stylesheet">
        <!---->
        <div>Список Кафе</div>

         <form method="get" action="/cafe/find">
             <div class="md-form active-cyan-2 mb-3">
                 <input class="form-control" type="text" placeholder="Search" aria-label="Search" name="name">

             </div>

         </form>
        <table class="table">
        <caption>Cafe catalog</caption>
            <thead>
            <tr>
                <th scope="col">image</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <#if userRole =="ADMIN">
                    <th scope="col">Editor</th>
                    <th scope="col">Delete</th>
                    <th><a href="/cafe/adder"><button type="button" class="btn btn-outline-info">+</button></a></th>
                </#if>

            </tr>
            </thead>
            <tbody>
            <#list cafes as cafe>
                <tr>
                    <th scope="col" >
                        <#if cafe.getFilename()??>
                            <img width="200" height="200" class="img-thumbnail" src="/img/${cafe.getFilename()}" alt="Image"/>
                        </#if>
                    </th>

                    <th scope="col"><a href="/cafe/${cafe.getName()}/page">${cafe.getName()}</a></th>
                    <th scope="col">${cafe.getText()}</th>
                    <#if userRole =="ADMIN">
                        <th scope="col"><a href = "/cafe/${cafe.getId()}">edit</a></th>
                        <th scope="col">
                            <form action="/cafe/del" method="get">
                                <input type="hidden" value="${cafe.getId()}" name ="cafeId">
                                <button class="btn btn-outline-success my-2 my-sm-0" >delete</button>
                            </form>
                            </th>
                    </#if>
                <tr>
                <#else >
                <b>No cafes</b>
            </#list>

            </tbody>
        </table>
</@c.page>