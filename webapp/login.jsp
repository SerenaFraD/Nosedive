<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<section id="login">
    <img src="img/logoSmall.png" alt="Logo small Nosedive">

    <div class="form">
        <form action="${pageContext.request.contextPath}/login" method="POST">
            <label>Email</label>
            <input type="text" name="email" value="" placeholder="Email" oninput="validaEmailLogin()" autofocus>
            <label>Password</label>
            <input type="password" name="pwd" value="" placeholder="Password" oninput="validaPasswordLogin()">

            <output name="result" for="result"></output>
            <button type="submit" name="button">Login</button>
        </form>
    </div>

    <div>
        <div>
            <b>Non hai un account?</b>
            <a href="registration.jsp">Registrati</a>
        </div>
        <a class="other" href="#">Password dimenticata?</a>
    </div>

</section>
</body>
</html>
