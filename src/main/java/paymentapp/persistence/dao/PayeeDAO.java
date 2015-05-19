package paymentapp.persistence.dao;

import paymentapp.persistence.dto.Payee;

public interface PayeeDAO {
	
	public Integer addPayee(Payee payee);
	public void getPayeeUsingSortCodeAndAcctNo(Integer sortCode, Integer AcctNo);
}
