package paymentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	
public class FooterController {
	
	private static final String CONTACT_US = "contact_us";
	private static final String T_AND_C = "terms_and_condition";
	private static final String NEW_PAYMENT = "redirect:/";
	
	@RequestMapping(value = "/contact_us", method = RequestMethod.GET)
	public String contactUs() {
		
		return CONTACT_US;
	}
	
	@RequestMapping(value = "/tandc", method = RequestMethod.GET)
	public String termsAndCondition() {
		
		return T_AND_C;
	}
	
	@RequestMapping(value = "/newPayment", method = RequestMethod.GET)
	public String newPayment() {
		
		return NEW_PAYMENT;
	}
	
}
