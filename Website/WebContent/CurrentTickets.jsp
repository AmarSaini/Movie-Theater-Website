<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

label {

	font-size: 30px;
	font-weight: bold; 

}

form {

	text-align: center;

}

body {

	background: linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%) no-repeat center fixed;
	background-size: cover;
	
}

input[type=text] {
    width: 20%;
    padding: 12px 20px;
    margin: 8px 0px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    width: 15%;
    border-radius: 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 35px;
    margin: 4px 20px;
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

<title>Current Tickets</title>
</head>
<body>

<form action="CurrentTickets" method="GET">
<label>Name: </label>
<br>
<input name="name" type="text">
<br>
<input name="Selection" type="submit" value="Submit">
</form>

<br>

<form action=CustomerMenu method="GET">
	<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>