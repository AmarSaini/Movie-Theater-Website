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
    width: 45%;
    border-radius: 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
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

<title>Receipt</title>
</head>
<body>

<%ArrayList<String> buyTicketInfo = (ArrayList<String>) request.getAttribute("buyTicketInfo");%>

<table style="width:100%" border="1">

<tr>
<td><b>Movie Name:</b></td>
<td><% out.print(buyTicketInfo.get(0)); %></td>
</tr>

<tr>
<td><b>Tickets Bought:</b></td>
<td><% out.print(buyTicketInfo.get(1)); %></td>
</tr>

<tr>
<td><b>Total Price:</b></td>
<td><% out.print(buyTicketInfo.get(2)); %></td>
</tr>

<tr>
<td><b>Room #:</b></td>
<td><% out.print(buyTicketInfo.get(3)); %></td>
</tr>

<tr>
<td><b>Show Date:</b></td>
<td><% out.print(buyTicketInfo.get(4)); %></td>
</tr>

<tr>
<td><b>Show Time:</b></td>
<td><% out.print(buyTicketInfo.get(5)); %></td>
</tr>

<tr>
<td><b>Duration:</b></td>
<td><% out.print(buyTicketInfo.get(6)); %></td>
</tr>

<tr>
<td><b>Format:</b></td>
<td><% out.print(buyTicketInfo.get(7)); %></td>
</tr>

</table>

<br>

<form action="CustomerMenu" method="GET">
	<input name="Selection" type="submit" value="Back To Main Menu">
</form>

</body>
</html>