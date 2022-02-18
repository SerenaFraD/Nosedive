<%@ page import="model.UtenteBean" %>
<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="Head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/css/navigation.css"/>
</head>

<%UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");%>
<body>
<nav>
    <ul class="navBar">
        <li>
            <a href="index.jsp"><img class="navBar" src="${pageContext.request.contextPath}/webapp/img/logoSmall.png" alt="logo piccolo"></a>
        </li>
        <% if (utente != null) {%>
        <li>
            <a href="${pageContext.request.contextPath}/webapp/homepage.jsp">
                <h3>Home</h3>
            </a>
        </li>
        <li>
            <form action="${pageContext.request.contextPath}/searchServlet" method="get">
                <input type="search" placeholder="Search" aria-label="Search" name="chiave">
                <button type="submit"><img class="navBar" src="${pageContext.request.contextPath}/webapp/img/search.svg" alt="search">
                </button>
            </form>
        </li>

        <li>
            <img class="navBar" src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" alt="stella">
            <h3><%=utente.getPunteggio()%>
            </h3>
        </li>
        <%}%>
    </ul>

    <ul class="navBar hidden">
        <li><img onclick="menu()" src="${pageContext.request.contextPath}/webapp/img/menu.svg" alt="menu"></li>
        <% if (utente != null) {%>
        <li><a href="${pageContext.request.contextPath}/webapp/userprofile.jsp?id_utente=<%=utente.getId_utente()%>">
            <img class="navBar" src="${pageContext.request.contextPath}/webapp/img/account.svg" alt="profilo">
            <h3>Profilo</h3>
        </a></li>

        <li><a href="${pageContext.request.contextPath}/webapp/carrello.jsp">
            <img src="${pageContext.request.contextPath}/webapp/img/carrello.svg" alt="carrello">
            <h3>Carrello</h3>
        </a></li>

        <li><a href="${pageContext.request.contextPath}/webapp/prodotti.jsp">
            <img src="${pageContext.request.contextPath}/webapp/img/shop.svg" alt="shop">
            <h3>Negozio</h3>
        </a></li>
        <% if (utente.isSupervisor()) {%>
        <li><a href="${pageContext.request.contextPath}/webapp/prodottiAdmin.jsp">
            <img src="${pageContext.request.contextPath}/webapp/img/addProduct.svg" alt="aggiungi prodotto">
            <h3>+ Prodotto</h3>
        </a></li>

        <li><a href="${pageContext.request.contextPath}/webapp/utenteAdmin.jsp">
            <img src="${pageContext.request.contextPath}/webapp/img/addPerson.svg" alt="aggiungi Utente">
            <h3>+ Utente</h3>
        </a></li>
        <%}%>
        <li>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit">
                <img src="${pageContext.request.contextPath}/webapp/img/logout.svg" alt="logout">
                <h3>Logout</h3>
                </button>
            </form>

        </li>
        <%} else {%>
        <li><a href="${pageContext.request.contextPath}/webapp/login.jsp">
            <img src="${pageContext.request.contextPath}/webapp/img/login.svg" alt="login">
            <h3>Login</h3>
        </a></li>
        <%}%>
    </ul>
</nav>
<script src="${pageContext.request.contextPath}/webapp/js/menu.js"></script>
</body>
</html>