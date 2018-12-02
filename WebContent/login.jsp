<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style type="text/css">

	body {
	
		background: url("${pageContext.request.contextPath}/images/airplane.jpg");
		overflow-x: hidden;
	
	}

	label {
	
		font-weight: bold;
	
	}

</style>
</head>
<body>
	<div class="wrapper row justify-content-center">
	
		<div class="container col-sm-4" style="background-color: rgba(0, 0, 0, .9); color: white; margin-top: 100px; padding-bottom: 50px">
		
			<div class="row justify-content-center" style="padding: 30px; padding-bottom: 0px;">
				<h1>Login</h1> <br/>
						
			</div>			
			
			<div class="row justify-content-center" style="padding: 5px;">							
				${errmsg}
			</div>
			
			<div class="container">
				<form action="${pageContext.request.contextPath}/search_flights.do" method="post">
				
					<div class="form-group row">
					    <label for="username" class="offset-sm-1 col-sm-2 col-form-label">Username</label>
					    <div class="col-sm-8">
					      <input type="text" class="form-control" name="username" id="username" placeholder="Enter your email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
					    </div>
					</div>
				
					<div class="form-group row">
						<label for="password" class="offset-sm-1 col-sm-2 col-form-label">Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" name="password" id="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{6,10}"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" >
						</div>
					</div>
				
					<div class="row justify-content-center">
						
						<button class="btn btn-success" type="submit" style="margin: 10px;">Login</button>
						<button class="btn btn-light" type="reset" style="margin: 10px;">Reset</button>
						
					</div>
				
				</form>
				
				<div class="row  justify-content-center">
					First time here? &nbsp;<a href="${pageContext.request.contextPath}/pages/new_registration.jsp">Create a new account</a>
				</div>
				
			</div>
		
		</div>
	
	</div>
</body>
</html>