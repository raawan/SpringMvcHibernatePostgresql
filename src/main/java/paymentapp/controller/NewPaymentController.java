package paymentapp.controller;


import java.math.BigDecimal;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import paymentapp.controller.dto.ConfirmationDTO;
import paymentapp.controller.dto.PayeeDetailsDTO;
import paymentapp.controller.dto.PayerCardDetailsDTO;
import paymentapp.persistence.dto.Payee;
import paymentapp.persistence.dto.PayerCard;
import paymentapp.service.ContactService;
import paymentapp.service.PaymentService;
import paymentapp.service.helperobject.PaymentInfo;

@Controller	
@SessionAttributes({"sessionPayee"})
public class NewPaymentController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired 
	private PaymentService  paymentService;
	
	private static final String NEW_PAYMENT = "new_payment";
	private static final String PAYEE_DETAILS = "payee_details";
	private static final String CARD_DETAILS = "card_details";
	private static final String CONFIRMATION = "confirmation";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		return NEW_PAYMENT;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String makePayment(Model model) {
		
		model.addAttribute("payee", new PayeeDetailsDTO());
		return PAYEE_DETAILS;
	}
	
	@RequestMapping(value = "/payee_details", method = RequestMethod.POST)
	public String submitPayeeDetails(@ModelAttribute("payeeForm") PayeeDetailsDTO payee, Model model) {
		model.addAttribute("sessionPayee", payee);
		
		BigDecimal totalCost = new BigDecimal(0);
		if(payee.getAmount()!=null) {
			//ToDO: move this calculation in service layer
			 totalCost = payee.getAmount().add(payee.getAmount().multiply( new BigDecimal(0.02), new MathContext(3)));
		}
		PayerCardDetailsDTO cardDetails = new  PayerCardDetailsDTO();
		cardDetails.setTotalcost(totalCost);
		model.addAttribute("cardDetails", cardDetails);
		return CARD_DETAILS;
	}
	
	@RequestMapping(value = "/card_details", method = RequestMethod.POST)
	public String submitPayerCardDetails(@ModelAttribute("cardDetailsForm") PayerCardDetailsDTO payercardDTO,
						 @ModelAttribute("sessionPayee") PayeeDetailsDTO payeeDTO, 
						 Model model) 
			throws ParseException {
		
		//converters and service calls 
		Payee payee = convertPayeeDTOtoPayeeDomainObject(payeeDTO);
		PayerCard payerCard = convertPayercardDTOtoPayerCardDomainObject(payercardDTO);
		PaymentInfo paymentInfo = convertPayeeAndPayerCardToPaymentInfoHelperObject(payeeDTO,payercardDTO);
		paymentService.submitPayment(payee, payerCard,paymentInfo);
		
		//Model and  view 
		ConfirmationDTO confirmationDTO = createModelForConfirmationPage(payeeDTO, payercardDTO);
		model.addAttribute("confirmationModel", confirmationDTO);
		return CONFIRMATION;
	}
	
	private ConfirmationDTO createModelForConfirmationPage(PayeeDetailsDTO payeeDTO,
			PayerCardDetailsDTO payercardDTO) {
		
		ConfirmationDTO confirmationDTO = new ConfirmationDTO();
		confirmationDTO.setAccountnumber(payeeDTO.getAccountnumber());
		confirmationDTO.setAmount(payercardDTO.getTotalcost().doubleValue());
		confirmationDTO.setDateofpayment(payeeDTO.getDateofpayment());
		confirmationDTO.setNameoncard(payeeDTO.getAcctholdername());
		confirmationDTO.setReference(payeeDTO.getReference());
		confirmationDTO.setSortcode(payeeDTO.getSortcode());
		return confirmationDTO;
	}

	private PaymentInfo convertPayeeAndPayerCardToPaymentInfoHelperObject(
			PayeeDetailsDTO payeeDTO, PayerCardDetailsDTO payercardDTO) {
		
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setAmount(payeeDTO.getAmount());
		paymentInfo.setDateOfPayment(payeeDTO.getDateofpayment());
		paymentInfo.setReference(payeeDTO.getReference());
		paymentInfo.setTotalAmountCharged(payercardDTO.getTotalcost());
		return paymentInfo;
	}

	@RequestMapping(value = "/confirmation", method = RequestMethod.POST)
	public String confirmation() {
		return CONFIRMATION;
	}
	/*
	 * ToDo : Use Converters and formatters
	 */
	private PayerCard convertPayercardDTOtoPayerCardDomainObject(
			PayerCardDetailsDTO payercardDTO) throws ParseException {
		
		PayerCard payerCard = new PayerCard();
		payerCard.setCardNumber(payercardDTO.getCardnumber());
		payerCard.setEmailAddress(payercardDTO.getEmailaddress());
		String[] mmAndyy = payercardDTO.getExpirydate().split("/");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		StringBuilder dateStr = new StringBuilder();
		if(mmAndyy.length==2) {
			dateStr.append("01").append("-").append(mmAndyy[0]).append("-").append(mmAndyy[1]);
			Date date = formatter.parse(dateStr.toString());
			payerCard.setExpiryDate(date);
		}
		payerCard.setNameOnCard(payercardDTO.getNameoncard());
		return payerCard;
	}

	private Payee convertPayeeDTOtoPayeeDomainObject(PayeeDetailsDTO payeeDTO) {
		
		Payee payee = new Payee();
		payee.setAccountHolderName(payeeDTO.getAcctholdername());
		payee.setAccountNumber(payeeDTO.getAccountnumber());
		payee.setBankAddress(payeeDTO.getBankaddress());
		payee.setBankName(payeeDTO.getBankname());
		payee.setSortCode(payeeDTO.getSortcode());
		return payee;
	}

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
}
