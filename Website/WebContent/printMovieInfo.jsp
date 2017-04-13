<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<title>Movie Info</title>
</head>
<body>

<%
String movie_name = (String) request.getAttribute("movie_name");
String releaseDate = (String) request.getAttribute("releaseDate");
String name = (String) request.getAttribute("name");
String gender = (String) request.getAttribute("gender");
String dateOfBirth = (String) request.getAttribute("dateOfBirth");
%>

<table style="width:50%" border="1">

<tr>
<td><b>Movie Name</b></td>
<td><% out.print(movie_name); %></td>
</tr>

<tr>
<td><b>Movie Release Date</b></td>
<td><% out.print(releaseDate); %></td>
</tr>

<tr>
<td><b>Main Actor's Name</b></td>
<td><% out.print(name); %></td>
</tr>

<tr>
<td><b>The Actor's Gender</b></td>
<td><% out.print(gender); %></td>
</tr>

<tr>
<td><b>The Actor's Birthday</b></td>
<td><% out.print(dateOfBirth); %></td>
</tr>

</table>

<br>

<form action="CustomerMenu" method="GET">
<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>