package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.entity.ZipCodeItem;
import com.normnondo.persistence.BeaconDao;
import com.normnondo.service.ZipCodeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet to display the available games from the database to the availableOpponents.jsp
 */

@WebServlet(
        urlPatterns = {"/availableOpponents"}
)


public class AvailableOpponentsServlet extends HttpServlet {
    /**
     * This doGet pulls the games from the database, then compares them to the zip codes from the API and displays all
     * the games in a 20 mile radius
     * /**
     *
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
        List<BeaconUsers> outputUsers = new ArrayList<>();

        ZipCodeService getZips = new ZipCodeService();
        String remoteUser = req.getRemoteUser();

        List<BeaconUsers> currentUser = userDao.getByEmail(remoteUser);
        BeaconUsers currentUserZip = currentUser.get(0);
        String currentZip = currentUserZip.getZipCode();

        List<ZipCodeItem> zipCodes = new ArrayList<>();
        try {
            zipCodes = getZips.zipCodeAPI(currentZip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<BeaconUsers> allUsers = userDao.getAll();
        for (ZipCodeItem zipCode : zipCodes) {
            for (BeaconUsers user : allUsers) {
              if (zipCode.getZipCode().equals(user.getZipCode())) {
                    outputUsers.add(user);
                }
            }
        }

        List<BeaconGames> gamesByZip = openGamesDao.getAll();
        for (BeaconUsers users : outputUsers) {
            for (BeaconGames games : gamesByZip)
            if (users.getId() == games.getBeaconUsers().getId()) {
                outputGames.add(games);
            }

        }

        req.setAttribute("gamesAvailable", outputGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/availableOpponents.jsp");
        dispatcher.forward(req, resp);

    }
}