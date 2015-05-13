package CounterApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CounterApp.persistence.dto.Contact;
import CounterApp.service.ContactService;

@Controller	
public class StartPageController {
	
	@Autowired
	private ContactService contactService;
	
	private static int counter = 0;
	private static final String WELCOME = "welcome";
	private static final String CURRENT_TIME = "current_time";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		 model.addAttribute("MsTime", System.currentTimeMillis());
		 
		 Contact contact = new Contact();
		 contact.setId(1);
		 contact.setEmail("minal@test.com");
		 contact.setFirstname("minal");
		 contact.setLastname("fulzele");
		 contact.setTelephone("1234567890");
		 
		 contactService.addContact(contact);

			
		return CURRENT_TIME;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		return WELCOME;
	}
	
}
