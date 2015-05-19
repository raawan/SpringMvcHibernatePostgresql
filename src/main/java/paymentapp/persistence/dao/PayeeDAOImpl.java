package paymentapp.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.Payee;

@Repository
public class PayeeDAOImpl implements PayeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer addPayee(Payee payee) {
		sessionFactory.getCurrentSession().save(payee);
		return payee.getId();
	}

	@Override
	public void getPayeeUsingSortCodeAndAcctNo(Integer sortCode, Integer AcctNo) {
		// TODO Auto-generated method stub
		
	}

}
