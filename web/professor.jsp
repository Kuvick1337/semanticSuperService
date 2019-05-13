<%@ page import="com.semantic.sparql.ErgebnisDto" %>
<%@ page import="com.semantic.sparql.FilterDto" %>
<%@ page import="com.semantic.sparql.SparqlService" %>
<%@ page import="com.semantic.sparql.SparqlServiceImpl2" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="error_page.jsp" %>--%>

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
    <title>Professor </title>
</head>
<body>

<div class="sidenav">
    <a href="old/home.jsp">Home</a>
    <a class="active" href="professor.jsp">Professor</a>
    <a href="lva.jsp">LVA</a>
    <a href="thema.jsp">Thema</a>
</div>

<div class="main">

    <h1 class="margin">Professor</h1> <br>

    <form action="/professor" method="post">
        <%
            SparqlService sparqlService = new SparqlServiceImpl2();
            List<String> professorFilter = sparqlService.getSuchfilterForProfessoren();

            System.out.println("found filters: " + professorFilter);

            for (String filter : professorFilter) {
                out.println("<label class=\"control-label col-sm-1\" for=\"" + filter + "\">" + filter + "</label>");
                out.println("<div class=\"col-sm-11\">");
                out.println("<input class=\"form-control\" id=\"" + filter + "\" placeholder=\"" + filter + "\" name=\"" + filter + "\">");
                out.println("</div>");
            }
        %>

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
        <%
            Enumeration en = request.getParameterNames();
            List<FilterDto> filterDtoList = new LinkedList<FilterDto>();

            String parameterName;
            String parameterValue;

            // enumerate through the keys and extract the values from the keys!
            while (en.hasMoreElements()) {
                parameterName = (String) en.nextElement();
                parameterValue = request.getParameter(parameterName);
                System.out.println(parameterName + ":" + parameterValue);

                // only add filters with actual input to search list
                if (parameterValue != null && !parameterValue.isEmpty()) {
                    filterDtoList.add(new FilterDto(parameterName, parameterValue));
                }
            }

//            if there are search filter present, then perform a search
            if (filterDtoList.size() > 0) {
                // pass filters to Sparql-Service to retrieve results
                List<ErgebnisDto> ergebnisDtoList = sparqlService.findProfessorenByFilter(filterDtoList);

                // if there are no search results, display a message
                if (filterDtoList.size() > 0 && ergebnisDtoList == null || ergebnisDtoList.size() == 0) {
                    out.println("<div class=\"alert alert-warning\">\n" +
                            "Es wurden leider keine Treffer zu Ihrer Suche gefunden!\n" +
                            "</div>");
                } else {
                    // print result table if results are there
                    for (int idx = 0; idx < ergebnisDtoList.size(); idx++) {
                        ErgebnisDto dto = ergebnisDtoList.get(idx);

                        out.println("<tr>");
                        out.println("<th scope=\"row\">" + (int) (idx + 1) + "</th>");
                        out.println("<td>" + dto.getObject() + "</td>");
                        out.println("<td>" + dto.getPredicate() + "</td>");
                        out.println("<td>" + dto.getSubject() + "</td>");
                        out.println("</tr>");
                    }
                }
            }
        %>
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
</body>
</html>
