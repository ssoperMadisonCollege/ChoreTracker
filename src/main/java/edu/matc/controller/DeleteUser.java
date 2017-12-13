package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A simple servlet to delete a user.
 */
@WebServlet (
        urlPatterns = {"/deleteUser"}
)

public class DeleteUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String deleteUserName = request.getParameter("userCheckbox");
        String url = "";

        try {
            UserDao dao = new UserDao();
            dao.deleteUser(deleteUserName);
            List<User> users = dao.getAllUsers();
            User user = dao.getUser(request.getRemoteUser());
            users.remove(user);
            request.setAttribute("users", users);
            url = "../Body/userResults.jsp";
        } catch (HibernateException he) {
            HttpSession session = request.getSession();
            log.error("Error deleting user: " + deleteUserName, he);
            session.setAttribute("ErrorMessage","Error deleting user: " + deleteUserName);
            // TODO redirect to an error page
            response.sendRedirect(url);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}