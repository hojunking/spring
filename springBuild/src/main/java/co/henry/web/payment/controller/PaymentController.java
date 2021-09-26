package co.henry.web.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.henry.web.payment.domain.PaymentVO;
import co.henry.web.payment.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired PaymentService service;
	
	@PostMapping("payment")
	@ResponseBody
	public int paymentInsert(PaymentVO vo) {
		System.out.println("오긴 온거니..?"+vo);
		int m = service.paymentInsert(vo);
		System.out.println("결과는 ="+m);
		return m;
	}
}
