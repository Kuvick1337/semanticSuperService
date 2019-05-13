<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>UPS - Fehler!</title>
</head>
<body>
<div class="header_area">
    <div class="jumbotron text-center">
        <h1>Festsaal Super Service</h1>
    </div>

    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="old/termin_uebersicht.jsp">Terminübersicht</a></li>
        <li><a href="old/termin_anfrage.jsp">Terminanfrage</a></li>
        <li><a href="old/termin_buchen.jsp">Termin buchen</a></li>
        <li><a href="old/termin_loeschen.jsp">Termin löschen</a></li>
    </ul>
</div>

<div class="container">
    <div class="alert alert-danger">
        <h2><strong>Ooops!...</strong> Leider ist ein Fehler aufgetreten!</h2>
    </div>
    <table width="60%" border="1">
        <tr valign="top">
            <td width="40%"><b>Error:</b></td>
            <td>${pageContext.exception}</td>
        </tr>

        <tr valign="top">
            <td><b>URI:</b></td>
            <td>${pageContext.errorData.requestURI}</td>
        </tr>

        <tr valign="top">
            <td><b>Status code:</b></td>
            <td>${pageContext.errorData.statusCode}</td>
        </tr>

        <tr valign="top">
            <td><b>Stack trace:</b></td>
            <td>
                <c:forEach var="trace"
                           items="${pageContext.exception.stackTrace}">
                    <p>${trace}</p>
                </c:forEach>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
