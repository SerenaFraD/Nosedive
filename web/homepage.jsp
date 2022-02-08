<%--suppress HtmlUnknownTarget --%>
<%@ include file="elements/Navigation.jsp" %>
<body onload="mostraPost('<%=utente.getPunteggio()%>', true, '${pageContext.request.contextPath}')">
<section id="standard">
    <div id="publish">
        <form action="${pageContext.request.contextPath}/postPublish" method="POST" name="publish">
            <label for="text"></label><textarea id="text" placeholder="Your message here" oninput="abilitateButton(event.target)"></textarea>
            <input type="file" id="image" name="files[]"
                   accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*"/>
            <label for="image">Select file</label>
            <input class="publish" type="submit" onclick="mostraPost('<%=utente.getPunteggio()%>', true, '${pageContext.request.contextPath}')" disabled>
        </form>
    </div>

    <hr>

    <div id="post">
        <script>

        </script>
        
    </div>
</section>

</body>
<html>
</html>


<!--
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
        -->