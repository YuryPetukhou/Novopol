package lv.javaguru.novopol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerMVC {

	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("mess","Welcome message");
		return "welcome";
	}
}
