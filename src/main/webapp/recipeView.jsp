<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Recipe</title>
</head>
<body>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<h1>${recipe.recipeName}</h1>
<h2>Meal Type: ${recipe.mealType}</h2>
<div class="row mt-2" id="container">
    <div class="row">
        <div class="col-md-3">
            <h2>Ingredient</h2>
        </div>
        <div class="col-md-3">
            <h2>Quantity</h2>
        </div>
        <div class="col-md-3">
            <h2>Unit of Measure</h2>
        </div>
    </div>
<c:forEach var="ingredient" items="${ingredients}">
    <div class="row mt-2">
        <input name="ingredientId" type="hidden" value=${ingredient.ingredientId}>
        <div class="col-md-3">
            <p>${ingredient.ingredientName}</p>
        </div>
        <div class="col-md-3">
            <p>${ingredient.quantity}</p>
        </div>
        <div class="col-md-3">
                <p>${ingredient.unitOfMeasure}</p>
        </div>
    </div>
    </c:forEach>


</body>
</html>
