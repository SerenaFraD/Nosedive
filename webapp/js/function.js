function publicaPost(contextPath) {
    $("#post").html("")
    console.log(post)
    $.ajax({
        type: 'POST',
        url: contextPath + '/postPublish',
        data: {
            //utente: utente,
        },
        success: function (data) {
            console.log(data)
            console.log('success')
            //nuovoPost(contextPath, data)
        },
        error: function (error) {
            console.log('error')
        }
    })
}