<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | Nosedive</title>
    <link rel="stylesheet" href="css/Login.css">
</head>
<body>
<%@ include file="navBar.jsp" %>

<div class="container h-100">
    <div class="d-flex justify-content-center h-100">
        <div class="user_card">

            <div class="d-flex justify-content-center">
                <div class="brand_logo_container">
                    <img src="https://i.imgur.com/o5ODS7P.png" class="brand_logo" alt="logo YourBook">
                </div>
            </div>

            <div class="d-flex justify-content-center form_container">
                <form action="login?action=login" method="POST" name="login">

                    <div class="input-group mb-3">
                        <div class="input-group-append">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="email" name="email" class="form-control input_user" placeholder="email"
                               oninput="validaEmailLogin()">
                    </div>

                    <div class="input-group mb-2">
                        <div class="input-group-append">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" name="pwd" class="form-control input_pass" placeholder="password"
                               oninput="validaPasswordLogin()">
                    </div>

                    <div class="form-group">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="customControlInline">
                            <label class="custom-control-label" for="customControlInline">Ricordami</label>
                        </div>
                    </div>

                    <div class="d-flex justify-content-center mt-3 login_container">
                        <button type="submit" class="btn login_btn" id="logme">Login</button>
                        <p id="result"></p>
                    </div>
                </form>
            </div>

            <div class="coso">
                <div class="d-flex justify-content-center links">
                    <p>Non hai un account?</p>
                    <a href="registration.jsp" class="ml-2 nonReg">Registrati</a>
                </div>

                <div class="d-flex justify-content-center links">
                    <a href="#" class="nonReg"><p>Password dimenticata?</p></a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

<!-- Core theme JS-->
<script src="JS/HomePage.js"></script>
</body>
</html>