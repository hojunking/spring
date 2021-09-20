<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<style>
#mail_check_input_box_false {
	background-color: #ebebe4;
}

#mail_check_input_box_true {
	background-color: white;
	
}
.correct{
	color:green;
}

.incorrect {
	color: red;
}
</style>
<!-- Begin Page Content -->
<div class="container-fluid">

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<div class="mail_wrap">
				<div class="mail_name">이메일</div>
				<div class="mail_input_box">
					<input class="mail_input" name="memberMail">
				</div>
					<span class="final_mail_ck">이메일을 입력해주세요.</span>
					<span class="mail_input_box_warn"></span>
				<div class="mail_check_wrap">
					<div class="mail_check_input_box" id="mail_check_input_box_false">
						<input class="mail_check_input" disabled="disabled">
					</div>
					<div class="mail_check_button">
						<button type="button">인증번호발송</button>
					</div>
					<div class="clearfix"></div>
					<span id="mail_check_input_box_warn"></span>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var code = "";
	var email = $('.mail_input').val();
	$(document).ready(function() {
		$(".mail_check_button").on("click", function() {
			var cehckBox = $(".mail_check_input"); // 인증번호 입력란
			var boxWrap = $(".mail_check_input_box"); // 인증번호 입력란 박스
			var warnMsg = $(".mail_input_box_warn");
			console.log(email);
			if (mailFormCheck(email)) {
				warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
				warnMsg.css("display", "inline-block");
			} else {
				warnMsg.html("올바르지 못한 이메일 형식입니다.");
				warnMsg.css("display", "inline-block");
				return false;
			}
			/* $('.mail_check_button').prop("disabled", true); */
			$.ajax({
				type : "get",
				url : "mailTest?email=" + email,
				success : function(data) {
					console.log("data=" + data);
					cehckBox.prop("disabled", false);
					boxWrap.attr('id', 'mail_check_input_box_true');
					code = data;
				}

			})
		})

	$(".mail_check_input").blur(function() {
		var inputCode = $(".mail_check_input").val();
		var checkResult = $("#mail_check_input_box_warn");

		if (inputCode == code) { // 일치할 경우
			checkResult.html("인증번호가 일치합니다.");
			checkResult.attr("class", "correct");
		} else { // 일치하지 않을 경우
			checkResult.html("인증번호를 다시 확인해주세요.");
			checkResult.attr("class", "incorrect");
		}

	});

	function mailFormCheck(email) {
		var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		return form.test(email);
	}
	});
</script>
<!-- /.container-fluid -->
<%@include file="/WEB-INF/views/includes/footer.jsp"%>




