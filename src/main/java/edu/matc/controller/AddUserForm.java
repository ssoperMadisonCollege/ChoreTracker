package edu.matc.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the userRole.
 *
 * @author ssoper
 */
@WebServlet(
        urlPatterns = {"/addUserForm"}
)

public class AddUserForm extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/JSP/Body/addUser.jsp");
        dispatcher.forward(req, resp);
    }
}