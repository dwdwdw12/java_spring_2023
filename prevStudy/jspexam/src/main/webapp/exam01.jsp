<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>

<%
	//스크립트릿(scriptlet) 이라고 한다. => java code를 사용한다.
	Date now = new Date();	//import도 가능
	System.out.println("현재 시스템에 설정된 날짜 및 시간: "+now);	//sysout 불가. 직접 입력. 콘솔에 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
	<p>서버에 설정된 시간 : <%= now %></p>		<!-- %= : 표현식   %@ : 지시어 -->
</body>
</html>