package com.normnondo.controller;

import com.normnondo.entity.BeaconUsers;
import com.normnondo.persistence.BeaconDao;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchBeaconUsers"}
)

public class SearchBeaconUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeaconDao beaconDao = new BeaconDao(BeaconUsers.class);

      /*  String searchTerm = req.getParameter("searchTerm");
        String[] searchType = req.getParameterValues("searchType");
        String searchString = null;

        if (searchTerm != null) {

            try {

                if (searchType[0] != null) {
                    searchString = searchType[0];
                } else if (searchType[0] == null && searchType[1] != null) {
                    searchString = searchType[1];
                } else if (searchType[1] == null && searchType[2] != null) {
                    searchString = searchType[2];
                }

            }
            catch (NullPointerException nullPointer) {
                System.out.println("NPException.");
                nullPointer.printStackTrace();
            }

            req.setAttribute("user", BeaconDao.findSpecificUser(searchTerm, searchString));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
            dispatcher.forward(req, resp);

        } else {*/
            req.setAttribute("users", /*(BeaconUsers)*/beaconDao.getAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
            dispatcher.forward(req, resp);

    }
}
