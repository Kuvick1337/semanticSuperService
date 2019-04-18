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
        <title>Professor </title>
    </head>
    <body>

    <div class="sidenav">
        <a href="home.jsp">Home</a>
        <a class="active" href="professor.jsp">Professor</a>
        <a href="lva.jsp">LVA</a>
        <a href="thema.jsp">Thema</a>
    </div>

    <div class="main">

        <h1 class="margin">Professor</h1> <br>

        <form>
            <div class="form-group">
                <label class="control-label col-sm-1" for="name">Name</label>
                <div class="col-sm-11">
                    <input class="form-control" id="name" placeholder="Name"
                           name="name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-1" for="title">Title</label>
                <div class="col-sm-11">
                    <input class="form-control" id="title" placeholder="Title"
                           name="title">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-1 col-sm-11">
                    <button type="submit" class="btn btn-primary btn-lg">Suchen</button>
                </div>
            </div>
        </form>


        <br>

        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nr</th>
                <th scope="col">Title</th>
                <th scope="col">Thema</th>
                <th scope="col">Author</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>

    </div>

    </div>
    </body>
</html>

