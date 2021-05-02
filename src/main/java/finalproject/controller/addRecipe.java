package finalproject.controller;

import com.mchange.v1.identicator.IdList;
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
import java.lang.reflect.Array;
import java.util.*;

@WebServlet(
            name = "addRecipe",
            urlPatterns = { "/addRecipe" }
    )
    public class addRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Recipe recipe = new Recipe();
            GenericDao recipeDao = new GenericDao(Recipe.class);
            GenericDao ingredientDao = new GenericDao(Ingredient.class);
            GenericDao userDao = new GenericDao(User.class);
            String recipeName = req.getParameter("recipeName");
            String mealType = req.getParameter("mealType");
            List<String> ingredientName = Arrays.asList(req.getParameterValues("ingredient"));
            List<String> quantities = Arrays.asList(req.getParameterValues("quantity"));
            List<String> unitOfMeasurements = Arrays.asList(req.getParameterValues("unitOfMeasure"));
            recipe.setRecipeName(recipeName);
            recipe.setMealType(mealType);

            List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
            User user = users.get(0);
            recipe.setUser(user);

            int id = recipeDao.insert(recipe);

            for (int i = 0; i < ingredientName.size(); i++) {
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientName(ingredientName.get(i));
                ingredient.setRecipe(recipe);
                ingredient.setQuantity(Integer.parseInt(quantities.get(i)));
                ingredient.setUnitOfMeasure(unitOfMeasurements.get(i));

                int ingredientId = ingredientDao.insert(ingredient);
            }

            req.setAttribute("recipe", recipe);
            req.setAttribute("ingredient", recipe.getIngredients());
            RequestDispatcher dispatcher = req.getRequestDispatcher("recipeConfirmation.jsp");


            dispatcher.forward(req, resp);
        }

    }

