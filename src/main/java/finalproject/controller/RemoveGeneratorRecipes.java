package finalproject.controller;

import finalproject.entity.Recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        Cookie cookie = new Cookie("recipes", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        RequestDispatcher dispatcher = req.getRequestDispatcher("generatorRecipesDisplay.jsp");

        dispatcher.forward(req, resp);

    }
}
