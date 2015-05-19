package paymentapp.persistence.dao;

import paymentapp.persistence.dto.Payment;

public interface PaymentDAO {
	
	public Integer addPayment(Payment payment);
}
