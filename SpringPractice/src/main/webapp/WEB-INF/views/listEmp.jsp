<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>입사일</th>
					<th>직무</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${getList }">
					<tr>
						<td>${List.employeeId }</td>
						<td>${List.firstName }</td>
						<td>${List.lastName }</td>
						<td>${List.email }</td>
						<td>${List.phoneNumber }</td>
						<td>${List.jobId }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>