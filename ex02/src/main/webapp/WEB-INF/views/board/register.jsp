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
			<div class="panel-heading">등록하기</div>
			<div class="panel-body">

				<form role="form" action="register" method="POST">
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title">
					</div>
					<div class="form-group">
						<textarea rows="3" class="form-control" name="Content"></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer">
					</div>
					<button type="submit" class="btn btn-primary">등록하기</button>
					<button type="button" onclick="location.href='list'" class="btn btn-danger">취소</button>
				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="/WEB-INF/views/includes/footer.jsp"%>