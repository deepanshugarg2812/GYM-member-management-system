<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/index.css">
		<meta charset="UTF-8">
		<title>Sign up</title>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <a class="navbar-brand" href="#">Gym</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav ml-auto">
		      <li class="nav-item">
		        <a class="nav-link" href="index.jsp">Login</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="signup.jsp">Sign up</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		<div class="container loginform">
			<h2 class="text-center">Login</h2>
			<div class="form-group">
				<input type="text" placeholder="Enter your username" name="username" class="form-control">
			</div>
			
			<div class="form-group">
				<input type="text" placeholder="Enter your password" name="password" class="form-control">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		
		</div>
	
	</body>
</html>