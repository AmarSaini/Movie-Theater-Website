<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style> 
h1 {

	color: black;
	font-size: 50px

}

form {

	text-align: center;

}

body {

	background: linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%) no-repeat center fixed;
	background-size: cover;
	
}

input[type=submit] {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    width: 60%;
    border-radius: 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 50px;
    margin: 8px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;

}

input[type=submit]:hover {

	border: 8px solid red;
	background-color: #00008b;
    color: white;

}

</style>

<title>Customer Menu</title>
</head>
<body>

<h1 align="center">Welcome to the Customer Menu</h1>

<form action="CustomerMenu" method="GET">
	<input name="Selection" type="submit" value="View Your Current Tickets">
	<input name="Selection" type="submit" value="View Showtimes/Buy A Ticket">
	<input name="Selection" type="submit" value="View A Movie's Information">
	<input name="Selection" type="submit" value="Back To Main Menu">
</form>

</body>
</html>