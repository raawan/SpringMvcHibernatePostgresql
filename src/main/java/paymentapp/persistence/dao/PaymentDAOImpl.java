package paymentapp.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.Payment;

@Repository
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer addPayment(Payment payment) {
		sessionFactory.getCurrentSession().save(payment);
		sessionFactory.getCurrentSession().flush();
		return payment.getId();
	}

}
