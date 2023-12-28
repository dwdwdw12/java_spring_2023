<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String jobSelect = request.getParameter("jobSelect");
	%>
	<%
		if(jobSelect.equals("a")){
	%>
		<jsp:forward page="a.jsp" />
	<%   /*자바 코드가 아니므로 일일히 여닫아야 함*/
		} else if(jobSelect.equals("b")){
	%>
		<jsp:forward page="b.jsp" />
	<%
		} else {
	%>
		<jsp:forward page="c.jsp" />
	<%
		}
	%>
	
</body>
</html>