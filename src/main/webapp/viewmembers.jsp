<%@page import="java.util.*"%>
<%@page import="com.main.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<meta charset="UTF-8">
		<title>Members</title>
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
		
		<div class="container" style="margin-top : 10px;">
			<h2 class="text-center">Members list and details</h2>	
			<table class="table">
			 <thead>
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Age</th>
			      <th scope="col">Date of joining</th>
			      <th scope="col">Date of ending of membership</th>
			      <th scope="col">Height</th>
			      <th scope="col">Weight</th>
			    </tr>
			  </thead>
			  <tbody>
				<%
					List<Member> list = (List<Member>) request.getAttribute("members");
					for(Member mem : list)
					{
				%>
					<tr>
						<td><%= mem.getId() %></td>
						<td><%= mem.getName() %></td>
						<td><%= mem.getAge() %></td>
						<td><%= mem.getDoj() %></td>
						<td><%= mem.getDoe() %></td>
						<td><%= mem.getHeight() %></td>
						<td><%= mem.getWeight() %></td>
					</tr>
					
				<% } %>
				</tbody>
			</table>
		</div>
	
	</body>
</html>