<%@ page import="java.util.Collection" %>
<%@ page import="it.unisa.model.ProductBean" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: pavil
  Date: 29/06/2020
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Collection<?> products = (Collection<?>) request.getAttribute("products");

    ProductBean product = (ProductBean) request.getAttribute("Prodotto");

    String categoria= request.getParameter("categoria");
%>

<%@ include file= "_header.jsp" %>
<head>
<title>Prodotti</title>

<link rel="stylesheet" href="Style.css">
</head>
    <h1 align="center" style="color: orangered">Prodotti</h1>

    <script type="text/javascript" src="prodotti.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="Style.css">
    <link href="./ProductStyle.css" rel="stylesheet" type="text/css">

<%if(categoria == null){%>
    <body onload="showProd('tutti', '${pageContext.request.contextPath}')">
<%}

else { %>
    <body onload="showProd('<%=categoria%>', '${pageContext.request.contextPath}')">
<% } %>

<body onload="showProd()">
<form id="formProd" action="">
    <select name="categoria" onchange="showProd(this.value,'${pageContext.request.contextPath}')">
        <!--ho dovuto inserire un altra voce perché l'evento é onchange-->
        <option value="#">Seleziona una categoria:</option>
        <option value="tutti">Tutti</option>
        <option value="carrozzeria">Carrozzeria</option>
        <option value="pneumatici">Pneumatici</option>
        <option value="meccanica">Meccanica</option>
    </select>
</form>


<div id="showProd">
    <script>

    </script>
</div>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>

<%@ include file= "_footer.jsp" %>











