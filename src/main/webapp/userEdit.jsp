<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 11.07.19
  Time: 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<div align="center">
    ${isValid}
    <form action="register" method="post">
        Email <input name="email" type="email" placeholder="Enter your email..."
                     value="${email}"><br>
        New password <input name="password" type="password"> <br>
        Repeat new password <input name="repeatPassword" type="password"><br>
        <button type="submit"> Submit</button>
        <button type="submit" formaction="users" formmethod="get"> Back to users list</button>
    </form>
</div>
</body>
</html>
