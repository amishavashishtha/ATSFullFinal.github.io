<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*, java.text.*, com.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Flight" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proforma Invoice</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style type="text/css">

       body {
       
              background: url("${pageContext.request.contextPath}/images/airplane.jpg");
              background-size: cover;
              background-repeat: no-repeat;
       
       }

       label {
       
              font-weight: bold;
       
       }

       .invoice {
              
              background-color: rgba(255, 255, 255, .9);
              padding: 50px;
              margin-bottom: 50px;
              border-radius: 5%;
       
       }

       @media only screen and (max-width: 992px) {
       
              .invoice {
              
                     border-radius: 0;
              
              }
       
       }

</style>



</head>
<body>

       <% Flight flight = (Flight) request.getAttribute("flightToBeBooked"); %>
       <% Customer customer = (Customer) session.getAttribute("customer"); %>

       <!--  Navbar -->
       <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
         <a class="navbar-brand" href="search_flight.html">FlyEasy!</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
       
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav mr-auto">
             <li class="nav-item">
               <a class="nav-link" href="search_flight.html">Home</a>
             </li>
             <li class="nav-item">
               <a class="nav-link active" href="search_flight.html">Search Flights</a>
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
                            
                            <%= customer.getcName() %>
                     </div>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="edit_customer_screen.html">Edit Profile</a>
                        <a class="dropdown-item" href="pages/cancelBooking.do">Cancel Bookings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="logout.do">Logout</a>
                      </div>
              </div>
           </div>
         </div>
       </nav>
       
       
       
              
       <div class="wrapper container" style="margin-top: 100px;">
       
              <div class="invoice offset-sm-3 col-sm-6">                  
                     
                     <div class="container" style="text-align: center">
                           <h1>Pro-forma Invoice</h1>
                     </div>
       
                     <hr class="col-lg-10"></hr>
                     
                     <div class="container">
                     
                           <form action="${pageContext.request.contextPath}/pages/confirmBooking.do?fNo=<%= flight.getfNo() %>" method="post">
                     
                                  <div class="form-row">
                                         <label for="customer_name" class="offset-sm-2 col-sm-4 col-form-label">Customer Name</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="customer_name" value="<%= customer.getcName() %>">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="airline_name" class="offset-sm-2 col-sm-4 col-form-label">Airline Name</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext"  id="airline_name" value="<%= flight.getaId().getaName() %>">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="leaving_from" class="offset-sm-2 col-sm-4 col-form-label">Leaving From</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="leaving_from" value="<%= flight.getSrc().getLocationName() %>">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="going_to" class="offset-sm-2 col-sm-4 col-form-label">Going To</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="going_to" value="<%= flight.getDest().getLocationName() %>">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="no_of_passengers" class="offset-sm-2 col-sm-4 col-form-label">Passengers</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="no_of_passengers" value="1">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="date_of_journey" class="offset-sm-2 col-sm-4 col-form-label">Date of Journey</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="date_of_journey" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(flight.getDepartTime()) %>">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="departure_time" class="offset-sm-2 col-sm-4 col-form-label">Departure Time</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="departure_time" value="<%= new SimpleDateFormat("HH:mm").format(flight.getDepartTime()) %> IST">
                                         </div>
                                  </div>
                                  
                                  <div class="form-row">
                                         <label for="booking_date" class="offset-sm-2 col-sm-4 col-form-label">Booking Date</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="booking_date" value="<%= new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %>">
                                         </div>
                                  </div>                            
                                  
                                  <div class="form-row">
                                         <label for="total_price" class="offset-sm-2 col-sm-4 col-form-label">Total Price</label>
                                         <div class="col-sm-6">
                                                <input type="text" readonly class="form-control-plaintext" id="total_price" value="INR <%= flight.getFare() %>">
                                         </div>
                                  </div>
                     
                     			<div class="container offset-sm-2" style="text-align: left">
                                  
	                                  <div>
	                           
	                                         <button class="btn btn-success" type="submit" style="margin: 20px;">Confirm</button>
	                                         <a href="search_results.html"><button class="btn btn-danger" type="button" style="margin: 20px;">Reset</button></a>
	                           
	                                  </div>
                           
                           		</div>
                     
                           </form>
                           
                           
                     
                     </div>
                     
              </div>
              
       
       </div>
</body>
</html>
