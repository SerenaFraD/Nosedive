<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/webapp/img/logoSmall.png"/>
    <link href="${pageContext.request.contextPath}/webapp/css/infoUtente.css" rel="stylesheet">
</head>
<%@ include file="Navigation.jsp" %>

<%
    String lavoro = (String) request.getSession().getAttribute("lavoro");
    String relazione = (String) request.getSession().getAttribute("relazione");
    UtenteBean otherUtente = (UtenteBean) request.getSession().getAttribute("altroUtente");
%>
<body>
<section class="info admin">
    <p>Informazioni utente</p>
    <table>
        <tr>
            <td><h3>Nome</h3></td>
            <td><%=otherUtente.getNome()%>
            </td>
        </tr>
        <tr>
            <td><h3>Punteggio</h3></td>
            <td><%=otherUtente.getPunteggio()%>
            </td>
        </tr>
        <tr>
            <td><h3>E-mail</h3></td>
            <td><%=otherUtente.getEmail()%>
            </td>
        </tr>
        <tr>
            <td><h3>Data di nascita</h3></td>
            <td><%=otherUtente.getCompleanno()%>
            </td>
        </tr>
        <tr>
            <td><h3>Lavoro</h3></td>
            <td><%=lavoro%>
            </td>
        </tr>
        <tr>
            <td><h3>Relazione</h3></td>
            <td><%=relazione%>
            </td>
        </tr>
        <tr>
            <td>
                <label for="bloccare">Bloccare?</label>
            </td>
            <td>
                <form action='"${pageContext.request.contextPath}/blocco'  method="post">
                    <input type="search" style="visibility:hidden" name="id" value="<%=otherUtente.getId_utente()%>">
                    <input type="checkbox" id="bloccare" name="bloccare" value="<%=otherUtente.isBloccato()%>">
                    <input type="submit" value="Submit"
                           onchange="modificaInformazioni(this.value, 'bloccato', '${pageContext.request.contextPath}')">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <label for="deceduto">Deceduto?</label>
            </td>
            <td>
                <form action='"${pageContext.request.contextPath}/deceduto'  method="post">
                    <input type="search" style="visibility:hidden" name="id" value="<%=otherUtente.getId_utente()%>">
                    <input type="checkbox" id="deceduto" name="deceduto" value="<%=otherUtente.isDeceduto()%>">
                    <input type="submit" value="Submit"
                           onchange="modificaInformazioni(this.value, 'deceduto', '${pageContext.request.contextPath}')">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <label for="supervisor">Supervisore?</label>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}">
                    <input type="checkbox" id="supervisor" name="supervisiore" value="Placeholder">
                    <input type="submit" value="Submit"
                           onchange="modificaInformazioni(this.value, 'supervisore', Placeholder)">
                </form>
            </td>
        </tr>
    </table>
</section>
</body>
</html>
