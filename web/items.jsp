<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 07.07.19
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of all items</title>
</head>
<body>
<div align="center">
    <% PrintWriter printWriter = response.getWriter();
        printWriter.write("<div align='center'>");
        printWriter.write("<h2> List of all items </h2>");
        printWriter.write("");
        printWriter.write("<a href=\"additem\"> Add new item </a>");
        printWriter.write("<table border=\"1\"\n" +
                "<tr>\n" +
                "<th>Name</th>\n" +
                "<th>Description</th>\n" +
                "<th>Price</th>\n" +
                "</tr>");
        List<Item> allItems = (List<Item>) request.getAttribute("allItems");
        for (Item item : allItems) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + item.getName() + "</td>");
            printWriter.write("<td>" + item.getDescription() + "</td>");
            printWriter.write("<td>" + item.getPrice() + "</td>");
            printWriter.write("</tr>");
            printWriter.write("</div>");
        };
    %>
    <form action="users" method="post">
        <button type="submit">Back to all users list</button>
    </form>
</div>
</body>
</html>
