<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<html>
<head>
<title>MVC 게시판</title>
<script>
function deleteboard(){
	let inputData = document.querySelector("#BOARD_PASS").value
	console.log( inputData)
	let boardData = ${board.BOARD_PASS} + '';
	if (boardData === inputData){
		deleteForm.submit();
		return;
	}
	alert("비밀번호가 일치하지 않아 삭제할 수가 없습니다!!!")
	document.querySelector("#BOARD_PASS").focus()  
}
</script>
</head>
<body>
<form name="deleteForm" action="./BoardDeleteAction.bo?num=${board.BOARD_NUM}" 
	method="post">
<table border=1>
<tr>
	<td>
		<font size=2>글 비밀번호 : </font>
	</td>
	<td>
		<input id="BOARD_PASS" name="BOARD_PASS" type="password">
	</td>
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteboard()">삭제</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">돌아가기</a>
	</td>
</tr>
</table>
</form>
</body>
</html>