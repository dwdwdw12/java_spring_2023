<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
	List boardList=(List)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

<html>
<head>
	<title>MVC 게시판</title>
</head>

<style>
	table{
		width: 70%;
		margin: 0 auto;
	}
	table, tr, td, th{
		border : 1px solid black; 
		border-collapse: collapse;
		text-align: left;
	}
	th.no{width: 9%}
	th.title{width: 40%}
	th.writer{width: 19%}
	th.regDate{width: 19%}
	th.readCnt{width: 9%}
	
</style>

<body>
<!-- 게시판 리스트 -->

<table width=50% border="0" cellpadding="0" cellspacing="0">

<c:if test="${listcount>0}">	<!--이 속성이 페이지에 있는지 확인. 없으면 request/session/application영역으로 이동해 탐색  -->
	<tr>
		<td colspan="4">MVC 게시판</td>
		<td>글 개수 : ${listcount}</td>
	</tr>
	
	<tr>
		<th class="no">번호</th>
		<th class="title">제목</th>
		<th class="writer">작성자</th>
		<th class="regDate">날짜</th>
		<th class="readCnt">조회수</th>
	</tr>
	
	
	<c:forEach var="board" items="${boardlist}">
		<%-- ${board} <br /> --%>
	
	
	<tr align="center" valign="middle" >
		<td>
			<div align="center">${board.getBOARD_NUM()} </div>
		</td>
		
		<td>
			<%-- <c:choose>
				<c:when test="${board.getBOARD_RE_LEV()!=0}">
					<c:forEach var="i" begin="0" end="${board.getBOARD_RE_LEV()*2}">
						&nbsp;&nbsp;
						▶
					</c:forEach>
					<c:otherwise>
						▶
					</c:otherwise>
				</c:when>
			</c:choose>  --%>
			
			<c:choose>  
               <c:when test="${board.getBOARD_RE_LEV()!=0}"> <!-- if와 동일 -->
                  <c:forEach var="i" begin="0" end="${board.getBOARD_RE_LEV()}">
                      &nbsp;&nbsp;
                  </c:forEach>
                  ▶
               </c:when> 
               <c:otherwise> 
                  ▶
               </c:otherwise> 
            </c:choose> 
			
		
			<a href="./BoardDetailAction.bo?num=${board.getBOARD_NUM()}" >
				${board.getBOARD_SUBJECT()}
			</a>
			
		</td>
		
		<td>
			<div align="center">${board.getBOARD_NAME()}</div>
		</td>
		<td>
			<div align="center">${board.getBOARD_DATE()}</div>
		</td>	
		<td>
			<div align="center">${board.getBOARD_READCOUNT()}</div>
		</td>
	</tr>
	</c:forEach>
	
	<tr>
		<td> <!--nowpage->page  -->
			<c:choose> 	
				<c:when test="${page<=1}"> 
					[이전]&nbsp;
				</c:when> 
				<c:otherwise> 					
					<a href="./BoardList.bo?page=${page-1}">[이전]</a>&nbsp;
				</c:otherwise> 
			</c:choose>
			
			<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
				<c:choose> 
				<c:when test="${a==page}"> 
					[${a}]
				</c:when> 
				<c:otherwise> 
					<a href="./BoardList.bo?page=${a}">[${a}]</a>&nbsp;
				</c:otherwise> 
				</c:choose>
			</c:forEach>	
			
					
			<c:choose> 
				<c:when test="${page>=maxpage}"> 
					[다음]
				</c:when> 
				<c:otherwise> 
					<a href="./BoardList.bo?page=${page+1}">[다음]</a>
				</c:otherwise> 
			</c:choose>
		</td>
	</tr>
	
</c:if>
<c:if test="${empty boardlist}">
    <tr>
		<td colspan="4">MVC 게시판</td>
		<td>등록된 글이 없습니다.</td>
	</tr>
</c:if>
	
	<tr>
		<td colspan="5">
	   		<a href="./BoardWrite.bo">[글쓰기]</a>
		</td>
	</tr>
</table>

</body>
</html>