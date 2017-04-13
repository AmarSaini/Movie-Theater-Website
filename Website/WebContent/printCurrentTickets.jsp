<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
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

table {

	border-collapse: collapse;
	width: 100%;
	font-size: 25px;

}

th, td {

	text-align: left;
	padding: 8px;

}

tr:nth-child(even) {

	background-color: #f2f2f2;

}

tr:nth-child(odd) {

	background-color: white;

}

th {

	background-color: #00008b;
	color: white;

}

</style>

<title>Current Ticket Info</title>
</head>

<body>

<%ArrayList<String> ticketInfo = (ArrayList<String>) request.getAttribute("ticketInfo");%>

<table border="1">

	<tr>
	<th>Movie Name</th>
	<th>Ticket Quantity</th>
	<th>Start Date</th>
	<th>Start Time</th>
	<th>Duration</th>
	<th>Room Number</th>
	<th>Movie Format</th>
	</tr>

	<%
	for(int i = 0; i < ticketInfo.size(); i+= 7) {
	%>

	<tr>
	<td><% out.print(ticketInfo.get(i)); %></td>
	<td><% out.print(ticketInfo.get(i+1)); %></td>
	<td><% out.print(ticketInfo.get(i+2)); %></td>
	<td><% out.print(ticketInfo.get(i+3)); %></td>
	<td><% out.print(ticketInfo.get(i+4)); %></td>
	<td><% out.print(ticketInfo.get(i+5)); %></td>
	<td><% out.print(ticketInfo.get(i+6)); %></td>
	</tr>

	<%
	}
	%>

</table>

<br>

<form action="CustomerMenu" method="GET">
	<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>