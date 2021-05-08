package finalproject.controller;

import finalproject.entity.GroceryList;
import finalproject.entity.Recipe;
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


@WebServlet(
        name = "DisplayGeneratorRecipes",
        urlPatterns = { "/DisplayGeneratorRecipes" }
)

public class DisplayGeneratorRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GroceryList groceryList = new GroceryList();
    String cookieIds;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;

        if (cookies != null) {
            for (Cookie nextCookie : cookies) {
                if (nextCookie.getName().equals("recipes")) {
                    cookie = nextCookie;
                    cookieIds = cookie.getValue();
                    break;
                }

            }

        }
        if (cookie == null ) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("noRecipesError.jsp");
            dispatcher.forward(req, resp);

        } else {
            List<Integer> recipeIds = groceryList.getRecipeIdsFromCookies(cookieIds);
            List<Recipe> recipes = groceryList.getRecipes(recipeIds);

            req.setAttribute("recipes", recipes);
            RequestDispatcher dispatcher = req.getRequestDispatcher("generatorRecipesDisplay.jsp");
            dispatcher.forward(req, resp);

        }

    }


}
