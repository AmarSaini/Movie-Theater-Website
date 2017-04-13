<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

label {

	font-size: 30px;

}

form {

	width: 60%;
	text-align: right;

}

input[type='radio'] {

	transform: scale(1.5);

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

</style>

<title>Insert title here</title>
</head>
<body>

<form action="AddMovie" method="GET">
	<label><b>Enter the Movie Name:</b></label> <input name="m_name" type="text"> <br>
	<label><b>Enter the Movie Release Date (YYYY-MM-DD):</b></label> <input name="m_releaseDate" type="text"> <br>
	<label><b>Enter the Main Actor's Name:</b></label> <input name="a_name" type="text"> <br>
	<label><b>Enter the Main Actor's Gender (M/F)</b>:</label>
	<input type="radio" name="a_gender" value="M"> <label>Male</label>
	<input type="radio" name="a_gender" value="F"> <label>Female</label> <br>
	<label><b>Enter the Actor's Birthday (YYYY-MM-DD):</b></label> <input name="a_birthday" type="text"> <br>
	<input name="Selection" type="submit" value="Submit">
</form>

<br>

<form action=EmployeeMenu method="GET">
	<input name="Selection" type="submit" value="Go Back">
</form>

</body>
</html>