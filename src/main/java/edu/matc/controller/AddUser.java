package edu.matc.controller;

import edu.matc.entity.House;
import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import edu.matc.persistence.HouseDao;
import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserRoleDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to add a user and a house.
 *
 * @author ssoper
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)

public class AddUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        UserDao  userDao = new UserDao();
        UserRole userRole = new UserRole();
        UserRoleDao userRoleDao = new UserRoleDao();
        House house = new House();
        HouseDao houseDao = new HouseDao();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        userDao.addUser(user);

        house.setUser(user);
        house.setHouseName(request.getParameter("houseName"));
        houseDao.addHouse(house);

        userRole.setUser(user);
        userRole.setRoleName("registered-user");
        userRoleDao.addUserRole(userRole);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/Body/addUserSuccess.jsp");
        dispatcher.forward(request, response);
    }
}