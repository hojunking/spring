<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="login" method="post">
			<input type="hidden" name="${_csrf.parameterName }"
				value="${_csrf.token }"> <input name="id"> <input
				name="password">
			<button>로그인</button>
		</form>
	</div>
	<!--  csrf -> 쿠키를 통해서 도메인 침입을 막는다. -->
</body>
</html>