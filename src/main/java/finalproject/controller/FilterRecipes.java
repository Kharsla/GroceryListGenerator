package finalproject.controller;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(
        name = "filterRecipes",
        urlPatterns = { "/filterRecipes" }
)
public class FilterRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
        List<Recipe> recipes = new ArrayList<>();
        User user = users.get(0);
        HashMap<String, String> searchCriteria = new HashMap<>();
        searchCriteria.put("userName", user.getUserName());

        if (req.getParameterMap().containsKey("search")) {
            String searchTerm = req.getParameter("search");
            searchCriteria.put("recipeName", searchTerm);
            recipes = recipeDao.getByMultipleCriteria(searchCriteria);
        }
        if (req.getParameterMap().containsKey("filter")) {
            String filterTerm = req.getParameter("filer");
            searchCriteria.put("mealType", filterTerm);

            recipes = recipeDao.getByMultipleCriteria(searchCriteria);
        }
        req.setAttribute("recipes", recipes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("recipeDisplay.jsp");


        dispatcher.forward(req, resp);
    }
}
