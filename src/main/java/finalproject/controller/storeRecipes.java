package finalproject.controller;

import finalproject.entity.GeneratorRecipe;
import finalproject.entity.Recipe;
import finalproject.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * This servlet stores the user's selected recipes for the grocery list in the recipes cookie
 */

@WebServlet(
        name = "storeRecipes",
        urlPatterns = { "/storeRecipes" }
)
public class storeRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int recipeId = Integer.parseInt(req.getParameter("recipe"));
        GenericDao generatorRecipeDao = new GenericDao(GeneratorRecipe.class);
        GeneratorRecipe recipeToAdd = new GeneratorRecipe();
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = (Recipe)recipeDao.getById(recipeId);
        recipeToAdd.setRecipe(recipe);
        generatorRecipeDao.insert(recipeToAdd);

        req.setAttribute("recipe", recipe);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addSuccess.jsp");

        dispatcher.forward(req, resp);
    }
}
