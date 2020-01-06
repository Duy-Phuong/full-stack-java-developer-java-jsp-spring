<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formatting demo</title>
</head>
<body>
<c:set var="date" value="<%=new java.util.Date()%>" />
<c:out value="${date }"></c:out>

<br/>Time: <strong><fmt:formatDate type="time" value="${date}" /></strong>

<br/>Date: <strong><fmt:formatDate type="date" value="${date}" /></strong>

<br/>Date and Time: <strong><fmt:formatDate type="both" value="${date}" /></strong>

<br/>Date and Time: <strong><fmt:formatDate type="both" value="${date}" timeZone="GMT -1" /></strong>

<br/>
<fmt:setLocale value="en_UK"/>
<br/>Date and Time: <strong><fmt:formatDate type="both" value="${date}" timeZone="GMT -1" /></strong>

</body>
</html>





