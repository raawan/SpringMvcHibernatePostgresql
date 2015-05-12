package CounterApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	
public class StartPageController {
	
	
	private static int counter = 0;
	private static final String WELCOME = "welcome";
	private static final String CURRENT_TIME = "current_time";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		
		 model.addAttribute("MsTime", System.currentTimeMillis());
		return CURRENT_TIME;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
 
		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		return WELCOME;
	}
	
}
