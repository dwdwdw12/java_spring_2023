<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>admin page</h1>
<p>principal : <sec:authentication property="principal"/></p>
<p>KakaoUserVO : <sec:authentication property="principal.user"/></p>
<p>사옹자 이름 : <sec:authentication property="principal.user.userid"/></p>
<p>사옹자 아이디 : <sec:authentication property="principal.userid"/></p>
<p>사용자 권한 리스트 : <sec:authentication property="principal.userid.authority"/></p>


<a href="/logout">logout</a>
</body>
</html>