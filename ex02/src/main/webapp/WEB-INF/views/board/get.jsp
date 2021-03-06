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
				<!--  첨부파일 여기! -->	
					<div class="panel-heading">
						첨부파일
						<c:forEach var="attach" items="${board.attachList }">
							<a href="download?uuid=${attach.uuid }">${attach.fileName }</a>
						</c:forEach>
					</div>
			</div>
		</div>
	</div>
</div>
	<div class="panel">
		<div class="col-lg-4">
		<form id="replyForm">
			<input type="hidden" name="bno" value="${board.bno}" class="form-control">
			<input name="replyer" class="form-control" placeholder="작성자">
			<input name="reply" class="form-control"placeholder="내용입력">
		</form>
		</div>
			<button type="button" id="saveReply" class="btn btn-success">댓글등록</button>
	</div>
	<!--댓글 등록-->
<!-- 댓글 목록-->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>댓글
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
			list();
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
				return '<li class="left clearfix"data-rno="'+data.rno+'">'
						+ '<div>'
						+'   <div class="header">'
						+	'<strong class="primary-font"data-replyer="'+data.replyer+'">'+data.replyer+'</strong>'
						+			'<small class="pull-right text-muted"data-replydate="'+data.replydate+'">'+data.replydate+'</small>'
						+		'</div>'
						+	'<span data-reply="'+data.reply+'"><p id="data">'+data.reply+'</p>'
						+		'<button id="del" class="btn btn-danger pull-right">삭제</button>'
						+		'<button id="updateForm" class="btn btn-success pull-right">수정</button></span>'
						+'</div>'
						+'</li>'
			}
			function list(){
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
			};
			//사용자 삭제 요청
			
			//삭제 버튼 클릭
			$('body').on('click','#del',function(){
				
				var rno = $(this).closest('li').data('rno');
				var result = confirm("정말로 삭제하시겠습니까?");
				var li = $(this).closest('li');
				if(result) {
					$.ajax({
						url:'../reply/'+rno,  
						type:'DELETE',
						contentType:'application/json;charset=utf-8',
						dataType:'json',
						error:function(xhr,status,msg){
							console.log("상태값 :" + status + " Http에러메시지 :"+msg);
						}, success:function(data){
							if(data == true){
								li.remove();
							} //if
						} //success
					});  //ajax     
				}//if
			}); //삭제 버튼 클릭
			//수정 버튼 클릭
			$('body').on('click','#updateForm',function(){
				var reply = $(this).closest('span').data('reply');
				
				console.log(reply);
				var str ='수정하기 <input type="text" id="modify" value="'+reply+'">'
						+'<button id="update" class="btn btn-success">수정</button>';
				$(this).closest('span').append(str);
				$(this).closest("#updateForm").remove();
				
				// $('span').contents().unwrap().wrap( '<input>' );
			});
			//댓글 수정하기	
			$('body').on('click','#update',function(){
				var rno = $(this).closest('li').data('rno');
				var reply = $('#modify').val();
				console.log(reply);
				$.ajax({ 
				    url: "../reply/", 
				    type: 'PUT', 
				    dataType: 'json', 
				    data: JSON.stringify({ rno: rno, reply:reply}),
				    contentType: 'application/json',
				    success: function(data) { 
				        alert("수정완료!!");
				        list();
				    },
				    error:function(xhr, status, message) { 
				        alert(" status: "+status+" er:"+message);
				    }
				});
				
				
			})
			
		})
	
	</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>