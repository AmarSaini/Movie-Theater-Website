<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

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

<title>Success</title>
</head>
<body>

<% String m_name = (String) request.getAttribute("m_name"); %>

<h1 align="center">A New Showtime for "<% out.print(m_name); %>" was Successfully Added to the Theater Database.</h1>

<br>

<form action=EmployeeMenu method="GET">
	<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>