package paymentapp.service;

import paymentapp.persistence.dto.Payee;
import paymentapp.persistence.dto.PayerCard;
import paymentapp.service.helperobject.PaymentInfo;

public interface PaymentService {
	
	public Integer submitPayment(Payee payee, PayerCard payer, PaymentInfo paymentInfo);
	public boolean getPaymentStatusUsingPaymentId(Integer id);
}
