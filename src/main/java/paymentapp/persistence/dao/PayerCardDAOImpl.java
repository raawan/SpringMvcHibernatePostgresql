package paymentapp.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.PayerCard;

@Repository
public class PayerCardDAOImpl implements PayerCardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer addCard(PayerCard card) {
		sessionFactory.getCurrentSession().save(card);
		return card.getId();
	}

	@Override
	public Integer getCardUsingCardNumber(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
