package finalproject.controller;

import finalproject.entity.GeneratorRecipe;
import finalproject.entity.GroceryList;
import finalproject.entity.Recipe;
import finalproject.entity.User;
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
import java.util.List;
import java.util.Set;

/**
 * This servlet displays all the recipes that will be used to generate the grocery list
 */
@WebServlet(
        name = "DisplayGeneratorRecipes",
        urlPatterns = { "/DisplayGeneratorRecipes" }
)

public class DisplayGeneratorRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GroceryList groceryList = new GroceryList();
    String cookieIds;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
        User user = users.get(0);
        Set<GeneratorRecipe> generatorRecipes = user.getGeneratorRecipes();
        if (generatorRecipes.isEmpty()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("noRecipesError.jsp");
            dispatcher.forward(req, resp);
        } else {
            Set<Recipe> recipes = groceryList.getRecipes(generatorRecipes);

            req.setAttribute("recipes", recipes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("generatorRecipesDisplay.jsp");
            dispatcher.forward(req, resp);

        }

    }


}
