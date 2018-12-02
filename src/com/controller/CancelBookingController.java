package com.controller;

import java.sql.SQLException;
import java.util.*;

import com.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.dao.BookingDAO;
import com.model.Customer;

/**
 * Servlet implementation class CancelBookingController
 */
@WebServlet({ "/CancelBookingController", "/pages/cancelBooking.do" })
public class CancelBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		
		List<Booking> bookingList = null;
		try {
			bookingList = new BookingDAO().getBookingByCId(customer.getcId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		request.setAttribute("bookingList", bookingList);
		
		RequestDispatcher rd = request.getRequestDispatcher("cancel_booking.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Flag 1");
		
		String bookingId = (String) request.getParameter("bookingId");
		
		System.out.println(bookingId);
		
		System.out.println("Flag 2");
		
		Booking booking = null;
		
		try {
			booking = (Booking) new BookingDAO().getBookingById(bookingId);
			
			System.out.println("Flag 3");
			
			new BookingDAO().deleteBookingById(bookingId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("booking", booking);
		
		RequestDispatcher rd = request.getRequestDispatcher("confirm_cancel_order_screen.html");
		rd.forward(request, response);
		
	}

}
