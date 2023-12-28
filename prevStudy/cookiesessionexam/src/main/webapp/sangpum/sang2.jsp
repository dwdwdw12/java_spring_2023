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
	String sangpumCookieValue = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cok : cookies) {
			if(cok.getName().equals("sangpumInfo")){
				sangpumCookieValue = cok.getValue();
				//System.out.println("쿠키정보"+sangpumCookieValue);
			} 
		}
	}
	if(!sangpumCookieValue.contains("2222")){
		sangpumCookieValue = sangpumCookieValue +"A"+ "2222";
	}
	Cookie cookie = new Cookie("sangpumInfo", sangpumCookieValue); 
	cookie.setPath("/");
	cookie.setMaxAge(60*60*3);
	response.addCookie(cookie);
	%>
	<h1>상품 상세정보: 의류제품</h1>
</body>
</html>