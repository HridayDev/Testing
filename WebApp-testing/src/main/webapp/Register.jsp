<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title> Register - Store </title>
		<!--%@include file="Common/CSS.jsp" %-->
	</head>
	<body style="background-color: #f0f1f2;">
		<!-- @include file="Common/Navbar.jsp" % -->
		<div class="container p-3">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body">
							<h3 class="text-center">Register</h3>
							<form action="test" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Full Name*</label>
									<input type="text" class="form-control" placeholder="Enter full name" required="required" name="name">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Email address*</label>
									<input type="email" class="form-control" placeholder="Enter email" required="required" name="email">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Phone Number*</label>
									<input type="number" class="form-control" placeholder="Enter phone" required="required" name="phno">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password*</label>
									<input type="password" class="form-control" placeholder="Password" required="required" name="pass">
								</div>
								<div class="form-check text-center">
									<input type="checkbox" class="form-check-input" id="tos" required="required" name="check">
									<label class="form-check-label" for="tos">I Agree To The TOS</label><br>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary">Submit</button><br>
									<a href="Login.jsp">Login</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--%@include file="Common/Footer.jsp" %-->
	</body>
</html>