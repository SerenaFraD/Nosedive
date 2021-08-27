function starAnimation() {
    target = event.target;
    target.style.backgroundColor = 'yellow';

    if (!checkAlreadyAnimated(target)) {
        target.style.backgroundColor = 'yellow';
        x = target.previousElementSibling;

        while (x != null) {
            x.style.backgroundColor = 'yellow';
            x = x.previousElementSibling;
        }
    }
}

function checkAlreadyAnimated(t) {
    target = event.target;
    next = target.nextElementSibling;

    target.style.backgroundColor = 'transparent';
    if(next != null) {
        if(next.style.backgroundColor == 'yellow') {  

            while (next != null) {
                next.style.backgroundColor = 'transparent';
                next = next.nextElementSibling;
            }

            return true;
        } else {
            return false;
        }
    }
    
}