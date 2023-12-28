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
	<p>
		Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis corporis eaque assumenda pariatur debitis sapiente accusantium deserunt labore animi porro illum ipsam autem asperiores eius explicabo provident repudiandae praesentium est?
	</p>
	<p>
		Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis corporis eaque assumenda pariatur debitis sapiente accusantium deserunt labore animi porro illum ipsam autem asperiores eius explicabo provident repudiandae praesentium est?
	</p>
	<p>
		Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis corporis eaque assumenda pariatur debitis sapiente accusantium deserunt labore animi porro illum ipsam autem asperiores eius explicabo provident repudiandae praesentium est?
	</p>
	
	<%
		response.sendRedirect("http://www.google.com");	
		//2개의 서로 다른 요청이 된다. 1) response02.jsp 요청 => 2) http://www.google.com 요청이 된다.
	%>
</body>
</html>