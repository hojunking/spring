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
		<form action="/sample/ex05">
			<input name="list[0].name"><input name="list[0].age"><br>
			<input name="list[1].name"><input name="list[1].age"><br>
			<input name="list[2].name"><input name="list[2].age"><br>
			<input name="list[3].name"><input name="list[3].age"><br>
			<button>등록</button>
			<!-- SampleVoList의 list객체와 동일 -->
		</form>
	</div>
</body>
</html>