<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %> 
   
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read Page</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<!-- row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
               	<div class="form-group">
               		<label>Bno</label>
               		<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
               	</div>
               	<div class="form-group">
               		<label>Title</label>
               		<input class="form-control" name="title" value="<c:out value="${board.title}"/>" readonly="readonly">
               	</div>
               	<div class="form-group">
               		<label>Text area</label>
					<textarea rows="3" class="form-control" name="content" readonly="readonly">${board.content}</textarea>
               	</div>
               	<div class="form-group">
               		<label>Writer</label>
               		<input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
               	</div>
               	<%-- <button data-oper="modify" class="btn btn-default" onclick="location.href='/board/modify?bno=${board.bno}'">Modify</button> --%>
               	<button data-oper="modify" class="btn btn-default">Modify</button>
               	<!-- <button data-oper="list" class="btn btn-info" onclick="location.href='/board/list'">List</button> -->
               	<button data-oper="list" class="btn btn-info">List</button>
            	
            	<form action="/board/modify" method="get" id="operForm">
            		<input type="hidden" id="bno" name="bno" value="${board.bno}">
            		<input type="hidden" name="pageNum" value="${cri.pageNum}">
            		<input type="hidden" name="amount" value="${cri.amount}">
            		
            		<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
            	</form>
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>	<!-- /.row -->

<!-- 댓글 -->
<!-- row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            	<i class="fa fa-comments fa=fw"></i>Reply		<!-- w3school-부트스트랩4-아이콘 참고 -->
            	<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
               	
               	<ul class="chat">
               		<li class="left clearfix" data-rno='12'>	<!-- getList에서 고쳐 쓸 부분. user00의 댓글은 표시되지 않음 -->
               			<div>
               				<div class="header">
               					<strong class="primary-font">user00</strong>
               					<small class="pull-right text-muted">2023-11-16 11:20</small>
               				</div>
               				<p>good job</p>
               			</div>
               		</li>
               	</ul>
               	
            </div> <!-- /.panel-body -->
            	<div class="panel-footer">
            	</div>
        </div> <!-- /.panel -->
    </div> <!-- /.col-lg-12 -->
</div> <!-- /.row -->
<!-- /댓글 -->

<!-- 모달창 -->
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<div class="form-group">
					<label>Reply</label>
					<input class="form-control" name="reply" value="New Reply"/>
				</div>
				<div class="form-group">
					<label>Replyer</label>
					<input class="form-control" name="replyer" id="replyer" value="Replyer"/>
				</div>
				<div class="form-group">
					<label>Reply Date</label>
					<input class="form-control" name="replyDate" value=""/>
				</div>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button id="modalRegisterBtn" type="button" class="btn btn-primary">Register</button>
				<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
				<button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
				<button id="modalCloseBtn" type="button" class="btn btn-info" data-dismiss="modal">Close</button>
			</div>

		</div>
	</div>
</div>
<!-- /모달창 -->

<script type="text/javascript" src="/resources/js/reply.js"></script>

<style>		/* 띄워쓰기 주의 */
	.chat > li:hover{
		cursor:pointer;
	}
</style>

<script>
	var bnoValue = '${board.bno}';

	var replyUL = $(".chat");

	console.log('bnoValue : ' + bnoValue);

	showList(1);

	//reply
	function showList(page) { //아니면 1을 대입
		replyService
				.getList(
						{
							bno : bnoValue,
							page : page || 1
						},
						function(replyCnt, list) {
							
							if(page==-1){					//아래의 다른 함수에서 page=-1을 호출, paging 처리가 새로 시작됨
								pageNum = Math.ceil(replyCnt/10.0);		//댓글 갯수가 10개를 넘어가면 다음 페이지로 이동함
								showList(pageNum);
								return;
							}
							
							var str = "";
							if (list == null || list.length == 0) {
								replyUL.html("");
								return;
							}
							for (var i = 0, len = list.length || 0; i < len; i++) {
								str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>"; //안쪽에 작은 따옴표로 바꾸기. rno값 주의.
								str += "<div><div class='header'>";
								str += "<strong class='primary-font'>"
										+ list[i].replyer + "</strong>";
								str += "<small class='pull-right text-muted'>"
										+ replyService
												.displayTime(list[i].replyDate)
										+ "</small>";
								//str += "</div><p>" + list[i].reply + "</p>";
								str += "</div><p>" + list[i].reply + "</p>";
								str += "</div></li>";
							}
							replyUL.html(str);
							
							showReplyPage(replyCnt);
						}); //end function

	} //end showList
	
	var modal =$(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalRegisterBtn = $("#modalRegisterBtn");
	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalCloseBtn = $("#modalCloseBtn");
	
	//댓글-모달창 설정
	$("#addReplyBtn").on("click", function(e){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();	//날짜를 숨기겠다
		modal.find("button[id != 'modalCloseBtn']").hide();	//close버튼을 제외한 모든 버튼을 숨김
		
		//readonly 속성 제거
		modalInputReplyer.removeAttr("readonly");
		
		modalRegisterBtn.show();					//register 버튼을 보여줌
		
		$(".modal").modal("show");		//class로 접근
	});
	
	//댓글 등록
	modalRegisterBtn.on("click", function(e){
		var reply = {
				bno : bnoValue,
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val()
		}
		
		replyService.add(reply, function(result){
			alert(result);
			modal.find("input").val();
			modal.modal("hide");
			
			showList(-1);			//댓글 내용 새로 고침(댓글 1페이지 호출) -> -1페이지 호출, getList()에서 paging을 새로 작동
		});
	});
	
	//댓글 조회 클릭 이벤트 처리
	$(".chat").on("click", "li", function(e){
		var rno = $(this).data("rno");
		//console.log("rno : " + rno);
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer).attr("readonly", "readonly") ;
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly"); //읽기전용 변경
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
		});
	});
	
	//댓글 수정
	modalModBtn.on("click", function(e){
		var reply = {
			rno : modal.data("rno"),
			reply : modalInputReply.val()
		};
		replyService.update(reply, function(result){
			alert(result);
			
			modal.modal("hide");
			console.log("Modify => " + pageNum)
			showList(pageNum);
		});
	});
	
	//댓글 삭제
	modalRemoveBtn.on("click", function(e){
		var rno = modal.data("rno");				//showList()를 통해 data-rno를 추가해 주었음.
		
		replyService.remove(rno, function(result){
			alert(result);
			modal.modal("hide");
			console.log("Delete => " + pageNum)
			showList(pageNum);
		});
	});
	
	//페이징 처리
	var pageNum = 1;
	var replyPageFooter = $(".panel-footer");
	
	function showReplyPage(replyCnt){
		var endNum = Math.ceil(pageNum/10.0)*10;
		var startNum = endNum - 9;
		
		var prev = startNum !=1;
		var next = false;
		
		if(endNum*10>=replyCnt){
			endNum = Math.ceil(replyCnt/10.0);
		}
		
		if(endNum*10<replyCnt){
			next=true;
		}
		
		var str = "<ul class='pagination pull-right'>";
		if(prev){
			str += "<li class = 'page-item'><a class='page-link' href='"+ (startNum-1) +"'>Previous</a></li>";
		}
		
		for(var i=startNum; i<=endNum; i++){
			var active = pageNum == i ? "active" : "";
			
			str += "<li class='page-item "+ active + "'> <a class='page-link' href='" + i + "'>" + i + "</a></li>";
		}
		
		if(next){
			str += "<li class = 'page-item'><a class='page-link' href='"+ (endNum+1) +"'>Next</a></li>";
		}
		
		str += "</ul>";
		console.log("str >>> " + str);
		
		replyPageFooter.html(str);
	}
	
	//댓글 페이지 이벤트 처리
	replyPageFooter.on("click", "li a", function(e){		// li>a 내부의 href를 꺼내기 위해서.
		e.preventDefault();
		
		var targetPageNum = $(this).attr("href");
		console.log("targetPageNum : " + targetPageNum);
		pageNum=targetPageNum;
		showList(pageNum);
	});
	
	//add
	/* var addValue = {
			reply : "JS TEST",
			replyer : "TESTER", 
			bno : bnoValue				//자바객체
	}
								//callback에 대응되는 함수
	replyService.add(addValue, function(result) {	//json 타입으로 변환.
		alert("RESULT : " + result)
	});	//js의 replyService-add 호출 */

	//getList
	/* replyService.getList({bno:bnoValue, page:1}, function(list){
		for(var i=0, len=list.length || 0; i<len; i++){		//list.length에 값이 없다면 0, 
			console.log(list[i]);
		}
	}); */

	//delete
	/* replyService.remove(49, 
		function(data) {
			console.log(data);
			if(data=="success"){
				alert("REMOVED");
			}
		}, 
		function(err) {
			alert("ERROR");
		}
	
	); */

	//update
	/* replyService.update(
			{rno:17, reply:"Modify Reply..."},
			function(data) {
				alert("수정완료 : " + data);
			},
			function(er) {
				alert("실패 : " + er);
			}
	); */

	//read, get
	/* replyService.get(
			41,						
			function(data) {			
				console.log(data);			//없으면 null값 반환
			},
			function(err) {
				console.log(err);
			}
	); */
</script>

<script>
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
		
	});
</script>
            
<%@ include file="../includes/footer.jsp" %> 
