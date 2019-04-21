package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
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
        urlPatterns = {"/availableOpponents"}
)

public class AvailableOpponentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Is this where I should change data from database to be more user-friendly? */
        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);

        req.setAttribute("gamesAvailable", openGamesDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/availableOpponents.jsp");
        dispatcher.forward(req, resp);


    }
}