<html>
<head>
    <link rel="stylesheet" href="navigation.css">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg fixed-top" id="mainNav">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand js-scroll-trigger" href="#"><img src="https://i.imgur.com/o5ODS7P.png" alt="logo YourBook"></a>

    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
            <li class="nav-item" id="cercaNavbar">
                <div class="container h-100">
                    <div class="d-flex justify-content-center h-100">
                        <div class="searchbar">
                            <!--<input class="search_input" type="text" name="" placeholder="Cerca...">
                            <a href="\${pageContext.request.contextPath}/RicercaServlet" class="search_icon"><i class="fas fa-search"></i></a>-->
                            <form action="${pageContext.request.contextPath}/RicercaServlet?action=findbook">
                                <input class="search_input" type="text" id="titolo" name="titolo">
                                <input type="submit" value="Submit" class="search_icon">
                            </form>
                        </div>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/index.jsp">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/InsertBook.jsp">Inserisci
                    Titolo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="suggestBook.jsp">Libri Suggeriti</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Libri?action=retrieveAll">Libri</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger"
                   href="${pageContext.request.contextPath}/myWishList.jsp">Wishlist</a>
            </li>
            <%if (user != null){%>
            <li class="nav-item">
                <a class="nav-link js scroll-trigger" href="User/myAccount.jsp">Ciao <%=user.getNome()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link js scroll-trigger" href="${pageContext.request.contextPath}/login?action=logout">Logout</a>
            </li>
            <% if(user.isAdmin()){%>
            <li class="nav-item">
                <a class="nav-link js scroll-trigger" href="${pageContext.request.contextPath}/Admin/adminManagement.jsp">Dashboard</a>
            </li>
            <%} //parentesi if admin
            }
            else{%>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/login.jsp">Accedi</a>
            </li>
            <%}%>
        </ul>

    </div>
</nav>

</body>
</html>