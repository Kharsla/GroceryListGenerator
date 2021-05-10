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
<%@include file="navbar.jsp"%>
<body>
<div class="container">
<h1>Recipes for the Generator</h1>
        <form method="get" action="removeRecipes" class="form">
                <input type="submit" class="btn btn-secondary" value="Remove All Recipes from Grocery List">
        </form>
<c:forEach var="recipe" items="${recipes}">
        <h4>${recipe.recipeName}</h4><br/>
</c:forEach>

</div>
</body>
</html>
