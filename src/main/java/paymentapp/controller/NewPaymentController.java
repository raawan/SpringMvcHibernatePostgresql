package paymentapp.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import paymentapp.controller.dto.PayeeDetailsDTO;
import paymentapp.controller.dto.PayerCardDetailsDTO;
import paymentapp.persistence.dto.Payee;
import paymentapp.persistence.dto.PayerCard;
import paymentapp.service.ContactService;
import paymentapp.service.PaymentService;

@Controller	
@SessionAttributes({"sessionPayee"})
public class NewPaymentController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired 
	private PaymentService  paymentService;
	
	private static int counter = 0;
	private static final String WELCOME = "welcome";
	private static final String NEW_PAYMENT = "new_payment";
	private static final String PAYEE_DETAILS = "payee_details";
	private static final String CARD_DETAILS = "card_details";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		 model.addAttribute("MsTime", System.currentTimeMillis());
		/* 
		 Contact contact = new Contact();
		 contact.setId(1);
		 contact.setEmail("mplusf@test.com");
		 contact.setFirstname("mahatma");
		 contact.setLastname("ravan");
		 contact.setTelephone("987654321");
		 
		 contactService.addContact(contact);*/

		System.out.println("==============================");	
		return NEW_PAYMENT;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String makePayment(Model model) {
		//model.addAttribute("payee",new Payee());
		return PAYEE_DETAILS;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		return WELCOME;
	}
	
	@RequestMapping(value = "/payee_details", method = RequestMethod.POST)
	public String submitPayeeDetails(@ModelAttribute("payee") PayeeDetailsDTO payee, Model model) {
		model.addAttribute("sessionPayee", payee);
		return CARD_DETAILS;
	}
	
	@RequestMapping(value = "/card_details", method = RequestMethod.POST)
	public String submitPayerCardDetails(@ModelAttribute PayerCardDetailsDTO payercardDTO , @ModelAttribute("sessionPayee") PayeeDetailsDTO payeeDTO) 
			throws ParseException {
		System.out.println("-----------------------------");
		System.out.println(payercardDTO.getEmailaddress());
		System.out.println(payeeDTO.getBankaddress());
		System.out.println("-----------------------------");
		Payee payee = convertPayeeDTOtoPayeeDomainObject(payeeDTO);
		PayerCard payerCard = convertPayercardDTOtoPayerCardDomainObject(payercardDTO);
		paymentService.submitPayment(payee, payerCard);
		return CARD_DETAILS;
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
		dateStr.append("01").append("-").append(mmAndyy[0]).append("-").append(mmAndyy[1]);
		Date date = formatter.parse(dateStr.toString());
		payerCard.setExpiryDate(date);
		payerCard.setNameOnCard(payercardDTO.getNameoncard());
		return payerCard;
	}

	private Payee convertPayeeDTOtoPayeeDomainObject(PayeeDetailsDTO payeeDTO) {
		Payee payee = new Payee();
		payee.setAccountHolderName(payeeDTO.getAcctholdername());
		payee.setAccountNumber(payeeDTO.getAccountnumber());
		payee.setAmount(payeeDTO.getAmount());
		payee.setBankAddress(payeeDTO.getBankaddress());
		payee.setBankName(payeeDTO.getBankname());
		payee.setDateOfPayment(payeeDTO.getDateofpayment());
		payee.setReference(payeeDTO.getReference());
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
