function modificaInformazioni(informazione, categoria, contextPath) {
    $.ajax({
        type: 'POST',
        url: contextPath + '/informazioniUtente',
        data: {
            informazione: informazione,
            tabella: categoria
        },
        success: function (data) {
            console.log(data)
            console.log('success')
        },
        error: function (error) {
            console.log('error')
        }
    })
}