<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/4/21
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add A New Recipe</title>
</head>
<body>
<form method="get" action="addRecipe">
    <label for="recipeName">RecipeName:</label><br>
    <input type="text" id="recipeName" name="recipeName"><br>

    <label for="mealType">Type of Meal:</label>

    <select name="mealType" id="mealType">
        <option value="Breakfast">Breakfast</option>
        <option value="Lunch">Lunch</option>
        <option value="Dinner">Dinner</option>
        <option value="Snack">Snack</option>
    </select>
   <br/>
    <label>Ingredient</label>
    <label>Quantity</label>
    <label>Unit of Measure</label>
    <br/>
    <input type="text" class="ingredient" name="ingredient"><br/>
    <INPUT TYPE="NUMBER" MIN="0" MAX="100" STEP="1" VALUE="0" SIZE="6">
    <select name="quantity" id="quantity">
        <option value="Each">Each</option>
        <option value="cup">cup</option>
        <option value="mL">mL</option>
        <option value="grams">g</option>
        <option value="tbsp">Tbsp</option>
    </select>
    <input type="submit">
</form>

</body>
</html>