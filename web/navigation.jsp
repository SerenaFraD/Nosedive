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
            <a href="${pageContext.request.contextPath}/homepage.jsp">
                <h3>Home</h3>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/prodotti.jsp">
                <h3>Shop</h3>
            </a>
        </li>
    </ul>

    <%if (utente != null) { %>
    <ul class="navBar">
        <li>
            <form action="${pageContext.request.contextPath}/SearchServlet" method="get">
                <input class="searchBar" type="search" placeholder="Search" aria-label="Search" name="chiave">
                <button class="searchBar" type="submit">Search</button>
            </form>
        </li>
        <li><img class="navBar" src="img/starIcon.svg" alt="stella"></li>
        <li>
            <h3><%=utente.getPunteggio()%></h3>
        </li>
        <li><img class="navBar" src="img/userIcon.png" alt="utente"></li>
        <li><a href="${pageContext.request.contextPath}/userprofile.jsp">
            <h3>Profilo</h3>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/cart.jsp"><h3>Carrello</h3></a></li>
        <li><h3 onclick="logout()">Esci</h3></li>
    </ul>


    <% if (utente.isSupervisor()) {%>
    <ul class="navBar">
        <li>
            <a href="${pageContext.request.contextPath}/admin/prodottiAdmin.jsp">Add Prodotto</a>
        </li>
    </ul>
    <%
        } //parentesi if supervisor
    } else {
    %>
    <ul class="navBar">
        <li>
            <a href="${pageContext.request.contextPath}/login.jsp">
                <h3>Accedi</h3>
            </a>
        </li>
    </ul>
    <%}%>
</nav>

<script src="${pageContext.request.contextPath}/js/logout.js"></script>
</body>
</html>