<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script>
$(document).ready(function(){
	
$("#payment_process").on('click',function requestPay() {
		var IMP = window.IMP; // 생략가능
           IMP.init("imp61283402");
           let buyerName= "송호준";
           let buyerId='123';
           let sNo = "111";
           let productId ="";
    	   let payMount ="";
       	   let payConfirmNum="";
       	   
       	IMP.request_pay({ // param
            pg: "html5_inicis",
            pay_method: "card",
            merchant_uid: "123",
            name: "호준이 엉덩이",
            amount: 500,
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
	         	   url:'payresult.doBB', //'../AddItemServlet.do'
		   	            method: 'post',
		   	            data: {
		   	            	buyerId: buyerId,
	            			sNo: sNo,
	            			productId: rsp.merchant_uid,
	            			payAmount: rsp.paid_amount,
	            			payConfirmNum:rsp.apply_num
		   	            },
		   	            success: function(response){
		   	            	console.log(response);
		   	            	$('#toPayResult').submit();
		   	            	
		   	            },
		   	            error: function (reject) {
		   	                console.error(reject);
		   	            } 
	            	});
	            
	            	$('#toPayResult').submit();
	            	//리스트에서 아이템 지우기...
	            	
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
</html>