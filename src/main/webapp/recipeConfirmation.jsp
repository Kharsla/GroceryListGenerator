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
        <c:forEach var="ingredient" items="${ingredient}">
            <tr>
                <td>${ingredient.ingredientName}</td>
                <td>${ingredient.quantity}</td>
                <td>${ingredient.unitOfMeasure}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
