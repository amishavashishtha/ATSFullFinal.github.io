package com.dao;

import com.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDAO {

	public Flight getFlightById(String F_NO) throws ClassNotFoundException, SQLException, ParseException
    {
		Flight f=null;
		Class.forName("com.mysql.jdbc.Driver");
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
        Statement stmt=con.createStatement();
 
        String query="Select * from FLIGHT_MASTER where F_NO='"+F_NO+"'";
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next())
        {
			String F_NO1=F_NO;
			String A_ID=rs.getString(2);
			Airline a=new AirlineDAO().getAirlineById(A_ID);
			int TOT_SEATS=rs.getInt(3);
			int src=rs.getInt(4);
			int dest=rs.getInt(5);
			Location l1=new LocationDAO().getLocationByID(src);
			Location l2=new LocationDAO().getLocationByID(dest);
			 Date ARRIVAL_TIME= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(6));
				
			  Date DEPART_TIME=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(7));
			int FARE=rs.getInt(8);
			f=new Flight(F_NO1, a, TOT_SEATS, l1, l2, ARRIVAL_TIME, DEPART_TIME, FARE); 
         }
     return f;
    }

	
	
	public List<Flight> getFlight(int departFrom,int arrivingTo,Date dop) throws ClassNotFoundException, SQLException
    {

        List<Flight>flist=new ArrayList<>();

       

		Class.forName("com.mysql.jdbc.Driver");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");

        Statement stmt=con.createStatement();

        //fill your code

        String query="select * from flight_master where src = " + departFrom + " and dest = " + arrivingTo + " and DEPART_TIME = '"+ sdf.format(dop) + "'";

        System.out.println(query);
        
        ResultSet rs=stmt.executeQuery(query);

        try {

	        while(rs.next())
			{
			
			  String F_NO=rs.getString(1);
			
			  String A_ID=rs.getString(2);
			
			  Airline a=new AirlineDAO().getAirlineById(A_ID);			  
			  
			  int TOT_SEATS=rs.getInt(3);
			
			  int src=rs.getInt(4);
			
			  int dest=rs.getInt(5);
			
			  Location l1=new LocationDAO().getLocationByID(src);
			
			  Location l2=new LocationDAO().getLocationByID(dest);
			
			  Date ARRIVAL_TIME= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(6));
			
			  Date DEPART_TIME=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(7));
			
			  int FARE = Integer.parseInt(rs.getString(8));
					  
			  
			  Flight f=new Flight(F_NO, a, TOT_SEATS, l1, l2, ARRIVAL_TIME, DEPART_TIME, FARE);
			
			  flist.add(f);
			
			 
			
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
		
		return flist;

    }
	
}
