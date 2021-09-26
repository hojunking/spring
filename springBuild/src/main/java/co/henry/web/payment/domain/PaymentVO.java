package co.henry.web.payment.domain;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVO {
	
	private Date payDate;
	private int payCost;
	private int userId;
	private long payConfirmNum;
	private long subTerm;
}
