package paymentapp.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayeeDetailsDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 24362481094534617L;
	private String acctholdername;
	private BigDecimal  amount;
	private String reference;
	private String bankname;
	private String bankaddress;
	private Integer sortcode;
	private Integer accountnumber;
	private Date dateofpayment;
	
	public String getAcctholdername() {
		return acctholdername;
	}
	public void setAcctholdername(String acctholdername) {
		this.acctholdername = acctholdername;
	}
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankaddress() {
		return bankaddress;
	}
	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}
	public Date getDateofpayment() {
		return dateofpayment;
	}
	public void setDateofpayment(Date dateofpayment) {
		this.dateofpayment = dateofpayment;
	}
	public Integer getSortcode() {
		return sortcode;
	}
	public void setSortcode(Integer sortcode) {
		this.sortcode = sortcode;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}
	
}
