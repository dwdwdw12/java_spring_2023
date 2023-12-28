<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>

<%
	String sessionId = session.getId();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <p>세션 아이디 : <%=sessionId %> </p>
	<%
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			System.out.println(cookies[i].getName()+ " : "+ cookies[i].getValue());
		}
	%> --%>
	<%
		String logCheck = (String)session.getAttribute("logCheck");
		if(logCheck!=null){
			out.println("<p>"+logCheck+"님</p>");
			out.println("<a href=\"logout.jsp\">로그아웃</a>");		//href->get방식
		} else{
	%>	
		<form action="login.jsp" method="post">
		<input type="text" name="userId" /><br />
		<input type="password" name="pwd" /><br />
		<input type="submit" value="로그인" />

	</form>
	<%		
			}
			
	%>
	
<!-- 	(div>section+aside)+footer>h3 -->
	<div>
		<section>
			<!-- ul>(li>a{상품목록$$$})*5 -->
			<ul>
				<li><a href="sangpumDetail.jsp?spno=1111">상품목록1111</a></li>
				<li><a href="sangpumDetail.jsp?spno=2222">상품목록2222</a></li>
				<li><a href="sangpumDetail.jsp?spno=3333">상품목록3333</a></li>
				<li><a href="sangpumDetail.jsp?spno=4444">상품목록4444</a></li>
				<li><a href="sangpumDetail.jsp?spno=5555">상품목록5555</a></li>
			</ul>
		</section>
		<aside>	<!-- 모듈로 만들어 삽입하면 편리 -->
			<%@include file = "orderList.jspf" %>
			<%-- <h3>최근에 본 상품</h3>
			<%
				List<String> list = (List<String>)session.getAttribute("sangpumList");
				int listLength = list.size();
			%>
			<p>최근 본 상품의 개수 : <%=listLength %></p>
			<ul>
			<%
				for(int i=0;i<listLength;i=i+1){
					out.println("<li>최근 본 상품 : " + list.get(i) + "</li>");	//장바구니 역할
				}
			%>
				
			</ul> --%>
		</aside>
		<a href="./indexsub.jsp">서브페이지</a>
	</div>
	<footer>
		<h4>회사 기본 정보</h4>
	</footer>
</body>
</html>