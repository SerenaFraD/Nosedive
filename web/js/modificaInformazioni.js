function modificaInformazioni(informazione, contextPath) {
    $.ajax({
        type: 'POST',
        url: contextPath + '/Informazioni',
        data: {
            informazione: informazione
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