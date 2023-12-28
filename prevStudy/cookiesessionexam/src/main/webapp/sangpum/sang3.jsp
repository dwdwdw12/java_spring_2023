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
	/*아래 if구문은 다른 형태로 작성되어야 할 수도 있음 = 전략에 따라서 잘*/
	if(!sangpumCookieValue.contains("3333")){
		sangpumCookieValue = sangpumCookieValue +"A"+ "3333";
	}
	Cookie cookie = new Cookie("sangpumInfo", sangpumCookieValue); 
	cookie.setPath("/");
	cookie.setMaxAge(60*60*3);
	response.addCookie(cookie);
	%>
	<h1>상품 상세정보: 컴퓨터제품</h1>
</body>
</html>