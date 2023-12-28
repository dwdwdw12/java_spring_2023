<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>

<%
	String firstParam = request.getParameter("firstParam");	//request는 내장되어 있음. 생성할 필요 없음
	
	String[] secondParams = request.getParameterValues("secondParams");	//문서?[이름1=자료1&이름2=자료2&... query String] 
												//입력폼에서 checkbox 또는 select의 멀티 속성으로 넘어온 자료를 받을 때.=>같은 이름을 가진 자료가 여러개 전달될 때
	//http://localhost:8088/request01.jsp?firstParam=500&secondParams=dongwoo&secondParams=data 	//같은이름->getParametr, 다른 이름->getParameterValues							
												
	Enumeration<String> enumer = request.getParameterNames();	//parameter 이름을 모를 때. ->iterator와 같음
	while(enumer.hasMoreElements()){
		System.out.println("넘겨받은 파라메터 이름 : "+enumer.nextElement());
	}
	System.out.println("=======================================");
	
	Map<String, String[]> parMap = request.getParameterMap();	//map: 키+값
	Set<String> parKey = parMap.keySet();
	Iterator<String> iter = parKey.iterator();
	while(iter.hasNext()){
		String paramName = iter.next();
		System.out.println("넘겨받은 파라메터 이름 : " + paramName);
		//System.out.println("넘겨받은 파라메터 자료 : " + parMap.get(paramName));
		for(int i=0;i<parMap.get(paramName).length;i+=1){
			System.out.println(parMap.get(paramName)[i]);
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>넘겨받은 자료 출력</p>
	
	<p><%= firstParam%></p>
	<p><%= secondParams[0]%></p>
	<p><%= secondParams[1]%></p>
</body>
</html>