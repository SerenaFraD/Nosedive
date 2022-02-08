function ricerca() {
    var input;
    var filtro;
    var lista;
    var voci;
    var x;
    var i;
    var testo;
    input = document.getElementById("ricercaLibri");
    filtro = input.value.toUpperCase();
    lista = document.getElementById("listaLibri");
    voci = lista.getElementsByTagName("span");
    for (i = 0; i < voci.length; i++) {
        x = lista.getElementsByTagName("span")[i];
        testo = x.textContent || x.innerText;
        if (testo.toUpperCase().indexOf(filtro) > -1) {
            voci[i].style.display = "";
        } else {
            voci[i].style.display = "none";
        }
    }
}