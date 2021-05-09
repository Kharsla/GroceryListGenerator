<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/9/21
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
  Source: https://www.concretepage.com/java-ee/jsp-servlet/form-based-authentication-in-jsp-using-tomcat
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("index.jsp");
%>

</body>
</html>
