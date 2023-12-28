<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %> 

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board List Page 
                <%-- >>>${result}>>> --%>
<!--                 <button id="regBtn" type="button" class="btn btn-xs pull-right" onclick="location.href='/board/register'">Register New Board</button>
-->                <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover"><!-- id="dataTables-example" -->
                    <thead>
                        <tr>
                            <th>#번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    
                    <c:forEach items="${list}" var="board">
                        <tr class="odd gradeX">
                            <td>${board.bno}</td>
                            <td>
                            	<%-- <a class="move" href="/board/get?bno=${board.bno}"> ${board.title}</a> --%>
                            	<a class="move" href="${board.bno}"> ${board.title} <b>[ ${board.replyCnt} ]</b> </a>
                            </td>
                            <td>${board.writer}</td>
                            <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                </table>
        <!-- 검색 조건 처리 -->
				<div class="row">
					<div class="col=lg-12">
						<form action="/board/list" method="get" id="searchForm">
							<select name="type" id="type">
								<%-- <option value="" <c:out value="${pageMaker.cri.type == null? 'selected' : ''}"/>>선택</option>
								<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected' : ''}"/> >제목</option>
								<option value="C" <c:out value="${pageMaker.cri.type eq 'C'? 'selected' : ''}"/>>내용</option>
								<option value="W" <c:out value="${pageMaker.cri.type eq 'W'? 'selected' : ''}"/>>작성자</option>
								<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'? 'selected' : ''}"/>>제목 or 내용</option>
								<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'? 'selected' : ''}"/>>제목 or 작성자</option>
								<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'? 'selected' : ''}"/>>제목 or 내용 or 작성자</option> --%>
								<option value="" >선택</option>
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="W">작성자</option>
								<option value="TC">제목 or 내용</option>
								<option value="TW">제목 or 작성자</option>
								<option value="TCW">제목 or 내용 or 작성자</option>
							</select>
							<input type="text" name="keyword" value="${pageMaker.cri.keyword}"/>
							<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
							<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
							<button class="btn btn-default">검색</button>
						</form>
					</div>
				</div>
        <!-- 검색 조건 처리 -->
		
		<!-- 페이징 처리 -->		
			<div class="pull-right">
			  <ul class="pagination">
			  	
			  	<c:if test="${pageMaker.prev}">
				    <li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
			  	</c:if>
			    
			    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
			    	<li class="page-item ${pageMaker.cri.pageNum==num ? "active" : ""}" >
			    			<a class="page-link" href="${num}">${num}</a></li>
			   
			    </c:forEach>
			   	
			   	<c:if test="${pageMaker.next}">
			   		<li class="page-item"><a class="page-link" href="${pageMaker.endPage+1}">Next</a></li>
			  	</c:if>
			  
			  </ul>
			</div>
		<!-- 페이징 처리 -->
			
			<form action="/board/list" method="get" id="actionForm">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				<input type="hidden" name="type" value="${pageMaker.cri.type}">
				<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
			</form>
				
			<!-- 모달창 추가 -->
				<!-- The Modal -->
			<div class="modal" id="myModal">
			  <div class="modal-dialog">
			      <div class="modal-content">
			      
			        <!-- Modal Header -->
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title" id="myModalLabel">Modal Title</h4>
			        </div>
			        
			        <!-- Modal body -->
			        <div class="modal-body">
			          처리가 완료되었습니다.
			        </div>
			        
			        <!-- Modal footer -->
			        <div class="modal-footer">
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			        </div>
			        
			      </div>
			    </div>
			  </div>

			<!-- 모달창 추가 -->
				                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

<script>
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null);	//스택에 남아있는 모달창에 대한 정보를 비움.
		
		/*모달창*/
		function checkModal(result){
			if(result===''||history.state){
				return;
			}
			
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
			}
			
			$("#myModal").modal("show");
		}
		
		//register 호출
		$("#regBtn").on("click", function(){
			self.location="/board/register";
		});
		
		//페이지 버튼 클릭 이동
		var actionForm = $("#actionForm");
		$(".page-item a").on("click", function(e){
			e.preventDefault();		//전송을 막음
			console.log('click');
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));	//this->page item>a 태그
			actionForm.submit(); //pageNum과 amount가 모두 전송됨.
		});
		
		//조회하고 리스트 화면으로 이동할 때 기본 pageNum 유지
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno', value='"+$(this).attr("href")+"'>"); //추가로 bno 값도 넘길 예정
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		}); 
		
		//검색버튼 이벤트 처리
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			if(!searchForm.find("option:selected").val()){
				alert("검색 조건을 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("검색어를 입력하세요");
				return false;
			}
			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			
			searchForm.submit();
		});
		
		//selected 체크
		var select = "${pageMaker.cri.type}";
		if(select !=""){
			$('#type option[value= '+ select +']').prop("selected", true);
		}
		
		//뒤로가기->새로고침
		 window.addEventListener('pageshow', (event) => {
		  if (event.persisted || window.performance.navigation.type === 2) {
			  //history.replaceState({}, null, location.pathname);
		  	    location.reload();
		  }
		}); 
		
	});
</script>

            
<%@ include file="../includes/footer.jsp" %> 
