<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>MVC 게시판</title>
	<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>

<body>
<!-- 게시판 수정 -->
<form action="BoardModifyAction.bo" method="post" name="modifyform">		<!-- div를 통해 class, id를 지정하면 스타일 지정에 도움이 됨 -->
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
		<td>내 용</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="60" rows="15">${board.BOARD_CONTENT}</textarea>
		</td>
	</tr>
	<%-- <c:if test="${!(empty board.BOARD_FILE)}">
		<tr>
		<td>파일 첨부</td>
		<td>
			&nbsp;&nbsp;${board.BOARD_FILE}
		</td>
	</tr>
	</c:if> --%>

	<tr>
		<td>비밀번호</td>
		<td>
			<input name="BOARD_PASS" type="password">
		</td>
	</tr>
		
	<tr>
		<td colspan="5">
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;		
		</td>
	</tr>
</table>
</form>
<!-- 게시판 수정 -->
</body>
</html>