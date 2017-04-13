<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

body {

	background: linear-gradient(141deg, #0fb8ad 0%, #1fc8db 51%, #2cb5e8 75%) no-repeat center fixed;
	background-size: cover;
	
}

input[type=submit] {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 16px 32px;
    width: 40%;
    font-size: 20px;
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

	font-size: 30px;
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

<title>Profits</title>
</head>
<body>

<%ArrayList<String> profitsInfo = (ArrayList<String>) request.getAttribute("profitsInfo");%>

<table style="width:50%" border="1">

<% 
for(int i = 0; i < profitsInfo.size(); i+= 2) { 
%>

<tr>
<td><b><% out.print(profitsInfo.get(i)); %>:</b>
<td>$<% out.print(profitsInfo.get(i+1)); %></td>
</tr>

<%
}
%>

</table>

<br>

<form action=EmployeeMenu method="GET">
<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>