package com.dao;

import com.model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {

	public Location getLocationByID(int id) throws ClassNotFoundException, SQLException
    {

            List<Location>lList=new ArrayList<>();

            Location l=null;

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
			
			Statement stmt=con.createStatement();
			
			                      
			
			String query="Select LOCATION_NAME from LOCATION_MASTER where LOCATION_ID="+id;
			
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			
			{
			
			    int LOCATION_ID=id;
			
			    String LOCATION_NAME=rs.getString(1);
			
			    l=new Location(LOCATION_ID, LOCATION_NAME);
			
			}
			
			return l;

    }
	
	public Location getLocationByName(String name) throws ClassNotFoundException, SQLException
    {

            List<Location>lList=new ArrayList<>();

            Location l=null;

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");
			
			Statement stmt=con.createStatement();
			
			                      
			
			String query="select LOCATION_ID from location_master where LOCATION_NAME = '"+name+"'";
			
			ResultSet rs=stmt.executeQuery(query);
			
			try {
			
				while(rs.next())
				
				{
				
				    int LOCATION_ID = rs.getInt(1);
				
				    String LOCATION_NAME=name;
				
				    l=new Location(LOCATION_ID, LOCATION_NAME);
				
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
			
			return l;

    }
	
}
