function buy() {
    alert("Acquisto avvenuto con successo")
    $.ajax({
        type: 'POST',
        url: ' ${pageContext.request.contextPath}/CartServlet',
        data: {
            action: 'clearCart'
        },
        success: function () {
            location.reload(true)
        }
    })
}