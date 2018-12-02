<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Flight, java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search Results</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">

       body {
       
              background: url("images/airplane.jpg");
              background-size: cover;
              background-repeat: no-repeat;
       
       }

       .parameters {
       
              text-align: left;
       
       }

</style>
</head>
<body>
<!--  Navbar -->
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
         <a class="navbar-brand" href="search_flight.html">FlyEasy!</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
       
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav mr-auto">
             <li class="nav-item active">
               <a class="nav-link" href="search_flight.html">Home <span class="sr-only">(current)</span></a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="search_flight.html">Search Flights</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="cancel_booking.html">Cancel Booking</a>
             </li>
             <!-- 
                    <li class="nav-item">
                      <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
              -->
           </ul>
           <div class="navbar-right" style="color: white; font-size: 20px;">
              <div  class="nav-item dropdown" style="cursor: pointer">
                     <div class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           
                            <span style="border: 1px solid white; border-radius: 100%; margin-right: 10px; text-align: center">
                                  <span class="fa fa-user" style="padding-left: 10px; padding-right: 5px;"></span>
                            </span>
                            
                            Tom Sawyer 
                     </div>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="edit_customer_screen.html">Edit Profile</a>
                        <a class="dropdown-item" href="cancel_booking.html">Cancel Bookings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Logout</a>
                      </div>
              </div>
           </div>
         </div>
       </nav>
       
       <div class="wrapper container-fluid" style="margin-left: 0px; text-align: center;">
       
              <div class="row" style="padding-top: 50px; padding-bottom: 50px; padding-left: 10%; background-color: rgba(255, 255, 255, .5);">
              
                     <div class="col parameters">
                           <label>Departing From</label>
                           <input type="text" class="form-control" placeholder="Departing From" />
                     
                     </div>
                     
                     <div class="col parameters">
                     
                           <label>Arriving To</label>
                           <input type="text" class="form-control" placeholder="Arriving To"/>
                     
                     </div>
                     
                     <div class="col parameters">
                     
                           <label>Departure DateTime</label>
                           <input class="form-control" type="datetime-local" id="datefield"/>
                     
                     </div>
                     
                     <div class="col parameters">
                     
                           <label>Travelers</label>
                           <input class="form-control" type="number" min="1" max="20" value="1"/>
                     
                     </div>
                     
                     <div class="col parameters">
                     
                           <br />
                           <button type="submit" class="btn btn-primary" > <span class="fa fa-search"></span> Search</button>
                     
                     </div>
              
              
              </div>
              
              <span style="font-size: 48px; color: white; font-weight: bolder; padding-top: 20px">
                     Search Results
              </span>
              
              <ul class="container list-group" style="margin-top: 50px; margin-bottom: 50px;">
              
                     <% 

                     List<Flight> flightList = (List<Flight>) request.getAttribute("flightList");
                     
                     for(Flight flight : flightList) { %>
              
                     <li class="list-group-item">                          
                     
                                  <div class=" result_item row">
                                         <div class="col">
                                                <%= flight.getfNo()  %>
                                         </div>
                                  
                                         <div class="col">
                                                <%= flight.getaId().getaName()  %>
                                         </div>
                                  
                                         <div class="col">
                                         
                                                <%= flight.getSrc().getLocationName()  %> <br/>
                                                <%= new SimpleDateFormat("HH:mm").format(flight.getDepartTime()) %> 
                                         
                                         </div>
                                  
                                         <div class="col">
                                         
                                                <%= flight.getDest().getLocationName()  %> <br/>
                                                <%= new SimpleDateFormat("HH:mm").format(flight.getArrivalTime())  %> 
                                         
                                         </div>
                                  
                                         <div class="col">
                                                
                                                INR <%= flight.getFare() %>
                                                
                                         </div>
                                  
                                         <div class="col">
                                         
                                                <form action="BookingFlight?fid=<%= flight.getfNo()  %>" method="Post">                                          
                                                    <button class="btn btn-dark" type="submit">Book</button>
                                                </form>
                                         
                                         </div>
                                         
                                  </div>
                                                      
                     </li>
                     
                     <% } %>
                                         
                     
              
              </ul>
              
       </div>
</body>
</html>
