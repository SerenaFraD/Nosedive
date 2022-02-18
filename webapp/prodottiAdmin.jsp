<%@ include file="Navigation.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}webapp/img/logoSmall.png"/>
    <link href="${pageContext.request.contextPath}/webapp/css/infoUtente.css" rel="stylesheet">
</head>
<%@ include file="Navigation.jsp" %>
<body>
<section class="info admin">
    <p>Aggiungi un nuovo prodotto</p>
    <form action="${pageContext.request.contextPath}/aggiungiProdotto" method="post">
        <table>
            <tr>
                <td><h3>Nome prodotto</h3></td>
                <td><label>
                    <input type="text" name="nome" placeholder="Nome prodotto" required>
                </label></td>
            </tr>
            <tr>
                <td><h3>Descrizione prodotto</h3></td>
                <td><label>
                    <input type="text" name="descrizione"
                           placeholder="Descrizione prodotto" required>
                </label></td>
            </tr>
            <tr>
                <td><h3>Costo</h3></td>
                <td><label>
                    <input type="text" name="costo" placeholder="euro" required>
                </label></td>
            </tr>
            <tr>
                <td><h3>Foto prodotto</h3></td>
                <td>
                    <input id="image" type="file" maxlength="200" placeholder="Inserisci link img"
                           accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*" onchange="validaFoto()"/>
                    <label id="foto" for="image">select file</label>
                </td>
            </tr>
            <tr>
                <td><h3>Categoria</h3></td>
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
                <td><h3>Punteggio minimo</h3></td>
                <td><label>
                    <input type="number" name="punteggio" value="1000" placeholder="1000" required>
                </label></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
    </form>
</section>

</body>
</html>
