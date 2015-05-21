package paymentapp.persistence.dao;

import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.Payee;

@Repository
public class PayeeDAOImpl extends GenericDAOImpl<Payee> implements PayeeDAO {
	
	@Override
	public Integer addPayee(Payee payee) {
		this.create(payee);
		return payee.getId();
	}

	@Override
	public void getPayeeUsingSortCodeAndAcctNo(Integer sortCode, Integer AcctNo) {
		// TODO Auto-generated method stub
		
	}

}
