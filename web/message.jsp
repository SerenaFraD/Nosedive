<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="elements/Navigation.jsp"/>
<%String message = (String) request.getAttribute("messaggio");%>
<html>
<head>
    <title>Nosedive</title>
    <link rel="stylesheet" href="css/message.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

<section id="small">
    <p id="message"><%=message%></p>
    <button>
        <a class="bottone" href="${pageContext.request.contextPath}/login.jsp" role="button">Accedi</a>
    </button>
</section>



</body>
</html>