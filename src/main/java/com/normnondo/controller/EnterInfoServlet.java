package com.normnondo.controller;

import java.io.*;
import javax.servlet.*;

import com.normnondo.entity.BeaconRole;
import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "enterInfoAction",
        urlPatterns = { "/enterInfoAction" }
)

public class EnterInfoServlet extends HttpServlet {


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

            BeaconDao beaconDao = new BeaconDao(BeaconUsers.class);
            BeaconDao roleDao = new BeaconDao(BeaconRole.class);
            HttpSession session = request.getSession();
            String roleName = "user";

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String zipCode = request.getParameter("zipCode");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            BeaconUsers beaconUser = new BeaconUsers(firstName, lastName, zipCode, phoneNumber, email, password);
            int id = beaconDao.insert(beaconUser);

            BeaconRole beaconRole = new BeaconRole(roleName, email);
            int roleId = roleDao.insert(beaconRole);

            String addMessage = "You have been added to database. Please login.";

            if (id > 0 && roleId > 0) {
                session.setAttribute("newBeaconUserAddMessage", addMessage);
            }

            String url = "/enterInfo.jsp";

            response.sendRedirect(url);
        }

}

