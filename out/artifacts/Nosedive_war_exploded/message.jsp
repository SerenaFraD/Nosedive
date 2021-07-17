<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrato! | YourBook</title>
    <link rel="stylesheet" href="CSS/message.css">
</head>
<body>
<%@ include file="navBar.jsp" %>

<div class="cont">
    <p id="message"><%=request.getAttribute("message")%></p>

    <div id="tasto">
        <a class="bottone" href="login.jsp" role="button">Accedi</a>
    </div>
</div>


<%@ include file="footer.jsp" %>
</body>
</html>