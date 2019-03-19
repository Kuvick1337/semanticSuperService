<%@ page import="com.semantic.model.Saal" %>
<%@ page import="com.semantic.repository.SaalRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error_page.jsp" %>

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
    <title>FESSS - Terminanfrage</title>
</head>
<body>
<div class="header_area">
    <div class="jumbotron text-center">
        <h1>semantic Super Service</h1>
    </div>

    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="termin_uebersicht.jsp">Terminübersicht</a></li>
        <li><a href="termin_anfrage.jsp">Terminanfrage</a></li>
        <li><a href="termin_buchen.jsp">Termin buchen</a></li>
        <li><a href="termin_loeschen.jsp">Termin löschen</a></li>
    </ul>

</div>


<div class="container">
    <%
        String isFrei = (String) request.getAttribute("isfrei");
        String isIncomplete = (String) request.getAttribute("incomplete");

        if (isIncomplete != null && "true".equals(isIncomplete)) {
            out.println("<div class=\"alert alert-warning\">\n" +
                    "Bitte füllen Sie das Formular ganz aus!\n" +
                    "</div>");
        } else if (isFrei != null && "true".equals(isFrei)) {
            out.println("<div class=\"alert alert-success\">\n" +
                    "Der Saal ist verfügbar!!! \n" +
                    "</div>");

        } else if (isFrei != null && "false".equals(isFrei)) {
            out.println("<div class=\"alert alert-danger\">\n" +
                    " Der gewählte Saal ist zur gewünschten Zeit leider nicht verfügbar!\n" +
                    "</div>");
        }
    %>
    <br>
    <form class="form-horizontal" action="/termin_anfrage" method="post">

        <div class="form-group">
            <label class="control-label col-sm-4" for="saal">Saal:</label>
            <div class="col-sm-6">
                <select name="saal" class="form-control" id="saal" name="saal">
                    <%
                        for (Saal saal : SaalRepository.getSäle()) {
                            out.println("<option value=\"" + saal.getId() + "\">" + saal.getName() + "</option>");
                        }
                    %>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-4" for="date_from">Datum von:</label>
            <div class="col-sm-4">
                <input type="datetime-local" class="form-control" id="date_from" placeholder="Startdatum"
                       name="date_from">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-4" for="date_to">Datum bis:</label>
            <div class="col-sm-4">
                <input type="datetime-local" class="form-control" id="date_to" placeholder="Enddatum" name="date_to">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
                <button type="submit" class="btn btn-primary btn-lg">Termin prüfen</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
