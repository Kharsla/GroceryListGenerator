package finalproject.controller;
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
import java.util.List;
@WebServlet(
        name = "updatePassword",
        urlPatterns = { "/updatePassword" }
)
public class updatePassword extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        GenericDao userDao = new GenericDao(User.class);
        List<User> users = userDao.getByCriteria("userName", req.getUserPrincipal().getName());
        User user = users.get(0);

        String password1 = req.getParameter("passwordOne");
        String password2 = req.getParameter("passwordTwo");
        if(password1.equals(password2)) {
            user.setPassword(password1);
            userDao.saveOrUpdate(user);
            dispatcher = req.getRequestDispatcher("index.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("signupError.jsp");
        }
        dispatcher.forward(req, resp);
    }

}
