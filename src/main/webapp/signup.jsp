<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/24/21
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="container">
<form method="post" action="addUser">
    <label for="username">UserName:</label>
    <input type="text" id="username" name="username"><br>
    <label for="password1">Password:</label>
    <input type="password" id="password1" name="password1"><br>
    <label for="password2">Re-Enter Password:</label>
    <input type="password" id="password2" name="password2"><br>
    <input type="submit"/>
</form>
</div>
</body>
</html>
