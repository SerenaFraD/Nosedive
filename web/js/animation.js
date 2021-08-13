function disappear() {
  //document.getElementById('registration').style.display='none';

  var element = document.getElementById('register');
  var elOpacity = 0.1;

  document.getElementById('invite').style.display = 'none';
  element.style.visibility = 'visible';
  element.style.display = 'block';

  var timer = setInterval(function () {
    if (elOpacity > 1) {
      clearInterval(timer);
    }
    element.style.opacity = elOpacity;
    elOpacity += elOpacity * 0.2;
  }, 30);
}
