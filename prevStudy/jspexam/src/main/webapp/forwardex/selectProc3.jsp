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
		String jobSelect = request.getParameter("jobSelect");
		String attrData = "속성에 저장된 값";
		request.setAttribute("attrData", attrData);	//속성을 통해 서브 페이지에 값 전달
		if(jobSelect.equals("a"))
	%>
		<jsp:forward page="a.jsp">
			<jsp:param value="준회원" name="memValue"/>	
		</jsp:forward>
		<!--파라메터로 서브 페이지에 값 전달-->
	<%
		if(jobSelect.equals("b"))		//처리문이 1개이기 때문에 {}생략가능
	%>
		<jsp:forward page="b.jsp">
			<jsp:param value="정회원" name="memValue"/>
		</jsp:forward>
	<%
		if(jobSelect.equals("c"))
	%>
		<jsp:forward page="c.jsp" >
			<jsp:param value="우수회원" name="memValue"/>
		</jsp:forward>
	<%
		if(jobSelect.equals("d"))
	%>
		<jsp:forward page="d.jsp" />
	<%
		if(jobSelect.equals("e"))
	%>
		<jsp:forward page="e.jsp" />
	<%
		if(jobSelect.equals("f"))
	%>
		<jsp:forward page="f.jsp" />
</body>
</html>