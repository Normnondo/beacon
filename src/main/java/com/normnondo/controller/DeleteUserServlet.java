package com.normnondo.controller;

import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to get user information to adminOnly.jsp for deletion
 */
@WebServlet(
        name = "deleteUserAction",
        urlPatterns = { "/deleteUserAction" }
)

public class DeleteUserServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               Description of the Parameter
     *@param  response              Description of the Parameter
     *@exception ServletException  if there is a Servlet failure
     *@exception IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        BeaconDao beaconDao = new BeaconDao(BeaconUsers.class);
        HttpSession session = request.getSession();

        String id = request.getParameter("user");

        int userId = Integer.parseInt(id);

        beaconDao.delete(beaconDao.getById(userId));

        String deleteUserMessage = "User has been deleted.";

        if (id == null) {
            session.setAttribute("deleteUserMessage", deleteUserMessage);
        }

        String url = "index.jsp";

        response.sendRedirect(url);
    }

}

