<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Search Flight</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style>

       body {
       
              background: url("${pageContext.request.contextPath}/images/airplane.jpg");
       
       }

</style>
</head>
<body>
       <!--  Navbar -->
       <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
         <a class="navbar-brand" href="#">FlyEasy!</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
       
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav mr-auto">
             <li class="nav-item">
               <a class="nav-link active" href="#">Home</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="#">Search Flights</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="pages/cancelBooking.do">Cancel Booking</a>
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
                                                
                            ${ sessionScope.customer.cName }
                            
                     </div>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="pages/edit_customer_screen.jsp">Edit Profile</a>
                        <a class="dropdown-item" href="cancel_booking.html">Cancel Bookings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Logout</a>
                      </div>
              </div>
           </div>
         </div>
       </nav>
              
       
       
       <div class="wrapper container">
       
       <!-- Search window -->
       <div class=row style="margin-top: 50px;">
       
              <div class="container" style="background-color: rgba(0, 0, 0, .5); color: white; padding: 20px;">
                     
                     <h1>
                           Search flight
                     </h1>
                     
                     <form action="SearchFlightController">
                     
                           <div class="form-row">
                           
                                  <div class="col">
                                         <input type="text" class="form-control" name="src" placeholder="Departing From" />
                                  </div>
                           
                                  <div class="col">
                                         <input type="text" class="form-control" name="dest" placeholder="Arriving To"/> 
                                  </div>
                           
                           </div>
                           
                           <br/>
                           
                           <div class="form-row">
                           
                                  <div class="col-sm-6">
                                         <label>Departure DateTime</label>
                                         <input class="form-control" name="departure_timestamp" type="datetime-local" id="datefield"/>
                                  </div>
                                  
                                  <div class="col-sm-3">
                                         <label>Travelers</label>
                                         <input class="form-control" name="no_of_travelers" type="number" min="1" max="20" value="1"/>
                                  </div>
                           
                                  <div class="col" style="text-align: center;">
                                         <br/>
                                         <button type="submit" class="btn btn-primary" > <span class="fa fa-search"></span> Search</button>
                                  </div>
                           
                           </div>
                     
                     </form>
                     
              </div>
       
       </div>
       
       </div>
       
       <script type="text/javascript">
       
              $(document).ready(function(){
                     
                     var today = new Date();
                     var dd = today.getDate();
                     var mm = today.getMonth()+1; //January is 0!
                     var yyyy = today.getFullYear();
              
                     today = yyyy+'-'+mm+'-'+dd;
                     document.getElementById("datefield").setAttribute("min", today);
                     
              });
       
       </script>
</body>
</html>
