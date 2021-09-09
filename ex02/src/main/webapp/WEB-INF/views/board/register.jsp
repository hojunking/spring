<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">등록</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">등록하기</div>
			<div class="panel-body">

				<form role="form" id="frm" action="register" method="POST">
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title">
					</div>
					<div class="form-group">
						<textarea rows="3" class="form-control" name="Content"></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer">
					</div>
					<button type="button" id="btnRegister" class="btn btn-primary">등록하기</button>
					<button type="button" onclick="location.href='list'"
						class="btn btn-danger">취소</button>
				</form>
				<div class="form-group">
					<label>첨부파일</label> <input type="file" class="form-control"
						name="uploadFile" multiple="multiple">
					<button type="button" id="uploadBtn">첨부파일등록</button>
					<ul id="uploaded"></ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {

		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880; //5MB

		function checkExtension(fileName, fileSize) {

			if (fileSize >= maxSize) {
				alert("파일 사이즈 초과");
				return false;
			}

			if (regex.test(fileName)) {
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			return true;
		}

		$('#uploadBtn').on('click',function() {
		var formData = new FormData(document.frm);
		var inputfile = $('[name="uploadFile"]');
		var files = inputfile[0].files;
		for (i = 0; i < files.length; i++) {
			if (!checkExtension(files[i].name,
					files[i].size)) {
				return;
			}
			formData.append("uploadFile", files[i]);
		}
		//formData
		$.ajax({
			processData : false,
			contentType : false,
			url : "../uploadAjaxAction",
			method : 'post',
			data : formData,
			success : function(result) {
			var str = "";

			for (i = 0; i < result.length; i++) {
				var obj = result[i];
				var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
		    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
		      
			str += "<li "
			str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
			str += "<span> "+ obj.fileName+"</span>";
			str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
			str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
			str += "<img src='/resources/img/attach.png'></a>";
			str += "</div>";
			str +"</li>";
			}
			$("#uploaded").html(str);
			alert("업로드 성공~");
		}
	});
});
		//등록버튼 이벤트   
		$("#btnRegister").on("click",function(){
			var str="";
			$("#uploaded li").each(function(i,obj){
				var jobj =$(obj);
				str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
				str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
				str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
				str += "<input type='hidden' name='attachList["+i+"].fileType' value='1>"//+ jobj.data("type")+"'>";
			});
			$("#frm").append(str).submit();
		})
		//업로드한거 다시 지우기
		$("#uploaded").on("click","button",function(e){
			console.log("delete file");
		if(confirm("지우실거냥?")){
		 var targetLi= $(this).closest("li");
		 targetLi.remove();
		}
		});
	});
</script>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>