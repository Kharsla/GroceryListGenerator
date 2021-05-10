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

/**
 * This servlet filters the users recipes based on criteria given by user input
 */

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
        logger.info(user.getUserId());
        String searchTerm = req.getParameter("search");
        String filterTerm = req.getParameter("filter");

        if(searchTerm != "") {
            String querySearch = "%" + searchTerm + "%";
            searchCriteria.put("recipeName", querySearch);
        }


        if (filterTerm != "") {
            searchCriteria.put("mealType", filterTerm);
        }

            recipes = recipeDao.getByMultipleCriteria(user,searchCriteria);
        logger.info(searchCriteria);
        req.setAttribute("recipes", recipes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("recipeDisplay.jsp");


        dispatcher.forward(req, resp);
    }
}
