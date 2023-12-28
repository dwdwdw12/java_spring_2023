<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>  <!-- error페이지(errorview)로 연결하지 않음. nullpointexception이 발생, error 500을 발생시키므로, 
    															web.xml을 통해 errorview로 이동. 포장된 내용? 기본값?을 표시 -->
    <%-- errorPage="./errorpage/errorview.jsp" --%>
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
	<h1>넘겨받은 이름의 4번째 문자</h1>
	<%=request.getParameter("name").charAt(3) %> <!-- request.getParameter("name"): 아무것도 없으니 null. 뒤에 메서드 추가시, NullPointerException -->
</body>
</html>