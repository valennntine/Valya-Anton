<#import "parts/common.ftlh" as c>
<@c.page>
    Editor
    <form action="/restaurant/update" method="post">
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Name</span>
            </div>
            <input type="text" name = "name" value="${restaurant.getName()}">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Address</span>
            </div>
            <input type="text" name = "address" value="${restaurant.getAddress()}">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Description</span>
            </div>
            <input type="text" name = "description" value="${restaurant.getDescription()}">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">PhoneNumber</span>
            </div>
            <input type="text" name = "phoneNumber" value="${restaurant.getPhoneNumber()}">
        </div>
        <input type="hidden" value="${restaurant.getId()}" name ="restaurantId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" >
        <!-- Что бы пост форму принимал сервер-->
        <button type="submit">Save</button>
    </form>
</@c.page>