<!DOCTYPE html>
<html lang="it">

<head>
    <title>Profilo</title>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link href="css/profile.css" rel="stylesheet">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Profilo utente">
    <meta name="author" content="Serena D'Urso">
</head>

<body>
<%@ include file="navigation.jsp" %>

<section id="standard">
    <div id="publish">
        <form action="publish" method="POST" name="publish">
            <textarea id="text" placeholder="Your message here" oninput="abilitateButton(event.target)"></textarea>
            <input type="file" id="image" name="files[]"
                   accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*"/>
            <label for="image">Select file</label>
            <input class="publish" type="submit" disabled>
        </form>
    </div>

    <hr>

    <div id="post">
        <img src="img/userIcon.png">
        <div>
            <p class="nome">Nome Utente</p>
            <p class="categoria">Categoria utente</p>
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
    </div>
</section>

<script src="${pageContext.servletContext.contextPath}/js/showCommentArea.js"></script>
<script src="${pageContext.servletContext.contextPath}//starAnimation.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/abilitateButton.js"></script>

</body>

</html>