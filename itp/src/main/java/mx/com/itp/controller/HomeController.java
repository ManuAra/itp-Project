package mx.com.itp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
		@RequestMapping("/")
		public String goToHomePage() {
		
			return "redirect:/userProfile/showLoginPage";
	}
}
