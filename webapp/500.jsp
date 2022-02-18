<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.StringWriter" %>
<head>
    <title>Nosedive</title>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <link rel="icon" type="image/x-icon" href="img/logoSmall.png"/>
    <link rel="stylesheet" type="text/css" href="css/error.css">
</head>
<body>
<jsp:include page="Navigation.jsp"/>
<section>
    <h1>Errore 500: <%= exception.getMessage() %>
    </h1>
    <p>
        <%
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            out.println(stringWriter);
            printWriter.close();
            stringWriter.close();
        %>
    </p>
</section>
</body>
</html>
