package finalproject.controller;

import finalproject.entity.Ingredient;
import finalproject.entity.Recipe;
import finalproject.entity.User;
import finalproject.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(
        name = "editRecipe",
        urlPatterns = { "/editRecipe" }
)
public class editRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        GenericDao ingredientDao = new GenericDao(Ingredient.class);
        int recipeId = Integer.parseInt(req.getParameter("recipe"));
        String recipeName = req.getParameter("recipeName");
        String mealType = req.getParameter("mealType");
        List<String> ingredientIds = Arrays.asList(req.getParameterValues("ingredientId"));
        List<String> ingredientName = Arrays.asList(req.getParameterValues("ingredient"));
        List<String> quantities = Arrays.asList(req.getParameterValues("quantity"));
        List<String> unitOfMeasurements = Arrays.asList(req.getParameterValues("unitOfMeasure"));
        Recipe recipe = (Recipe) recipeDao.getById(recipeId);



        for (int i = 0; i < ingredientIds.size(); i++) {

        }

        req.setAttribute("recipe", recipe);
        req.setAttribute("ingredient", recipe.getIngredients());
        RequestDispatcher dispatcher = req.getRequestDispatcher("recipeConfirmation.jsp");


        dispatcher.forward(req, resp);
    }

}
