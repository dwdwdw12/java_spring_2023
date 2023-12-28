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
		response.addHeader("serverName", "user server");	//f12 눌러서 Network>Name>Header>Response Headers에 serverName이 추가되었는지 확인.
	%>
	<h1>Response01</h1>
	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea voluptatem modi ut voluptates quo minus enim quidem veritatis 
	dolores esse ducimus fugiat maiores aut! Culpa quaerat tempore hic. Sequi aut!
</body>
</html>