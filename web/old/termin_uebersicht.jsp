<%@ page import="com.semantic.model.Termin" %>
<%@ page import="com.semantic.repository.TerminRepository" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <title>FESSS - Terminübersicht</title>
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

<div class="container">
    <h2>Großer Festsaal
        <small>alle Termine</small>
    </h2>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <tr>
                    <th>Termin-Name</th>
                    <th>Startdatum</th>
                    <th>Endatum</th>
                    <th>Teilnehmer</th>
                    <th>Verpflegung</th>
                </tr>
                <%
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");

                    for (Termin termin : TerminRepository.getTermineForSaal(1)) {
                        out.println("<tr><td>" + termin.getName()
                                + "</td><td>" + formatter.format(termin.getStartDatum())
                                + "</td><td>" + formatter.format(termin.getEndDatum())
                                + "</td><td>" + termin.getParticipants()
                                + "</td><td><span class=\"glyphicon glyphicon-" + (termin.getNeedFood() ? "ok" : "remove") + "\"></span></td></tr>");
                    }
                %>
            </table>
        </div>
    </div>
</div>
<br/>

<div class="container">
    <h2>Kleiner Festsaal
        <small>alle Termine</small>
    </h2>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <tr>
                    <th>Termin-Name</th>
                    <th>Startdatum</th>
                    <th>Endatum</th>
                    <th>Teilnehmer</th>
                    <th>Verpflegung</th>
                </tr>
                <%
                    for (Termin termin : TerminRepository.getTermineForSaal(2)) {
                        out.println("<tr><td>" + termin.getName()
                                + "</td><td>" + formatter.format(termin.getStartDatum())
                                + "</td><td>" + formatter.format(termin.getEndDatum())
                                + "</td><td>" + termin.getParticipants()
                                + "</td><td><span class=\"glyphicon glyphicon-" + (termin.getNeedFood() ? "ok" : "remove") + "\"></span></td></tr>");
                    }
                %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
