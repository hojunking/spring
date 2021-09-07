<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
	<script>
		//스크립트를 밑에 쓰는게 좋다.
		//페이지 로드가 다 이뤄지지 않은 상태에서 실행되서 실행X
	$(function(){

		$("#btn1").on("click",function(){
			$.ajax({
				url:"ajax1",
				method:"GET",
				
				//async: false, 동기식
				data:{writer:$("#writer").val()},      //input값 보내기
				dataType:"json",  //plain = text, json, xml
				success: function(data){
					$("#result").append(data.content+"<br>");
					$("#result").append(data.writer+"<br>");
				}  //callback함수, data(변수이름)
			});
			$("#result").append("클릭됨<br>");
		})
		
		$("#btn2").on("click",function(){
			$.ajax({
				url:"ajax2",
				method:"post",
				data: JSON.stringify({writer : $("#writer").val()}),
				contentType : "application/json",
				dataType:"json",
				success: function(data){
					$("#result").append($("<p>").html(data.content))
						$("#result").append('<p>'+ data.content +'</p>')
				}  //callback함수, data(변수이름)
			});
		})
		//동적으로 추가될 때에도 작동하도록 한다.
		//부모 태그(#result)에 이벤트를 지정해 놓는다. ->그리고 중간에 <p>태그 넣기
		$("#result").on("click","p",function(){
			$(this).remove();
		})
	})
	</script>
</head>
<body>
	<input name="writer" id="writer">
	<button type="button" id="btn1">문자열</button>
	<button type="button" id="btn2">파라미터(JSON)</button>
		
		<div id="result"></div>
		
	
</body>
</html>