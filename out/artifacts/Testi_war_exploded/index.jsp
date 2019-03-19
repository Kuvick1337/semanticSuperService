<%--
  Created by IntelliJ IDEA.
  User: Franz
  Date: 14/04/2018
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.fesss.repository.TestRepository"%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>FESSS - Festsaal Super Service</title>
  </head>
  <body>
      Hello World!
      Der Rowcount aktuell ff= <%=TestRepository.getRowcount(out)   %>
      Der Rowcount aktuell ff= <% out.println(TestRepository.getRowcount(out) );  %>
  </body>
</html>
