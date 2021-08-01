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
                    <label for="recipeName">RecipeName:</label>
                    <input type="text" id="recipeName" class="form-control" name="recipeName" value=${recipe.recipeName} required>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-4 form-group">
                    <label for="mealType">Type of Meal:</label>
                    <select  class="form-select form-select-sm" name="mealType" id="mealType">
                        <option value="breakfast" ${ingredient.mealType.equals("breakfast") ? 'selected' : ''}>Breakfast</option>
                        <option value="lunch" ${ingredient.mealType.equals("lunch") ? 'selected' : ''}>Lunch</option>
                        <option value="dinner" ${ingredient.mealType.equals("dinner") ? 'selected' : ''}>Dinner</option>
                        <option value="snack" ${ingredient.mealType.equals("snack") ? 'selected' : ''}>Snack</option>
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
                    <div class="col-md-3">
                        <input type="text"  class="form-control" class="ingredient" name="ingredient" value=${ingredient.ingredientName} required>
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
            <button id="btn" class="btn btn-secondary">Add more ingredients</button>
            <input class="btn btn-primary" type="submit" Value="submit">
        </form>
    </div>
</div>

</body>
</html>

<!--Source: https://stackoverflow.com/questions/49507557/how-to-dynamically-add-rows-to-a-form-in-html-when-i-click-on-add-row-button -->
<script>
    var count=1;
    $("#btn").click(function(){

        $("#container").append(addNewRow(count));
        count++;
        return false;
    });

    function addNewRow(count){
        var newrow=
            '<div class="row mt-2">' +
            '<div class="col-md-3">' +
            '<input type="text"  class="form-control" class="ingredient" name="ingredient" required>' +
            '</div>' +
            '<div class="col-md-3">' +
            '<input name="quantity" class="form-control" class="quantity" TYPE="NUMBER" MIN="0.0" MAX="100.0" STEP="0.1" VALUE="0" SIZE="6" required>' +
            '</div>' +
            '<div class="col-md-3">' +
            '<select name="unitOfMeasure" class="form-select form-select-sm" class="unitOfMeasure">' +
            '<option value="Each">Each</option>' +
            '<option value="cup">cup</option>' +
            '<option value="mL">mL</option>' +
            '<option value="grams">g</option>' +
            '<option value="tbsp">Tbsp</option>' +
            '</select>' +
            '</div>' +
            '</div>';
        return newrow;
    }
</script>
