package com.controller;

import com.model.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;

/**
* Servlet implementation class LoginController
*/
@WebServlet({"/search_flights.do", "/pages/search_flights.do"})
public class LoginController extends HttpServlet {
                private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                	request.setAttribute("errmsg", "");
                    RequestDispatcher rd=request.getRequestDispatcher("../login.jsp");
                    rd.include(request, response);
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub

                                String username = request.getParameter("username");
                                String password = request.getParameter("password");
                                
                                Customer c = null;
                                
                                try {
                                                c = new CustomerDAO().getUserByEmail(username);                                      
                                                
                                } catch (ClassNotFoundException | SQLException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }                              
                                
                                
                                if(c == null) {
                                                request.setAttribute("errmsg", "<font color='red'>Invalid Username</font>");
                                                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                                                rd.include(request, response);
                                                
                                }
                                
                                else if(password.equals(c.getPassword()))
                                {
                                                HttpSession session = request.getSession();
                                                session.setAttribute("customer", c);
                                                
                                                RequestDispatcher rd=request.getRequestDispatcher("pages/search_flight.jsp");
                                                rd.include(request, response);
                                                
                                }
                                else
                                {
                                                request.setAttribute("errmsg", "<font color='red'>Invalid Password</font>");
                                                RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                                                rd.include(request, response);
                                }
                                
                                
                }

}
