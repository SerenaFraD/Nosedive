<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.servletContext.contextPath}/webapp/img/logoSmall.png"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webapp/css/profile.css">
</head>
<%@ include file="Navigation.jsp" %>
<%
    String other = request.getParameter("otherUtente");
    UtenteBean otherUtente = (UtenteBean) request.getSession().getAttribute("otherUtente");
    int userIdPost, punteggio;
    String nome;

    if (other == null) {
        userIdPost = utente.getId_utente();
        nome = utente.getNome();
        punteggio = utente.getPunteggio();
    } else {
        userIdPost = otherUtente.getId_utente();
        nome = otherUtente.getNome();
        punteggio = otherUtente.getPunteggio();
    }
%>
<body onload="mostraPost('<%=userIdPost%>', false, '${pageContext.request.contextPath}')">

<section class="profilo">
    <img class="propic" src="${pageContext.servletContext.contextPath}/webapp/img/userIcon.png" alt="Imagine profilo">
    <div class="information">
        <p class="nome"><%=nome%>
        </p>

        <p class="categoria"><%=punteggio%>
        </p>

        <p class="attributi">
            <%if (otherUtente != null && otherUtente.isDeceduto())%>
            Deceduto
            <%if (otherUtente != null && otherUtente.isBloccato())%>
            Bloccato
        </p>

        <% if (otherUtente != null) { %>
        <form action="${pageContext.servletContext.contextPath}/seguiServlet" method="post">
            <button>
                <%%> Follow <%%>
            </button>
        </form>
        <%}%>
    </div>

    <hr>
    <% if (otherUtente == null) { %>
    <div class="publish">
        <form action="${pageContext.servletContext.contextPath}/postPublish" method="POST" name="publish">
            <textarea name="testo" id="text" placeholder="Your message here"
                      oninput="abilitateButton(event.target)"></textarea>
            <input type="file" id="image" name="files"
                   accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*"/>
            <label for="image">Select file</label>
            <input class="publish" type="submit" disabled>
        </form>
    </div>

    <hr>
    <%}%>

    <div id="post">
        <script>

        </script>
        <!--
        <div>
            <p class="data">DataPost</p>
        </div>

        <p class="text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur venenatis tellus sit amet elit
            tincidunt bibendum. Donec id scelerisque libero. Sed nec ornare est, id ullamcorper sem. Aliquam
            elementum feugiat sagittis. Aliquam ac lorem sed libero fringilla gravida. Nunc egestas porta vulputate.
            Donec eu dapibus nibh, eget facilisis diam. Fusce lobortis diam eu velit placerat luctus. Pellentesque
            sodales ullamcorper arcu, a convallis massa blandit in. Interdum et malesuada fames ac ante ipsum primis
            in faucibus.
        </p>

        <div class="stars">
            <img src="${pageContext.servletContext.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.servletContext.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.servletContext.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.servletContext.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.servletContext.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
        </div>

        <button onclick="showCommentArea(event.target)" class="showCommentButton"> Commenta</button>

        <div class="commento showCommentDiv">
            <form action="${pageContext.servletContext.contextPath}/postCommento" method="POST" name="commento">
                <textarea placeholder="Commento" oninput="abilitateButtonComment()"></textarea>
                <input class="publishComment" type="submit" disabled>
            </form>
        </div>
        -->
    </div>
</section>
<script src="${pageContext.servletContext.contextPath}/webapp/js/showCommentArea.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/starAnimation.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/abilitateButton.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/mostraPost.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/animation.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/validate.js"></script>
<script src="${pageContext.servletContext.contextPath}/webapp/js/logout.js"></script>
</body>
</html>