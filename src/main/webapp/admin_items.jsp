<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 07.07.19
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of all items</title>
</head>
<body>
<div align="center">
    <h2> List of all items</h2>
    <a href="/admin/additem">Add new item</a> <br>
    <form>
    <input formmethod="get" formaction="/admin/users" type="submit" value="Back to all users">
    </form>
    <form action="/logout" method="post">
        <button type="submit">Logout</button>
    </form>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <c:forEach var="item" items="${allItems}">
        <tr>
            <td>${item.getName()}</td>
            <td>${item.getDescription()}</td>
            <td>${item.getPrice()}</td>
            <td>
                <form action="/admin/itemEdit" method="get">
                    <input type="hidden" name="id" value="${item.getId()}">
                    <button type="submit"> Edit</button>
                </form>
            </td>
            <td>
                <form action="/admin/itemDelete" method="post">
                    <button name="delete" type="submit" value="${item.getId()}">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tr>
    </table>
</div>
</body>
</html>
