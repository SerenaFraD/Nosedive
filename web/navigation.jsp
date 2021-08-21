<html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="css/navigation.css">
</head>

<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <!-- Navigation Bar-->
   <!--
    <nav>
        <ul class="navBar">
            <li>
                <a href="index.jsp"><img class="navBar" src="img/logoSmall.png"></a>
            </li>
            <li>
                <a href="index.jsp">
                    <h3>Home</h3>
                </a>
            </li>
        </ul>
        <ul class="navBar">
            <li><img class="navBar" src="img/starIcon.svg"></li>
            <li>
                <h3>#</h3>
            </li>
            <li><img class="navBar" src="img/userIcon.png"></li>
            <li><a href="#">
                    <h3>Profilo</h3>
                </a></li>
        </ul>

    </nav> -->
<nav class="navbar navbar-expand-lg navbar-light navbar-custom">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active fs-5" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-5" href="#">Link</a>
                </li>
            </ul>
            <form class="d-flex mt-2" action="SearchServlet" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="chiave">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
</body>

</html>