<%@ page import="model.UtenteBean" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21/08/2021
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% UtenteBean ricercato = (UtenteBean) request.getSession().getAttribute("ricercato");

if(ricercato == null){
    response.sendRedirect(response.encodeRedirectURL("index.jsp"));
}
else {
    request.getSession().removeAttribute("ricercato");
%>
<h1><%=ricercato.getNome()%></h1>

<%
}
%>

</body>
</html>
