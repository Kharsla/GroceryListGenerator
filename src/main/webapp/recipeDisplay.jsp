<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<%@include file="navbar.jsp"%>
<div>
    <h2>Recipes </h2>
   <table id="recipeTable">
        <thead>
        <th>Recipe </th>
        <th>Recipe Name </th>
        <th>Meal Type </th>
        </thead>
        <tbody>
        <form method="post" action="filterRecipes">
            <input type="text" id="search" name="search">
            <select name="filter" id="filter">
                <option value=""> </option>
                <option value="breakfast">Breakfast</option>
                <option value="lunch">Lunch</option>
                <option value="dinner">Dinner</option>
                <option value="snack">Snack</option>
            </select>
            <input type="submit" value="Search">
        </form>
        <c:forEach var="recipe" items="${recipes}">
        <form method="post" action="storeRecipes">
                <input name="recipe" type="hidden" value=${recipe.recipeId}>
                <td>${recipe.recipeId}</td>
                <td>${recipe.recipeName}</td>
                <td>${recipe.mealType}</td>
                <td><input type="submit" value="Add to Grocery List"></td>
            </tr>
        </form>
        </c:forEach>
        <form method="post" action="GenerateGroceryList">
            <input type="submit" value="Generate GroceryList">
        </form>

        </tbody>
    </table>
</div>
</body>
</html>
