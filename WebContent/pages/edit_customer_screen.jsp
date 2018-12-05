<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
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
       
       .form-row {
       
              padding: 10px;
       
       }
       
       .fa-pencil {
       
              margin-left: 10px;
       
       }

</style>

</head>
<body>

       <% Customer customer = (Customer) session.getAttribute("customer"); %>

       <!--  Navbar -->
       <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
         <a class="navbar-brand" href="${pageContext.request.contextPath}/home.do">FlyEasy!</a>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
           <span class="navbar-toggler-icon"></span>
         </button>
       
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
           <ul class="navbar-nav mr-auto">
             <li class="nav-item">
               <a class="nav-link active" href="${pageContext.request.contextPath}/home.do">Home</a>
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
                        <a class="dropdown-item" href="#">Edit Profile</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/pages/cancelBooking.do">Cancel Bookings</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout.do">Logout</a>
                      </div>
              </div>
           </div>
         </div>
       </nav>
       
       <div class="wrapper container">
       
              <div class="container" style="margin-top: 50px; background-color: rgba(0, 0, 0, .5); color: white">
              
                     <h1 style="padding-top: 50px;">Edit Profile</h1>
                     
                     <div class="container">
                          ${msg}
                     </div>
                     
                     <form action="${pageContext.request.contextPath}/pages/EditCustomer" method="post">                                          
                     
                                                              
                     
                           <div class="form-row">
                                  <label for="customer_name" class="col-sm-2 col-xs-12 col-form-label">Customer Name</label>
                                  <div class="col-sm-4">
                                         <input type="text" class="form-control" name="cName" id="customer_name" value="${ sessionScope.customer.cName }" >
                                  </div>
                                  
                           </div>
                           
                           <div class="form-row">
                                  <label for="dob" class="col-sm-2 col-form-label">DOB</label>
                                  <div class="col-sm-4">
                                         <input type="text" class="form-control" name="dob" id="dob" value="10-JAN-1995" >
                                  </div>
                                  
                           </div>
                           
                           <div class="form-row">
                                  <label for="email" class="col-sm-2 col-form-label">Email</label>
                                  <div class="col-sm-4">
                                         <input type="email" class="form-control" id="email" name="email" value="${ sessionScope.customer.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                         title="email should be as per rule" >
                                  </div>
                                  
                           </div>
                           
                     
                           <div class="form-row">
                                  <label for="phoneno" class="col-sm-2 col-form-label">Phone number</label>
                                  <div class="col-sm-4">
                                         <input type="number" class="form-control" id="phoneno" name="phno" value="${ sessionScope.customer.phno }" maxlength="10"
                                           title="must not exceed 10 values">
                                  </div>
                                  
                           </div>
                     
                           <div class="form-row">
                                  <label for="address" class="col-sm-2 col-form-label">Address</label>
                                  <div class="col-sm-4">
                                         <input type="text" class="form-control" id="address" name="address" maxlength="100" value="${ sessionScope.customer.address }"
                                           title="Address cannot be more than 100 characters " >
                                  </div>
                                  
                           </div>
                     
                           <div class="form-row">
                                  <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                                  <div class="col-sm-4">
                                         <input type="text" class="form-control" id="gender" name="gender" value="${ sessionScope.customer.gender }" >
                                  </div>
                                  
                           </div>
                           
                           <div class="form-row">
                                  <label for="ssn" class="col-sm-2 col-form-label">SSN_Number</label>
                                  <div class="col-sm-4">
                                         <input type="text" class="form-control" id="ssn" name="ssnType" value="${ sessionScope.customer.ssn.type }" >
                                  </div>
                                  
                                  
                                  <div class="w-100"></div>
                                  
                                  <div class="offset-sm-2 col-sm-4">
                                         <input type="text" class="form-control" id="ssn" name="ssnNumber" value="${ sessionScope.customer.ssn.no }" >
                                  </div>
                                  
                           </div>
                     
                           <div class="form-row">
                                  <button class="btn btn-primary"  type="submit" style="margin: 10px">Update</button>
                                  <button class="btn btn-danger" type="reset" style="margin: 10px">Reset</button>
                           </div>
                     
                     </form>
              
              </div>
       
       </div>
       
       


</body>
</html>
