<#import "parts/common.ftlh" as c>
<@c.page>

    <h2 align="center" >Add Restaurant</h2>

    <form method="post" action = "/restaurant/adder/add" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}" >
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">RestaurantsName</span>
            </div>
            <input name = "name" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Address</span>
            </div>
            <input name = "address" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Description</span>
            </div>
            <textarea class="form-control" name="description" aria-label="With textarea"></textarea>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Phone number</span>
            </div>
            <input name = "phoneNumber" type="tel" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Count Of Places</span>
            </div>
            <input name = "countOfPlaces" type="number" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <input type="file" name="file">
            </div>
        </div>
        <div style="margin: 10px">
            <button type="submit" class="btn btn-secondary" >Add</button>
        </div>

    </form>
</@c.page>