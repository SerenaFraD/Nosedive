<%@ include file="navigation.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Aggiungi prodotto">
    <meta name="author" content="Serena D'Urso">

    <title>Aggiungi prodotto</title>

    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link href="css/infoUtente.css" rel="stylesheet">
</head>
<body>

<section id="standard">
    <p>Aggiungi un nuovo prodotto</p>
    <form action="${pageContext.servletContext.contextPath}/aggiungiProdotto" method="post">
        <table>
            <tr>
                <td>Nome prodotto</td>
                <td><input type="text" name="nome" placeholder="Nome prodotto" required></td>
            </tr>
            <tr>
                <td>Descrizione prodotto</td>
                <td><input type="text" name="descrizione"
                           placeholder="Descrizione prodotto" required></td>
            </tr>
            <tr>
                <td>Costo</td>
                <td><input type="text" name="costo" placeholder="euro" required></td>
            </tr>
            <tr>
                <td>Foto prodotto</td>
                <td>
                    <input id="image" type="file" maxlength="200" placeholder="Inserisci link img"
                           accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" onchange="validaFoto()"/>
                    <label for="image">Select file</label>
                </td>
            </tr>
            <tr>
                <td>Categoria</td>
                <td>
                    <select name="categoria" id="categoria">
                        <option value="auto">Automobili</option>
                        <option value="affitto">Affitto</option>
                        <option value="internet">Internet</option>
                        <option value="acquistoImmobili">Immobili</option>
                        <option value="educazione">Educazione</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Punteggio minimo</td>
                <td><input type="number" name="punteggio" value="1000" placeholder="1000" required></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</section>

</body>
</html>
