<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="kr.co.dongwoo.util.CookieBox"%>
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
	<h1>쿠키를 보는(쿠키박스 객체를 생성해야 한다.) 다양한 방법</h1>
	<p>특정 쿠키의 내용(값)을 보기</p>
	<%
		CookieBox cb = new CookieBox(request); 
		if(cb.exists("newCookie")){
			out.println("<p>"+ cb.getValue("newCookie") +"</p>");
		}
	%>
	<hr />
	<%-- <p>전체 쿠키의 목록과 내용(값)을 보기</p>
	<%
		CookieBox cb2 = new CookieBox(request); 
		Iterator<String> iter = cb2.getCookieNames().iterator();
		while(iter.hasNext()){
			String cookieName = iter.next();
			String cookieValue = cb2.getValue(cookieName);
	%>
	<li><%=cookieName %> : <%=cookieValue %> </li>
	<%		
		}
	%>
	<hr /> --%>
	<%-- <p>전체 쿠키의 목록과 내용(값)을 보기</p>
	<%
		CookieBox cb2 = new CookieBox(request); 
		List<String> nameList = cb2.getCookieNames();
		for(String cookieName: nameList){
			String cookieValue = cb2.getValue(cookieName);
	%>
	<li><%=cookieName %> : <%=cookieValue %> </li>
	<%		
		}
	%> --%>
	<p>전체 쿠키의 목록과 내용(값)을 보기</p>
	<%
		CookieBox cb2 = new CookieBox(request); 
		List<String> nameList = cb2.getCookieNames();
		for(String cookieName: nameList){
	%>
	<li><%=cookieName %> : <%=cb2.getValue(cookieName) %> </li>
	<%		
		}
	%>  <!--향상된 for문은 {} 꼭 붙여야 함-->
</body>
</html>