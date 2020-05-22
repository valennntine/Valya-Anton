<#import "parts/common.ftlh" as c>
<@c.page>


    <form action="/restaurant/${restaurant.getName()}/page" method="get">

        <div class="container" style="margin-top: 5%">
            <div class="row">
                <div class="col-sm">
                    <#if restaurant.getFilename()??>
                        <img class="img-thumbnail" src="/img/${restaurant.getFilename()}" alt="Image"/>
                    </#if>
                </div>
                <div class="col-sm">
                    <h2 align="center">${restaurant.getName()}</h2>
                    <div class="container">
                        <div class="row" style="margin-top: 5%">
                            <i>${restaurant.getDescription()}</i>
                        </div>
                        <div class="row" style="margin-top: 5%">
                            <ul>
                                <li>${restaurant.getAddress()}</li>
                                <li>${restaurant.getPhoneNumber()}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

</@c.page>