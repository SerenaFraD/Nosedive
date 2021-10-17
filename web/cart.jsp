<%@ page import="model.UtenteBean" %>
<%@ page import="model.ProdottoBean" %>
<%@ page import="control.servlet.CarrelloServlet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String error = (String) request.getAttribute("error");

    CarrelloServlet carrello = (CarrelloServlet) session.getAttribute("carrello");
    UtenteBean utenteBean = (UtenteBean) session.getAttribute("user");

    if (carrello == null) {
        response.sendRedirect(response.encodeRedirectURL("./CartServlet"));
        return;
    }
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Carrello ordini">
    <meta name="author" content="Serena D'Urso">

    <title>Carrello | Nosedive</title>
    <link rel="stylesheet" href="css/carrello.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <script type="text/javascript" src="js/carrello.js"></script>
</head>

<body>
<%@ include file="navigation.jsp" %>
<h2>Carrello</h2>

<%
    List<ProdottoBean> prodCarrello = carrello.getItems(); //todo fix, wtf I just ctrl+c this and doesn't work
%>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Nome</th>
        <th scope="col">Codice Prodotto</th>
        <th scope="col">Punteggio minimo</th>
        <th scope="col">Costo</th>
        <th scope="col">Abilitato</th>
        <th scope="col">Elimina</th>
    </tr>
    </thead>

    <%
        if (prodCarrello.size() > 0) {
            for (ProdottoBean prod : prodCarrello) {
    %>
    <tr>
        <th><%=prod.getNome()%>
        </th>
        <td><%=prod.getId_prodotto()%>
        </td>
        <td><%=prod.getPunteggio_min()%>
        </td>
        <td><%=prod.getCosto() + "&#8364"%>
        </td>


        <td>
            <button onclick="window.location.href='<%=response.encodeURL("CartServlet?action=deleteCart&id=" + prod.getId_prodotto())%>'"
                    class="btn btn-outline-danger btn-sm">x
            </button>
        </td>
    </tr>
    <% }
    } else {
    %>
    <tr>
        <td colspan="12" align="center">Il tuo carrello è vuoto</td>
    </tr>

    <%
        }
    %>

</table>
<div id="bottoni">
    <button onclick="window.location.href='${pageContext.request.contextPath}/prodotti'"
            class="btn btn-secondary btn-sm">Continua lo Shopping
    </button>
    <%
        if (prodCarrello.size() > 0) {
    %>

    <button onclick="window.location.href='<%=response.encodeURL("CartServlet?action=clearCart")%>'"
            class="btn btn-secondary btn-sm">Clear
    </button>

    <%if (utenteBean != null) {%>
    <button class="btn btn-secondary btn-sm" id="acquista" onclick="buy()">Compra!</button>
    <%}%><% } %>

</div>
</body>

</html>




