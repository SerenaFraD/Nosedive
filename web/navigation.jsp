<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    UtenteBean utente = (UtenteBean) session.getAttribute("utente");
%>

<html>
<head>
    <link rel="stylesheet" href="css/navigation.css"/>
</head>

<body>
<nav>
    <ul class="navBar">
        <li>
            <a href="index.jsp"><img class="navBar" src="img/logoSmall.png" alt="logo piccolo"></a>
        </li>
        <li>
            <a href="index.jsp">
                <h3>Home</h3>
            </a>
        </li>
    </ul>

    <%if (utente != null) { %>
        <ul class="navBar">
            <li>
                <form action="SearchServlet" method="get">
                    <input type="search" placeholder="Search" aria-label="Search" name="chiave">
                    <button type="submit">Search</button>
                </form>
            </li>
            <li><img class="navBar" src="img/starIcon.svg" alt="stella"></li>
            <li>
                <h3>#</h3>
            </li>
            <li><img class="navBar" src="img/userIcon.png" alt="utente"></li>
            <li><a href="#">
                <h3>Profilo</h3>
            </a></li>
        </ul>


        <% if (utente.isSupervisor()) {%>
        <ul class="navBar">
            <li>
                <a href="${pageContext.request.contextPath}/Admin/adminManagement.jsp">Dashboard</a>
            </li>
        </ul>
        <%} //parentesi if admin
    } else {%>
        <ul class="navBar">
            <li>
                <a href="${pageContext.request.contextPath}/login.jsp">
                    <h3>Accedi</h3>
                </a>
            </li>
        </ul>
    <%}%>
</nav>

<!--
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
-->
</body>

</html>