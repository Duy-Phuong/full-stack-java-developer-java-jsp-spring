<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
<!-- 
1. toLowerCase()
2. toUpperCase()
3. indexOf()
4. replace()
5. substring()
6. substringBefore()
7. substringAfter()
 -->
 
<br/>${fn:toUpperCase("StudyEasy.org")}
<br/>${fn:toLowerCase("StudyEasy")}
<br/>${fn:indexOf("StudyEasy", "u") }
<br/>${fn:replace("StudyEasy.org","StudyEasy","SuperEasy") }
<br/>${fn:substring("StudyEasy.org", 2, 5) }
<br/>${fn:substringBefore("StudyEasy.Org", "Easy") }
<br/>${fn:substringAfter("StudyEasy.Org", "Easy") }


</body>
</html>









