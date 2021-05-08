<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sucessfully Added Recipe</title>
</head>
<%@include file="navbar.jsp"%>
<body>
<h1>The following recipe has been added to your List:</h1>
<p>${recipe.recipeName}</p>
<p>${recipe.mealType}</p>

</body>
</html>
