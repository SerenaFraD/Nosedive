function abilitateButton() {
    target = event.target;
    path = target.offsetParent;
    b = path.getElementsByClassName('publish');

    b[0].style.backgroundColor = 'yellow';
    b[0].disabled = false;

    console.log(b[0]);
}


function abilitateButtonComment() {
    target = event.target;
    path = target.offsetParent;
    b = path.getElementsByClassName('publishComment');

    b[0].style.backgroundColor = 'yellow';
    b[0].disabled = false;

    console.log(b[0]);
}