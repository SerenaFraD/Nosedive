<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body>
<jsp:include page="Navigation.jsp"/>
<section>
    <h1>Errore 404</h1>
    <p>La pagina richiesta non è stata trovata.</p>
</section>


<script type="text/javascript">
    setTimeout(function () {
        location.href = '../..';
    }, 10000);
</script>
