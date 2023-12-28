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
	if(!sangpumCookieValue.contains("1111")){
		sangpumCookieValue = sangpumCookieValue +"A"+ "1111";	//구분자로 *을 사용. a와 같은 문자도 구분자로 사용가능
	}
	Cookie cookie = new Cookie("sangpumInfo", sangpumCookieValue); 
	cookie.setPath("/");
	cookie.setMaxAge(60*60*3);	//60초*60*3=3시간
	response.addCookie(cookie);
	%>  <!--jspf로 만들어 include하거나, 별개의 클래스로 만들어 호출하기-->
	<h1>상품 상세정보: 전자제품</h1>
	<%-- <%
		Cookie cookie = new Cookie("sangpumInfo","1111");	//전자제품에 붙은 코드
		cookie.setPath("/");
		response.addCookie(cookie);
	%>
	
	<h1>상품 상세정보: 전자제품</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cok : cookies){
				System.out.println("상품1 접속");
				System.out.println(cok.getName() + " : " + cok.getValue());
			}
		}
	%> --%>
</body>
</html>