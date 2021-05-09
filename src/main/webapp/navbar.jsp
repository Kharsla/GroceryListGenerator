<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/6/21
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Grocery List Generator</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="<%=request.getContextPath()%>/displayRecipes">All Recipes <span class="sr-only"></span></a>
            <a class="nav-item nav-link" href="addNewRecipe.jsp">Add a New Recipe <span class="sr-only"></span></a>
            <a class="nav-item nav-link" href="<%=request.getContextPath()%>/DisplayGeneratorRecipes"v>Recipes for Grocery List<span class="sr-only"></span></a>
            <a class="nav-item nav-link" href="<%=request.getContextPath()%>/GenerateGroceryList">My Grocery List <span class="sr-only"></span></a>
        </div>
    </div>
</nav>

</html>
