<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %> 
   
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Modify Page</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Modify Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
            	<form role="form" action="/board/modify" method="post">
            		
            		<input type="hidden" name="pageNum" value="${cri.pageNum}">
            		<input type="hidden" name="amount" value="${cri.amount}">
            		
            		<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
            	
	               	<div class="form-group">
	               		<label>Bno</label>
	               		<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
	               	</div>
	               	<div class="form-group">
	               		<label>Title</label>
	               		<input class="form-control" name="title" value="${board.title}">
	               	</div>
	               	<div class="form-group">
	               		<label>Text area</label>
						<textarea rows="3" class="form-control" name="content">${board.content}</textarea>
	               	</div>
	               	<div class="form-group">
	               		<label>Writer</label>
	               		<input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
	               	</div>
	               	<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
	               	<button type="submit" data-oper="remove" class="btn btn-danger">remove</button>
	               	<button type="submit" data-oper="list" class="btn btn-info">List</button>
               	</form>
            </div> <!-- /.panel-body -->
        </div> <!-- /.panel -->
    </div> <!-- /.col-lg-12 -->
</div>

<!-- 이미지 출력 -->
<div class="bigPictureWrapper">
	<div class="bigPicture">
	</div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
        
        <div class="panel-heading">Files</div>
        <div class="panel-body">
        	<div class="form-group uploadDiv">
        		<input type="file" name="uploadFile" multiple="multiple">
        	</div>
        <div class="uploadResult">
        	<ul>
        	
        	</ul>
        </div>
        </div>	<!-- panel body -->
       </div>
    </div>
</div>

<style>		/* 띄워쓰기 주의 */
	.uploadResult{
		width: 100%;
		background-color: gray;
	}
	.uploadResult ul{
		display: flex;
		flex-flow: row;
		justify-content: center;
		align-items: center;
	}
	.uploadResult ul li{
		list-style: none;
		padding: 10px;
		align-content: center;
		text-align: center;
	}
	.uploadResult ul li img{
		width: 100px;
	}
	.uploadResult ul li span{
		color: white;
	}
	.bigPictureWrapper{
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top: 0%;
		width: 100%;
		height: 100%;
		background-color: gray;
		z-index: 100;
		background: rgba(255,255,255,0.5);
	}
	.bigPicture{
		position: relative;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.bigPicture img{
		width: 600px;
	}
</style>

<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form");
		
		$('button').on("click", function(e){
			
			e.preventDefault();	//이동 중지
			
			var operation = $(this).data("oper");	//data-oper
			
			console.log(operation);
			
			if(operation === 'remove'){ 
				formObj.attr("action", "/board/remove");	//action을 바꿈
			} else if(operation === 'list'){
				//self.location="/board/list";	//get방식이라서
				formObj.attr("action", "/board/list").attr("method", "get");
				
				var pageNumTag = $("input[name='pageNum']").clone();	//.clone() 복제
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				formObj.empty();				
				
				formObj.append(pageNumTag);			//form의 다른 내용은 지우고, pageNum과 amount만 넘기고 싶을 때
				formObj.append(amountTag);			//굳이 안 해도 됨.
				formObj.append(typeTag);			
				formObj.append(keywordTag);			
				//return;
			} else if(operation === 'modify'){
				console.log("submit clicked");
				var str = "";
				$(".uploadResult ul li").each(function(i,obj){
					var jobj = $(obj);
					console.dir(jobj);
					
					str+="<input type='hidden' name='attachList[" + i + "].fileName' value='" + jobj.data("filename") + "'>";
					str+="<input type='hidden' name='attachList[" + i + "].uuid' value='" + jobj.data("uuid") + "'>";
					str+="<input type='hidden' name='attachList[" + i + "].uploadPath' value='" + jobj.data("path") + "'>";
					str+="<input type='hidden' name='attachList[" + i + "].fileType' value='" + jobj.data("type") + "'>";
					
				});
				formObj.append(str).submit();
			}
			
			formObj.submit();
			
		});
		
		//get.jsp에서 가져옴...
		(function(){
			var bno = '<c:out value="${board.bno}"/>';
			$.getJSON("/board/getAttachList", {bno : bno}, function(arr) {
				console.log(arr);
				
				var str = "";
				
				$(arr).each(function(i, attach) {
					// image type
					if(attach.fileType)
					{
						var fileCallPath = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName);
						
						str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
						str += "<span> " + attach.fileName + "</span>";
						str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br/>";
						str += "<img src='/display?fileName="+fileCallPath+"'>";
						str += "</div>";
						str += "</li>";
					}
					else
					{
						str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
						str += "<span>" + attach.fileName + "</span><br/>";
						str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br/>";
						str += "<img src='/resources/img/attach.png'></a>";
						str += "</div>";
						str += "</li>";
					}
				});
				
				$(".uploadResult ul").html(str);
				
			});
			
		})();//end function
		
		$(".uploadResult").on("click", "button", function(e){
			console.log("delete file");
			if(confirm("Remove this file? ")){
				var targetLi = $(this).closest("li");
				targetLi.remove();
			}
		});
	//파일 재업로드	
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880; //5MB
		
		function checkExtension(filename, fileSize){
			
			if(fileSize>=maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(regex.test(filename)){
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}
		
		$("input[type='file']").change(function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			for(var i=0; i<files.length;i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				url: '/uploadAjaxAction',
				processData: false,
				contentType: false,
				data: formData,
				type: 'POST',
				dataType: 'json',
				success: function(result){
					console.log(result);
					showUploadResult(result);
				}
			});
		});
		
		function showUploadResult(uploadResultArr){
			if(!uploadResultArr||uploadResultArr.length==0){
				return ;
			}
			var uploadUL = $(".uploadResult ul");
			
			var str="";
			
			$(uploadResultArr).each(function(i, obj){
				//image type
				if(obj.image){
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
					
					str+= "<li data-path ='"+ obj.uploadPath + "'";
					str+=" data-uuid='"+ obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'";
					str+= " ><div>";
					str+="<span>" + obj.fileName + "</span>";
					str+= "<button type='button' data-file=\'" + fileCallPath+"\' data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='/display?fileName=" + fileCallPath + "'>";
					str+= "</div>";
					str+= "</li>";
				} else{
					var fileCallPath = encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
					
					str+="<li ";
					str+= "data-path='" + obj.uploadPath +"' data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'><div>";
					str+="<span>" + obj.fileName + "</span>";
					str+= "<button type='button' data-file=\'" + fileCallPath+"\' data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str+="<img src='resources/img/noimage.gif'></a>";
					str+= "</div>";
					str+= "</li>";
				}
			});
			uploadUL.append(str);
		}

		
	});
</script>

            
<%@ include file="../includes/footer.jsp" %> 
