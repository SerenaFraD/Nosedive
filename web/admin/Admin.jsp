<%--
  Created by IntelliJ IDEA.
  User: pavil
  Date: 23/07/2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="./StyleAdmin.css">
</head>

<body>
<%@ include file= "../_header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-sm">
        <h2>Inserimento Prodotti</h2>
        <form action="${pageContext.request.contextPath}/AdminServlet" method="POST" onsubmit="console.log('ciao')">
            <select name="categoria" id="selectCategoria" >
                <option value="Carrozzeria" id="optionCarrozzeria" selected="selected">Carrozzeria</option>
                <option value="Pneumatici" id="optionPneumatici">Pneumatici</option>
                <option value="Meccanica" id="optionMeccanica">Meccanica</option>
            </select><br>

            <label>Nome:</label><br>
            <input name="name" type="text" maxlength="20" placeholder="Inserisci nome" required><br>

            <label>Codice:</label><br>
            <input name="codProd" type="text" maxlength="5" placeholder="Inserisci codice" required><br>

            <label>Link img:</label><br>
            <input name="img" type="text" maxlength="200" placeholder="Inserisci link img" required><br>

            <label>Descrizione:</label><br>
            <textarea name="description" maxlength="100" rows="3" placeholder="Inserisci la descrizione" required></textarea><br>

            <label>Prezzo:</label><br>
            <input name="price" type="number" min="0" value="0" required><br>

            <label>Marca:</label><br>
            <input name="brand" type="text" maxlength="20" placeholder="Inserisci Marca" required><br>

            <label>Disponibilitá:</label><br>
            <input name="availability" type="text" maxlength="1" placeholder="Inserisci Disponibilitá (y o n)" required><br>

            <label>Offerta:</label><br>
            <input name="offer" type="text" maxlength="1" placeholder="Inserisci Offerta (y o n)" required><br>

            <label>Quantitá:</label><br>
            <input name="quantity" type="number" min="1" value="1" ><br>

            <div class="aggiuntivi" id="meccanica">
            <label>Impiego:</label><br>
            <input name="use" type="text" maxlength="20" placeholder="Candela" ><br>
            </div>

            <div class="aggiuntivi" id="pneumatici">
            <label>Misure:</label><br>
            <input name="measure" type="text" maxlength="9" placeholder="150/70R16"><br>

            <label>Stagione:</label><br>
            <input name="season" type="text" maxlength="20" placeholder="Invernali"><br>
            </div>

            <div class="aggiuntivi" id="carrozzeria">
            <label>Materiale:</label><br>
            <input name="material" type="text" maxlength="20" placeholder="Carbonio"><br>
            </div>
            <input name="action" value="insert" hidden>

            <button type="Submit">Invia</button>
            <input type="reset" value="Reset">
        </form>
    </div>

    <div class="col-sm">
        <h2 style="color:orangered;">Eliminazione Prodotti</h2>
        <form action="${pageContext.request.contextPath}/AdminServlet" method="POST">
            <fieldset>
                <label>Codice:</label><br>
                <input name="codProdEl" type="text" maxlength="5" placeholder="Cxxxx" required><br>

                <input type="submit" name="action" value="Delete">
            </fieldset>
        </form>

    </div>
</div>
</div>
<%@ include file= "../_footer.jsp" %>
</body>
</html>

<script src="${pageContext.servletContext.contextPath}/js/Admin.js"></script>
