<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 명부</h1>
	<%-- ${list}
	${list.size()} --%>
	<c:forEach var="list" items="${list}">
    <p>ID : ${list.memId}</p>
    <p>비밀번호 : ${iist.memPassword}</p>
    <p>이름 : ${list.memName}</p>
    <p>이메일 : ${list.email}</p>
    <p>우편번호 : ${list.postCode}</p>
    <p>상세주소 : ${list.detailAddress}</p>
    <p>가입일 : ${list.regiDate}</p>
    <h1>--------------------------------</h1>
	</c:forEach>
</body>
</html>