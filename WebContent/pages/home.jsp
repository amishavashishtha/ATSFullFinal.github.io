<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>


<style type="text/css">

       #carouselExampleIndicators {
              height: 300px;
       }

</style>


</head>
<body>

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
               <a class="nav-link" href="search_flight.html">Search Flights</a>
             </li>
             <li class="nav-item">
               <a class="nav-link active" href="#">Cancel Booking</a>
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
                        <a class="dropdown-item" href="#">Cancel Bookings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Logout</a>
                      </div>
              </div>
           </div>
         </div>
       </nav>

       <div id="carouselExampleIndicators" class="carousel slide carousel-fade" data-ride="carousel">
         <ol class="carousel-indicators">
           <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
           <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
           <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
         </ol>
         <div class="carousel-inner">
           <div class="carousel-item active">
             <img class="d-block w-100" src="../images/airplane.jpg" alt="First slide">
             <div class="carousel-caption d-none d-md-block">
                  <h5>First Slide</h5>
                  <p>Lorem ipsum do re mi fa so la ti</p>
                </div>
           </div>
           <div class="carousel-item">
             <img class="d-block w-100" src="../images/airplane.jpg" alt="Second slide">
             <div class="carousel-caption d-none d-md-block">
                  <h5>Second Slide</h5>
                  <p>Lorem ipsum do re mi fa so la ti</p>
                </div>
           </div>
           <div class="carousel-item">
             <img class="d-block w-100" src="../images/airplane.jpg" alt="Third slide">
             <div class="carousel-caption d-none d-md-block">
                  <h5>Third Slide</h5>
                  <p>Lorem ipsum do re mi fa so la ti</p>
                </div>
           </div>
         </div>
         <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
           <span class="carousel-control-prev-icon" aria-hidden="true"></span>
           <span class="sr-only">Previous</span>
         </a>
         <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
           <span class="carousel-control-next-icon" aria-hidden="true"></span>
           <span class="sr-only">Next</span>
         </a>
       </div>

       <script>
              $(document).ready(function() { 
                     
                     $('.carousel').carousel({
                       interval: 2000
                     })
                     
                     var height = $(document).height();  
                     
                     $('.carousel').css("height", height);
                     
              });
              
       </script>

</body>
</html>