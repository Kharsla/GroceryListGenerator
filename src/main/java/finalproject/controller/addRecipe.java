package finalproject.controller;

import finalproject.entity.Recipe;
import finalproject.persistence.RecipeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(
            name = "addRecipe",
            urlPatterns = { "/addRecipe" }
    )
    public class addRecipe extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Recipe recipe = new Recipe();
            RecipeDao dao = new RecipeDao();

            //hard coded fix later
            recipe.setRecipeName("spagehetii");
            recipe.setMealType("Dinner");
            req.setAttribute("recipe", recipe);
            RequestDispatcher dispatcher = req.getRequestDispatcher("addSuccess.jsp");


            dispatcher.forward(req, resp);
        }

    }

