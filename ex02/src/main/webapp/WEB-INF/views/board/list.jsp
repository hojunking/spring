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
	<table class="table table-striped table-bordered table-hover"
		id="board">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>타이틀</th>
				<th>내용</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list }">
				<tr>
					<td><a class="move" href="${list.bno }">${list.bno }</a></td>
					<td>${list.writer}</td>
					<td>${list.title }[${list.replycnt }]</td>
					<td>${list.content }</td>
					<td><fmt:formatDate value="${list.regdate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>${pageMaker}
	<!--페이지값 넘기기  -->
	<form id="actionForm" action="list" method="get">
			<select name="type" >
				<option value=""${empty pageMaker.cri.type ? selected:''} >선택</option>
				<option value="T"
				<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
				<option value="W"${pageMaker.cri.type eq 'W'?'selected':''}>작성자</option>
				<option value="C"${pageMaker.cri.type eq 'C'?'selected':''}>내용</option>
				<option value="TC"${pageMaker.cri.type eq 'TC'?'selected':''}>제목 or 내용</option>
				<option value="TW"${pageMaker.cri.type eq 'TW'?'selected':''}>제목 or 작성자</option>
				<option value="WC"${pageMaker.cri.type eq 'WC'?'selected':''}>작성자 or 내용</option>
				<option value="TWC"${pageMaker.cri.type eq 'TWC'?'selected':''}>제목 or 작성자 or 내용</option>
			</select>
			<input name="keyword" value="${pageMaker.cri.keyword }">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
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

		$(".move").on("click",function(e) {
			e.preventDefault();
			var bno = $(this).attr("href")
			actionForm
					.append('<input type="hidden" name="bno" value="'+bno+'">')
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