<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<head>
    <title>Edit Recipe</title>
</head>
<body>
<div class="container">
    <h1>Edit Recipe</h1>
    <div>
        <form method="post" action="editRecipe">
            <div class="row">
                <div class="col-md-4 form-group">
                    <input name="recipe" type="hidden" value=${recipe.recipeId}>
                    <label for="recipeName">RecipeName:</label>
                    <input type="text" id="recipeName" class="form-control" name="recipeName" value="${recipe.recipeName}" required>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-4 form-group">
                    <label for="mealType">Type of Meal:</label>
                    <select  class="form-select form-select-sm" name="mealType" id="mealType">
                        <option value="breakfast" ${recipe.mealType.equals("breakfast") ? 'selected' : ''}>Breakfast</option>
                        <option value="lunch" ${recipe.mealType.equals("lunch") ? 'selected' : ''}>Lunch</option>
                        <option value="dinner" ${recipe.mealType.equals("dinner") ? 'selected' : ''}>Dinner</option>
                        <option value="snack" ${recipe.mealType.equals("snack") ? 'selected' : ''}>Snack</option>
                    </select>
                </div>
            </div>
            <div class="row mt-2" id="container">
                <div class="row">
                    <div class="col-md-3">
                        <label>Ingredient</label>
                    </div>
                    <div class="col-md-3">
                        <label>Quantity</label>
                    </div>
                    <div class="col-md-3">
                        <label>Unit of Measure</label>
                    </div>
                </div>
<c:forEach var="ingredient" items="${ingredients}">
                <div class="row mt-2">
                    <input name="ingredientId" type="hidden" value=${ingredient.ingredientId}>
                    <div class="col-md-3">
                        <input type="text"  class="form-control" class="ingredient" name="ingredient" value="${ingredient.ingredientName}" required>
                    </div>
                    <div class="col-md-3">
                        <input name="quantity" class="form-control" class="quantity" TYPE="NUMBER" MIN="0.0" MAX="100.0" STEP="0.1" SIZE="6" VALUE=${ingredient.quantity} required>
                    </div>
                    <div class="col-md-3">
                        <select name="unitOfMeasure" class="form-select form-select-sm" class="unitOfMeasure">
                            <option value="Each" ${ingredient.unitOfMeasure.equals("Each") ? 'selected' : ''}>Each</option>
                            <option value="cup" ${ingredient.unitOfMeasure.equals("cup") ? 'selected' : ''}>cup</option>
                            <option value="mL" ${ingredient.unitOfMeasure.equals("mL") ? 'selected' : ''}>mL</option>
                            <option value="grams" ${ingredient.unitOfMeasure.equals("grams") ? 'selected' : ''}>g</option>
                            <option value="tbsp" ${ingredient.unitOfMeasure.equals("tbsp") ? 'selected' : ''}>Tbsp</option>
                        </select>
                    </div>
                </div>
</c:forEach>
            </div>
            <input class="btn btn-primary" type="submit" Value="submit">
        </form>
    </div>
</div>

</body>
</html>

<!--Source: https://stackoverflow.com/questions/49507557/how-to-dynamically-add-rows-to-a-form-in-html-when-i-click-on-add-row-button -->

