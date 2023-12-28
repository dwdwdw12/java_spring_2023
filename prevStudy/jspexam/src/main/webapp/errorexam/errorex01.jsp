<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %> <!-- 우선순위는 이 파일이 web.xml 에러페이지 설정보다 높음 -->
    <%-- errorPage="./errorpage/errorview.jsp" --%> 											 <!-- error페이지(errorview)로 연결해줌 -->
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
		String[] datas = "가나다".split("");
	%>
	<h1>넘겨받은 이름의 4번째 문자</h1>
	<%-- <%=request.getParameter("name").charAt(3) %> --%> <!-- request.getParameter("name"): 아무것도 없으니 null. 뒤에 메서드 추가시, NullPointerException -->
	<%=datas[3] %>
	
</body>
</html>