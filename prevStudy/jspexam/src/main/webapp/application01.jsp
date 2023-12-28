<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		String url = application.getInitParameter("url");
		String driverClass = application.getInitParameter("driver");
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url,"dongwoo","dongwoo");
	%>
	
	<p>초기화 파라메터로 얻어온 값(url) : <%=url %></p>
	<p>초기화 파라메터로 얻어온 값(driver) : <%=driverClass %></p>
	
	<p>WAS(Tomcat) 정보 : <%=application.getServerInfo() %></p>
	<p>Tomcat의 서블릿 메인 버전 : <%=application.getMajorVersion() %></p>
	<p>Tomcat의 서블릿 서브 버전 : <%=application.getMinorVersion() %></p>
	
</body>
</html>