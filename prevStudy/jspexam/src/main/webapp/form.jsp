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
	<!-- <form action="request03.jsp" method="get"> --> 
	<!--경로 설정시 / 사용 주의하기. Servers-Web module-path와 일치하지 않을 수 있음.-->
	<!--"/request03.jsp"로 변경시 ip주소/request03.jsp로 이동. "./request03.jsp"는 ip주소/설정된_path/request03.jsp로 이동.-->
	<form action="./request03.jsp" method="post">
		<input type="text" name="irum" />
		<input type="text" name="age"/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>