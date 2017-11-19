package edu.matc.controller;

import edu.matc.entity.Chore;
import edu.matc.persistence.ChoreDao;
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
 * A simple servlet to search for chores.
 * @author ssoper
 */

@WebServlet(
        urlPatterns = {"/choreSearch"}
)

public class ChoreSearch extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ChoreDao ChoreDao = new ChoreDao();
        List<Chore> chores = ChoreDao.getAllChores();
        log.error("Chores list: " + chores.toString());
        req.setAttribute("chores", chores);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/JSP/Body/choreResults.jsp");
        dispatcher.forward(req, resp);
    }
}