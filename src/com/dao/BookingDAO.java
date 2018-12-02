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

public class BookingDAO {

	public String getMaxId() throws ClassNotFoundException, SQLException
    {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
		Statement stmt=con.createStatement();
		int Bid = 0;
		String b="";
		try
		{
			String q1="select max(substring(BOOKING_ID,2,1)) from BOOKING_INFO";
			ResultSet rs=stmt.executeQuery(q1);
			rs.next();
			Bid=Integer.parseInt(rs.getString(1));
			Bid++;
		    b= "B" + Bid;
		}
		catch(Exception ex)
		{
		System.out.println(ex);
		}
		return b;
    }

	
	public String createNewBooking(Booking booking) throws ClassNotFoundException, SQLException
	{

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
        Statement stmt=con.createStatement();
       
        try
        {
	        String query="insert into booking_info values('"+booking.getBookingId()+"','"+sdf.format(booking.getBookingDt())+"','"+booking.getfNo()+"','"+booking.getcId().getcId() +"','"+booking.getPrice()+"'," + booking.getSeatsBooked() + ",'"+sdf.format(booking.getDOJ())+"')";
	        System.out.println(query);
	        int rs=stmt.executeUpdate(query);	     	      
	        
	        con.close();
	        
	        return booking.getBookingId();
        
        }
        catch(Exception ex)
        {
        	System.out.println(ex);        	
        }
        
        return null;
	}

	public Booking getBookingById(String bookingId) throws SQLException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
        Statement stmt = null;
        try {
        	stmt=con.createStatement();
        }
        catch(Exception e) {
        	System.out.println("Its here");
        }
        //fill your code
        Booking c=null;
        String query="Select * from BOOKING_INFO where Booking_ID='"+bookingId+"'";
        ResultSet rs=stmt.executeQuery(query);
        Booking b = null;
        try {
			rs.next();
			
			String Booking = bookingId;
			Date bookingDt = rs.getDate(2);
			String fNo = rs.getString(3);
			int cId = rs.getInt(4);
			Customer customer = new CustomerDAO().getUserById(cId);
			Integer price=rs.getInt(5);
			Integer seatsBooked = rs.getInt(6);
			Date doj = rs.getDate(7);	
			
			System.out.println(bookingId);
			System.out.println(bookingDt);
			System.out.println(fNo);
			System.out.println(price);
	       
			b = new Booking(bookingId, bookingDt, fNo, customer, price, seatsBooked, doj);
			
			System.out.println(b);
	        
            
    	}
        catch(Exception e)
        {
        	System.out.println(e);
        }
        return b;
	              
	}

	public List<Booking> getBookingByCId(int cId) throws SQLException, ClassNotFoundException
	{
		List<Booking>blist=new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
        Statement stmt=con.createStatement();
        //fill your code
        Booking c=null;
        String query="Select * from BOOKING_INFO where CID="+cId;
        ResultSet rs=stmt.executeQuery(query);
        Customer customer = new CustomerDAO().getUserById(cId);
        try {
        	while(rs.next())
            {
	            String bookingId = rs.getString(1);
	            Date bookingDt = rs.getDate(2);
				String fNo = rs.getString(3);								
				Integer price=rs.getInt(5);
				Integer seatsBooked = rs.getInt(6);
				Date doj = rs.getDate(7);	             
	       
	           Booking b = new Booking(bookingId, bookingDt, fNo, customer, price, seatsBooked, doj);
	           blist.add(b);
            }
    	}
        catch(Exception e)
        {
        	System.out.println(e);
        }
        return blist;
	              
	}
	
	 public List<Booking> listAllBooking(int cId) throws ClassNotFoundException, SQLException
     {

		 List<Booking> blist=new ArrayList<>();

          Class.forName("com.mysql.jdbc.Driver");

          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");

          Statement stmt=con.createStatement();

          //fill your code

          String query="Select * from booking_info";

          ResultSet rs=stmt.executeQuery(query);

          while(rs.next())
          {

              String Booking_Id=rs.getString(1);

              Date booking_Dt=rs.getDate(2);

              String F_No=rs.getString(3);

             

              int c=rs.getInt(4);

              Integer price=rs.getInt(5);

              Date DOJ=rs.getDate(6);

                                                

             

              }

           return blist;

     }
	 
	 public boolean deleteBookingById(String bookingId) throws ClassNotFoundException, SQLException
	 {
		 boolean b=false;
		 Class.forName("com.mysql.jdbc.Driver");
	     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
	     Statement stmt=con.createStatement();

	     try
	     {
	     
		     String query="delete from booking_info where Booking_ID='"+bookingId+"'";
		    
		     int rs=stmt.executeUpdate(query);
		     
		     b=true;
	     }
	     catch(Exception ex)
	     {
	    	 System.out.println(ex);
	     }
	     
	     return b;
	 }

	 
	
}
