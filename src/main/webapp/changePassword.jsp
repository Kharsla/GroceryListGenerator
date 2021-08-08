<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 8/7/21
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Password</title>
</head>
<body>
<form method="post" action="updatePassword">
    <div class="form-group">
        <label for="passwordOne">Password:</label>
        <input class="form-control" type="password" id="passwordOne" name="passwordOne">
    </div>
    <div class="form-group">
        <label for="passwordTwo">Re-Enter Password:</label>
        <input  class="form-control" type="password" id="passwordTwo" name="passwordTwo"><br>
    </div>
    <input class="btn btn-primary" type="submit"/>
</form>

</body>
</html>
