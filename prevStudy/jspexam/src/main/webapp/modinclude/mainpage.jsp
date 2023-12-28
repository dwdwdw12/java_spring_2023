<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

	<%-- <%@ include file="header.jspf" %> --%>
	
	<hr />
	<section>
		<h3>메인페이지의 본문내용</h3>
		<h3>메인페이지의 본문내용</h3>
		<h3>메인페이지의 본문내용</h3>
		<h3>메인페이지의 본문내용</h3>
		<h3>메인페이지의 본문내용</h3>
	</section>
	<%-- <%@ include file="header.jspf" %> --%>    <!-- 변수가 없다면 여러번 사용 가능 -->
	<div>
		<p>헤더에 들어있는 변수 사용하기1 <%=now %></p>	<!--header.jspf의 변수-->
		<p>헤더에 들어있는 변수 사용하기2 <%=text %></p>
	</div>
	<a href="subpage01.jsp">subpage01</a>
