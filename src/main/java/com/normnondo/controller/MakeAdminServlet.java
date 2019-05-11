package com.normnondo.controller;

import com.normnondo.entity.BeaconRole;
import com.normnondo.persistence.BeaconDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to allow admin to grant admin privileges to another user
 */
@WebServlet(
        name = "makeAdminAction",
        urlPatterns = { "/makeAdminAction" }
)

public class MakeAdminServlet extends HttpServlet {

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

        BeaconDao beaconDao = new BeaconDao(BeaconRole.class);
        HttpSession session = request.getSession();

        String id = request.getParameter("newAdmin");

        int userId = Integer.parseInt(id);

        String newRoleName = "admin";
        BeaconRole userToUpdate = (BeaconRole)beaconDao.getById(userId);
        userToUpdate.setRoleName(newRoleName);
        beaconDao.saveOrUpdate(userToUpdate);

        String makeAdminMessage = "User has been granted Admin privileges.";

        if (id == null) {
            session.setAttribute("makeAdminMessage", makeAdminMessage);
        }

        String url = "/index.jsp";

        response.sendRedirect(url);
    }

}