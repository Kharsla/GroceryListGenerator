package finalproject.controller;

import finalproject.entity.User;
import finalproject.persistence.RecipeDao;
import finalproject.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "displayrecipes",
        urlPatterns = { "/displayRecipes" }
)
public class displayRecipes extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RecipeDao dao = new RecipeDao();
        UserDao userDao = new UserDao();
        User user = new User();

        if(req.getParameterMap().containsKey("search")) {
            String searchTerm = req.getParameter("search");
        } else if (req.getParameterMap().containsKey("filter")) {
            String filterTerm = req.getParameter("filer");
        }
        user = userDao.getByUserName(req.getUserPrincipal().getName());
       req.setAttribute("recipes", user.getRecipes());
       RequestDispatcher dispatcher = req.getRequestDispatcher("recipeDisplay.jsp");


        dispatcher.forward(req, resp);
    }

}
