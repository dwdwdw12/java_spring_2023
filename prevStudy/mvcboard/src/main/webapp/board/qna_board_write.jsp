<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<html>
<head>
	<title>MVC 게시판</title>
	<script language="javascript">
	function addboard(){
		//정확하게 해당 자료가 입력되었는지 체크하는 구문이 들어간다.
		boardform.submit();
	}
	</script>
</head>
<body>
<!-- 게시판 등록 -->
<h1>게시글 쓰기</h1>
<form action="./BoardAddAction.bo" method="post" enctype="multipart/form-data" name="boardform">
	<!--파일 첨부할 때 enctype에 multipart사용-->
	
	<!-- (label{작성자비밀번호제목내용파일첨부}+input+br)*5 -->
	<label for="BOARD_NAME">작성자</label>
	<input type="text" name="BOARD_NAME" id="BOARD_NAME" /><br />
	
	<label for="BOARD_PASS">비밀번호</label>
	<input type="password" name="BOARD_PASS" id="BOARD_PASS"/><br />
	
	<label for="BOARD_SUBJECT">제목</label>
	<input type="text" name="BOARD_SUBJECT" id="BOARD_SUBJECT" size="50" maxlength="100"/><br />
	
	<label for="BOARD_CONTENT">내용</label>
	<textarea name="BOARD_CONTENT" id="BOARD_CONTENT" cols="60" rows="15" ></textarea><br />
	
	<label for="BOARD_FILE">파일첨부</label>
	<input type="file" name="BOARD_FILE" id="BOARD_FILE"/> <span>파일 최대 크기 : 5MB</span> <br />
	
	<a href="javascript:addboard()">[등록]</a>&nbsp;&nbsp;
	<a href="javascript:history.go(-1)">[뒤로]</a>	<!--이전으로 1번 이동. history 사용-->
	
</form>
<!-- 게시판 등록 -->
</body>
</html>