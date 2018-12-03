package com.controller;

import com.dao.FlightDAO;
import com.model.Flight;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class BookingFlight
*/
@WebServlet("/pages/BookingFlight")
public class BookingFlight extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingFlight() {
	    super();
	    // TODO Auto-generated constructor stub
    }

    /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub                   
    }

    /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub                   
        
        Enumeration<String> params = request.getParameterNames();
        if(params.hasMoreElements())
        {
            String p = params.nextElement();
            String fNo = request.getParameter(p);                       
            
            Flight flight = null;
            try {
                try {
                                flight = new FlightDAO().getFlightById(fNo);
                } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            request.setAttribute("flightToBeBooked", flight);
            
            RequestDispatcher rd = request.getRequestDispatcher("proforma_invoice_screen.jsp");
            rd.forward(request, response);
        }
                    
    }

}
