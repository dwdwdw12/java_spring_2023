<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>받은 회원 정보</h1>
	${member} <br />
	회원 아이디: ${member.getMemId() }<br />
	회원 이름: ${member.getMemName() }<br />
	상세주소: ${member.getDetailAddress() }<br />
	상세주소2: ${member.detailAddress }<br />
</body>
</html>