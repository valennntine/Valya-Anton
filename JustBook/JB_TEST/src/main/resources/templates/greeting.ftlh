<#import  "parts/security.ftlh" as s>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JustBook</title>
    <link rel="stylesheet" type="text/css" href="./parts/styleIndex.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JustBook</title>
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">JB</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/cafe">Cafes</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/restaurant">Restaurants</a>
            </li>
            <#if s.isAdmin>
                <li class="nav-item active">
                    <a class="nav-link" href="/user">Users</a>
                </li>
            </#if>
            <#if s.user??>
            <li class="nav-item active">
                <a class="nav-link" href="/user/profile">Profile</a>
            </li>
            </#if>
        </ul>

    </div>
    <#if s.user??>
        <div>
            <form action = "/logout" method = "post" class="form-inline my-2 my-lg-0" style="align-content: end">
                <button class="btn btn-outline-success my-2 my-sm-0" type = "submit" value = "Sign Out">Sign Out</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </form>
        </div>
    </#if>
</nav>
<div class="parallax">
        <h1 class="font-weight-bold white">Booking cafes,<br> restaurants and bars</h1>
    </div>
    <div class="container-fluid myblock">
        <h1>About Us</h1>
        <div class="row justify-content-around">
            <div class="col-md-4 text-left" style="padding-top: 5%;">
                <p>
                    You are able to choose the exact place (table/seat) you wish to be seated within the interior of the chosen club/bar/restaurant
                    and reserve it online. When you choose a place this is automatically reflected on the booking system of the business allowing
                    them to easily and conveniently accommodate you at your desired table/seat. In addition,
                    Justbook allows users to explore incoming events and also add exciting offers to the booking.
                    <br>
                    <button type="button" class="btn btn-link"><a href="/cafe">Cafes</a></button>
                    <button type="button" class="btn btn-link"><a href="/restaurant">Restaurants</a></button>
                    <button type="button" class="btn btn-link"><a href="#">Bars</a></button>
                </p>
            </div>
            <div id="carouselExampleIndicators" class="carousel slide col-md-6" data-ride="carousel" style="padding-bottom: 2%">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <h2>Restaurant</h2>
                        <img class="d-block w-100" src="/img/${cafe2}" alt="Первый слайд">
                    </div>
                    <div class="carousel-item">
                        <h2>Cafe</h2>
                        <img class="d-block w-100" src="/img/${cafe1}" alt="Второй слайд">
                    </div>
                    <div class="carousel-item">
                        <h2>Bar</h2>
                        <img class="d-block w-100" src="/img/${cafe3}" alt="Третий слайд">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <div class="container-fluid myblock2">
        <h1 class="white2">What are the advantages of our service?</h1>
        <div class="row justify-content-center" style="padding-top: 3%;padding-bottom: 2%; opacity: 0.95;">
            <div class="col-md-3">
                <div class="card bg-light mb-3">
                    <div class="card-header">
                        <h2 >We're fast</h2>
                    </div>
                    <div class="card-body">
                        <h4>Up to 2 hours from your call</h4>
                        <p class="card-text">You are able to choose the exact place (table/seat) you wish to be seated within the interior of the chosen club/bar/restaurant
                            and reserve it online</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card bg-light mb-3">
                    <div class="card-header">
                        <h2>We're free</h2>
                    </div>
                    <div class="card-body">
                        <h4>All books for our users are free</h4>
                        <p class="card-text">You can find restaurant in our big catalog and create book.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card bg-light mb-3">
                    <div class="card-header">
                        <h2>Some Text</h2>
                    </div>
                    <div class="card-body">
                        <h4 style="padding-bottom:0px;">Some Text</h4>
                        <p class="card-text">Some Text</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="page-footer font-small stylish-color-dark pt-4">
        <div class="container mx-auto text-center">
            <div class="container text-center text-md-left">
                <div class="row">
                    <div class="col-md-4 mx-auto">
                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Just Book</h5>
                        <p>some text some text some text some text some text some text some text some text some text</p>
                    </div>
                    <!-- Grid column -->
                    <hr class="clearfix w-100 d-md-none">
                    <!-- Grid column -->
                    <div class="col-md-2 mx-auto">
                        <!-- Links -->
                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Links</h5>
                        <ul class="list-unstyled">
                            <li>
                                <a href="#">Contacts page</a>
                            </li>
                            <li>
                                <a href="/restaurant">Book Restaurants</a>
                            </li>
                            <li>
                                <a href="/cafe">Cafes</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Grid column -->
                    <hr class="clearfix w-100 d-md-none">
                    <!-- Grid column -->
                    <hr class="clearfix w-100 d-md-none">
                    <!-- Grid column -->
                    <div class="col-md-2 mx-auto">
                        <!-- Links -->
                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Partners</h5>
                        <ul class="list-unstyled">
                            <li>
                                <a href="#" target="_blank">Relax</a>
                            </li>
                            <li>
                                <a href="#" target="_blank">Brioche</a>
                            </li>
                            <li>
                                <a href="#" target="_blank">O.D.I</a>
                            </li>
                            <li>
                                <a href="#" target="_blank">SomeText</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Grid column -->
                </div>
                <!-- Grid row -->
            </div>
            <!-- Footer Links -->
        </div>
    </footer>

    <script>
    // When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function() { scrollFunction() };

    function scrollFunction() {
        if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
            document.getElementById("myBtn").style.display = "block";
        } else {
            document.getElementById("myBtn").style.display = "none";
        }
    }

    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }
    </script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<style>
    .container-fluid {
        padding: 0;
        margin: 0;
    }
    .parallax {
        background-image: url("/img/${cafe3}");
        height: 100%;
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        padding-bottom:9%;
    }

    h2 {
        font-family: 'Montserrat', sans-serif;
        font-weight: bold;
    }

    h3 {
        font-family: 'Montserrat', sans-serif;
        font-weight: normal;
    }

    h4 {
        font-family: 'Montserrat', sans-serif;
        font-weight: lighter;
    }

    h6 {
        font-family: 'Montserrat', sans-serif;
        font-weight: normal;
    }
    p.card-text{
        font-family: 'DM Sans', sans-serif;
    }
    .nav-item {
        padding-top: 1px;
        padding-right: 2%;
        padding-left: 0%;
        padding-bottom: 0px;

    }



    .myblock {
        padding-top: 1%;
        padding-bottom: 1%;
        background-color: #ececec;
        text-align: center;

    }
    .myblock2 {
        padding-top: 1%;
        text-align: center;
        background-image: url("/img/${cafe1}");
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
    }

    .white {
        background-color: #343a40;
        border-radius: 10px;
        display: inline-block;
        opacity: 0.8;
        font-weight: bolder;
        font-size: 50px;
        color: #FFFFFF;
        margin-top:23%;
        margin-left: 15%;
        padding: 1%;

    }

    .white2 {
        background-color: #FFFFFF;
        border-radius: 10px;
        display: inline-block;
        opacity: 0.8;
        font-weight: bolder;
        font-size: 50px;
        color: #343a40;
    }


    h1 {
        font-family: 'Montserrat', sans-serif;
        font-weight: normal;
        align-self: center;
        font-weight: bolder;
        font-size: 50px;
        color: #343a40;
    }

    .sprite {
        background-image: url("/img/${cafe2}");
        background-repeat: no-repeat;
        height: 58px;
        width: 56.5px;
        display: inline-block;
        margin-right: 10px;
    }

    a:hover {
        background-position-y: bottom;
    }


    footer{
        padding-bottom: 2%;
    }
    .d-block{
        max-height: 30%;
    }
    #myBtn {
        display: none;
        position: fixed;
        bottom: 20px;
        right: 50px;
        z-index: 99;
        opacity: 0.5;
        transition: all 0.3s ease-out;
    }

    #myBtn:hover {
        opacity: 1;
    }
    .card{
        max-width: 30rem; min-height: 15rem;
    }
    .carousel-caption{
        padding-bottom: 36%;
        padding-left: 45%;
    }
    .carousel-text{
        color: white;
        display: inline;

    }
    .carousel-text1{
        color: #000000;
        display: inline;

    }
    .b-review{
        padding-top: 1%;
    }
    .b1-review{
        padding-top: 3%;
        padding-bottom: 3%;
    }
    .bu-pic{
        border-radius: 2px;
        border: 1px solid grey;
        height: 190px;
        max-width: 350px;
    }
    .b-pic{
        border-radius: 2px;
        border: 1px solid grey;
        height: 250px;
        max-width: 500px;
    }
    .b-link{
        color: #000;
        text-decoration: none;
    }
    .b-link:hover{
        color: #000;
        text-decoration: underline;
    }
    .frame{
        border-radius: 5px;
        border: 2px solid grey;
    }
    .contact{
        font-size: 18px;
    }
</style>