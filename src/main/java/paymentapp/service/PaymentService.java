package paymentapp.service;

import paymentapp.persistence.dto.Payee;
import paymentapp.persistence.dto.PayerCard;

public interface PaymentService {
	
	public Integer submitPayment(Payee payee, PayerCard payer);
	public boolean getPaymentStatusUsingPaymentId(Integer id);
}
