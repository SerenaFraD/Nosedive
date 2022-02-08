function menu() {
    var ul = document.getElementsByClassName('hidden');
    li = ul[0].getElementsByTagName('li');

    if (window.getComputedStyle(li[1]).visibility == 'hidden') {
        console.log("cioa");
        state = 'visible';
    } else {
        console.log("hey");
        state = 'hidden';
    }

    for(i=1; i < li.length; i++) {
        console.log(li[i]);
        li[i].style.visibility = state;        
    }
}
