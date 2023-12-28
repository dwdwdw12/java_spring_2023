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
		//String forwardPage = request.getParameter("jobSelect").toLowerCase()+".jsp";
		String abc = "abcdef";
		int k = abc.indexOf(jobSelect);
		String pp=abc.charAt(k)+".jsp";  
	%>
		<%-- <jsp:forward page="<%=forwardPage %>"/> --%>
	 	<jsp:forward page="<%=pp %>"/> 
	<%-- <%
		String forwardPage=null;
		if(jobSelect.equals("a")){
			forwardPage="a.jsp";
		}
		else if(jobSelect.equals("b")){
			forwardPage="b.jsp";
		} 
		else if(jobSelect.equals("c")) {
			forwardPage="c.jsp";
		}
		else if(jobSelect.equals("d")) {
			forwardPage="d.jsp";
		}
		else if(jobSelect.equals("e")) {
			forwardPage="e.jsp";
		}
		else if(jobSelect.equals("f")) {
			forwardPage="f.jsp";
		}
	%>
	<jsp:forward page="<%=forwardPage %>"/> --%>
	
</body>
</html>