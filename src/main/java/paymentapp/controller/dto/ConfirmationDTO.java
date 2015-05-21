package paymentapp.controller.dto;

import java.util.Date;

public class ConfirmationDTO  {
	
	private String nameoncard;
	private Double amount;
	private Integer sortcode;
	private Integer accountnumber;
	private String reference;
	private Date dateofpayment;
	
	public String getNameoncard() {
		return nameoncard;
	}
	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getSortcode() {
		return sortcode;
	}
	public void setSortcode(Integer sortcode) {
		this.sortcode = sortcode;
	}
	public Integer getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Date getDateofpayment() {
		return dateofpayment;
	}
	public void setDateofpayment(Date dateofpayment) {
		this.dateofpayment = dateofpayment;
	}
	
	
}
