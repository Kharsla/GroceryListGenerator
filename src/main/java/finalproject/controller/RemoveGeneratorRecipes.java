package finalproject.controller;

import finalproject.entity.GeneratorRecipe;
import finalproject.entity.Recipe;
import finalproject.entity.User;
import finalproject.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * This servlet deletes all the cookies for the user selected recipes for the grocery list
 */
@WebServlet(
        name = "removeRecipes",
        urlPatterns = { "/removeRecipes" }
)
public class RemoveGeneratorRecipes extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<GeneratorRecipe> recipesToRemove = new ArrayList<>();
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
        User user = users.get(0);
        HashMap<String, String> searchCriteria = new HashMap<>();
        searchCriteria.put("userId", String.valueOf(user.getUserId()));
        GenericDao generatorRecipeDao = new GenericDao(GeneratorRecipe.class);
        recipesToRemove = generatorRecipeDao.getByMultipleCriteria(user, searchCriteria);

        for(GeneratorRecipe recipe: recipesToRemove){
            generatorRecipeDao.delete(recipe);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("generatorRecipesDisplay.jsp");

        dispatcher.forward(req, resp);

    }
}
