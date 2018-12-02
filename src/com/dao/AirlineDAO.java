package com.dao;

import com.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineDAO {

	public Airline getAirlineById(String id) throws ClassNotFoundException, SQLException

	   {

	        

	          Airline al=null;


	          Class.forName("com.mysql.jdbc.Driver");

	          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ars","root","root");

	          Statement stmt=con.createStatement();

	                                  //fill your code

	          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	          String query="Select * from AIRLINES_MASTER where A_ID="+"'"+id+"'";

	          ResultSet rs=stmt.executeQuery(query);

	                               

	          while(rs.next())

	          {
	        	  String A_Id=id;

	              String A_Name=rs.getString(2);

	              Date DOP=rs.getDate(3);

	              al=new Airline(A_Id, A_Name, DOP);
   
	          }

	          return al;

	    

	 }
	
}
