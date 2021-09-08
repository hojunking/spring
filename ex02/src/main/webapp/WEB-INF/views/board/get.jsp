<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h2 class="page-header"></h2>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				작성일자:
				<fmt:formatDate value="${board.regdate }" type="both"
					dateStyle="default" timeStyle="default" />
				<br />마지막수정:
				<fmt:formatDate value="${board.updatedate }" type="both"
					dateStyle="default" timeStyle="default" />
			</div>
			<div class="panel-body">
				<form role="form" action="modify" method="POST">
					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
					
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
					<div align="right">
						<button type="submit" class="btn btn-primary">수정하기</button>
						<%-- <button type="button" class="btn btn-danger" onclick="location.href='delete?bno=${board.bno }'">삭제하기</button> 
					get 방식으로 하기--%>
						<button type="submit" formaction="delete" class="btn btn-danger">게시글삭제</button>
						<a class="btn btn-success" href="list?pageNum=${cri.pageNum }&amount=${cri.amount}">목록으로</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
	<!--댓글 등록-->
	<div class="panel">
		<form id="replyForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input name="replyer" value="송호준">
			<input name="reply">
			<button type="button" id="saveReply">댓글등록</button>
		</form>
	</div>
<!-- 댓글 목록-->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>Reply
			</div>
			<div class="panel-body">
				<ul class="chat">
				</ul>
			</div>
		</div>
	</div>
</div>
	<script>
		let bno="${board.bno }";
		$(function() {
			//등록처리
			$("#saveReply").on('click',function(){
				$.ajax({
					url:"../reply/",
					method:"post",
					data:$("#replyForm").serialize(),
					dataType:"JSON",
					success:function(data){
						console.log(data);
						$(".chat").append(makeLi(data));
						//append는 뒤에 prepend는 앞에 , html은 덮어쓰기 // append는 추가
					}
				});
			});

			function makeLi(data){
				return '<li class="left clearfix">'
						+ '<div>'
						+'   <div class="header">'
						+	'<strong class="primary-font">'+data.replyer+'</strong>'
						+			'<small class="pull-right text-muted">'+data.replydate+'</small>'
						+		'</div>'
						+	'<span>'+data.reply
						+		'<button id="del" data-rno="'+data.rno+'" class="btn btn-danger pull-right">삭제</button>'
						+		'<button class="btn btn-primary pull-right">수정</button></span>'
						+'</div>'
						+'</li>'
			}
			//목록조회
			$.ajax({
				url:"../reply/", //(default = get method)
				data:{bno:bno}, //"bno=377" 이렇게 써도 ajax가 다 바꿔준다.
				dataType:"JSON",
				success:function(datas){
					console.log(datas);
						str="";
					for(i=0; i<datas.list.length;i++){
						str+= makeLi(datas.list[i]);
					}
					$(".chat").html(str);

				}
			});
			//사용자 삭제 요청
			
		})
		function userDelete() {
			//삭제 버튼 클릭
			$('body').on('click','#del',function(){
				var rno = $(this).closest('button').data('rno');
				var result = confirm(rno +"정말로 삭제하시겠습니까?");
				var li = $(this).closest('li');
				if(result) {
					$.ajax({
						url:'/'+rno,  
						type:'DELETE',
						contentType:'application/json;charset=utf-8',
						dataType:'json',
						error:function(xhr,status,msg){
							console.log("상태값 :" + status + " Http에러메시지 :"+msg);
						}, success:function(data){
							if(dta.result == true){
								li.remove();
								alert("삭제완료!");
							} //if
						} //success
					});  //ajax     
				}//if
			}); //삭제 버튼 클릭
		}//userDelete
	</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>