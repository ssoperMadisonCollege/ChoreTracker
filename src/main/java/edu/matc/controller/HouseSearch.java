package edu.matc.controller;

import edu.matc.entity.House;
import edu.matc.persistence.HouseDao;
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
 * A simple servlet to search for houses.
 * @author ssoper
 */

@WebServlet(
        urlPatterns = {"/houseSearch"}
)

public class HouseSearch extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HouseDao HouseDao = new HouseDao();
        List<House> houses = HouseDao.getAllHouses();
        log.error("Houses list: " + houses.toString());
        req.setAttribute("houses", houses);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/JSP/Body/houseResults.jsp");
        dispatcher.forward(req, resp);
    }
}