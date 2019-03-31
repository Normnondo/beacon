package com.normnondo.controller;

import com.normnondo.persistence.BeaconGamesDao;

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

        BeaconGamesDao openGamesDao = new BeaconGamesDao();

        req.setAttribute("gamesAvailable", openGamesDao.getAllGames());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/availableOpponents.jsp");
        dispatcher.forward(req, resp);


    }
}