package edu.matc.controller;

import edu.matc.entity.Chore;
import edu.matc.persistence.ChoreDao;
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
 * A simple servlet to delete a chore.
 */
@WebServlet (
        urlPatterns = {"/deleteChore"}
)

public class DeleteChore extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int deleteChore = Integer.parseInt(request.getParameter("choreCheckbox"));
        log.info("choreCheckBox value: " + deleteChore);
        String url = "";

        try {
            ChoreDao dao = new ChoreDao();
            dao.deleteChore(deleteChore);
            List<Chore> chores = dao.getAllChores();
            log.info("new list of chores after delete: " + chores);
            request.setAttribute("chores", chores);
            url = "JSP/Body/choreResults.jsp";
        } catch (HibernateException he) {
            HttpSession session = request.getSession();
            log.error("Error deleting chore: " + deleteChore, he);
            session.setAttribute("ErrorMessage","Error deleting chore: " + deleteChore);
            // TODO redirect to an error page
            response.sendRedirect(url);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


}