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
	<h1>b를 선택했기 때문에 그 작업이 이루어짐</h1>
	<h2><%=request.getParameter("memValue") %></h2>
	<h3>속성을 통해 전달된 자료: <%=request.getAttribute("attrData") %></h3>
	<h4>처음에 넘겨준 자료 <%=request.getParameter("irum") %></h4>
</body>
</html>