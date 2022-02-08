function logout(contextPath) {
    console.log(logout)
    $.ajax({
        type: 'get',
        url: contextPath + '/logout',
        data: {
            //utente: utente,
        },
        success: function (data) {
            // console.log(data)
            console.log('success')
            //nuovoPost(contextPath, data)
        },
        error: function (error) {
            console.log('error')
        }
    })
}