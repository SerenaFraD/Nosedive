<%@ page import="java.util.Collection" %>
<%@ page import="model.ProdottoBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.servletContext.contextPath}/webapp/img/logoSmall.png"/>
    <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/webapp/css/prodotti.css'/>
</head>
<%@ include file="Navigation.jsp" %>
<%
    //todo aiuto
    Collection<?> products = (Collection<?>) request.getAttribute("products");
    ProdottoBean product = (ProdottoBean) request.getAttribute("Prodotto");
    String categoria = request.getParameter("categoria");
%>
    <%if(categoria == null){%>
<body onload="mostraProdotti('tutti', '${pageContext.request.contextPath}')">
<%} else {%>
<body onload="mostraProdotti('<%=categoria%>', '${pageContext.request.contextPath}')">
<% }%>
<section id="prodotti">
    <h3>Nosedive Shop</h3>
    <form action="" method="post" id="formProd">
        <select name="categoria" onchange="mostraProdotti(this.value,'${pageContext.request.contextPath}')">
            <option value="#">Seleziona una categoria</option>
            <option value="tutti">Tutti</option>
            <option value="internet">Internet</option>
            <option value="affitti">Affitti</option>
            <option value="educazione">Educazione</option>
        </select>
    </form>


    <div class="container">
        <script>

        </script>
        <!--
        <div class="product">
            <img src="${pageContext.request.contextPath}/webapp/img/product.jpg"/>
            <h1>Nome prodotto</h1>
            <p>Descrizione</p>
            <p>categoria</p>
            <p>costo</p>
            <button type="submit"><img class="buttons" src="${pageContext.request.contextPath}/webapp/img/add.svg"/></button>
        </div>
        -->
    </div>
    </div>
</section>
<script src="${pageContext.servletContext.contextPath}/webapp/js/showCommentArea.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/starAnimation.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/abilitateButton.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/mostraProdotti.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/animation.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/validate.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/logout.js"></script>
</body>
