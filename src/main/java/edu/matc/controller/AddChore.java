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
import java.time.LocalDate;

/**
 * A simple servlet to add a chore.
 * @author ssoper
 */

@WebServlet(
        urlPatterns = {"/addChore"}
)

public class AddChore extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Chore chore = new Chore();
        ChoreDao  choreDao = new ChoreDao();

        chore.setChoreName(request.getParameter("choreName"));
        chore.setChoreDate(LocalDate.parse(request.getParameter("choreDate")));
        chore.setChoreName(request.getParameter("choreName"));
        chore.setChoreInterval(request.getParameter("choreInterval"));
        chore.setAssignedToUser(request.getParameter("assignedToUser"));

        choreDao.addChore(chore);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Body/addChore.jsp");
        dispatcher.forward(request, response);
    }
}