<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrato! | Nosedive</title>
    <link rel="stylesheet" href="CSS/message.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Serena D'Urso">
</head>

<body>
<%@ include file="navigation.jsp" %>

<div class="cont">
    <p id="message"><%=request.getAttribute("message")%>
    </p>

    <div id="tasto">
        <a class="bottone" href="login.jsp" role="button">Accedi</a>
    </div>
</div>

</body>
</html>