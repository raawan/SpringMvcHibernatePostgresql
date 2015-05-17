package paymentapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import paymentapp.persistence.dto.Contact;
import paymentapp.service.ContactService;

@Controller	
public class StartPageController {
	
	@Autowired
	private ContactService contactService;
	
	private static int counter = 0;
	private static final String WELCOME = "welcome";
	private static final String NEW_PAYMENT = "new_payment";
	private static final String PAYEE_DETAILS = "payee_details";
	
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

			
		return NEW_PAYMENT;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String makePayment(Model model) {
		
		return PAYEE_DETAILS;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		return WELCOME;
	}
	
}
