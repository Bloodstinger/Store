<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 05.07.19
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of all users #godmode</title>
</head>
<body>
<div align="center">
    <h2> List of all users</h2>
    <a href="register"> Add new user.</a> <br>
    <a href="items">List of all items</a> <br>
    <table border="1">
        <tr>Email</tr>
        <tr> Password</tr>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>
                    <form action="userDelete" method="post">
                        <button name="delete" type="submit" value="${user.getId()}"> Delete</button>
                    </form>
                    <form action="userEdit" method="post">
                        <button name="edit" type="submit" value="${user.getId()}"> Edit</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
