package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet used to delete games entered by the user
 */
@WebServlet(
        urlPatterns = {"/beaconweb/deleteGameUser"}
)

public class DeleteGameUserServlet extends HttpServlet {
    /**
     * This doGet grabs all the game database information, filters it by user, and sends it to the deleteGame.jsp
     *@param  req                  Description of the Parameter
     *@param  resp                 Description of the Parameter
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);
        BeaconDao userDao = new BeaconDao(BeaconUsers.class);
        List<BeaconGames> outputGames = new ArrayList<>();

        String remoteUser = req.getRemoteUser();

        List<BeaconUsers> currentUser = userDao.getByEmail(remoteUser);
        BeaconUsers currentUserId = currentUser.get(0);
        int currentId = currentUserId.getId();

        List<BeaconGames> allGames = openGamesDao.getAll();
        for (BeaconGames games : allGames) {
            if (currentId == games.getBeaconUsers().getId()) {
                outputGames.add(games);
            }
        }

        req.setAttribute("gamesAvailable", outputGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/beaconweb/deleteGame.jsp");
        dispatcher.forward(req, resp);

    }
}