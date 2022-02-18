<%@ page import="java.util.List" %>
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
<% List<UtenteBean> list = (List<UtenteBean>) request.getSession().getAttribute("result");%>

<section class="info">
    <p>Risultato per key</p>
    <%if(list.isEmpty()) {%>
    <p>La tua ricerca non ha dato risultato :(</p>

    <%} else {%>
    <table>
        <%for (UtenteBean element : list) {%>
        <tr>
            <td class="nome"><%=element.getNome()%>
            </td>
            <td class="punteggio"><%=element.getPunteggio()%>
            </td>
            <td>
                <% if (utente.isSupervisor()) {%>
                <button onclick="window.location.href='<%=response.encodeURL("recuperaUtente?otherUtente=" + element.getId_utente() + "&sup=true")%>'">
                    Profilo
                </button>
                <%} else {%>
                <button onclick="window.location.href='<%=response.encodeURL("recuperaUtente?otherUtente=" + element.getId_utente())%>'">
                    Profilo
                </button>
                <%}%>
            </td>
        </tr>
        <%}%>
    </table>
    <%}%>
</section>
</body>
</html>
