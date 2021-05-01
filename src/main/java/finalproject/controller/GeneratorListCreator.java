package finalproject.controller;

import finalproject.entity.Recipe;
import finalproject.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "addToGeneratorList",
        urlPatterns = { "/addToGenerator" }
)
public class GeneratorListCreator {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipeId = req.getParameter("recipeId");
        Cookie[] cookies = req.getCookies();
        GenericDao recipeDao = new GenericDao(Recipe.class);
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
            String updatedStringForCookie = cookieValue + " | " + recipeId;
            cookie.setValue(updatedStringForCookie);
        }
        resp.addCookie(cookie);
        RequestDispatcher dispatcher = req.getRequestDispatcher("addSuccess.jsp");

        dispatcher.forward(req, resp);
    }
}
