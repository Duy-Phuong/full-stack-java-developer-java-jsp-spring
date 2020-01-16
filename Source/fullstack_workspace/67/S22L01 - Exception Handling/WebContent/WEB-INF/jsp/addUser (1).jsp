<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/files/css/style.css" />
<title>Add User</title>
</head>
<body>
<table>
<form:form modelAttribute="user" action="addUser">

<tr><td>Name : <form:input path="name"/> 
<form:errors path="name" cssStyle="color:red"></form:errors></td></tr>
<tr><td>Email : <form:input path="email"/>
<form:errors path="email" cssStyle="color:red"></form:errors></td></tr>
<tr><td><input type="submit" value="Sumit"></td></tr>
</form:form>
</table>
</body>
</html>