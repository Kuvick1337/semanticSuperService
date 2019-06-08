<%@ page import="com.semantic.sparql.ServerList" %>
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

<div class="main">
    <div class="text-center">
        <h1 class="margin">Serverliste</h1> <br>
    </div>

    <p>Derzeit werden folgende Server abgefragt:</p>

    <ul class="list-group list-group-flush">
        <%
            for (String s : ServerList.getServers()) {
                out.println("<li class=\"list-group-item\">" + s + "</li>");
            }
        %>
    </ul>

    <br>

</div>
</body>
</html>

