<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<body>
<div class="container">
<h1>${recipe.recipeName} was sucessfully added!</h1>
    <a href="<%=request.getContextPath()%>/displayRecipes">Go to all recipes</a>
</div>
</body>
</html>
