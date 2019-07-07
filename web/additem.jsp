<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 04.07.19
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String isValid = (String) request.getAttribute("isValid");
    if (isValid != null) {
        response.getWriter().write("<div align=\"cenet\">");
        response.getWriter().print(isValid);
        response.getWriter().write("</div>");
    }
%>
<html>
<head>
    <title>Add New Item</title>
</head>
<body>
<H2><%= request.getParameter("isValid") == null
        ? ""
        : response.getWriter().printf("Fields could not be epty!")%></H2>
<form action="/additem" method="post">
    Name <input type="text" name="name"> <br>
    Description <input type="text" name="description"><br>
    Price <input type="number" name="price" value="0"><br>
    <input type="submit" value="Add new item "> <br>
    <input type="submit" formaction="/items" value="List of all items">
</form>
</body>
</html>
