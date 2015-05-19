package paymentapp.persistence.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="PAYMENT")
public class Payment {
	
	public Payment(Payee payee, PayerCard payerCard) {
		payees.add(payee);
		payerCards.add(payerCard);
	}
	
	@Id
	@Column(name="PAYMENT_ID")
	@GeneratedValue
	private Integer id;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PAYMENT_PAYEE", 
                joinColumns={@JoinColumn(name="PAYMENT_ID")}, 
                inverseJoinColumns={@JoinColumn(name="PAYEE_ID")})
	private List<Payee> payees = new ArrayList<Payee>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PAYMENT_PAYERCARDS", 
                joinColumns={@JoinColumn(name="PAYMENT_ID")}, 
                inverseJoinColumns={@JoinColumn(name="PAYERCARD_ID")})
	private List<PayerCard> payerCards=new ArrayList<PayerCard>();
	
	@Column
	private boolean paymentStatus; //true=success;false=fail
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Payee> getPayees() {
		return payees;
	}

	public void setPayees(List<Payee> payees) {
		this.payees = payees;
	}


	public List<PayerCard> getPayerCards() {
		return payerCards;
	}

	public void setPayerCards(List<PayerCard> payerCards) {
		this.payerCards = payerCards;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
