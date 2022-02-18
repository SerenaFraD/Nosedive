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
<body>
<%@ include file="Navigation.jsp" %>
<%
    String lavoro = (String) request.getSession().getAttribute("lavoro");
    String relazione = (String) request.getSession().getAttribute("relazione");
    UtenteBean otherUtente = (UtenteBean) request.getSession().getAttribute("altroUtente");
%>
<section class="info">
    <p>Informazioni utente</p>
    <table>
        <tr>
            <td><h3>Nome</h3></td>
            <td><%=utente.getNome()%>
            </td>
        </tr>
        <tr>
            <td><h3>Punteggio</h3></td>
            <td><%=utente.getPunteggio()%>
            </td>
        </tr>
        <tr>
            <td><h3>E-mail</h3></td>
            <td><%=utente.getEmail()%>
            </td>
        </tr>
        <tr>
            <td><h3>Data di nascita</h3></td>
            <td><%=utente.getCompleanno()%>
            </td>
        </tr>
        <tr>
            <td><h3>Foto profilo</h3></td>
            <td><%=utente.getPropic()%>
            </td>
            <td>
                <input type="file" id="image" name="file"
                       accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" onchange="validaFoto()"/>
                <label id="foto" for="image">Select file</label>
            </td>
        </tr>
        <tr>
            <td><h3>Lavoro</h3></td>
            <td><%=lavoro%>
            </td>
            <%
                if (otherUtente == null) {
            %>
            <td>
                <form action="${pageContext.request.contextPath}">
                    <select name="lavoro" id="lavoro"
                            onchange="modificaInformazioni(this.value, 'lavoro', '${pageContext.request.contextPath}')">
                        <option value=" ">Lavoro</option>
                        <option value="impiegato">Impiegato</option>
                        <option value="studente">Studente</option>
                        <option value="insegnante">Insegnante</option>
                        <option value="operaio">Operaio</option>
                    </select>
                </form>
            </td>
            <%}%>
        </tr>
        <tr>
            <td><h3>Relazione</h3></td>
            <td><%=relazione%>
            </td>
            <%if (otherUtente == null) {%>
            <td>
                <form action="${pageContext.request.contextPath}">
                    <select name="relazione" id="relazione"
                            onchange="modificaInformazioni(this.value, 'relazione', '${pageContext.request.contextPath}')">
                        <option value="">Relazione</option>
                        <option value="sposato">Sposato</option>
                        <option value="fidanzato">Fidanzato</option>
                        <option value="single">Single</option>
                    </select>
                </form>
            </td>
            <%}%>
        </tr>
    </table>
</section>
</body>
</html>



