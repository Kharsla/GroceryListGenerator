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
<h1 class="text-center">Sign up for Grocery List Generator</h1>
<div class="container">
<form class="col-md-4 mx-auto" method="post" action="addUser">
    <div class="form-group">
    <label for="username">UserName:</label>
    <input class="form-control" type="text" id="username" name="username">
    </div>
    <div class="form-group">
    <label for="password1">Password:</label>
    <input class="form-control" type="password" id="password1" name="password1">
    </div>
    <div class="form-group">
    <label for="password2">Re-Enter Password:</label>
    <input  class="form-control" type="password" id="password2" name="password2"><br>
    </div>
    <input class="btn btn-primary" type="submit"/>
</form>
</div>
</body>
</html>
