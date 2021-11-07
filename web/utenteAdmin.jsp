<%@ include file="navigation.jsp" %>
<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String lavoro = (String) request.getSession().getAttribute("lavoro");
    String relazione = (String) request.getSession().getAttribute("relazione");
    UtenteBean otherUtente = (UtenteBean) request.getSession().getAttribute("altroUtente");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Info utente">
    <meta name="author" content="Serena D'Urso">

    <title>Informazioni utente</title>

    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link href="css/infoUtente.css" rel="stylesheet">
</head>
<body>

<section id="standard">
    <p>Informazioni utente</p>
    <table>
        <tr>
            <td>Nome</td>
            <td><%=otherUtente.getNome()%>
            </td>
        </tr>
        <tr>
            <td>Punteggio</td>
            <td><%=otherUtente.getPunteggio()%>
            </td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><%=otherUtente.getEmail()%>
            </td>
        </tr>
        <tr>
            <td>Data di nascita</td>
            <td><%=otherUtente.getCompleanno()%>
            </td>
        </tr>
        <tr>
            <td>Lavoro</td>
            <td><%=lavoro%>
            </td>
        </tr>
        <tr>
            <td>Relazione</td>
            <td><%=relazione%>
            </td>
        </tr>
        <tr>
            <td>
                <form action="">
                    <label for="bloccare"> Bloccare? </label>
                    <input type="checkbox" id="bloccare" name="bloccare" value="<%=otherUtente.isBloccato()%>">
                    <input type="submit" value="Submit" onchange="modificaInformazioni(this.value, 'bloccato', '${pageContext.request.contextPath}')">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="">
                    <label  for="deceduto"> Deceduto? </label>
                    <input type="checkbox" id="deceduto" name="deceduto" value="<%=otherUtente.isDeceduto()%>">
                    <input type="submit" value="Submit" onchange="modificaInformazioni(this.value, 'deceduto', '${pageContext.request.contextPath}')">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="">
                    <label  for="supervisor"> Supervisore? </label>
                    <input type="checkbox" id="supervisor" name="deceduto" value="<%=otherUtente.isSupervisor()%>">
                    <input type="submit" value="Submit" onchange="modificaInformazioni(this.value, 'supervisore', '${pageContext.request.contextPath}')">
                </form>
            </td>
        </tr>
    </table>
</section>

</body>
</html>
