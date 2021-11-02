function mostraPost(utente, flag,  contextPath) {
    $("#post").html("")
    console.log(postShow)
    $.ajax({
        type: 'POST',
        url: contextPath + '/postShow',
        data: {
            utente: utente,
            flag : flag //false -> mostra post profilo, true -> mostra post homepage
        },
        success: function (data) {
            console.log(data)
            console.log('success')
            nuovoPost(contextPath, data)
        },
        error: function (error) {
            console.log('error')
        }
    })
}

function nuovoPost(contextPath, data) { //dati json
    let post = document.createElement('DIV')
    post.id = 'post'

    data.forEach(function (element, index) {
        let body = document.createElement('DIV')

        let data = document.createElement('P')
        data.className = 'data'
        data.innerText = element['timestamp']

        let nome = document.createElement('P')
        nome.className = 'nome'
        nome.innerText = element['id_utente']

        //let userPic = document.createElement('IMG')
        //userPic.setAttribute('src', element['propic'])

        let testo = document.createElement('P')
        testo.className = 'text'
        testo.innerText = element['testo']

        let img = document.createElement('IMG')
        img.className = 'img-post'
        img.setAttribute('src', element['postpic'])

        let stars = document.createElement('DIV')
        stars.className = "stars"

        let s1 = document.createElement('IMG')
        s1.onclick(starAnimation(event.target))
        s1.setAttribute('src', "img/starIcon.svg")

        let s2 = document.createElement('IMG')
        s2.onclick(starAnimation(event.target))
        s2.setAttribute('src', "img/starIcon.svg")

        let s3 = document.createElement('IMG')
        s3.onclick(starAnimation(event.target))
        s3.setAttribute('src', "img/starIcon.svg")

        let s4 = document.createElement('IMG')
        s4.onclick(starAnimation(event.target))
        s4.setAttribute('src', "img/starIcon.svg")

        let s5 = document.createElement('IMG')
        s5.onclick(starAnimation(event.target))
        s5.setAttribute('src', "img/starIcon.svg")

        let button = document.createElement('BUTTON')
        button.onclick(showCommentArea(event.target))
        button.className = 'showCommentButton'
        button.innerText = "Commenta"

        let commentoDiv = document.createElement('DIV')
        commentoDiv.id = "commento"
        commentoDiv.className = "showCommentoDiv"

        let form = document.createElement('FORM')
        form.setAttribute("action", "publish")
        form.setAttribute("method", "POST")
        form.setAttribute('name', 'commento')

        let textarea = document.createElement("textarea")
        textarea.id = "commentot"
        textarea.setAttribute("placeholder", "Commento")
        textarea.oninput(abilitateButtonComment())

        let input = document.createElement("INPUT")
        input.className = "publishComment"
        input.setAttribute("type", "submit")
        input.disabled

        body.appendChild(data)
        body.appendChild(nome)
        body.appendChild(userPic)
        body.appendChild(testo)
        body.appendChild(img)

        stars.appendChild(s1)
        stars.appendChild(s2)
        stars.appendChild(s3)
        stars.appendChild(s4)
        stars.appendChild(s5)

        body.appendChild(stars)
        body.appendChild(button)

        form.appendChild(textarea)
        form.appendChild(input)

        commentoDiv.appendChild(form)

        post.appendChild(body)
    })
    document.getElementById('post').appendChild(post)
}