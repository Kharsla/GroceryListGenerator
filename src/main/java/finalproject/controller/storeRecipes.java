package finalproject.controller;

import finalproject.entity.Recipe;
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
import java.util.ArrayList;
import java.util.List;
/**
 * This servlet stores the user's selected recipes for the grocery list in the recipes cookie
 */

@WebServlet(
        name = "storeRecipes",
        urlPatterns = { "/storeRecipes" }
)
public class storeRecipes extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String recipeId = req.getParameter("recipe");
        Cookie[] cookies = req.getCookies();
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = (Recipe)recipeDao.getById(Integer.parseInt(recipeId));
        Cookie cookie = null;

        if(cookies != null) {
            for (Cookie nextCookie : cookies) {
                if (nextCookie.getName().equals("recipes")) {
                    cookie = nextCookie;
                    break;
                }

            }
        }
        if(cookie == null) {
            cookie = new Cookie("recipes", recipeId);
        } else {
            String cookieValue = cookie.getValue();
            String updatedStringForCookie = cookieValue + "-" + recipeId;
            cookie.setValue(updatedStringForCookie);
        }
        logger.info(cookie.getValue());
        resp.addCookie(cookie);
        req.setAttribute("recipe", recipe);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addSuccess.jsp");

        dispatcher.forward(req, resp);
    }
}
