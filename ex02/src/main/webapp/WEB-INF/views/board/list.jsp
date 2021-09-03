<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
		<!-- /.col-lg-12 -->
	</div>
	<table class="table table-striped table-bordered table-hover" id="board">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>타이틀</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>수정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list }">
				<tr onclick="location.href='get?bno=${list.bno }'">
					<td>${list.bno }</td>
					<td>${list.writer}</td>
					<td>${list.title }</td>
					<td>${list.content }</td>
					<td><fmt:formatDate value="${list.regdate }"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${list.updatedate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button class="btn btn-primary" onclick="location.href='register'">등록하러가기</button>
</div>
	<script>
	$(document).ready(function(){
		$("#board").DataTable();
	})
		
	</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>