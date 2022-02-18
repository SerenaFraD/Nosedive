<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webapp/css/error.css" />
</head>
<%String message = (String) session.getAttribute("messaggio");%>
<body>
<jsp:include page="Navigation.jsp"/>
<section>
    <p id="message"><%=message%>
    </p>
    <button>
        <a class="bottone" href="login.jsp" role="button">Accedi</a>
    </button>
</section>
</body>
</html>
