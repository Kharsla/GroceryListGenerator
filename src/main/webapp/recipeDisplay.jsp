<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<%@include file="head.jsp"%>
<%@include file="navbar.jsp"%>
<div class="container">
   <h2>Recipes </h2>
   <div class="row">
       <form method="post" action="filterRecipes">
           <input type="text" id="search" name="search" placeholder="Search by Name">
           <label for="filter">Meal Type</label>
           <select name="filter" id="filter">
               <option value=""> </option>
               <option value="breakfast">Breakfast</option>
               <option value="lunch">Lunch</option>
               <option value="dinner">Dinner</option>
               <option value="snack">Snack</option>
           </select>
           <input type="submit" value="Filter" class="btn btn-secondary">
       </form>
   </div>
   <div class="row">
       <table id="recipeTable" class="table">
            <thead>
                <th>Recipe</th>
                <th>Meal Type</th>
            </thead>
            <tbody>
            <c:forEach var="recipe" items="${recipes}">
                <tr>
                    <form method="post" action="storeRecipes">
                        <input name="recipe" type="hidden" value=${recipe.recipeId}>
                        <td>${recipe.recipeName}</td>
                        <td>${recipe.mealType}</td>
                        <td><input type="submit" class="btn btn-secondary" value="Add to Grocery List"></td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
       </table>
   </div>
</div>
</body>
</html>
