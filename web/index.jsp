<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="elements/Navigation.jsp" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content="Nosedive, website"/>
    <meta name="author" content="Serena D'Urso"/>
    <title>Nosedive</title>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <img class="logo" src="img/logo2.jpg" />
    <section class="opaque">
        <div class="intro">
            <p>
                La piattaforma ‘Nosedive” è un social network rivolto a tutta la popolazione maggiorenne,
                con lo scopo di monitorare il punteggio relativo ad ogni individuo, basandosi sulle azioni
                intraprese e lo stile di vita che conduce. Gli utenti presenti iscritti su Nosedive inseriscono
                le informazioni personali, le azioni intraprese quotidianamente e assegnare votazioni ad altri utenti e
                il sistema si occuperà di aggiornare il punteggio e di assegnare le penalità, se necessario.
                Ogni singolo individuo, in base al punteggio correntemente collegato al suo profilo, deve essere
                inserito in una categoria della società. In base alla categoria alla quale l’individuo è stato assegnato
                saranno proposti collegamenti (amicizie) differenziati.
            </p>
            <img src="img/aboutus.jpg" alt="Lacie with points">
        </div>
    </section>

    <!-- Presentation section -->
    <section class="opaque">
        <img class="about" src="img/aboutus2.jpg">

        <article class="about">
            <h3 class="about">About us</h3>
            <div class="row">
                <img src="img/serena.jpg" alt="Serena D'Urso">
                <div class="column">
                    <h4>Serena D'Urso</h4>
                    <p>(0512105709)</p>
                </div>
            </div>
            <div class="row">
                <img src="img/riccardo.jpg" alt="Riccardo Amaro">
                <div class="column">
                    <h4>Riccardo Amaro</h4>
                    <p>(0512105841)</p>
                </div>
            </div>
        </article>
    </section>
</body>
</html>