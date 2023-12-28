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
	<h3>메인에 들어있는 첫번째 내용</h3>
	<h3>메인에 들어있는 첫번째 내용</h3>
	<h3>메인에 들어있는 첫번째 내용</h3>
	<h3>메인에 들어있는 첫번째 내용</h3>
	<h3>메인에 들어있는 첫번째 내용</h3>
	<%
		String name = "홍길동";	//메인에서 데이터를 생성함
		request.setAttribute("iname", name);	//parameter로 넘겨주는 방식과 비교해보기
	%>
	<jsp:include page="sub.jsp">
		<jsp:param value="홍길동" name="irum"/>	
		<jsp:param value="400" name="age"/>	
	</jsp:include>
	<h4>메인의 footer</h4>
	<h4>메인의 footer</h4>
	<h4>메인의 footer</h4>
</body>
</html>