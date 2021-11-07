<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="navigation.jsp" %>
<%
    List<UtenteBean> list = (List<UtenteBean>) request.getSession().getAttribute("result");
%>
<html>
<head>
    <title>Risultato ricerca</title>
</head>
<body>
<section id="standard">
    <p>Risultato ricerca:</p>
    <%if(list.isEmpty()) {%>
    <p>La tua ricerca non ha trovato risultato :(</p>

    <%} else {%>
    <table>
        <%for(UtenteBean element: list) {%>
        <tr>
            <td><%=element.getNome()%></td>
            <td><%=element.getPunteggio()%></td>
            <td><button onclick="window.location.href='<%=response.encodeURL("recuperaUtente?otherUtente=" + element.getId_utente())%>'">Profilo</button></td>
        </tr>
        <%}%>
    </table>
    <%}%>
</section>
</body>
</html>
