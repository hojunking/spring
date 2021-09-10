<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<style>
	.required{
		color : red;
	}
		.emp:hover{
			color : blue;
		}
		.emp{
			cursor : pointer;
		}
</style>
<script>
	$(function() {
		$("#btnEmpSearch").on("click", function() {
			//검색페이지를 ajax -> modal 바디에 넣고 띄우기
			$.ajax({
				url : "empSearch",
				success : function(data) {
					$('#empModal .modal-body').html(data);
					$('#empModal').modal('show');
				}
			});
		});
		//매니저 단건검색
		$('#managerId').on('keydown', function() {
			preventdefault();
			$('name').val("");
			if($('#managerId').val()=="")
			return;
			
			if(e.keyCode==13){
				e.preventdefault();
			
			$.ajax({
				url : "ajaxEmp",
				data : {
					employeeId : $('#managerId').val()
				},
				success : function(data) {
					if (data) {
						$('#name').val(data.firstName)
					} else {
						$('#btnEmpSearch').click();
					}
				}
			})
			};
		})
//등록버틑ㄴ


	function validation(){
		if(frm.lastName.value==""){
			alert("이름을 입력해 주세요!!");
			frm.lastName.focus();
			return false;
		}
		return true;
	}
		$("#btnRegister").on("click",function(){
			if(validation()){
				frm.submit();
			}

		})
	})
	//입력했는지 확인하고 말해준다.
</script>
<title>Insert title here</title>
<div class="col-lg-12">
	<h3 class="page-header">사원등록</h3>
	<!-- /.col-lg-12 -->
</div>
<form action="${empty emp ? 'updateEmp' : 'insertEmp'}" name="frm" method="post">
	<table class="table table-striped table-bordered table-hover"
		id="member">
	<c:if test="${not empty emp}">
	

		<thead>
			<tr>
				<th>아이디</th>
				<th><input name="employeeId" value="${emp.employeeId }"></th>
			</tr>
			<tr>
				<th>이름</th>
				<th><input name="firstName" id="name" value="${emp.firstName }"></th>

			</tr>
			<tr>
				<th>성</th>
				<th><input name="lastName" id="lastName" value="${emp.lastName }"></th>
			</tr>
			<tr>
				<th>이메일</th>
				<th><input name="email" value="${emp.email }"></th>
			</tr>
			<tr>
				<th>전화번호</th>
				<th><input name="phoneNumber" value="${emp.phoneNumber }"></th>
			</tr>
			<tr>
				<th>입사일</th>
				<th><input name="hireDate" value="${emp.hireDate }"></th>
			</tr>
			<tr>
				<th>직무</th>
				<th><select name="jobId">
						<option value="">선택</option>
						<c:forEach var="jobs" items="${opt.jobs }">
							<option value="${jobs.jobId }">${jobs.jobTitle }</option>
						</c:forEach>
				</select></th>
			</tr>
			<tr>
				<th>급여</th>
				<th><input name="salary" value="${emp.salary }"></th>
			</tr>
			<tr>
				<th>커미션</th>
				<th><input name="commissionPct" value="${emp.commissionPct }"></th>
			</tr>
			<tr>
				<th>매니저아이디</th>
				<th><input name="managerId" id="managerId">
					<button type="button" class="btn btn-primary"
						data-target="#empModal" data-toggle="modal" id="btnEmpSearch">검색</button>
				<select name="departmentId">
						<option value="">선택</option>
						<c:forEach var="depts" items="${opt.depts}">
							<option value="${depts.departmentId }">${depts.departmentName }</option>
						</c:forEach>
				</select></th>
			</tr>
			<tr>
				<th>부서번호</th>
				<th><input name="departmentId" value="${emp.departmentId }"></th>
			</tr>
		</c:if>
	</table>
<button class="btn btn-primary" id="btnRegister">등록</button>
</form>



<!-- Logout Modal-->
<div class="modal fade" id="empModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<a class="btn btn-primary" href="">확인</a>
			</div>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>