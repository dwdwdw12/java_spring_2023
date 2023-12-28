<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		String spno = request.getParameter("spno");		//list에 담으면 물품에 대한 관심의 정도(중복가능)를 파악할 수 있음. set에 담으면 중복을 제거, 장바구니 등에 활용가능
		if(session.getAttribute("sangpumList")==null){
			List<String> list = new ArrayList<String>();
			list.add(spno);
			session.setAttribute("sangpumList", list);
		} else{
			List<String> list = (List<String>)session.getAttribute("sangpumList");
			list.add(spno);
			session.setAttribute("sangpumList", list);
		}		
				
		
		//session.setAttribute("sangpumList", list);
	%>
	
	
	<p>상품목록<%=spno %>의 상세한 정보</p>
	<hr />
	<%@include file = "orderList.jspf" %>
	<a href="./">Home</a>
	
</body>
</html>