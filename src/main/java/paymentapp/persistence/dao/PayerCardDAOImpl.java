package paymentapp.persistence.dao;

import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.PayerCard;

@Repository
public class PayerCardDAOImpl extends GenericDAOImpl<PayerCard> implements PayerCardDAO {
	
	
	@Override
	public Integer addCard(PayerCard card) {
		this.create(card);
		return card.getId();
	}

	@Override
	public Integer getCardUsingCardNumber(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
