package com.controller;

import java.sql.SQLException;
import java.text.*;
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.dao.CustomerDAO;
import com.model.Customer;
import com.model.SSN;

/**
 * Servlet implementation class RegistUser
 */
@WebServlet({ "/RegistUser", "/pages/RegUser.do", "/login.do" })
public class RegistUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cName = request.getParameter("name");   		   
		//Date dob = request.getParameter(arg0);
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");     
		String address = request.getParameter("address");     
		String phno = request.getParameter("phone");      
		String email = request.getParameter("email");     
		String password = request.getParameter("password");     	
		String ssnType = request.getParameter("ssnType");
		String ssnNo = request.getParameter("ssnNo");
		
		Customer c = null;
		try {
			c = new CustomerDAO().getUserByEmail(email);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(c != null) {
			request.setAttribute("errmsg_email", "<font color='red'>Email ID already registered!</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("pages/new_registration.jsp");
			rd.forward(request, response);	
			return;
		}
		
		boolean ssnNoExists = false;
		try {
			ssnNoExists = new CustomerDAO().getUserBySSNno(ssnNo);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(ssnNoExists) {
			request.setAttribute("errmsg_ssnNo", "<font color='red'>Entered SSN_No already registered!</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("pages/new_registration.jsp");
			rd.forward(request, response);	
			return;
		}
		
		SSN ssn = new SSN(ssnType, ssnNo); 
		
		System.out.println(cName);
		System.out.println(dob);
		System.out.println(gender);
		System.out.println(address);
		System.out.println(phno);
		System.out.println(email);
		System.out.println(password);
		System.out.println(ssnType);
		System.out.println(ssnNo);
		
		Integer integer = new Integer(-5); 
		
		Customer customer = null;
		
		try {
			customer = new Customer(cName, null, new SimpleDateFormat("yyyy-MM-dd").parse(dob), gender, address, phno, email, password, ssn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			boolean regist_success = new CustomerDAO().createNewCustomer(customer);
			
			if(!regist_success) {
				request.setAttribute("errmsg_regfail", "<font color='red'>Error in registration!</font>");
				RequestDispatcher rd = request.getRequestDispatcher("pages/new_registration.jsp");
				rd.forward(request, response);	
				return;
			}
			
			request.setAttribute("errmsg", "<font color='green'>Account creation successful!<br/>Login to continue.</font>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
