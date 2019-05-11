package com.normnondo.controller;

import com.normnondo.entity.BeaconGames;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to insert new games into the game database
 */
@WebServlet(
        name = "enterGameSearch",
        urlPatterns = { "/enterGameSearch" }
)

public class GameSearchServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        BeaconDao beaconDao = new BeaconDao(BeaconGames.class);
        BeaconDao userDao = new BeaconDao(BeaconUsers.class);
        HttpSession session = request.getSession();
        String remoteUser = request.getRemoteUser();

        String gameType = request.getParameter("gameType");
        String gameStyle = request.getParameter("gameStyle");
        String points = request.getParameter("points");
        String army = request.getParameter("army");
        String location = request.getParameter("location");

        List<BeaconUsers> currentUser = userDao.getByEmail(remoteUser);
        BeaconUsers userID = currentUser.get(0);
        BeaconGames beaconGame = new BeaconGames(gameType, gameStyle, points, army, location, userID);
        int id = beaconDao.insert(beaconGame);

        String addMessage = "Your game has been listed.";

        if (id > 0) {
            session.setAttribute("newBeaconGameAddMessage", addMessage);
        }

        String url = "/gameSearch.jsp";

        response.sendRedirect(url);
    }

}
