package finalproject.controller;

import finalproject.entity.GroceryList;
import finalproject.entity.Ingredient;
import finalproject.entity.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "GenerateGroceryList",
        urlPatterns = { "/GenerateGroceryList" }
)
public class GenerateGroceryList extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GroceryList groceryList = new GroceryList();
    String cookieIds;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;

        if(cookies != null) {
            for (Cookie nextCookie : cookies) {
                if (nextCookie.getName().equals("recipes")) {
                    cookie = nextCookie;
                    cookieIds = cookie.getValue();
                    break;
                }

            }
        }

        List<Integer> recipeIds = groceryList.getRecipeIdsFromCookies(cookieIds);
        List<Recipe> recipes = groceryList.getRecipes(recipeIds);
        List<Ingredient> ingredients = groceryList.getIngredientsFromRecipes(recipes);

        //Display grocery List

    }
}
