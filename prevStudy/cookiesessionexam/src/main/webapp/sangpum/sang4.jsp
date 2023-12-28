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
			//System.out.println(cok.getName() + " : " + cok.getValue());
		}
	}
	if(!sangpumCookieValue.contains("4444")){
		sangpumCookieValue = sangpumCookieValue +"A"+ "4444";
	}
	Cookie cookie = new Cookie("sangpumInfo", sangpumCookieValue); 
	cookie.setPath("/");
	cookie.setMaxAge(60*60*3);
	response.addCookie(cookie);
	%>
	<h1>상품 상세정보: 식료품</h1>
</body>
</html>