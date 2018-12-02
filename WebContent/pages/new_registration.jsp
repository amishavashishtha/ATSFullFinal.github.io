<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		background-size: cover;
		background-repeat: no-repeat;
		overflow-x: hidden;
	
	}

	label {
	
		font-weight: bold;
	
	}

	#password + .glyphicon {
	   cursor: pointer;
	   pointer-events: all;
	 }

</style>
</head>
<body>
	<div class="row">
	
		<div class="container offset-md-6 col-lg-6" style="background-color: rgba(0, 0, 0, .8); color: white;">
		
			<div class="container" style="padding: 30px;">
				<h1>Registration Page</h1>
			</div>
			
			<div class="container" style="padding-bottom: 10px;">
				Already have an account? &nbsp;<a href="${pageContext.request.contextPath}/login.do">Login</a>
			</div>
			
			<div class="container" style="padding-bottom: 10px;">
				${errmsg_regfail}
			</div>
			
			<div class="container">
				<form action="${pageContext.request.contextPath}/login.do" onsubmit="return validateForm()" method="post">
				
					<div class="form-group row">
					    <label for="name" class="col-sm-2 col-form-label">Name</label>
					    <div class="col-sm-6">
					      <input type="text" class="form-control" name="name" id="name" placeholder="Enter your name" required pattern="[a-zA-Z ]+"  title="Name cannot contain special characters or numbers" />
					    </div>
					</div>
				
					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-6">
							<input id=email type="email" name="email" class="form-control" aria-describedby="emailHelp"  placeholder="Enter your email"  required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"  title="Please enter a valid email" />
							<small id="emailHelp" class="form-text text-muted">
							<span>
								${errmsg_email}
							</span>
						</small>
						</div>											
					</div>
				
					<div class="form-group row  has-feedback">
						<label for="password" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-6">
							<input type="password" id="password" name="password" class="form-control" aria-describedby="passwordHelp" required  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{6,10}" title="Password should be as per defined rules" />
							<i class="fas fa-eye-open form-control-feedback"></i>
							<small id="passwordHelp" class="form-text text-muted">
								<span style="color: white;">
									Password length must be between 6 and 10 characters. <br/> 
									Use at least 1 upper case, 1 special character, 1 digit and lower case letters.
								</span>
							</small>
						</div>					
					</div>
					
					<div class="form-group row">
						<label for="confirmPassword" class="col-sm-2 col-form-label">Confirm Password</label>
						<div class="col-sm-6">
							<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" id="confirmPassword"  aria-describedby="confirmPasswordHelp" required title="Please re-enter password to confirm" />
							<small id="confirmPasswordHelp" class="form-text text-muted">
								<span id="errmsg"></span>								
							</small>
						</div>						
					</div>
										
					
					<div class="form-group row">
						<label for="dob" class="col-sm-2 col-form-label">DOB</label>
						<div class="col-sm-6">
							<input id="dob" name="dob" type="date" class="form-control" required title="Please enter your Date of Birth in MM/DD/YYYY format"  required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" />
						</div>
					</div>
					
					<div class="form-group row">
						<label for="address" class="col-sm-2 col-form-label">Address</label>
						<div class="col-sm-6">
							<textarea maxlength="100" name="address" id="address" class="form-control" rows="3" required title="Address must be provided and must not exceed 100 characters"></textarea>
						</div>
					</div>
				
					<div class="form-group row">
						<label for="phone" class="col-sm-2 col-form-label">Phone</label>
						<div class="col-sm-6">
							<input type="tel" name="phone" id="phone"  class="form-control" id="phoneno" maxlength="10"
                                           title="Contact number must not exceed 10 values" pattern="(?=.*\d).{10}" required>
							<!-- <input type="number" name="phone"  maxlength="10" id="phone" class="form-control" required title="Contact number must be provided and must not exceed 10 values" /> -->
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Gender</label>
						<div class="col-sm-6">
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="M" checked>
							  <label class="form-check-label" for="inlineRadio1">Male</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="F">
							  <label class="form-check-label" for="inlineRadio2">Female</label>
							</div>
						</div>
					</div>
				
					<div class="form-group row">
						<label for="ssn" class="col-sm-2 col-form-label">SSN</label>
						<div class="col-sm-6">
							<select id="SSN" name="ssnType" class="form-control" required>
								<option>Passport</option>
								<option>Voter ID</option>
								<option>Pan Card</option>
								<option>Driving License</option>
							</select>
						</div>
						<div class="w-100"></div>
						<div class="offset-sm-2 col-sm-6" style="margin-top: 10px">
							<input type="text" name="ssnNo" class="form-control" placeholder="Enter SSN ID number" required title="Please enter SSN number" aria-describedby="ssnNoHelp" />
							<small id="ssnNoHelp" class="form-text text-muted">
								<span>
									${errmsg_ssnNo}
								</span>
							</small>
						</div>
					</div>
				
					<div class="form-group container" style="display: inline-block;">
						
						<input class="btn btn-success" type="submit" value="Register" />
						<input class="btn btn-light" type="reset" value="Clear" />
						
					</div>
				
				</form>
			</div>
		
		</div>
	
	</div>
	
	<script>
	
		function validateForm() {
			
			var psw1 = document.getElementById("password").value;
			var psw2 = document.getElementById("confirmPassword").value;
						
			if(psw1 != psw2) {				
				
				document.getElementById("errmsg").innerHTML = "<font color=red>Passwords do not match!</font>";
				return false;
				
			}
			
		}
		
		// toggle password visibility
		$('#password + .glyphicon').on('click', function() {
		  $(this).toggleClass('glyphicon-eye-close').toggleClass('glyphicon-eye-open'); // toggle our classes for the eye icon
		  $('#password').togglePassword(); // activate the hideShowPassword plugin
		});
	
	</script>
	
</body>
</html>