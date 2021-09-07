<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container-fluid">
		<h2 class="h3 mb-2 text-gray-800">상세보기</h2>
	</div>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<div class="panel-heading">
				작성일자:
				<fmt:formatDate value="${board.regdate }" type="both"
					dateStyle="default" timeStyle="default" />
				<br />마지막수정:
				<fmt:formatDate value="${board.updatedate }" type="both"
					dateStyle="default" timeStyle="default" />
			</div>
			<div class="card-body">
				<form role="form" action="modify" method="POST">

					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value="${board.title }">
					</div>
					<div class="form-group">
						<textarea rows="3" class="form-control" name="Content">${board.content }</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value="${board.writer}">
					</div>
					<input type="hidden" name="bno" value="${board.bno }">
					<div align="right">
						<button type="submit" class="btn btn-primary">수정하기</button>
						<%-- <button type="button" class="btn btn-danger" onclick="location.href='delete?bno=${board.bno }'">삭제하기</button> 
					get 방식으로 하기--%>
						<button type="submit" formaction="delete" class="btn btn-danger">게시글삭제</button>
					</div>
				</form>
			</div>
		</div>
	</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>