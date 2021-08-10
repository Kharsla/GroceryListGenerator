<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 8/7/21
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<head>
    <title>User Profile</title>
</head>
<body>
<p>UserName: ${user.userName}</p>
<a href="changePassword.jsp">Change Password</a>
</body>
</html>
