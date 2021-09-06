<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">회원리스트</h1>
		<!-- /.col-lg-12 -->
	</div>
	<table class="table table-striped table-bordered table-hover"
		id="member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직무</th>
				<th>급여</th>
				<th>커미션</th>
				<th>매니저아이디</th>
				<th>부서번호</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach var="list" items="${list }">
				<tr>
					<td><a class="move" href="${list.employeeId }">${list.employeeId}</a></td>
					<td>${list.firstName}</td>
					<td>${list.lastName }</td>
					<td>${list.email }</td>
					<td>${list.phoneNumber }</td>
					<td><fmt:formatDate value="${list.hireDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${list.jobId }</td>
					<td>${list.salary }</td>
					<td>${list.commissionPct }</td>
					<td>${list.managerId }</td>
					<td>${list.departmentId }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>${pageMaker}
	<!--페이지값 넘기기  -->
	<form id="actionForm" action="list" method="get">
			<select name="type" >
				<option value=""${empty pageMaker.cri.type ? selected:''} >선택</option>
				<option value="T"
				<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>아이디</option>
				<option value="W"${pageMaker.cri.type eq 'W'?'selected':''}>이름</option>
				<option value="C"${pageMaker.cri.type eq 'C'?'selected':''}>전화번호</option>
				<option value="TC"${pageMaker.cri.type eq 'TC'?'selected':''}>아이디 or 전화번호</option>
				<option value="TW"${pageMaker.cri.type eq 'TW'?'selected':''}>아이디 or 이름</option>
				<option value="WC"${pageMaker.cri.type eq 'WC'?'selected':''}>이름 or 전화번호</option>
				<option value="TWC"${pageMaker.cri.type eq 'TWC'?'selected':''}>아이디 or 이름 or 전화번호</option>
			</select>
			<input name="keyword" value="${pageMaker.cri.keyword }">
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
		<button class='btn btn-default'>검색</button>
	</form>
	<div id="pageButton" class='pull-right'>
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li class="pagination_button previous"><a
					href="${pageMaker.startPage-1 }">이전으로</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="num">
				<li class="pagination_button"><a href="${num }">${num }</a></li>
			</c:forEach>
			<c:if test="${pageMaker.next }">
				<li class="pagination_button next"><a
					href="${pageMaker.endPage+1 }">다음</a></li>
			</c:if>
		</ul>
	</div>
	<button class="btn btn-primary" onclick="location.href='register'">등록하러가기</button>
</div>
<script>
	$(function() {
		var actionForm = $("#actionForm")

		$(".move")
				.on(
						"click",
						function(e) {
							e.preventDefault();
							var bno = $(this).attr("href")
							actionForm
									.append('<input type="hidden" name="employeeId" value="'+employeeId+'">')
							actionForm.attr("action", "get")
							actionForm.submit();
						})

		$(function() {
			$("#pageButton a").on("click", function(e) {
				e.preventDefault(); //a, submit 특성 초기화
				var p = $(this).attr("href")
				$('[name="pageNum"]').val(p)
				actionForm.submit();
			})
			/* $("#board").DataTable(); */
		})
	})
</script>
	
				
<%@include file="/WEB-INF/views/includes/footer.jsp"%>