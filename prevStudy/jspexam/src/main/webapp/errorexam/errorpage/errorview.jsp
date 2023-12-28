<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true"%>
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
	<h1>오류가 발생했습니다</h1>
	<%= exception.getClass().getName() %> 파일에서 발생된 오류
	오류 메시지: <%= exception.getMessage() %>
</body>
</html>