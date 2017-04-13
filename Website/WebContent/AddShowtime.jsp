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

	width: 60%;
	text-align: right;

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
    width: 40%;
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

.dropbtn {
    background-color: #990000;
    color: white;
    padding: 16px;
    font-size: 16px;
    border-radius: 12px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

</style>

<title>Add Showtime</title>
</head>
<body>

<form action="AddShowtime" method="GET">
	<label>Enter the Movie Name:</label> <input name="m_name" type="text"> <br>
	<div class="dropdown">
  		<button class="dropbtn">Info</button>
  		<div class="dropdown-content">
    		<a>Rooms 1-4 have Normal format</a>
    		<a>Rooms 5-6 have 3D format</a>
    		<a>Rooms 7-8 have IMAX format</a>
  		</div>
	</div>
	<label>Enter the Room Number:</label> <input name="s_roomID" type="text"> <br>
	<label>Enter the Show Start Date (YYYY-MM-DD):</label> <input name="s_startDate" type="text"> <br>
	<label>Enter the Show Start Time (#:## AM/PM):</label> <input name="s_startTime" type="text"> <br>
	<label>Enter the Show Duration (Minutes):</label> <input name="s_duration" type="text"> <br>
	<input name="Selection" type="submit" value="Submit">
</form>

<br>

<form action=EmployeeMenu method="GET">
	<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>