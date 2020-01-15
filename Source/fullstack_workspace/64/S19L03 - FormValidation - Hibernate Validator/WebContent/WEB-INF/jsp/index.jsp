<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/files/css/style.css"/>
</head>
<body>
	<h4>Submit your information</h4>
	<hr />
	
	<form:form action="hello" modelAttribute="info">
	
	First Name : <form:input path="firstName" required="true" placeholder="Enter First Name" />
		<p />
	Last Name : <form:input path="lastName" placeholder="Enter Last Name" />
		<p />
	Gender : <form:radiobuttons path="gender" items="${gender}" />
		<p />
	Country : <form:select path="country" items="${countries}" >
		</form:select>
		<p />
	Visited Country:
	<p />
		<form:checkboxes items="${visitedCountry}" path="visitedCountry" />

     <p>
	Message :
	     <form:textarea path="message" required="true" />
	<p />
	<input type="submit" Value="Submit">

	</form:form>
</body>
</html>




