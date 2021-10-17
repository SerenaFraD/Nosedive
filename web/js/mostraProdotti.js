function mostraProdotti(categoria, contextPath) {
    $("#mostraProdotti").html("")
    console.log(categoria)
    $.ajax({
        type: 'POST',
        url: contextPath + '/Categoria',
        data: {
            categoria: categoria
        },
        success: function (data) {
            console.log(data)
            console.log('success')
            nuovaRiga(contextPath, data)
        },
        error: function (error) {
            console.log('error')
        }
    })
}

function nuovaRiga(contextPath, data) { //dati json
    let row = document.createElement('DIV') //creo il div
    row.className = 'row row-cols-1 row-cols-md-4'; // todo modificare pls

    data.forEach(function (element, index) {
        let col = document.createElement('DIV')
        col.className = 'col mb-4' // todo modificare pls

        let card = document.createElement('DIV')
        card.className = 'card'

        let img = document.createElement('IMG')
        img.className = 'card-img-top' // todo modificare pls
        img.setAttribute('src', element['img'])
        img.setAttribute('width', '300')
        img.setAttribute('height', '300')

        let body = document.createElement('DIV')
        body.className = 'card-body' // todo modificare pls

        let nome = document.createElement('H5')
        nome.className = 'card-title'  // todo modificare pls
        nome.innerText = element['nome']
        nome.setAttribute('align', 'center')

        let descrizione = document.createElement('P')
        descrizione.className = 'card-text'   // todo modificare pls
        descrizione.innerText = element['descrizione']
        descrizione.setAttribute('align', 'center')

        let costo = document.createElement('P')
        costo.className = 'card-text'   // todo modificare pls
        costo.innerText = '€' + element['costo']
        costo.setAttribute('align', 'center')
        var link = "CartServlet?action=addCart&id=" + element['codiceProd']

        let pMin = document.createElement('P')
        pMin.className = 'card-text'   // todo modificare pls
        pMin.innerText = element['pMin']
        pMin.setAttribute('align', 'center')

        let button = document.createElement('A')
        button.setAttribute('href', link)
        button.className = 'btn btn-primary'   // todo modificare pls
        button.setAttribute('align', 'center')
        button.innerText = 'Aggiungi al carrello'

        body.appendChild(nome)
        body.appendChild(descrizione)
        body.appendChild(costo)
        body.appendChild(pMin)
        body.appendChild(button)
        card.appendChild(img)
        card.appendChild(body)
        col.appendChild(card)
        row.appendChild(col)

    })
    document.getElementById('showProd').appendChild(row)
}