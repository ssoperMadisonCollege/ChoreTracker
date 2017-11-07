package edu.matc.controller;

import edu.matc.entity.UserRole;
import edu.matc.persistence.UserRoleDao;
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
 * A simple servlet to welcome the userRole.
 * @author ssoper
 */

@WebServlet(
        urlPatterns = {"/userRoleSearch"}
)

public class UserRoleSearch extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRoleDao UserRoleDao = new UserRoleDao();
        List<UserRole> userRoles = UserRoleDao.getAllUserRoles();
        log.error("UserRoles list: " + userRoles.toString());
        req.setAttribute("userRoles", userRoles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/JSP/userRoleResults.jsp");
        dispatcher.forward(req, resp);
    }
}