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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Ingredient> originalIngredients = new HashSet<>();
        Set<Ingredient> formIngredients = new HashSet<>();

        if (recipeName != recipe.getRecipeName()) {
            recipe.setRecipeName(recipeName);
            recipeDao.saveOrUpdate(recipe);
        }
        if (mealType != recipe.getMealType()) {
            recipe.setMealType(mealType);
            recipeDao.saveOrUpdate(recipe);
        }

        for (String ingredientId: ingredientIds) {
            Ingredient originalIngredient = (Ingredient) ingredientDao.getById(Integer.parseInt(ingredientId));
            originalIngredients.add(originalIngredient);
        }

        for (int i = 0; i < ingredientName.size(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(ingredientName.get(i));
            ingredient.setIngredientId(Integer.parseInt(ingredientIds.get(i)));
            ingredient.setRecipe(recipe);
            ingredient.setQuantity(Double.parseDouble(quantities.get(i)));
            ingredient.setUnitOfMeasure(unitOfMeasurements.get(i));
            formIngredients.add(ingredient);
        }

        for (Ingredient originalIngredient: originalIngredients) {
            for (Ingredient formIngredient: formIngredients) {
                if (originalIngredient.getIngredientId() == formIngredient.getIngredientId()) {
                    ingredientDao.saveOrUpdate(formIngredient);
                }
            }
        }

        req.setAttribute("recipe", recipe);
        req.setAttribute("ingredient", recipe.getIngredients());
        RequestDispatcher dispatcher = req.getRequestDispatcher("editConfirmation.jsp");


        dispatcher.forward(req, resp);
    }

}
