<#import "parts/common.ftlh" as c>
<@c.page>


            <form action="/cafe/${cafe.getName()}/page" method="get">

                <div class="container" style="margin-top: 5%">
                    <div class="row">
                        <div class="col-sm">
                            <#if cafe.getFilename()??>
                                <img class="img-thumbnail" src="/img/${cafe.getFilename()}" alt="Image"/>
                            </#if>
                        </div>
                        <div class="col-sm">
                            <h2 align="center">${cafe.getName()}</h2>
                            <div class="container">
                                <div class="row" style="margin-top: 5%">
                                    <i>${cafe.getDescription()}</i>
                                </div>
                                <div class="row" style="margin-top: 5%">
                                    <ul>
                                     <li>${cafe.getText()}</li>
                                        <li>${cafe.getPhoneNumber()}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <#if cafe.getGoogleMap()??>
                <div class="container" align="center" style=" margin-top: 5%; margin-bottom: 5%">
                    <hr align="center" width="500" size="2" color="000000" />
                    <iframe align="center" src="${cafe.getGoogleMap()}" width="500" height="275" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                    <hr align="center" width="500" size="2" color="000000" />
                </div>
                </#if>

            </form>

</@c.page>