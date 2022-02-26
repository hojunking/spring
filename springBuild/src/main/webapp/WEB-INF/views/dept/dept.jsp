<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-lg-12">
	<h3 class="page-header">부서관리</h3>
	<!-- /.col-lg-12 -->
		<div class="form-group">
			<table id="list"class="table table-striped table-bordered table-hover">
				<tr><td>부서번호</td>
					<td>부서이름</td>
					<td>부서관리자</td>
					<td>위치</td>
				</tr>
			</table>
		<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#deptModal">등록
		</button>
		</div>

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
					부서이름:<input name="departmentName">
						</div>
					<div class="form-group">
					매니저아이디:<select name="managerId">
						<option value="">선택</option>
					</select></div>
					<div class="form-group">
					위치정보:<select name="locationId">
					<option value="">선택</option></select>
					</div>
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
			$("<tr>")
			.append($("<td onclick='read("+data.departmentId+")'>").html(data.departmentId))
			.append($("<td>").html(data.departmentName))
			.append($("<td>").html(data.managerId))
			.append($("<td>").html(data.locationId))
			.appendTo($("#list"));
				});
			$.each(datas,function(j,select) {
				$('<option value="'+select.managerId+'">').html(select.managerId)
				.appendTo($("select[name=managerId]"));
				$('<option value="'+select.locationId+'">').html(select.locationId)
				.appendTo($("select[name=locationId]"));
			})
		}
	});
};

	function read(){
		
	}
	$('#btnInsert').on('click',function(){
		$.ajax({ 
		    url: "insert",  
		    method: 'POST',  
		    data : $("#insert").serialize(), //controller에서 requestbody로 받아야 한다.
		    dataType: 'json', 
		    success: function(data) {
		    	if(data==true){
		    		alert("등록되었습니다.");
		    		$('#deptModal').modal('hide');
		    	}else{
		    		alert("오류발생!");
		    	}
		    }, 
		    error:function(xhr, status, message) { 
		        alert(" status: "+status+" er:"+message);
		    } 
		 });  
	});//등록 버튼 클릭
	
	
});
</script>





