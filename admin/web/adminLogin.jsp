<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Management System Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<nav style="background-color: rgba(0, 0, 0, 0.1);"
		class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Hotel Online Reservation</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<br /> <br />
		<div class="col-md-8" style="margin-left: 150px;">
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h4>Administrator</h4>
				</div>
				<div class="panel-body">
					<form action="AdminLogin" method="Get">
						<div class="form-group">
							<label>Username</label> <input type="text" name="username"
								class="form-control" required="required" />
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password" name="password"
								class="form-control" required="required" />
						</div>
						<br />
						<div class="form-group">
							<button name="login" class="form-control btn btn-primary">
								<i class="glyphicon glyphicon-log-in"> Login</i>
							</button>
							&nbsp;
							<button name="reset" class="form-control btn btn-danger">
								Reset</button>
						</div>
						<br />
						<div class="form-group">
							<a href="HotelMainPage.jsp">Go To Home Page</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<br />
	<br />
	
</body>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.js"></script>
</html>