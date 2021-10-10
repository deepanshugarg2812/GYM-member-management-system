<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/home.css">
		<meta charset="UTF-8">
		<title>Home</title>
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
		        <a class="nav-link" href="home.jsp">Add members</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="viewmembers">View Members</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="viewmember.jsp">View Member info</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="deletemembers.jsp">Delete Members</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="logout">Logout</a>
		      </li>
		    </ul>
		  </div>
		</nav>
		
		<div class="container loginform">
			<form method="post" action="addmember">
				<h2 class="text-center">Add Member</h2>
				<div class="form-group">
					<input type="text" placeholder="Enter Name" name="name" class="form-control">
				</div>
				
				<div class="form-group">
					<input type="number" placeholder="Enter age" name="age" class="form-control">
				</div>
				
				<div class="form-group">
					<input type="text" placeholder="Enter Height" name="height" class="form-control">
				</div>
				
				<div class="form-group">
					<input type="text" placeholder="Enter Weight" name="weight" class="form-control">
				</div>
				
				<div class="form-group">
					<input type="text" placeholder="Enter Date of Joining in YYYY-MM-DD Format" name="doj" class="form-control">
				</div>
				
				
				<div class="form-group">
					<input type="text" placeholder="Enter Date of ending in YYYY-MM-DD Format" name="doe" class="form-control">
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Add</button>
				</div>
			</form>
		</div>
	
	</body>
</html>