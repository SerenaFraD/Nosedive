<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Pagina di registrazione di YourBook">
    <meta name="author" content="Serena D">

    <title>Registrazione|YourBook</title>

    <!-- Bootstrap core CSS -->
    <link href="CSS/registration.css" rel="stylesheet">

</head>
<body>
<%@ include file="navBar.jsp" %>

<div class="cont">
    <div class="formArea">
        <div class="formCol">
            <form action="register" method="POST" name="registration">
                <table>
                    <tr>
                        <td><label for="nome">Nome</label></td>
                        <td><input type="w3-text" id="nome" name="nome" placeholder="Mario" oninput="validaNome()"
                                   autofocus></td>
                    </tr>

                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input type="w3-text" id="email" name="email" placeholder="mariorossi@posta.it"
                                   oninput="validaEmail()"></td>
                    </tr>

                    <tr>
                        <td><label for="pwd">Password</label></td>
                        <td><input type="password" id="pwd" name="pwd" placeholder="password"
                                   oninput="validaPassword()"></td>
                    </tr>

                    <tr>
                        <td><label for="pwdConf">Conferma Password</label></td>
                        <td><input type="password" id="pwdConf" name="pwdConf" placeholder="password"
                                   oninput="validaPassword()"></td>
                    </tr>

                    <tr>
                        <td><label for="nazionalita">Nazionalità</label></td>
                        <td><select id="nazionalita" name="nazionalita">
                            <option value="Italia">Italia</option>
                            <option value="America">America</option>
                            <option value="Inghilterra">Inghilterra</option>
                            <option value="Arabia Saudita">Arabia Saudita</option>
                            <option value="Francia">Francia</option>
                            <option value="Germania">Germania</option>
                            <option value="Burundi">Burundi</option>
                            <option value="Giappone">Giappone</option>
                            <option value="Indonesia">Indonesia</option>
                            <option value="Australia">Australia</option>
                        </select>
                        </td>
                    </tr>

                    <tr>
                        <td><label for="eta">Anno di nascita</label></td>
                        <td><select id="eta" name="eta">
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="27">27</option>
                            <option value="26">26</option>
                        </select></td>
                    </tr>

                </table>
                <output name="result" for="result">
                </output>

                <button type="submit" class="btn login_btn" id="registrami" disabled>Registrati!</button>
            </form>
        </div>
        <div class="logoCol">
            <h1>Registrati a YourBook adesso!</h1>
            <img src="Immagini/logoYourBook.png" alt="Logo YourBook"/>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
<script src="${pageContext.servletContext.contextPath}/JS/validate.js"></script>
</body>
</html>