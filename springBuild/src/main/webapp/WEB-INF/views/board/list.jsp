<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
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
					<tfoot>
						<tr>
							<th>number</th>
							<th>title</th>
							<th>writer</th>
							<th>date</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="list" items="${list }">
							<tr onclick="location.href='read?bno=${list.bno }'">
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

</div>
<!-- End of Main Content -->
<%@include file="/WEB-INF/views/includes/footer.jsp"%>