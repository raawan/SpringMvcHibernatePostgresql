package paymentapp.controller.dto;

import java.math.BigDecimal;

public class PayerCardDetailsDTO {
	
	private String nameoncard;
	private String cardnumber;
	private String expirydate;
	private String cvv;
	private String emailaddress;
	private BigDecimal totalcost;
	
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public BigDecimal getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(BigDecimal totalcost) {
		this.totalcost = totalcost;
	}
	
}
