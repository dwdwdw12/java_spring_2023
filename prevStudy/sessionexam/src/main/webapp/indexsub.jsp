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
	<h1>서브페이지</h1>
	<div>
		<session>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Earum optio repellendus hic quas inventore et nisi aspernatur non odio quis nam suscipit consequuntur. Illo ea voluptate laboriosam aperiam accusantium architecto.</session>
		<aside><%@include file = "orderList.jspf" %></aside>
		<a href="./">Home</a>
	</div>
</body>
</html>