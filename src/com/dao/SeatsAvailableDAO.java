package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.model.Booking;
import com.model.Flight;
import com.model.SeatsAvailable;


public class SeatsAvailableDAO {
	
	public SeatsAvailable getTotalSeats(String fno) throws ClassNotFoundException, SQLException, ParseException
    {
       SeatsAvailable s=null;
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
      Statement stmt=con.createStatement();
      //fill your code
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String query="Select * from SEATS_AVAILABLE where F_NO='"+fno+"'";
      ResultSet rs=stmt.executeQuery(query);
             
      while(rs.next())
      {
    	  String fNo=rs.getString(1);
    	  Flight fNo1=new FlightDAO().getFlightById(fNo);
    	  Integer avaSeats=rs.getInt(2);
    	  Date deptDate=rs.getDate(3);
    	  s=new SeatsAvailable(fNo1, avaSeats, deptDate);
      }
      return s;
     
  }
 
	public void updateSeatAvailable(Flight f,Booking b) throws ClassNotFoundException, SQLException
     {
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
              Statement stmt=con.createStatement();
             
                 try
                  {
                     String query="update seats_available set AVA_SEATS="+(f.getTotSeats()-b.getSeatsBooked());
                     
                  int rs=stmt.executeUpdate(query);
                 }
                  catch(Exception ex)
                  {
                  System.out.println(ex);
                  }
     }


}
