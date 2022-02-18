<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link rel='stylesheet' href='${pageContext.request.contextPath}/webapp/css/profile.css'/>
</head>

<%@ include file="Navigation.jsp" %>

<body onload="mostraPost('<%=utente.getPunteggio()%>', true, '${pageContext.request.contextPath}')">
<section id="standard">
    <div class="publish">
        <form action="${pageContext.servletContext.contextPath}/postPublish" method="POST" name="publish">
            <textarea id="text" placeholder="Your message here"
                                                oninput="abilitateButton(event.target)"></textarea>
            <input type="file" id="image" name="files[]"
                   accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*"/>
            <label for="image">Select file</label>
            <input class="publish" type="submit"
                   onclick="mostraPost('<%=utente.getPunteggio()%>', true, '${pageContext.request.contextPath}')"
                   disabled>
        </form>
    </div>

    <hr>

    <div id="post">
        <img src="${pageContext.request.contextPath}/webapp/img/userIcon.png" alt="user"/>
        <div>
            <p class="nome">Nome Utente</p>
            <p class="categoria">Categoria utente</p>
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
            <img src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
            <img src="${pageContext.request.contextPath}/webapp/img/starIcon.svg" onclick="starAnimation(event.target)" alt="star"/>
        </div>

        <button onclick="showCommentArea(event.target)" class="showCommentButton"> Commenta</button>

        <div class="commento showCommentDiv">
            <form action="${pageContext.servletContext.contextPath}/publish" method="POST" name="commento">
                <textarea placeholder="Commento" oninput="abilitateButtonComment()"></textarea>
                <input class="publishComment" type="submit" disabled>
            </form>
        </div>
    </div>


</section>
</body>
</html>