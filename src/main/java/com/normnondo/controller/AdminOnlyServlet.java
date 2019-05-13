package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
import com.normnondo.entity.BeaconRole;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Servlet to display all users, games, and roles to admin for adminstrative purposes
 */
@WebServlet(
        urlPatterns = {"/beaconweb/adminOnly"}
)

public class AdminOnlyServlet extends HttpServlet {

    /**
     * This doGet grabs all the database information and sends it to the adminOnly.jsp
     *@param  req                  Description of the Parameter
     *@param  resp                 Description of the Parameter
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);
        BeaconDao allUsersDao = new BeaconDao(BeaconUsers.class);
        BeaconDao allRolesDao = new BeaconDao(BeaconRole.class);

        req.setAttribute("gamesAvailable", openGamesDao.getAll());
        req.setAttribute("usersAvailable", allUsersDao.getAll());
        req.setAttribute("rolesAvailable", allRolesDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("adminOnly.jsp");
        dispatcher.forward(req, resp);

    }
}
