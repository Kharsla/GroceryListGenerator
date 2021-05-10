package finalproject.controller;

import finalproject.entity.Recipe;
import finalproject.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "deleteRecipe",
        urlPatterns = { "/deleteRecipe" }
)
public class DeleteRecipe extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        int recipeId = Integer.parseInt(req.getParameter("recipe"));
        Recipe recipe = (Recipe)recipeDao.getById(recipeId);

        recipeDao.delete(recipe);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayRecipes");

        dispatcher.forward(req, resp);

    }
}
