package paymentapp.persistence.dao;

import paymentapp.persistence.dto.PayerCard;

public interface PayerCardDAO {
	
	public Integer addCard(PayerCard card);
	public Integer getCardUsingCardNumber(Integer id);
}
