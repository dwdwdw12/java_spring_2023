<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="membersave" method="get">	<!-- get방식으로 받음 -->
	<label for="memId">아이디</label><input type="text" id="memId" name="memId"/><br />		<!--VO 객체의 필드명과 완벽히 일치해야 함-->
	<label for="memPassword1">비밀번호</label><input type="password" id="memPassword1" /><br />
	<label for="memPassword2">비밀번호 확인</label><input type="password" id="memPassword2" name="memPassword"/><br />	<!--패스워드&패스워드 확인-->
	<label for="memName">회원명</label><input type="text" id="memName" name="memName"/><br />
	<label for="email">메일주소</label><input type="text" id="email" name="email"/><br />
	<label for="postCode">우편번호</label><input type="text" id="postCode" name="postCode"/><br />
	<label for="detailAddress">상세주소</label><input type="text" id="detailAddress" name="detailAddress"/><br />
	
	<!-- input:submit+br -->
	<input type="submit" value="회원가입" /><br />
	<input type="reset" value="입력취소" />
	
</form>
</body>
</html>