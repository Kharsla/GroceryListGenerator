package finalproject.controller;

import finalproject.persistence.RecipeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "displayrecipes",
        urlPatterns = { "/displayRecipes" }
)
public class displayRecipes extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RecipeDao dao = new RecipeDao();
       req.setAttribute("recipes", dao.getAllRecipes());
       RequestDispatcher dispatcher = req.getRequestDispatcher("recipeDisplay.jsp");


        dispatcher.forward(req, resp);
    }

}
