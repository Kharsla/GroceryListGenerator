<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/21
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
    <h1>Grocery List Generator</h1>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>Username: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>

<p>Don't have an account? Sign up <a href="signup.jsp">here</a></p>
</body>
</html>
