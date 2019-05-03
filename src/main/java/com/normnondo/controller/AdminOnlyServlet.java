package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
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
 * Servlet to display the available games from the database to the availableOpponents jsp
 */

@WebServlet(
        urlPatterns = {"/adminOnly"}
)

public class AdminOnlyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);
        BeaconDao allUsersDao = new BeaconDao(BeaconUsers.class);

        req.setAttribute("gamesAvailable", openGamesDao.getAll());
        req.setAttribute("usersAvailable", allUsersDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminOnly.jsp");
        dispatcher.forward(req, resp);


    }
}
