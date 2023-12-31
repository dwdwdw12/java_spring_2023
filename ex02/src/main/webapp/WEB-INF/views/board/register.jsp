<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %> 
   
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Register</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Board Register Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form action="/board/register" role="from" method="post"> <!-- action=""이 없을 경우, 자신을 호출한 register로 돌아가서, controller가 실행됨 -->
                	<div class="form-group">
                		<label>Title</label>
                		<input class="form-control" name="title">
                	</div>
                	<div class="form-group">
                		<label>Text area</label>
						<textarea rows="3" class="form-control" name="content"></textarea>
                	</div>
                	<div class="form-group">
                		<label>Writer</label>
                		<input class="form-control" name="writer">
                	</div>
                	<button type="submit" class="btn btn-default">Submit Button</button>
                	<button type="reset" class="btn btn-danger">Reset Button</button>
                </form>
                
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>

            
<%@ include file="../includes/footer.jsp" %> 
