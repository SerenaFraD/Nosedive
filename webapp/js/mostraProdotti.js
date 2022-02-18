function mostraProdotti(categoria, contextPath) {
    $("#mostraProdotti").html("")
    console.log(categoria)
    $.ajax({
        type: 'POST',
        url: contextPath + '/categoria',
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

    data.forEach(function (element, index) {
        let prod = document.createElement('DIV')
        prod.className = 'product'
        const src = contextPath + "/webapp/img/product.jpg";
        let img = document.createElement('IMG')
        img.setAttribute('src', src)
        img.setAttribute('src', element['img'])
        img.setAttribute('width', '300')
        img.setAttribute('height', '300')
        let nome = document.createElement('H1')
        nome.innerText = element['nome']
        nome.setAttribute('align', 'left')
        let descrizione = document.createElement('P')
        descrizione.innerText = element['descrizione']
        descrizione.setAttribute('align', 'left')
        let costo = document.createElement('P')
        costo.innerText = '€' + element['costo']
        costo.setAttribute('align', 'left')
        let pMin = document.createElement('P')
        pMin.innerText = element['pMin']
        pMin.setAttribute('align', 'center')
        let button = document.createElement('A')
        const link = contextPath + "/carrello?action=addCart&id=" + element['id_prodotto'];
        button.setAttribute('href', link)
        button.setAttribute('align', 'left')
        button.innerText = 'Aggiungi al carrello'

        prod.appendChild(img)
        prod.appendChild(nome)
        prod.appendChild(descrizione)
        prod.appendChild(costo)
        prod.appendChild(pMin)
        prod.appendChild(button)

        document.getElementsByClassName('container').item(0).appendChild(prod)
    })

}