<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 05.07.19
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of all users #godmode</title>
</head>
<body>

<div align="center">
<% PrintWriter printWriter = response.getWriter();
    printWriter.write("<div align='center'>");
    printWriter.write("<h2> List of all users </h2>");
    printWriter.write("<table border=\"1\"\n" +
            "<tr>\n" +
            "<th>Email</th>\n" +
            "<th>Password</th>\n" +
            "</tr>");
    List<User> allUsers = (List<User>) request.getAttribute("allUsers");
    for (User user : allUsers) {
        printWriter.write("<tr>");
        printWriter.write("<td>" + user.getEmail() + "</td>");
        printWriter.write("<td>" + user.getPassword() + "</td>");
        printWriter.write("</tr>");
        printWriter.write("</div>");
    };
%>
</div>
</body>
</html>
