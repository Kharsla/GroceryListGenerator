package finalproject.controller;

import finalproject.entity.User;
import finalproject.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "viewUserInfo",
        urlPatterns = { "/viewUserInfo" }
)
public class viewUserInfo extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
        User user = users.get(0);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("viewUserProfile.jsp");
        dispatcher.forward(req, resp);
    }

}
