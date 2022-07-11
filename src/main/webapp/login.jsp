<%--
  Created by IntelliJ IDEA.
  User: begin
  Date: 7/8/22
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>Login Page</h1>
<form action="/login" method="POST">
    <label>Username
        <input name="username" type="text" placeholder="Enter username">
    </label>
    <br>
    <label>Password
        <input name="password" type="text" placeholder="Enter password">
    </label>
    <br>
    <button>Login</button>

</form>
</body>
</html>
