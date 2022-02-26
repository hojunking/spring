<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h2 class="h3 mb-2 text-gray-800">Tables</h2>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>number</th>
							<th>title</th>
							<th>writer</th>
							<th>date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${list }">
							<tr onclick="location.href='get?bno=${list.bno }'">
								<td>${list.bno }</td>
								<td>${list.title }</td>
								<td>${list.writer }</td>
								<td><fmt:formatDate value="${list.regdate }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
	<script>
	$(document).ready(function() {
	    $("#dataTable").DataTable();
	} );
	
	</script>

<!-- End of Main Content -->
