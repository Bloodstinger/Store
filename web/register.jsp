<%--
  Created by IntelliJ IDEA.
  User: bloodstinger
  Date: 03.07.19
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<pre><%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
    <script>
        function validate() {
            var email = document.form.email.value;
            var password = document.form.password.value;
            var conpassword = document.form.conpassword.value;

            if (email == null || email == "") {
                alert("Email can't be blank");
                return false;
            }   else if (password.length < 6) {
                alert("Password must be at least 6 characters long.");
                return false;
            } else if (password != conpassword) {
                alert("Confirm Password should match with the Password");
                return false;
            }
        }
    </script>
</head>
<body>
<div align="center">
    <form action="index.jsp" method="post">
        Email <input name="email" type="email"/><br>
        Password <input name="password" type="password"><br>
        Repeat password <input name="repeatPassword" type="password"><br>
        <button type="submit"> Register</button>
    </form>
</div>
</body>
</html>
