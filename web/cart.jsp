<%@ page import="it.unisa.model.UserBean" %>
<%@ page import="it.unisa.model.ProductBean" %>
<%@ page import="it.unisa.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pavil
  Date: 14/07/2020
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String)request.getAttribute("error");

    Cart carrello = (Cart) session.getAttribute("carrello");
    UserBean userBean = (UserBean) session.getAttribute("user");


    if( carrello == null){
        response.sendRedirect(response.encodeRedirectURL("./CartServlet"));
        return;
    }
%>
<html>
<head>
    <title>Carrello</title>
    <%@ include file= "_header.jsp" %>
    <style type="text/css"> @import url(Style.css);</style>
    <script src="https://cdn.jsdelivr.net/jquery/latest/jquery.js"></script>

</head>
<body>
<h2 align="center" style="color: orangered; padding: 60px">Carrello</h2>

<%
    List<ProductBean> prodCarrello = carrello.getItems();
%>


<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">Nome</th>
        <th scope="col">Codice</th>
        <th scope="col">Quantità</th>
        <th scope="col">Prezzo</th>
        <th scope="col">Elimina</th>
    </tr>
    </thead>

    <%
        if(prodCarrello.size() > 0) {
            for(ProductBean prod: prodCarrello) {
    %>
    <tr>
        <th><%=prod.getNome()%></th>
        <td><%=prod.getCodiceProd()%></td>
        <td><%=prod.getQuantita()%></td>    <!-- input type="number" min="1" max="20" -->
        <td><%=prod.getPrezzo()*prod.getQuantita()+"&#8364"%></td>
        <!--<td><a align="center" class= "eliminaprod" href="<%//=response.encodeURL("CartServlet?action=deleteCart&id=" + prod.getCodiceProd())%>">   x   </a></td>-->
        <td><button onclick="window.location.href='<%=response.encodeURL("CartServlet?action=deleteCart&id=" + prod.getCodiceProd())%>'" class="btn btn-outline-danger btn-sm">x</button></td>
    </tr>
    <% 		}
    } else {
    %>
    <tr><td colspan="12" align="center">Il tuo carrello è vuoto</td></tr>

    <%
        }
    %>
    <!--<button onclick="window.location.href='http://localhost:8080/MotoDoc_war_exploded/prodotti'">Continua lo Shopping</button>-->
</table>
<div id="bottoni">
    <button onclick="window.location.href='${pageContext.request.contextPath}/prodotti'" class="btn btn-secondary btn-sm" >Continua lo Shopping</button>
    <%
        if(prodCarrello.size() > 0) {
    %>

    <button onclick="window.location.href='<%=response.encodeURL("CartServlet?action=clearCart")%>'" class="btn btn-secondary btn-sm">Clear</button>
    <!--<a href="<%//=response.encodeURL("CartServlet?action=clearCart")%>">Clear</a>-->
    <script>
        function buy(){
            alert("Acquisto avvenuto con successo")
            $.ajax({
                type: 'POST',
                url: ' ${pageContext.request.contextPath}/CartServlet',
                data:{
                    action: 'clearCart'
                },
                success:function() {
                    location.reload(true)
                }
            })
        }
    </script>
    <%if(userBean != null){%>
    <button  class="btn btn-secondary btn-sm" id="acquista" onclick="buy()" >Buy</button>   <!-- da inserire il link-->
    <%}%><%  } %>

</div>

<%@ include file= "_footer.jsp" %>

</body>

</html>




