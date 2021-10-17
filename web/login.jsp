<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login | Nosedive</title>
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Pagina di registrazione di Nosedive">
    <meta name="author" content="Serena D'Urso">
</head>
<body>
<%@ include file="navigation.jsp" %>

<section id="login">
    <img src="img/logoSmall.png" alt="Logo small Nosedive">

    <div class="form">
        <form action="login?action=login" method="POST">
            <input type="w3-text" name="email" value="" placeholder="Email" oninput="validaEmailLogin()" autofocus>
            <input type="password" name="pwd" value="" placeholder="Password" oninput="validaPasswordLogin()">
            <output name="result" for="result"></output>
            <button type="submit" name="button">Login</button>
        </form>
    </div>

    <div>
        <div>
            <b>Non hai un account?</b>
            <a href="${pageContext.servletContext.contextPath}/registration.jsp">Registrati</a>
        </div>
        <a class="other" href="#">Password dimenticata?</a>
    </div>

</section>
<script src="${pageContext.servletContext.contextPath}/js/validate.js"></script>
</body>
</html>
