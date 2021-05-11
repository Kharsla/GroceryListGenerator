<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
<h1>The following recipe has been added to your List: ${recipe.recipeName}</h1>
    <a href="<%=request.getContextPath()%>/displayRecipes">Go back to all recipes</a>
</div>
</body>
</html>
