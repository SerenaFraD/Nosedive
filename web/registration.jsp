<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<!DOCTYPE html>
<html lang="it">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Pagina di registrazione di Nosedive">
    <meta name="author" content="Serena D'Urso">

    <title>Registrazione</title>

    <link href="registration.css" rel="stylesheet">
</head>

<body>
    <!-- <%@ include file="navBar.jsp" %> -->
    <section id="registration">
        <div id="invite">
            <p>Ready to join</p>
            <h2>NOSEDIVE?</h2>
            <button type="button" onclick="disappear()">click to register</button>
        </div>
        <div id="register">
            <form action="register" method="POST" name="registration">
                <table class="register">
                    <tr>
                        <td><label for="nome">Nome</label></td>
                        <td><input type="w3-text" id="nome" name="nome" placeholder="Mario" oninput="validaNome()"
                                autofocus>
                        </td>
                    </tr>

                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input type="w3-text" id="email" name="email" placeholder="mariorossi@posta.it"
                                oninput="validaEmail()"></td>
                    </tr>

                    <tr>
                        <td><label for="pwd">Password</label></td>
                        <td><input type="password" id="pwd" name="pwd" placeholder="password"
                                oninput="validaPassword()">
                        </td>
                    </tr>

                    <tr>
                        <td><label for="pwdConf">Conferma Password</label></td>
                        <td><input type="password" id="pwdConf" name="pwdConf" placeholder="password"
                                oninput="validaPassword()"></td>
                    </tr>

                    <tr>
                        <td><label for="eta">Anno di nascita</label></td>
                        <td>
                            Modificare data di nascita
                        </td>
                    </tr>

                </table>
                <output name="result" for="result">
                </output>

                <button type="submit" id="register" disabled>Registrati!</button>
            </form>
        </div>


    </section>

    <script src="${pageContext.servletContext.contextPath}/JS/validate.js"></script>
    <script src="animation.js"></script>
    
</body>

</html>