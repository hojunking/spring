<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container-fluid">
	<h2 class="h3 mb-2 text-gray-800">상세보기</h2>
	</div>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
		<div class="card-body">
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
					<input type="hidden" name="bno" value="${board.bno }">
					<div align="right">
						<button type="submit" class="btn btn-primary">등록하기</button>
					<button type="button" onclick="location.href='list'" class="btn btn-danger">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
