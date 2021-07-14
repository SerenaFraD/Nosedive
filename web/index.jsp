<%@ page import="model.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>YourBook</title>
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico"/>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css"/>
    <title>HomePage</title>
    <link rel="stylesheet" href="CSS/HomePage.css">
</head>
<body>

<%@ include file="navBar.jsp" %>

<!-- Masthead-->
<header class="masthead">
    <div class="container">
        <div class="masthead-subheading">Benvenuto su YourBook!</div>
        <div class="masthead-heading text-uppercase">Siamo felici di averti sul nostro sito</div>
        <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Vai ai Libri</a>
    </div>
</header>
<!-- Services-->
<section class="page-section" id="services">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Services</h2>
            <h3 class="section-subheading text-muted">Semplifichiamo la tua scelta del libro.</h3>
        </div>
        <div class="row text-center">
            <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-shopping-cart fa-stack-1x fa-inverse"></i>
                        </span>
                <h4 class="my-3">Modulo di IA</h4>
                <p class="text-muted">Il nostro modulo di Intelligenza artificiale ti suggerirá i titoli piú adatti a
                    te.</p>
            </div>
            <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
                        </span>
                <h4 class="my-3">Responsive Design</h4>
                <p class="text-muted">Puoi navigare sul nostro sito da qualsiasi dispositivo.</p>
            </div>
            <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-user fa-stack-1x fa-inverse"></i>
                        </span>
                <h4 class="my-3">Assistenza</h4>
                <p class="text-muted">Offriamo assistenza 24/7</p>
            </div>
        </div>
    </div>
</section>
<section class="page-section" id="about">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">About</h2>
            <h3 class="section-subheading text-muted">Puntiamo di crescere insieme a voi.</h3>
        </div>
        <ul class="timeline">
            <li>
                <div class="timeline-image"><img class="rounded-circle img-fluid" src="assets/img/about/1.jpg" alt=""/>
                </div>
                <div class="timeline-panel">
                    <div class="timeline-heading">
                        <h4>2018</h4>
                        <h4 class="subheading">Iscrizione ad Unisa</h4>
                    </div>
                    <div class="timeline-body"><p class="text-muted">Nel 2018 ci siamo iscritti ad unisa alla facoltá di
                        informatica pronti per intraprendere questo splendido percorso</p></div>
                </div>
            </li>
            <li class="timeline-inverted">
                <div class="timeline-image"><img class="rounded-circle img-fluid" src="assets/img/about/2.jpg" alt=""/>
                </div>
                <div class="timeline-panel">
                    <div class="timeline-heading">
                        <h4>II Anno</h4>
                        <h4 class="subheading">Primo progetto web di TSW</h4>
                    </div>
                    <div class="timeline-body"><p class="text-muted">Al II Anno é partito il primo semplice progetto
                        web</p></div>
                </div>
            </li>
            <li>
                <div class="timeline-image"><img class="rounded-circle img-fluid" src="assets/img/about/3.jpg" alt=""/>
                </div>
                <div class="timeline-panel">
                    <div class="timeline-heading">
                        <h4>III Anno</h4>
                        <h4 class="subheading">Progettazione YourBook</h4>
                    </div>
                    <div class="timeline-body"><p class="text-muted">L'idea del progetto YourBook comincia a balenare
                        nelle nostre menti</p></div>
                </div>
            </li>

            <li class="timeline-inverted">
                <div class="timeline-image">
                    <h4>
                        Be Part
                        <br/>
                        Of Our
                        <br/>
                        Story!
                    </h4>
                </div>
            </li>
        </ul>
    </div>
</section>
<!-- Team-->
<section class="page-section bg-light" id="team">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Il nostro splendido Team</h2>
            <h3 class="section-subheading text-muted">Insieme abbiamo lavorato a YourBook</h3>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="Immagini/fotoPaolo.jpg" alt=""/>
                    <h4>Paolo Petta</h4>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="Immagini/fotoSerena.jpg" alt=""/>
                    <h4>Serena D'Urso</h4>
                    <a class="btn btn-dark btn-social mx-2" href="https://www.facebook.com/robotbabe/"><i
                            class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/serena-d-urso-6b0994144/"><i
                            class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="team-member">
                    <img class="mx-auto rounded-circle" src="assets/img/team/3.jpg" alt=""/>
                    <h4>Riccardo Amaro</h4>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 mx-auto text-center"><p class="large text-muted">Lorem ipsum dolor sit amet,
                consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam
                corporis ea, alias ut unde.</p></div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

<!-- Bootstrap core JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Third party plugin JS-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<!-- Contact form JS-->
<script src="assets/mail/jqBootstrapValidation.js"></script>
<script src="assets/mail/contact_me.js"></script>
<!-- Core theme JS-->
<script src="JS/HomePage.js"></script>
</body>
</html>