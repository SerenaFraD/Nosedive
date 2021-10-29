<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String message = (String) request.getAttribute("messaggio");
%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Profilo utente">
    <meta name="author" content="Serena D'Urso">

    <title>Errore | Nosedive</title>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link href="css/error.css" rel="stylesheet">
</head>
<body>
<%@ include file="navigation.jsp" %>
<section id="small">
    <p><%=message%></p>
    <button><a href="#">Torna alla home page</a></button>
</section>
</body>
</html>
