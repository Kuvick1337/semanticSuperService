<%@ page import="com.semantic.sparql.ServerList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Serverliste</title>
</head>
<body>

<div class="sidenav">
    <a href="index.jsp">Home</a>
    <a href="professor.jsp">Professor</a>
    <a href="lva.jsp">LVA</a>
    <a href="thema.jsp">Thema</a>
    <a class="active" href="servers.jsp">Server-Liste</a>
</div>

<div class="container">
    <div class="text-center">
        <h1 class="margin">Serverliste</h1> <br>
    </div>

    <%
        Boolean add = (Boolean) request.getAttribute("add");
        Boolean remove = (Boolean) request.getAttribute("remove");

        if (add != null && add) {
            out.println("<div class=\"alert alert-success col-sm-offset-3\">\n" +
                    "Der Server wurde erfolgreich hinzugefügt! \n" +
                    "</div>");
        } else if (add != null) {
            out.println("<div class=\"alert alert-warning col-sm-offset-3\">\n" +
                    "Der Server befindet sich bereits in der Liste!\n" +
                    "</div>");
        } else if (remove != null && remove) {
            out.println("<div class=\"alert alert-success col-sm-offset-3\">\n" +
                    "Der Server wurde erfolgreich aus der Liste entfernt! \n" +
                    "</div>");
        } else if (remove != null) {
            out.println("<div class=\"alert alert-warning col-sm-offset-3\">\n" +
                    "Der Server befindet sich nicht in der Liste!\n" +
                    "</div>");
        }
    %>

    <p class="col-sm-offset-3">Derzeit werden folgende SPARQL-Server abgefragt:</p>

    <ul class="list-group list-group-flush col-sm-offset-3">
        <%
            for (String s : ServerList.getInstance().getServers()) {
                out.println("<li class=\"list-group-item \">" + s + "</li>");
            }
        %>
    </ul>

    <form class="form-horizontal col-sm-offset-3" action="/server" method="post">
        <div class="form-group">
            <label class="control-label col-sm-1" for="server">Server:</label>
            <div class="col-sm-3">
                <input type="text" class="form-control" id="server" name="server">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-1 ">
                <button type="submit" name="add" class="btn btn-primary btn-lg">Hinzufügen</button>
                <button type="submit" name="delete" class="btn btn-secondary btn-lg">Löschen</button>
            </div>
        </div>
    </form>


    <br>

</div>
</body>
</html>

