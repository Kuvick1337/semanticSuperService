<%@ page import="com.semantic.service.TerminService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="../error_page.jsp" %>

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
    <link href="../style.css" rel="stylesheet" type="text/css">
    <title>FESSS - Terminanfrage</title>
</head>
<body>
<div class="header_area">
    <div class="jumbotron text-center">
        <h1>semantic Super Service</h1>
    </div>

    <ul>
        <li><a href="../index.jsp">Home</a></li>
        <li><a href="termin_uebersicht">Terminübersicht</a></li>
        <li><a href="termin_anfrage.jsp">Terminanfrage</a></li>
        <li><a href="termin_buchen.jsp">Termin buchen</a></li>
        <li><a href="termin_loeschen.jsp">Termin löschen</a></li>
    </ul>

</div>

<%
    int saalId = Integer.parseInt(request.getParameter("saal"));
    String datumVon = request.getParameter("date_from");
    String datumbis = request.getParameter("date_to");

    if (TerminService.isSaalAvailable(saalId, datumVon, datumbis)) {
        out.println("<div class=\"alert alert-danger\">\n" +
                " Der gewaehlte Saal ist zur gewuenschten Zeit leider nicht verfuegbar!\n" +
                "</div>");
    } else{
        out.println("<div class=\"alert alert-success\">\n" +
                "  Saal ist verfuegbar!!! \n" +
                "</div>");
    }
%>

</body>
</html>
