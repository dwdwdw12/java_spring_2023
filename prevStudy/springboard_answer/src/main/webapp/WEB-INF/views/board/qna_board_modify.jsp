<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>MVC 게시판</title>
	<script type="text/javascript">
	function modifyboard(e){
		let inputData = document.querySelector("#BOARD_PASS").value
		let boardData = ${board.BOARD_PASS} + '';
		if (boardData === inputData){
			modifyform.submit();
			return;
		}
		alert("비밀번호가 일치하지 않아 수정할 수가 없습니다!!!")
		document.querySelector("#BOARD_PASS").focus()
	}
	</script>
</head>

<body>
<!-- 게시판 수정 -->
<form action="BoardModify.bo" method="post" name="modifyform">	<!--BoardModifyAction을 BoardModify로 변경. controller에 맞추어.-->
<input type="hidden" name="BOARD_NUM" value="${board.BOARD_NUM}">
<table>
	<tr>
		<td colspan="2">MVC 게시판</td>
	</tr>
	<tr>
		<td>제 목</td>
		<td>
			<input name="BOARD_SUBJECT" size="50" maxlength="100" 
				value="${board.BOARD_SUBJECT}">
		</td>
	</tr>
	<tr>
		<td>내 용</div></td>
		<td>
			<textarea name="BOARD_CONTENT" cols="60" rows="15">${board.BOARD_CONTENT}</textarea>
		</td>
	</tr>
	<c:if test="${board.BOARD_FILE != null}">
		<tr>
			<td>파일 첨부</td>
			<td>${board.BOARD_FILE}</td>
		</tr>
	</c:if>
	<tr>
		<td>비밀번호</td>
		<td><input id="BOARD_PASS" name="BOARD_PASS" type="password"></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>
		</td>
	</tr>
</table>
</form>
<!-- 게시판 수정 -->
</body>
</html>