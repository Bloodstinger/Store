<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 04.07.19
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Item</title>
</head>
<body>
<H2>${isEmpty}</H2>
<form action="/items" method="post">
    Name <input type="text" name="name"> <br>
    Description <input type="text" name="description">
    Price <input type="number" name="price">
    <input type="submit" value="add">
</form>
</body>
</html>
