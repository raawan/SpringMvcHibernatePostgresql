package paymentapp.controller;


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
import paymentapp.persistence.dto.Contact;
import paymentapp.persistence.dto.Payee;
import paymentapp.service.ContactService;
import paymentapp.service.PaymentService;

@Controller	
@SessionAttributes("payee")
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
		model.addAttribute("payee",new Payee());
		return PAYEE_DETAILS;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		return WELCOME;
	}
	
	@RequestMapping(value = "/payee_details", method = RequestMethod.POST)
	public String submitPayeeDetails(@ModelAttribute PayeeDetailsDTO payee, Model model) {
		model.addAttribute("payee", payee);
		System.out.println("-----------------------------");
		System.out.println(payee.getBankaddress());
		System.out.println(payee.getReference());
		System.out.println("-----------------------------");
		return CARD_DETAILS;
	}
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
}
