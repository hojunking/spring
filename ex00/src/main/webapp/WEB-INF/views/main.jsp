<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is mainPage</h1>
	<form action="login">
		<input name="id" value="${param.id}"> <input name="pw">
		<button>로그인</button>
	</form>


	<div><img src="${pageContext.request.contextPath }/resources/사진.jpg" id="robot"></div>
    <button id="btn1">숨기기</button>
    <button id="btn2">보이기</button>
    
    <select id ="fruit"></select>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
  $('#btn1').on("click",function(){
	//   $('#robot').css("display","none");
	$("#robot").toggle();
  });
  $('#btn2').on("click",function(){
	//   $('#robot').css("display","show");
	// $("#robot").slideDown();
	$('#robot').attr('src','${pageContext.request.contextPath }/resources/logo1.jpg');
  });
</script>
</body>
</html>