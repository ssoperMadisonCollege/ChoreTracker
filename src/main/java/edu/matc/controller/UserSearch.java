package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author ssoper
 */

@WebServlet(
        urlPatterns = {"/userSearch"}
)

public class UserSearch extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao UserDao = new UserDao();
        List<User> users = UserDao.getAllUsers();
        log.error("Users lists: " + users.toString());
        req.setAttribute("users", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/JSP/Body/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}