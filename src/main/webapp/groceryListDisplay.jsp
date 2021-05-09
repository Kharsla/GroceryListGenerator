<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
    <div class="col-md-6">
    <table class="table">
        <thead>
        <tr>
            <th colspan="2">My Grocery List</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ingredient" items="${ingredients}">
            <tr>
                <td>${ingredient.quantity}  ${ingredient.unitOfMeasure}</td>
                <td>${ingredient.ingredientName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    </div>
</div>
</body>
</html>
