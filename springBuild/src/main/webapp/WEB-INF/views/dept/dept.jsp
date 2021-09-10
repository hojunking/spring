<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="col-lg-12">
	<h3 class="page-header">부서관리</h3>
	<!-- /.col-lg-12 -->
		<div id="list">
		</div>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deptModal">등록
</button>
</div>








<div class="modal fade" id="deptModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">부서정보입력</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="container">
				<form id="insert" >
				<div class="card shadow mb-4">
					<div class="card-header py-3">
				<div class="form-group">
					부서번호:<input name="departmentId"></div>
					<div class="form-group">
					부서이름:<input name="departmenㄴtName"></div>
					<div class="form-group">
					매니저아이디:<input name="managerId"></div>
					<div class="form-group">
					위치정보:<input name="locationId"></div>
					</div>
					</div>
				</form>
			</div>
			</div>
			<div class="modal-footer">
				<button type="button"id="btnInsert"class="btn btn-primary" >확인</button>
			</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		deptList();
		//등록
		//수정
		//목록조회
	function deptList(){
		$.ajax({
			url : "deptList",
			dataType : "json",
			success : function(datas){
			console.log(datas);
			$.each(datas,function(i,data){  //each function
			$("<div>").append($("<span>").html(data.departmentId))
			.append($("<span>").html(data.departmentName))
			.appendTo($("#list"));
				} )
			}
			
		});
	}
	$('#btnInsert').on('click',function(){
		$("#insert")
/* 			var id = $('input:text[name="id"]').val();
		var name = $('input:text[name="name"]').val();
		var passsword = $('input:text[name="password"]').val();
		var role = $('select[name="role"]').val(); */		
		$.ajax({ 
		    url: "insert",  
		    type: 'POST',  
		    dataType: 'json', 
		    data : JSON.stringify($("#insert").serialize()), //controller에서 requestbody로 받아야 한다.
		    contentType: 'application/json', 
		    success: function(response) {
		    		deptList();
		    }, 
		    error:function(xhr, status, message) { 
		        alert(" status: "+status+" er:"+message);
		    } 
		 });  
	});//등록 버튼 클릭
	
	
})
</script>










<%@include file="/WEB-INF/views/includes/footer.jsp"%>