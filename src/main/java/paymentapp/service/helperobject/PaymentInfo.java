package paymentapp.service.helperobject;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentInfo {
	
	private BigDecimal totalAmountCharged;
	
	private BigDecimal amount;
	
	private String reference;
	
	private Date dateOfPayment;

	public BigDecimal getTotalAmountCharged() {
		return totalAmountCharged;
	}

	public void setTotalAmountCharged(BigDecimal totalAmountCharged) {
		this.totalAmountCharged = totalAmountCharged;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	
}
