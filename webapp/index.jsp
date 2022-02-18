<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webapp/css/index.css">
</head>
<body>
<jsp:include page="Navigation.jsp"/>
<img class="logo" src="${pageContext.request.contextPath}/webapp/img/logo2.jpg" alt="logo"/>
<!-- Introduction section -->
<section class="opaque">
    <div class="intro">
        <p>
            La piattaforma "Nosedive” è un social network rivolto a tutta la popolazione maggiorenne,
            con lo scopo di monitorare il punteggio relativo ad ogni individuo, basandosi sulle azioni
            intraprese e lo stile di vita che conduce. Gli utenti presenti iscritti su Nosedive inseriscono
            le informazioni personali, le azioni intraprese quotidianamente e assegnare votazioni ad altri utenti e
            il sistema si occuperà di aggiornare il punteggio e di assegnare le penalità, se necessario.
            Ogni singolo individuo, in base al punteggio correntemente collegato al suo profilo, deve essere
            inserito in una categoria della società. In base alla categoria alla quale l’individuo è stato assegnato
            saranno proposti collegamenti (amicizie) differenziati.
        </p>
        <img src="${pageContext.request.contextPath}/webapp/img/aboutus.jpg" alt="Lacie with points">
    </div>
</section>

<!-- Presentation section -->
<section class="opaque">
    <img class="about" src="${pageContext.request.contextPath}/webapp/img/aboutus2.jpg" alt="macheneso">

    <article class="about">
        <h3 class="about">About us</h3>
        <div class="row">
            <img src="${pageContext.request.contextPath}/webapp/img/serena.jpg" alt="Serena D'Urso">
            <div class="column">
                <h4>Serena D'Urso</h4>
                <p>(0512105709)</p>
            </div>
        </div>
        <div class="row">
            <img src="${pageContext.request.contextPath}/webapp/img/riccardo.jpg" alt="Riccardo Amaro">
            <div class="column">
                <h4>Riccardo Amaro</h4>
                <p>(0512105841)</p>
            </div>
        </div>
    </article>
</section>
</body>
</html>