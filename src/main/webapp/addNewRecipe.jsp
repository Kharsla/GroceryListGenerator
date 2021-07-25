<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/4/21
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <h1>Add a New Recipe</h1>
    <div>
        <form method="post" action="addRecipe">
            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="recipeName">RecipeName:</label>
                    <input type="text" id="recipeName" class="form-control" name="recipeName" required>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-md-4 form-group">
                    <label for="mealType">Type of Meal:</label>
                    <select  class="form-select form-select-sm" name="mealType" id="mealType">
                        <option value="breakfast">Breakfast</option>
                        <option value="lunch">Lunch</option>
                        <option value="dinner">Dinner</option>
                        <option value="snack">Snack</option>
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
                <div class="row mt-2">
                    <div class="col-md-3">
                        <input type="text"  class="form-control" class="ingredient" name="ingredient" required>
                    </div>
                    <div class="col-md-3">
                        <input name="quantity" class="form-control" class="quantity" TYPE="NUMBER" MIN="0.0" MAX="100.0" STEP="0.1" VALUE="0" SIZE="6" required>
                    </div>
                    <div class="col-md-3">
                        <select name="unitOfMeasure" class="form-select form-select-sm" class="unitOfMeasure">
                            <option value="Each">Each</option>
                            <option value="cup">cup</option>
                            <option value="mL">mL</option>
                            <option value="grams">g</option>
                            <option value="tbsp">Tbsp</option>
                        </select>
                    </div>
                </div>
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
