function disappear() {
  //document.getElementById('registration').style.display='none';

  const element = document.getElementById('register');
  let elOpacity = 0.1;

  document.getElementById('invite').style.display = 'none';
  element.style.visibility = 'visible';
  element.style.display = 'block';

  const timer = setInterval(function () {
    if (elOpacity > 1) {
      clearInterval(timer);
    }
    element.style.opacity = elOpacity;
    elOpacity += elOpacity * 0.1;
  }, 50);
}
