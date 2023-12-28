<%@page import="java.util.Enumeration"%>
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
	<%-- <%
	Enumeration<String> headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()){
		String headerName = headerNames.nextElement();
		String headerValue = request.getHeader(headerName);
		out.println(headerName + " : " + headerValue + " <br />");	//<%= % 를 대체. 내장되어 있음.
	}
	%> --%>
	
	<%
	Enumeration<String> headerNames = request.getHeaderNames();	//예시)다운로드 받을 때, 접속한 브라우저/운영체제 기반의 파일을 제공한다.
	while(headerNames.hasMoreElements()){
		String headerName = headerNames.nextElement();
		String headerValue = request.getHeader(headerName);%>
		<%= headerName%> : <%= headerValue %> <br />
	<% 	
	}
	%>
</body>
</html>