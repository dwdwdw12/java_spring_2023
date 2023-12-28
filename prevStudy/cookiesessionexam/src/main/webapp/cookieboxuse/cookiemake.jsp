<%@page import="kr.co.dongwoo.util.CookieBox"%>
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
	<h1>쿠키를 생성하는 페이지</h1>
	<p>이 페이지의 내용은 상품 폴더의 sang1.jsp, sang2.jsp, sang3.jsp에서 사용되는 기능이다.</p>
	
	<%
		Cookie cookie = CookieBox.createCookie("newCookie", "5555", 60*60, "/");
		response.addCookie(cookie);
		//response.addCookie(CookieBox.createCookie("newCookie", "5555", 60*60, "/"));
	%>
	
</body>
</html>