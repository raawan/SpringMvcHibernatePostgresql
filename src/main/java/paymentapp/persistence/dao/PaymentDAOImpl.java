package paymentapp.persistence.dao;

import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.Payment;

@Repository
public class PaymentDAOImpl extends GenericDAOImpl<Payment> implements PaymentDAO {
	
	
	@Override
	public Integer addPayment(Payment payment) {
		this.create(payment);
		//ToDo: check if flush is required . its withing @transactional context
		this.flush();
		return payment.getId();
	}

}
