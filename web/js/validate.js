var borderOk = '2px solid #080';
var borderNo = '2px solid #f00';
var passwordOk = false;
var nomeOk = false;
var emailOk = false;

function validaPassword() {
    var inputpw = document.forms['registration']['pwd'];
    var inputpwconf = document.forms['registration']['pwdConf'];
    var password = inputpw.value;

    if (password.length >= 8 && password.toUpperCase() != password
        && password.toLowerCase() != password && /[0-9]/.test(password)) {
        inputpw.style.border = borderOk;

        if (password == inputpwconf.value) {
            inputpwconf.style.border = borderOk;
            passwordOk = true;
        } else {
            inputpwconf.style.border = borderNo;
            passwordOk = false;
        }
    } else {
        inputpw.style.border = borderNo;
        inputpwconf.style.border = borderNo;
        passwordOk = false;
    }

    cambiaStatoRegistrami();
}

function validaPasswordLogin() {
    var inputpw = document.forms['login']['pwd'];
    var password = inputpw.value;

    if (password.length >= 8 && password.toUpperCase() != password
        && password.toLowerCase() != password && /[0-9]/.test(password)) {
        passwordOk = true;
    } else {
        passwordOk = false;
    }

    cambiaStatoLogme();
}

function validaNome() {
    var inputNome = document.forms['registration']['nome'];

    if (inputNome.value.trim().length > 0
        && inputNome.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
        inputNome.style.border = borderOk;
        nomeOk = true;
    } else {
        inputNome.style.border = borderNo;
        nomeOk = false;
    }

    cambiaStatoRegistrami();
}

function validaEmail() {
    var input = document.forms['registration']['email'];
    if (input.value.match(/^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w+)+$/)) {
        input.style.border = borderOk;
        emailOk = true;
    } else {
        input.style.border = borderNo;
        emailOk = false;
    }

    cambiaStatoRegistrami();
}

function validaEmailLogin() {
    var input = document.forms['login']['email'];
    if (input.value.match(/^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w+)+$/)) {
        emailOk = true;
    } else {
        emailOk = false;
    }

    cambiaStatoLogme();
}

function cambiaStatoRegistrami() {
    if (passwordOk && nomeOk && emailOk) {
        document.getElementById('submit').disabled = false;
        document.getElementById('result').innerHTML = '';
    } else {
        document.getElementById('submit').disabled = true;
        document.getElementById('result').innerHTML = 'Verifica che tutti i campi siano in verde.';
    }
}

function cambiaStatoLogme() {
    if (passwordOk && emailOk) {
        document.getElementById('submit').disabled = false;
        document.getElementById('result').innerHTML = '';
    } else {
        document.getElementById('submit').disabled = true;
        document.getElementById('result').innerHTML = 'Verifica email o password';
    }
}

function validaFoto() {
    var formData = new FormData();
    var file = document.getElementById("image").files[0];
    formData.append("Filedata", file);
    var t = file.type.split('/').pop().toLowerCase();
    if (t != "jpeg" && t != "jpg" && t != "png" && t != "bmp" && t != "gif") {
        alert('Inserire una foto valida');
        document.getElementById("img").value = '';
        return false;
    }

    var fsize = (file.size / 1024 / 1024).toFixed(2);
    if (fsize > 2) {
        alert('Dimensione massima 2MB');
        document.getElementById(id).value = '';
        return false;
    }
    return true;
}
