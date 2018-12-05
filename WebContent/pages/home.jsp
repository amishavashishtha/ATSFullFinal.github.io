<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style type="text/css">

	body {
	
		background: url("${pageContext.request.contextPath}/images/airplane.jpg");
	
	}

</style>
</head>
<body>

	<% Customer customer = (Customer) session.getAttribute("customer"); %>

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
	        <a class="nav-link" href="${pageContext.request.contextPath}/pages/search_flight.jsp">Search Flights</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/pages/cancelBooking.do">Cancel Booking</a>
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
		    		
		    		<%= customer.getcName().split(" ")[0] %>
		    		
	    		</div>
	    		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/EditCustomer">Edit Profile</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/cancelBooking.do">Cancel Bookings</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/logout.do">Logout</a>
		        </div>
	    	</div>
	    </div>
	  </div>
	</nav>




	<div class="wrapper container">
		
		<div class="row justify-content-center" style="margin-top: 100px">
			
			<div class="jumbotron" style="background-color: rgba(0, 0, 0, .7); color: white"> 
			  <h1 class="display-4">Hello, <%= customer.getcName().split(" ")[0] %>!</h1>
			  <p class="lead">Now experience completely seamless and hassle free flight booking with FlyEasy!</p>
			  <hr class="my-4" style="border-color: white; background-color: white; color: white">
			  <p>Lets find the best flight to your next destination.</p>
			  <a class="btn btn-light btn-lg" href="${pageContext.request.contextPath}/pages/search_flight.jsp" role="button">Search Flights</a>
			</div>
			
		</div>
		
	</div>

</body>
</html>