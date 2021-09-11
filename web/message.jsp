<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrato! | Nosedive</title>
    <link rel="stylesheet" href="CSS/message.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
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