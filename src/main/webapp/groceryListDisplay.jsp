<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<%@include file="head.jsp"%>
<body>
<div>
    <h2>Recipes </h2>
    <form method="get" action="GenerateGroceryList">
        <input type="submit" value="Generate My GroceryList">
    </form>

    <table id="ingredientTable">
        <tbody>
        <c:forEach var="ingredient" items="${ingredients}">
                <td>${ingredient.quantity}</td>
                <td>${ingredient.unitOfMeasure}</td>
                <td>${ingredient.ingredientName}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>
</body>
</html>
