<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script>
$(document).ready(function(){
	$("#payment").on('click',function(){
		let userId='5';
		let subTerm='10';
		let paycost='1000';
		let payConfirmNum='1992';
		$.ajax({
      	   url:'payment', //'../AddItemServlet.do'
	            method: 'post',
	            data: {
	            	userId: userId,
        			subTerm: subTerm, 
        			payCost: paycost,
        			payConfirmNum:payConfirmNum
	            },
	            success: function(response){
	            	console.log(response);
	            	alert("db에도 들어갔졍!");
	            	$('#payment_process')
	            	.html('<div class="card-body">'
	            		+	'<div class="card mb-4">'
	            		+		'<div class="card mb-2" style="border:none;  border-radius:0; ">'
	            		+		'<div class="card-header py-3">결제가 완료되었습니다.</div>'
	            		+			'<a href="javascript:history.back();">뒤로가기</a>'
	            		+		'</div>'
	            		+		'</div>'
	            		+	'</div>');
	            	
	   	            },
	   	            error: function (reject) {
	   	                console.error(reject);
	   	            } 
         	});
	});
	
	
	
$("#payment_process").on('click',function requestPay() {
		var IMP = window.IMP; // 생략가능
           IMP.init("imp61283402");
           let buyerName= "송호준";
           let userId='5';
      
           IMP.request_pay({ // param
            pg: "html5_inicis",
            pay_method: "card",
            merchant_uid: "11",
            name: "호준이 엉덩이",
            amount: 200,
            buyer_email: "gkwlal3@gmail.com",
            // buyer_name: "$('#buyer').text()",
            // buyer_tel: $('#bPhone').text(),
            // buyer_addr: $('#bAddress').text(),
            // buyer_postcode: "우편번호",
            m_redirect_url: 'http://localhost/Test'


        }, function (rsp) { // callback
	            console.log(rsp);
	     	   	var msg="";
	            if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
				 
	            alert("결제 성공");
	            
	            /* 결제 성공 시 결과 저장 */
	            $.ajax({
	         	   url:'payment', //'../AddItemServlet.do'
	   	            method: 'post',
	   	         	dataType: 'json',
	   	            data: {
	   	            	userId: userId,
            			subTerm: rsp.merchant_uid, 
            			payCost: rsp.paid_amount,
            			payConfirmNum:rsp.apply_num
	   	            },
	   	            success: function(response){
	   	            	console.log(response);
	   	            	alert("db에도 들어갔졍!");
	   	            	$('#payment_process')
	   	            	.html('<div class="card-body">'
	   	            		+	'<div class="card mb-4">'
	   	            		+		'<div class="card mb-2" style="border:none;  border-radius:0; ">'
	   	            		+		'<div class="card-header py-3">결제가 완료되었습니다.</div>'
	   	            		+			'<a href="javascript:history.back();">뒤로가기</a>'
	   	            		+		'</div>'
	   	            		+		'</div>'
	   	            		+	'</div>');
	   	            	
		   	            },
		   	            error: function (reject) {
		   	                console.error(reject);
		   	            } 
	            	});
	            
	            } else {	
		               alert("결제에 실패하였습니다. " + rsp.error_msg);
				}
        });
                      
       }
   );//import 결제 API 끝
});//ajax 끝
</script>

<button type="button" id="payment_process" class="btn btn-warning btn-lg justfy-item-center mr-2">
	결 제 하 기</button>
	<button type="button" id="payment" class="btn btn-warning btn-lg justfy-item-center mr-2">
	개시발</button>
</html>