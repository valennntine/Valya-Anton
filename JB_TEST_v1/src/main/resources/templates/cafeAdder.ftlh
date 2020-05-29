<#import "parts/common.ftlh" as c>
<@c.page>

    <h2 align="center" >Add Cafe</h2>

    <form method="post" action = "/cafe/adder/add" enctype="multipart/form-data">
         <input type="hidden" name="_csrf" value="${_csrf.token}" />
         <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">CafesName</span>
            </div>
            <input name = "name" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Address</span>
            </div>
            <input name = "text" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
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
            <input name = "phone" type="tel" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-sm">Url of google map<a href="https://www.google.com/maps"> Link </a></span>
            </div>
            <input name = "map" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"/>
        </div>
        <div class="input-group input-group-sm mb-3" >
            <div class="input-group-prepend">
                <input type="file" name="file"/>
            </div>
        </div>
        <div style="margin: 10px">
            <button type="submit" class="btn btn-secondary" >Add</button>
        </div>

    </form>
</@c.page>