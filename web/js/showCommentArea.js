function showCommentArea() {
    target = event.target;
    target.style.display = 'none';
    x = target.nextElementSibling;
    x.style.display = 'block';
}
