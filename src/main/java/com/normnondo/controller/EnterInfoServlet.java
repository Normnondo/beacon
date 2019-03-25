package com.normnondo.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This is a pretty busy servlet, it gets the parameters from the Employee
 * Search JSP, then sends those parameters to the EmployeeDirectory class. It
 * pulls back that information, and then sends it to the Employee Search Results
 * JSP which outputs it for the user to see.
 * @author Norm Nondorf
 */
@WebServlet(
        name = "enterInfoAction",
        urlPatterns = { "/enterInfoAction" }
)
public class EnterInfoServlet {

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

        HttpSession session = request.getSession();
       // Search searchResults = new Search();

       /* try {
            EmployeeDirectory directory;
            directory = (EmployeeDirectory)getServletContext()
                    .getAttribute("directoryOfEmployees");

            String searchTerm = request.getParameter("searchTerm");
            String[] searchType = request.getParameterValues("searchType");
            String searchString = null;


            if (searchType[0] != null) {
                searchString = searchType[0];
            } else if (searchType[0] == null && searchType[1] != null) {
                searchString = searchType[1];
            } else if (searchType[1] == null && searchType[2] != null) {
                searchString = searchType[2];
            }
            searchResults = directory.searchDatabase(searchTerm, searchString);
        }
        catch (NullPointerException nullPointer) {
            System.out.println("NPException.");
            nullPointer.printStackTrace();
        }

        session.setAttribute("searchResults", searchResults);

        String url = "/jsp/employeeSearchResults.jsp"; */

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }



}

