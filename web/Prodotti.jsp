<%@ page import="java.util.Collection" %>
<%@ page import="model.ProdottoBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>
<%
    Collection<?> products = (Collection<?>) request.getAttribute("products");
    ProdottoBean product = (ProdottoBean) request.getAttribute("Prodotto");
    String categoria = request.getParameter("categoria");
%>

<head>
    <title>Negozio | Nosedive</title>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <script type="text/javascript" src="js/mostraProdotti.js"></script>
    <link rel="stylesheet" href="css/prodotti.css">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Negozio">
    <meta name="author" content="Serena D'Urso">
</head>

<body>


<h1>Negozio</h1>
    <%if(categoria == null){%>
<body onload="mostraProdotti('tutti', '${pageContext.request.contextPath}')">
    <%}

else { %>
<body onload="mostraProdotti('<%=categoria%>', '${pageContext.request.contextPath}')">
    <% } %>

<body onload="mostraProdotti()">
<form id="formProd" action="">
    <select name="categoria" onchange="mostraProdotti(this.value,'${pageContext.request.contextPath}')">
        <option value="#">Seleziona una categoria:</option>
        <option value="tutti">Tutti</option>
        <option value="internet">Internet</option>
        <option value="affitti">Affitti</option>
        <option value="educazione">Educazione</option>
    </select>
</form>


<div id="mostraProdotti">
    <script>

    </script>
</div>

</body>
