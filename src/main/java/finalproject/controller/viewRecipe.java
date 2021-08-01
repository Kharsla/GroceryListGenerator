package finalproject.controller;

import finalproject.entity.Ingredient;
import finalproject.entity.Recipe;
import finalproject.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(
        name = "viewRecipe",
        urlPatterns = { "/viewRecipe" }
)
public class viewRecipe extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Set<Ingredient> ingredients = new HashSet<Ingredient>();
        int recipeId = Integer.parseInt(req.getParameter("recipe"));
        Recipe recipe = (Recipe)recipeDao.getById(recipeId);
        ingredients = recipe.getIngredients();
        req.setAttribute("recipe", recipe);
        req.setAttribute("ingredients", ingredients);
        RequestDispatcher dispatcher = req.getRequestDispatcher("recipeEdit.jsp");


        dispatcher.forward(req, resp);

    }
}
