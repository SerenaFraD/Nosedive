<%@ page import="model.UtenteBean" %>
<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utente");
%>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigation.css"/>
    <title>Nosedive</title>
</head>

<body>
<nav>
    <ul class="navBar">
        <li>
            <a href=""><img class="navBar" src="${pageContext.request.contextPath}/img/logoSmall.png"
                            alt="logo piccolo"></a>
        </li>
        
        <% if (utente != null) {%> 
            <li>
                <a href="${pageContext.request.contextPath}/homepage.jsp">
                    <h3>Home</h3>
                </a>
            </li>
            <li>
                <form action="${pageContext.request.contextPath}/SearchServlet" method="get">
                    <input type="search" placeholder="Search" aria-label="Search" name="chiave">
                    <button type="submit"><img class="navBar" src="../img/search.svg"></button>
                </form>
            </li>

            <li>
                <img class="navBar" src="${pageContext.request.contextPath}/img/starIcon.svg" alt="stella">
                <h3><%=utente.getPunteggio()%></h3>
            </li>
        </ul>

        <ul class="navBar hidden">
            <li><img onclick="menu()" src="../img/menu.svg"></li>
            
            <li><a href="${pageContext.request.contextPath}/userprofile.jsp?id_utente=<%=utente.getId_utente()%>">
                <img class="navBar" src="../img/account.svg" alt="profilo">
                <h3>Profilo</h3>
            </a></li>

            <li><a href="${pageContext.request.contextPath}/cart.jsp">
                <img src="../img/carrello.svg" alt="carrello">
                <h3>Carrello</h3>
            </a></li>

            <li><a href="${pageContext.request.contextPath}/prodotti.jsp">
                <img src="../img/shop.svg" alt="shop">
                <h3>Negozio</h3>
            </a></li>

            <% if (utente.isSupervisor()) {%>
                <li><a href="${pageContext.request.contextPath}/prodottiAdmin.jsp">
                    <img src="../img/addProduct.svg" alt="aggiungi prodotto">
                    <h3>+ Prodotto</h3>
                </a></li>
        
                <li><a href="../utenteAdmin.html">
                    <img src="../img/addPerson.svg" alt="aggiungi Utente">
                    <h3>+ Utente</h3>
                </a></li>
            <%}%>

        

        <li><a href="${pageContext.request.contextPath}/index.jsp" onclick="logout()">
            <img src="../img/logout.svg" alt="logout">
            <h3>Logout</h3>
        </a></li>

        <%} else {%>
            <li><a href="../login.html">
                <img src="../img/login.svg" alt="login">
                <h3>Login</h3>
            </a></li>
        <%}%>
    </ul>
</nav>

<script src="${pageContext.request.contextPath}/js/logout.js"></script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
</body>
</html>