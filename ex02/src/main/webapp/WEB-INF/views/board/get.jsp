<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">등록</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				작성일자:
				<fmt:formatDate value="${board.regdate }" type="both" dateStyle="default" timeStyle="default" />
				<br />마지막수정:
				<fmt:formatDate value="${board.updatedate }" type="both" dateStyle="default" timeStyle="default" />
			</div>
			<div class="panel-body">

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
					<div align="right">					<button type="submit" class="btn btn-primary">수정하기</button>
					<%-- <button type="button" class="btn btn-danger" onclick="location.href='delete?bno=${board.bno }'">삭제하기</button> 
					get 방식으로 하기--%>
					<button type="submit" formaction="delete" class="btn btn-danger">게시글삭제</button>
					<button type="button" onclick="location.href='list'" class="btn btn-success">목록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>