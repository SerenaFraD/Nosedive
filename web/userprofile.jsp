<%@ page import="model.UtenteBean"%>
<%
    UtenteBean utente = (UtenteBean) session.getAttribute("utente");
    UtenteBean otherUtente = (UtenteBean) session.getAttribute("otherUtente");
    boolean follows = (boolean) session.getAttribute("follows");
    int userIdPost, punteggio = 0;
    String filename, nome;

    if(otherUtente == null) {
        filename = utente.getPropic();
        userIdPost = utente.getId_utente();
        nome = utente.getNome();
    }  else {
        filename = otherUtente.getPropic();
        userIdPost = otherUtente.getId_utente();
        nome = otherUtente.getNome();
        punteggio = otherUtente.getPunteggio();
    }
%>
<%@ include file="navigation.jsp" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Profilo utente">
    <meta name="author" content="Serena D'Urso">

    <title>Profilo</title>

    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link href="css/profile.css" rel="stylesheet">
</head>

<body onload="mostraPost('<%=userIdPost%>', false, '${pageContext.request.contextPath}')">

<section id="standard">
    <img id="propic" src="img/<%=filename%>" alt="Imagine profilo">
    <div class="information">
        <p class="nome"><%=nome%></p>

        <p class="categoria"><%=punteggio%></p>

        <p class="bloccato">
            <%if(otherUtente != null && otherUtente.isDeceduto())%>
            Deceduto
            <%if(otherUtente != null &&  otherUtente.isBloccato())%>
            Bloccato
        </p>

        <% if(otherUtente != null) { %>
        <form action="<%if(follows) {%> follow <%} else {%> unfollow <%}%>" method="get">
            <button>
                <%if(follows) {%> Follow <%} else {%> Unfollow <%}%>"
            </button>
        </form>
        <%}%>
    </div>

    <hr>
    <% if(otherUtente == null) { %>
    <div id="publish">
        <form action="${pageContext.servletContext.contextPath}/postPublish" method="POST" name="publish">
            <textarea name="testo" id="text" placeholder="Your message here" oninput="abilitateButton(event.target)"></textarea>
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
            <p class="nome">DataPost</p>
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
            <img src="img/starIcon.svg" onclick="starAnimation(event.target)">
            <img src="img/starIcon.svg" onclick="starAnimation(event.target)">
            <img src="img/starIcon.svg" onclick="starAnimation(event.target)">
            <img src="img/starIcon.svg" onclick="starAnimation(event.target)">
            <img src="img/starIcon.svg" onclick="starAnimation(event.target)">
        </div>

        <button onclick="showCommentArea(event.target)" class="showCommentButton"> Commenta</button>

        <div id="commento" class="showCommentDiv">
            <form action="publish" method="POST" name="commento">
                <textarea id="commentot" placeholder="Commento" oninput="abilitateButtonComment()"></textarea>
                <input class="publishComment" type="submit" disabled>
            </form>
        </div>
        -->
    </div>

</section>

<script src="${pageContext.servletContext.contextPath}/js/showCommentArea.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/starAnimation.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/abilitateButton.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/mostraPost.js"></script>
</body>

</html>