<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<div>
    <h2>Recipes </h2>
   <table id="recipeTable">
        <thead>
        <th>Recipe </th>
        <th>Recipe Name </th>
        <th>Meal Type </th>
        </thead>
        <tbody>
        <c:forEach var="recipe" items="${recipes}">
            <tr>
                <td>${recipe.recipeId}</td>
                <td>${recipe.recipeName}</td>
                <td>${recipe.mealType}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
