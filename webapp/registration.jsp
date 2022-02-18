<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link href="{${pageContext.request.contextPath}/webapp/css/registration.css" rel="stylesheet"/>
</head>
<body>
<section id="registration">
    <div id="invite">
        <p>Ready to join</p>
        <h2>NOSEDIVE?</h2>
        <button type="button" onclick="disappear()">click to register</button>
    </div>

    <div id="register">
        <form action="${pageContext.request.contextPath}/register" method="POST" name="registration">
            <table class="register">
                <tr>
                    <td><label for="nome">Nome</label></td>
                    <td><input type="text" id="nome" name="nome" placeholder="Mario" oninput="validaNome()"
                               autofocus>
                    </td>
                </tr>

                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="text" id="email" name="email" placeholder="mariorossi@posta.it"
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
                        <input id="eta" class="center" type="date">
                    </td>
                </tr>

                <tr>
                    <td><label>Sesso</label></td>
                    <td>
                        <input class="sesso" type="radio" id="f" name="sex" value="female">
                        <label class="sesso" for="f">Donna</label><br>
                        <input class="sesso" type="radio" id="m" name="sex" value="male">
                        <label class="sesso" for="m">Uomo</label><br>
                    </td>
                </tr>
            </table>
            <button type="submit">Invio</button>
        </form>
    </div>
</section>
</body>
</html>