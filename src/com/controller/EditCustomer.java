package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.model.Customer;
import com.model.SSN;

/**
* Servlet implementation class EditCustomer
*/
@WebServlet({ "/pages/EditCustomer", "/EditCustomer" })
public class EditCustomer extends HttpServlet {
                private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomer() {
        super();
       // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                              System.out.println("Bolo maa");
                              RequestDispatcher rd = request.getRequestDispatcher("pages/edit_customer_screen.jsp");
                               rd.include(request, response);
                }

                /**
                * @see HttpServlet#doPost(.HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                              
                              HttpSession session = request.getSession();
                              
                              Customer customer=(Customer) session.getAttribute("customer");
                              
                              String cName = request.getParameter("cName");
                              String dob = request.getParameter("dob");
                              String email=request.getParameter("email");
                              String phno=request.getParameter("phno");
                              String address=request.getParameter("address");
                              String gender=request.getParameter("gender");
                              String ssnType=request.getParameter("ssnType");
                              String ssnNumber=request.getParameter("ssnNumber");
                              
                              
                              System.out.println(cName);
                              System.out.println(dob);
                              System.out.println(email);
                              System.out.println(phno);
                              System.out.println(address);
                              System.out.println(gender);
                              System.out.println(ssnType);
                              System.out.println(ssnNumber);
                              
                              Customer customerNew=null;
			                    try {
			                                    customerNew = new Customer(cName, customer.getcId(), new SimpleDateFormat("dd-MMM-yyyy").parse(dob), gender, address, phno, email, customer.getPassword(), new SSN(ssnType, ssnNumber));
			                    } catch (ParseException e1) {
			                                    // TODO Auto-generated catch block
			                                    e1.printStackTrace();
			                    }
                              
                              try {
	                                            new CustomerDAO().updateCustomerDetails(customerNew);
	                            } catch (ClassNotFoundException e) {
	                                            // TODO Auto-generated catch block
	                                            e.printStackTrace();
	                            } catch (SQLException e) {
	                                            // TODO Auto-generated catch block
	                                            e.printStackTrace();
	                            } 
                              
                              session.setAttribute("customer", customerNew);
                              
                              request.setAttribute("msg", "<font color=green> Customer Updated Sucessfully!</font>");
                              RequestDispatcher rd = request.getRequestDispatcher("edit_customer_screen.jsp");
                    rd.include(request, response);
                              
                }

}
