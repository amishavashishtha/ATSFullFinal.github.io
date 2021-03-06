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
@WebServlet({"/home.do", "/pages/search_flights.do"})
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
                	
                		
            		Customer customer = (Customer) request.getSession().getAttribute("customer");
                		
                	if(customer == null) {
                	
	                	request.setAttribute("errmsg", "<font color=red>Login to access the features</font>");
	                    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	                    rd.include(request, response);
                    
                	}
                	else {
                		
                		RequestDispatcher rd=request.getRequestDispatcher("pages/home.jsp");
                        rd.include(request, response);
                		
                	}
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                				
                    
			                	 String username = null; 
			                	 String password = null; 
                	 
                				try {
                	
	                                username = request.getParameter("username");
	                                password = request.getParameter("password");
                                
                				} catch(Exception e) {                					                			
                					
                					request.setAttribute("errmsg", "<font color=red>Login to access the features</font>");
                					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                                    rd.include(request, response);
                					
                				}
                                
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
                                                
                                                RequestDispatcher rd=request.getRequestDispatcher("pages/home.jsp");
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
