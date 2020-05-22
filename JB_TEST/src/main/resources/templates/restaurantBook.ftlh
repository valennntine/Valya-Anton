<#import "parts/common.ftlh" as c>
<@c.page>
    <h2 align="center" >Add Book</h2>

    <form method="post" action = "/restaurant/${restaurant.getName()}/addBook" enctype="multipart/form-data">
        <input type="hidden" name="_csrf" value="${_csrf.token}" >
        <input type="hidden" name="id" value="${restaurant.getId()}">
        <input type="hidden" name="name" value="${restaurant.getName()}">
        <h3 align="center" >${restaurant.getName()}</h3>
        <h4 style="color:red">${message!}</h4>

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Date and Time</span>
            </div>
            <input name = "dateAndTime" type="datetime-local" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Code Word</span>
            </div>
            <input name = "codeWord" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Count Of People</span>
            </div>
            <input name = "countOfPeoples" type="number" value="1" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm">
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Phone number</span>
            </div>
            <input name = "phoneNumber" type="tel" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" >
        </div>
        <div style="margin: 10px">
            <button type="submit" class="btn btn-secondary" >Add</button>
        </div>

    </form>
</@c.page>