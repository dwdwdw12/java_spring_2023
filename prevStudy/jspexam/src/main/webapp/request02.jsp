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
	<h1>서버 클라이언트 정보 얻기</h1>
	<p>접속 클라이언트 ip주소 : <%= request.getRemoteAddr() %> <br /></p>
	<p>요청 정보 길이 : <%= request.getContentLength() %> <br /></p>
	
	
</body>
</html>