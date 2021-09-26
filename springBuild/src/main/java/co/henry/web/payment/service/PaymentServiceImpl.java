package co.henry.web.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.henry.web.payment.domain.PaymentVO;
import co.henry.web.payment.mapper.PaymentMapper;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentMapper map;
	@Override
	public int paymentInsert(PaymentVO vo) {
		return map.paymentInsert(vo);
	}
	
	
}
