package com.dao;

import java.text.*;
import com.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO {
                    
    public int getMaxId() throws ClassNotFoundException, SQLException
    {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
		Statement stmt=con.createStatement();
		int Cid=Integer.MIN_VALUE;
		try
		{
			String cid=("select max(Cid) from customer_info");
			ResultSet rs=stmt.executeQuery(cid);
			rs.next();
			Cid=rs.getInt(1);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return Cid;
    }
    
    public boolean createNewCustomer(Customer customer) throws ClassNotFoundException, SQLException
    {

	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
	    Statement stmt=con.createStatement();
	
		try
		{
			
			String cid=("select max(Cid) from customer_info");
			ResultSet rs=stmt.executeQuery(cid);
			rs.next();
			int Cid=rs.getInt(1);
			String query="insert into customer_info values('"+customer.getcName()+"',"+(Cid+1)+",'"+sdf.format(customer.getDob())+"','"+customer.getGender()+"','"+customer.getAddress()+"','"+customer.getPhno()+"','"+customer.getEmail()+"','"+customer.getPassword()+"','"+customer.getSsn().getType()+"','"+customer.getSsn().getNo()+"')";
			Cid++;
			int rs1=stmt.executeUpdate(query);
		
			if(rs1 > 0) {
				
				return true;
				
			}
			
		}
		catch(Exception ex)
		{			
			System.out.println(ex);
			return false;
		}
		
		return false;
    }

    public Customer getUserById(int cId) throws SQLException, ClassNotFoundException
    {
	    //List<Customer>clist=new ArrayList<>();
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
	    Statement stmt=con.createStatement();
	    //fill your code
		Customer c=null;
		String query="Select * from CUSTOMER_INFO where Cid="+cId;
		ResultSet rs=stmt.executeQuery(query);
		try
		{
			while(rs.next())
	        {
		    
				 String cName = rs.getString(1);				 
				 Date dob = rs.getDate(3);
				 String gender = rs.getString(4);
				 String address = rs.getString(5);
				 String phno = rs.getString(6);
				 String email = rs.getString(7);
				 String password = rs.getString(8);
				 String ssnType = rs.getString(9);
				 String ssnNo = rs.getString(10);
				 
				 SSN ssn = new SSN(ssnType, ssnNo);
				 
			    return new Customer(cName, cId, dob, gender, address, phno, email, password, ssn);
			    
		        
	        }
		}
		catch(Exception e)
		{
		   System.out.println(e);
		}
		finally {
			
			try {
				if(con != null) {
					//con.close();
				}
			}
			catch(Exception e) {
				System.out.println("Exception while closing the connection!");
			}
			
		}
		
		return null;
     
    }
                    
    public Customer getUserByEmail(String emailId) throws SQLException, ClassNotFoundException
    {
	    //List<Customer>clist=new ArrayList<>();
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
	    Statement stmt=con.createStatement();
	    //fill your code
		Customer c=null;
		String query="Select * from CUSTOMER_INFO where Email='"+emailId+"'";
		ResultSet rs=stmt.executeQuery(query);
		try
		{
			while(rs.next())
	        {
		    
				 String cName=rs.getString(1);
				 Integer cId=rs.getInt(2);
				 Date dob=rs.getDate(3);
				 String gender=rs.getString(4);
				 String address=rs.getString(5);
				 String phno=rs.getString(6);
				 String email=emailId;
				 String password=rs.getString(8);
				 String ssnType = rs.getString(9);
				 String ssnNo = rs.getString(10);
				 
				 SSN ssn = new SSN(ssnType, ssnNo);
				 
			    return new Customer(cName, cId, dob, gender, address, phno, email, password, ssn);
			    
		        
	        }
		}
		catch(Exception e)
		{
		   System.out.println(e);
		}
		finally {
			
			try {
				if(con != null) {
					//con.close();
				}
			}
			catch(Exception e) {
				System.out.println("Exception while closing the connection!");
			}
			
		}
		return null;
     
    }
   
     
    public boolean getUserBySSNno(String SSNno) throws SQLException, ClassNotFoundException
    {
	    Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
	    Statement stmt=con.createStatement();
	    //fill your code
		Customer c=null;
		String query="Select * from CUSTOMER_INFO where ssn_no='"+SSNno+"'";
		ResultSet rs=stmt.executeQuery(query);
		
		boolean exists = false;
		
		try
		{
			while(rs.next())
	        {
		    				 
			    exists = true;
			    
		        
	        }
		}
		catch(Exception e)
		{
		   System.out.println(e);
		}
		finally {
			
			try {
				if(con != null) {
					//con.close();
				}
			}
			catch(Exception e) {
				System.out.println("Exception while closing the connection!");
			}
			
		}
		return exists;
     
    }
    public void updateCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException
    {
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
           Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
     Statement stmt=con.createStatement();
     
     try
     {
            String query="update customer_info set CName='"+customer.getcName()+"',Dob='"+sdf.format(customer.getDob())+"',Gender='"+customer.getGender()+"',Address='"+customer.getAddress()+"',Phno='"+customer.getPhno()+"',Email='"+customer.getEmail()+"',Password='"+customer.getPassword()+"',Ssn_type='"+customer.getSsn().getType()+"' where Cid="+customer.getcId();
            System.out.println(query);
            int rs=stmt.executeUpdate(query);
      
     
     }
     catch(Exception ex)
     {
     System.out.println(ex);
     }
    }

    
   }

