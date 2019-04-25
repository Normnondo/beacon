package com.normnondo.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "enterInfoAction",
        urlPatterns = { "/enterInfoAction" }
)

public class EnterInfoServlet extends HttpServlet {
        BeaconDao beaconDao = new BeaconDao(BeaconUsers.class);
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
            int id = 0;

            HttpSession session = request.getSession();


            beaconDao = (BeaconDao)getServletContext().getAttribute("newBeaconUser");

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String zipCode = request.getParameter("zipCode");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            BeaconUsers newBeaconUser = new BeaconUsers(firstName, lastName, zipCode, phoneNumber, email, password);
            id = beaconDao.insert(newBeaconUser);

            String addMessage = "You have been added to database.";

            if (id > 0) {
                session.setAttribute("newBeaconUserAddMessage", addMessage);
            }

            String url = "/enterInfo";

            response.sendRedirect(url);
        }

}

