package com.controller;

import com.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookingDAO;
import com.dao.FlightDAO;
import com.dao.SeatsAvailableDAO;

/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet({ "/ConfirmBooking", "/pages/confirmBooking.do" })
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("final_invoice_screen.html");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fNo = request.getParameter("fNo");
		
		System.out.println(fNo);
		
		int no_of_travellers = Integer.parseInt(request.getParameter("no_of_passengers"));
		
		System.out.println(no_of_travellers);
		
		Flight flight = null;
		
		try {
			flight = new FlightDAO().getFlightById(fNo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");				
	
		String bookingId = null;
		
		try {
			bookingId = new BookingDAO().getMaxId();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Booking booking = new Booking(bookingId, new Date(), fNo, customer, flight.getFare() * no_of_travellers, no_of_travellers, flight.getDepartTime());
	
		try {
			new SeatsAvailableDAO().updateSeatAvailable(new FlightDAO().getFlightById(fNo), booking);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			new BookingDAO().createNewBooking(booking);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("booking", booking);
		
		RequestDispatcher rd = request.getRequestDispatcher("final_invoice_screen.jsp");
		rd.forward(request, response);
		
	}

}
