<%@ page isErrorPage="true" %>
<jsp:include page="elements/Navigation.jsp"/>

<main>
    <article>
        <h1>Errore 404</h1>
        <p>La pagina richiesta non è stata trovata.</p>
    </article>
</main>

<script type="text/javascript">
    setTimeout(function () {
        location.href = './';
    }, 3000);
</script>
