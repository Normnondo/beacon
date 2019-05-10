package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.entity.ZipCodeItem;
import com.normnondo.persistence.BeaconDao;
import com.normnondo.service.ZipCodeService;

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
 * Servlet to display the available games from the database to the availableOpponents jsp
 */

@WebServlet(
        urlPatterns = {"/deleteGameUser"}
)

public class DeleteGameUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);
        BeaconDao userDao = new BeaconDao(BeaconUsers.class);
        List<BeaconGames> outputGames = new ArrayList<>();
      //  List<BeaconUsers> outputUsers = new ArrayList<>();

      //  ZipCodeService getZips = new ZipCodeService();
        String remoteUser = req.getRemoteUser();

        List<BeaconUsers> currentUser = userDao.getByEmail(remoteUser);
        BeaconUsers currentUserId = currentUser.get(0);
        int currentId = currentUserId.getId();

      /*  List<ZipCodeItem> zipCodes = new ArrayList<>();
        try {
            zipCodes = getZips.zipCodeAPI(currentZip);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

     /*   List<BeaconUsers> allUsers = userDao.getAll();
        for (ZipCodeItem zipCode : zipCodes) {
            for (BeaconUsers user : allUsers) {
                if (zipCode.getZipCode().equals(user.getZipCode())) {
                    outputUsers.add(user);
                }
            }
        }*/

        List<BeaconGames> allGames = openGamesDao.getAll();
      //  for (BeaconUsers users : outputUsers) {
            for (BeaconGames games : allGames)
                if (currentId == games.getBeaconUsers().getId()) {
                    outputGames.add(games);
                }

      //  }
        req.setAttribute("gamesAvailable", outputGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/deleteGame.jsp");
        dispatcher.forward(req, resp);


    }
}