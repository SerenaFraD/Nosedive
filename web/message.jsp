<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navigation.jsp" %>
<html>
<head>
    <title>Registrato! | Nosedive</title>
    <link rel="stylesheet" href="css/error.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Serena D'Urso">
</head>

<body>


<div class="cont">
    <p id="message"><%=request.getAttribute("messaggio")%></p>

    <div id="tasto">
        <a class="bottone" href="${pageContext.request.contextPath}/login.jsp" role="button">Accedi</a>
    </div>
</div>

</body>
</html>