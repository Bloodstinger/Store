<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 11.07.19
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit item</title>
</head>
<body>
<form action="/additem" method="post">
    Name <input type="text" name="name" value="${name}"> <br>
    Description <input type="text" name="description" value="${description}"/><br>
    Price <input type="number" name="price" value="${price}">
    <input type="submit" value="Confirm"> <br>
    <input type="submit" formaction="/items" value="Back to all items">
</form>
</body>
</html>
