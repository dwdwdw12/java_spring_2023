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
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		if(userId.equals(pwd)){
			session.setAttribute("logCheck", userId);
		}
		response.sendRedirect("./");	//web.xml의 설정정보에 따라 이동. "/"로 변경시 다른 곳으로 이동(servers-modules-path 참고)
	%>
</body>
</html>