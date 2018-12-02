package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlightDAO;
import com.dao.LocationDAO;
import com.model.Flight;
import com.model.Location;

/**
* Servlet implementation class SearchFlightController
*/
@WebServlet("/SearchFlightController")
public class SearchFlightController extends HttpServlet {
                private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightController() {
        super();
        // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                response.getWriter().append("Served at: ").append(request.getContextPath());
                                
                                String src = request.getParameter("src");
                                String dest = request.getParameter("dest");
                                String dateTime = request.getParameter("departure_timestamp");
                                String no_of_travelers = request.getParameter("no_of_travelers");
                                
                                System.out.println(src);
                                System.out.println(dest);
                                System.out.println(dateTime);
                                System.out.println(no_of_travelers);
                                
                                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                
                                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                
                                Date dt = null;
                                try {
                                                dt = sdf1.parse(dateTime.replaceAll("T", " "));
                                } catch (ParseException e1) {
                                                // TODO Auto-generated catch block
                                                e1.printStackTrace();
                                }
                                
                                System.out.println(sdf2.format(dt));
                                
                                Location locationSrc = null;
                                Location locationDest = null;
                                
                                try {
                                                
                                                locationSrc = new LocationDAO().getLocationByName(src);
                                                locationDest = new LocationDAO().getLocationByName(dest);
                                                
                                                System.out.println(locationSrc.getLocationId());
                                                System.out.println(locationDest.getLocationId());
                                                
                                } catch (ClassNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                
                                try {
                                                List<Flight> flightList = new FlightDAO().getFlight(locationSrc.getLocationId(), locationDest.getLocationId(), dt);
                                                
                                                request.setAttribute("flightList", flightList);
                                                
                                                RequestDispatcher rd = request.getRequestDispatcher("pages/search_results.jsp");
                                                rd.forward(request, response);
                                                
                                                /*
                                                for (Flight flight : flightList) {
                                                                System.out.println(flight);
                                                }
                                                */
                                                
                                } catch (ClassNotFoundException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                } catch (SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                                
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                                
                                //RequestDispatcher rd = request.getRequestDispatcher("pages/search_results.html");
                                //rd.forward(request, response);
                }

}

