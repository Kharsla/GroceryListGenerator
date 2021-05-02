package finalproject.controller;

import finalproject.entity.Recipe;
import finalproject.entity.User;
import finalproject.persistence.GenericDao;
import finalproject.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "addUser",
        urlPatterns = { "/addUser" }
)
public class addUser extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        User user = new User();
        GenericDao userDao = new GenericDao(User.class);

        String userName = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        if(password1 == password2) {
            user.setUserName(userName);
            user.setPassword(password1);
            req.setAttribute("user", user);
            userDao.insert(user);
            dispatcher = req.getRequestDispatcher("addSuccess.jsp");
        } else {
            //Will change once new jsp made
            dispatcher = req.getRequestDispatcher("loginError.jsp");
        }

        dispatcher.forward(req, resp);
    }

}


