<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/6/21
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<c:forEach var="recipe" items="${recipes}">
        <td>${recipe.recipeId}</td>
        <td>${recipe.recipeName}</td>
        <td>${recipe.mealType}</td>
</c:forEach>
</body>
</html>
