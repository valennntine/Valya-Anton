<#import "parts/common.ftlh" as c>
<@c.page>
    Editor
    <form action="/cafe/update" method="post">
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Name</span>
            </div>
            <input type="text" name = "name" class="form-control" value="${cafe.getName()}"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Address</span>
            </div>
            <input type="text" class="form-control" name = "text" value="${cafe.getText()}"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Description</span>
            </div>
            <input type="text" class="form-control" name = "description" value="${cafe.getDescription()}"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">PhoneNumber</span>
            </div>
            <input type="text" class="form-control" name = "phone" value="${cafe.getPhoneNumber()}"/>
        </div>
        <#if cafe.getGoogleMap()??>
            <div class="input-group input-group-sm mb-3" >
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-sm">GoogleMap</span>
                </div>
                <input type="text" class="form-control" name = "googleMap" value="${cafe.getGoogleMap()}"/>
            </div>
        </#if>
            <input type="hidden" class="form-control" value="${cafe.getId()}" name ="cafeId"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <!-- Что бы пост форму принимал сервер-->
        <button type="submit">Save</button>
    </form>
</@c.page>