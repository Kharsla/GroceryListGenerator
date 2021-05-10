package finalproject.controller;

import finalproject.entity.Role;
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
/**
 * This servlet adds a user to the database from the form data
 */

@WebServlet(
        name = "addUser",
        urlPatterns = { "/addUser" }
)
public class addUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        User user = new User();
        Role role = new Role();
        GenericDao userDao = new GenericDao(User.class);
        GenericDao roleDao = new GenericDao(Role.class);

        String userName = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        logger.info(password1);
        logger.info(password2);

        if(password1.equals(password2)) {
            user.setUserName(userName);
            user.setPassword(password1);
            req.setAttribute("user", user);
            userDao.insert(user);
            role.setUser(user);
            role.setUserName(user.getUserName());
            role.setRoleName("admin");
            roleDao.insert(role);
            dispatcher = req.getRequestDispatcher("addUserSuccess.jsp");
        } else {
            dispatcher = req.getRequestDispatcher("signupError.jsp");
        }

        dispatcher.forward(req, resp);
    }

}


