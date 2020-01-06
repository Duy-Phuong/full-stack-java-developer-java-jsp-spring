<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo</title>
</head>
<body>
<c:set var="someNumber" value="654321.123456"/>
<b><c:out value="${someNumber}" /></b>
<br/>
<br/>
Max Integer Digits : <fmt:formatNumber type="number" maxIntegerDigits="3" value="${someNumber}" />
<br/>
Max Fraction Digits :<fmt:formatNumber type="number" maxFractionDigits="3" value="${someNumber}" />
<br/>
Currency : <fmt:formatNumber value="${someNumber}" type="currency"/>
<br/>
<fmt:setLocale value="en_US"/>
Currency : <fmt:formatNumber value="${someNumber}" type="currency"/>
</body>
</html>

