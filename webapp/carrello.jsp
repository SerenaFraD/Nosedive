<%@ page import="model.CarrelloBean" %>
<%@ page import="model.ProdottoBean" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/css/prodotti.css"/>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    List<ProdottoBean> prodCarrello = null;
    UtenteBean utenteBean = (UtenteBean) session.getAttribute("user");
    try {
        CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello");
        prodCarrello = carrello.getItems();
    } catch (NullPointerException e) {
        System.out.println("Qualcosa");
    }
%>

<%@ include file="Navigation.jsp" %>
<h2>Carrello</h2>
<section id="prodotti">
    <h3>Carrello</h3>

    <div id="bottoni">
        <button onclick="window.location.href='${pageContext.request.contextPath}/webapp/prodotti.jsp'">Continua lo Shopping
        </button>
        <% if (prodCarrello != null && prodCarrello.size() > 0) {%>
        <button onclick="window.location.href='${pageContext.request.contextPath}/carrello?action=clearCart'">Clear</button>
        <%if (utenteBean != null) {%>
        <button id="acquista" onclick="buy()">Compra!</button>
        <%
                }
            }
        %>
    </div>
<!--onload="mostraProdotti()"-->
    <body >

    <div class="container">
        <%
            if (prodCarrello != null && prodCarrello.size() > 0) {
                for (ProdottoBean prod : prodCarrello) {
        %>
        <div class="product">
            <img src="${pageContext.servletContext.contextPath}/webapp/img/product.jpg" alt="prodotto"/>
            <h1><%=prod.getNome()%>
            </h1>
            <p><%=prod.getDescrizione()%>
            </p>
            <p><%=prod.getCategoria()%>
            </p>
            <p><%=prod.getCosto() + "&#8364"%>
            </p>
            <button type="submit"><img src="${pageContext.servletContext.contextPath}/webapp/img/delete.svg" alt="delete"/></button>
        </div>
        <% }
        } else {
        %><p class="mt">Il tuo carrello e' vuoto</p><%}%>
    </div>
</section>
<script>
    function buy(){
        alert("Acquisto avvenuto con successo")
        $.ajax({
            type: 'POST',
            url: ' ${pageContext.request.contextPath}/carrello',
            data:{
                action: 'clearCart'
            },
            success:function() {
                location.reload(true)
            }
        })
    }
</script>
</body>

</html>




