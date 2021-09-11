<%@ page import="model.UtenteBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <% UtenteBean ricercato = (UtenteBean) request.getSession().getAttribute("ricercato");

    if (ricercato == null) {
        response.sendRedirect(response.encodeRedirectURL("index.jsp"));
    } else {
        request.getSession().removeAttribute("ricercato");
    }

%>

<body>
<section id="standard">
    <p>Informazioni utente</p>
    <table>
        <tr>
            <td>Nome</td>
            <td><%=ricercato.getNome()%>
            </td>
        </tr>
        <tr>
            <td>Punteggio</td>
            <td>punteggio</td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><%=ricercato.getEmail()%>
            </td>
        </tr>
        <tr>
            <td>Data di nascita</td>
            <td>dd/mm/yyyy</td>
        </tr>
        <tr>
            <td>Foto profilo</td>
            <td>foto</td>
            <td>
                <input type="file" id="image" name="file"
                       accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" onchange="validaFoto()"/>
                <label for="image">Select file</label>
            </td>
        </tr>
        <tr>
            <td>Lavoro</td>
            <td>lavoro</td>
            <td>
                <select name="lavoro" id="lavoro">
                    <option value=" ">Lavoro</option>
                    <option value="impiegato">Impiegato</option>
                    <option value="studente">Studente</option>
                    <option value="insegnante">Insegnante</option>
                    <option value="operaio">Operaio</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Relazione</td>
            <td>relazione</td>
            <td>
                <select name="relazione" id="relazione">
                    <option value="">Relazione</option>
                    <option value="sposato">Sposato</option>
                    <option value="fidanzato">Fidanzato</option>
                    <option value="single">Single</option>
                </select>
            </td>
        </tr>
    </table>

</section>

</body>
</html>



