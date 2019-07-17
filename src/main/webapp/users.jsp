<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 05.07.19
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of all users #godmode</title>
</head>
<body>
<div align="center">
    <h2> List of all users</h2>
    <a href="/register.jsp"> Add new user.</a> <br>
    <a href="/admin/items">List of all items</a> <br>
    <form action="/logout" method="post">
        <button type="submit">Logout</button>
    </form>
    <table border="1">
        <tr>Email</tr>
        <tr> Password</tr>
        <tr> Role</tr>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <form action="userDelete" method="post">
                        <button name="delete" type="submit" value="${user.getId()}"> Delete</button>
                    </form>
                    <form action="userEdit" method="get">
                        <input type="hidden" name="id" value="${user.getId()}">
                        <button type="submit"> Edit</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
