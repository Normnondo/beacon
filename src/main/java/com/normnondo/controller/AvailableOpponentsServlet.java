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
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Servlet to display the available games from the database to the availableOpponents jsp
 */

@WebServlet(
        urlPatterns = {"/availableOpponents"}
)

public class AvailableOpponentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao openGamesDao = new BeaconDao(BeaconGames.class);
        BeaconDao userDao = new BeaconDao(BeaconUsers.class);
        //openGamesDao.getAll();
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


        for(ZipCodeItem zips : zipCodes) {
            List<BeaconUsers> allUsers = userDao.getAll();

            tempUsers = allUsers.stream().filter(user -> user.getZipCode().equals(zips.getZipCode()))
                    .collect(Collectors.toList());
            outputUsers.add(tempUsers);
        }

        for (BeaconUsers users : outputUsers) {
            List<BeaconGames> gamesByZip = openGamesDao.getAll();

            outputGames = gamesByZip.stream().filter(game -> game.equals(users.getId()))
                    .collect(Collectors.toList());

        }
        req.setAttribute("gamesAvailable", outputGames/*openGamesDao.getAll()*/);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/availableOpponents.jsp");
        dispatcher.forward(req, resp);


    }
}